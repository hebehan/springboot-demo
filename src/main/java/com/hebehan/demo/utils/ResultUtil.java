package com.hebehan.demo.utils;

import com.hebehan.demo.model.Result;

public class ResultUtil {

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
