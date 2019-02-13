package com.fruit.app.controller;

import com.fruit.app.component.LocaleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制层基类，提供公共方法
 * Created by zoyation on 2017-08-29.
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Resource
    protected LocaleMessageSource localeMessageSource;
}
