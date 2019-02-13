package com.fruit.app.component;

import com.fruit.app.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by zoyation on 2017-09-05.
 */
public abstract class MessageTemplate {
    //信息发送结果
    public static class MsgResult{
        //是否成功
        private boolean success;
        //错误代码
        private String errorCode;
        //发送消息
        private String msg;

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
    @Autowired
    protected PropertiesConfig propertiesConfig;
    @Resource
    protected LocaleMessageSource localeMessageSource;

    /**
     * 发送信息
     * @param destination 目的地
     * @param message 消息类容
     */
    public abstract MsgResult sendMsg(String destination, String message);
}
