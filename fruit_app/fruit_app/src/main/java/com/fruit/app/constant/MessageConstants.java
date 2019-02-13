package com.fruit.app.constant;

/**
 * 国际化常量
 * Created by zoyation on 2017-08-29.
 */
public interface MessageConstants {
    /****************错误信息**********************/
    //未知错误
    String UNKNOWN_EXCEPTION="unknown_exception";
    //验证码类型错误
    String VIA_TYPE_MISMATCH="via_type_mismatch";
    //验证码无效
    String VIA_CODE_MISMATCH="via_code_mismatch";
    //手机号码格式错误
    String MOBILE_PHONE_MISMATCH="mobile_phone_mismatch";
    //手机号已存在
    String MOBILE_PHONE_EXISTS="mobile_phone_exists";
    //手机号不存在
    String MOBILE_PHONE_NOT_EXISTS="mobile_phone_not_exists";
    //发送短信失败
    String SEND_PHONE_MSG_ERROR="send_phone_msg_error";

    /****************提示信息**********************/
    //注册验证码提示
    String REGISTER_CODE_MSG = "register_code_msg";
    //登录验证码提示
    String LOGIN_CODE_MSG = "login_code_msg";
    //修改密码验证码提示
    String FIND_PASSWORD_CODE_MSG = "find_password_code_msg";
    //用户类型无效提示
    String USER_TYPE_MISMATCH = "user_type_mismatch";
    //用户已存在提示
    String USER_EXISTS = "user_exists";
    //用户不存在提示
    String USER_NOT_EXISTS = "user_not_exists";
    //密码错误
    String PASSWORD_MISMATCH = "password_mismatch";
    //密码为空
    String PASSWORD_EMPTY = "password_empty";
}
