package com.hebehan.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * aop 测试
 */
@Aspect
@Component
public class HttpAspect {

    public static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.hebehan.demo.controller.IndexController.getAll(..))")//拦截指定方法 IndexController.*(..)拦截所有
    public void log(){
    }

    @Before("log()")
    public void dobefore(JoinPoint joinpoint){
        logger.info("do before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        logger.info("url={}",attributes.getRequest().getRequestURL());
        logger.info("method={}",attributes.getRequest().getMethod());
        logger.info("ip={}",attributes.getRequest().getRemoteAddr());
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
        logger.info("args={}", joinpoint.getArgs());

    }

    @After("log()")
    public void doafter(){
        logger.info("do after");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        logger.info("url={}",attributes.getRequest().getRequestURL());
//        logger.info("method={}",attributes.getRequest().getMethod());
//        logger.info("ip={}",attributes.getRequest().getRemoteAddr());
//        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
//        logger.info("args={}", joinpoint.getArgs());
    }

    @AfterReturning(returning = "obj" ,pointcut = "log()")
    public void afterReturn(Object obj){
        logger.info("response={}",obj.toString());
    }
}
