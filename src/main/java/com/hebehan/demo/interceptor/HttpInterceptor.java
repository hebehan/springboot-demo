package com.hebehan.demo.interceptor;

import com.hebehan.demo.utils.HttpUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpInterceptor implements HandlerInterceptor{


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle is execute");
//        System.out.println(HttpUtils.HttpRequestToString(request));
//        System.out.println(HttpUtils.HttpReSponseToString(response));
//        System.out.println(handler.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle is execute");
//        System.out.println(HttpUtils.HttpRequestToString(request));
//        System.out.println(HttpUtils.HttpReSponseToString(response));
//        System.out.println(handler.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion is execute");
//        System.out.println(HttpUtils.HttpRequestToString(request));
//        System.out.println(HttpUtils.HttpReSponseToString(response));
//        System.out.println(handler.toString());
    }
}
