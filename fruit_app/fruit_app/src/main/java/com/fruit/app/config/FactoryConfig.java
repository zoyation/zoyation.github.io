package com.fruit.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * spring 校验
 * Created by zoyation on 2017-10-17.
 */
@Configuration
@EnableAutoConfiguration
public class FactoryConfig {
    final static Logger logger= LoggerFactory.getLogger(FactoryConfig.class);
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
