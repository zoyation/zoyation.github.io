package com.fruit.app.service.impl;

import com.fruit.app.component.LocaleMessageSource;
import com.fruit.app.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by zoyation on 2017-08-30.
 */
public abstract class BaseService {
    @Resource
    protected LocaleMessageSource localeMessageSource;
    @Autowired
    protected PropertiesConfig propertiesConfig;
}
