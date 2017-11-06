package com.hebehan.demo.exception;

import com.hebehan.demo.model.Result;
import com.hebehan.demo.result.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result personExceptionHandle(Exception e){
        if (e instanceof PersonException){
            return ResultUtil.error(((PersonException) e).getCode(),e.getMessage());
        }else {
            return ResultUtil.error(-1,e.getMessage());
        }
    }
}
