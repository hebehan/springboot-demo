package com.hebehan.demo.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * http 工具类
 */
public class HttpUtils {

    public static String HttpRequestToString(HttpServletRequest request)throws Exception{
        Map map = new HashMap();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headername = (String) headerNames.nextElement();
            String headervalue = request.getHeader(headername);
            map.put(headername, headervalue);
        }


        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length >0) {
                for (String param: paramValues) {
                    map.put(paramName,param);
                }
            }
        }

//        Enumeration attrNames = request.getAttributeNames();
//        while (attrNames.hasMoreElements()){
//            String attr = (String) attrNames.nextElement();
//            Object attrValue = request.getAttribute(attr);
//            map.put(attr,attrValue);
//        }

        return map.toString();
    }

    public static String HttpReSponseToString(HttpServletResponse response)throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        response.getWriter().append(stringBuilder);
        return stringBuilder.toString();
    }

}
