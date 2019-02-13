package com.fruit.app.exception;

/**
 * 业务异常信息
 * Created by zoyation on 2017-08-29.
 */
public class BusinessException extends RuntimeException {
    //异常编码
    private String messageCode;

    //异常信息
    private String oriError;

    public BusinessException(String messageCode, String message) {
        this(messageCode,message,null);
    }

    public BusinessException(String messageCode, String message,String oriError) {
        super(message);
        this.messageCode = messageCode;
        this.oriError = oriError;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getOriError() {
        return oriError;
    }

    public void setOriError(String oriError) {
        this.oriError = oriError;
    }
}
