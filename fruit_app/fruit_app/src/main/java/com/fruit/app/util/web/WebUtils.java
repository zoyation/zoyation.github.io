package com.fruit.app.util.web;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * WEB请求参数处理工具类
 * Created by zoyation on 2017-09-05.
 */
public final class WebUtils {

    private WebUtils() {
    }

   public static HttpServletRequest getRequest(){
       RequestAttributes ra = RequestContextHolder.getRequestAttributes();
       ServletRequestAttributes sra = (ServletRequestAttributes) ra;
       HttpServletRequest request = sra.getRequest();
       return request;
   }

    public static String getRequestParam(String paramName){
        return getRequest().getParameter(paramName);
    }

    public static String getHeaderToken(String tokenId){
        return getRequest().getHeader(tokenId);
    }
}
