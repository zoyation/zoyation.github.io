package com.fruit.app.util.prop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fruit.app.config.PropertiesConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * 属性文件工具类
 * Created by zoyation on 2017-09-05.
 */
public class PropertiesUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;
    private static Map<String,String> propertiesMap = new HashMap<String, String>();
    public PropertiesUtil() {
    }
    public static String getConfigByKey(String key) throws JsonProcessingException {
        if (propertiesMap ==null){
            PropertiesConfig ymlConfig = applicationContext.getBean(PropertiesConfig.class);
        }
        return propertiesMap.get(key);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(PropertiesUtil.applicationContext == null){
            PropertiesUtil.applicationContext  = applicationContext;
        }
    }
}
