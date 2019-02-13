package com.fruit.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zoyation on 2017-09-05.
 */
@Component
@ConfigurationProperties(prefix = "com.fruit")
// PropertySource默认取application.properties
@PropertySource(value = "classpath:/props/default.properties")
public class PropertiesConfig {
    /**
     * 验证吗过期时间 毫秒
     */
    private long expireTime;

    /**
     * 手机短信地址
     */
    private String mobileUri;
    /**
     * 手机短信uid
     */
    private String mobileUid;
    /**
     * 手机短信 uidKey
     */
    private String mobileUidKey;

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getMobileUid() {
        return mobileUid;
    }

    public void setMobileUid(String mobileUid) {
        this.mobileUid = mobileUid;
    }

    public String getMobileUidKey() {
        return mobileUidKey;
    }

    public void setMobileUidKey(String mobileUidKey) {
        this.mobileUidKey = mobileUidKey;
    }

    public String getMobileUri() {
        return mobileUri;
    }

    public void setMobileUri(String mobileUri) {
        this.mobileUri = mobileUri;
    }
}
