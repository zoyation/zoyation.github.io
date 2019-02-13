package com.fruit.app.service;
import com.fruit.app.component.MessageTemplate;
import com.fruit.app.enums.EViaCodeType;
import com.fruit.app.model.TUser;
import com.fruit.common.dto.param.*;

/**
 * 用户管理
 * Created by zoyation on 2017-08-26.
 */
public interface IUserService {

    /**
     * 发送验证码接口
     * @param mobilePhone 手机号
     * @param viaCodeType 验证码类型
     */
    MessageTemplate.MsgResult sendViaCode(String mobilePhone, EViaCodeType viaCodeType);

    /**
     * 校验验证码接口
     * @param mobilePhone 手机号
     * @param viaCode 验证码
     * @param viaCodeType 验证码类型
     */
    boolean checkViaCode(String mobilePhone, String viaCode, EViaCodeType viaCodeType);

    /**
     * 用户注册
     * @param registerDto 注册信息
     */
    int saveRegister(RegisterDto registerDto);

    /**
     * 用户登录
     * @param loginDto 登录信息
     * @return 用户信息
     */
    TUser login(LoginDto loginDto);

    /**
     * 修改个人信息
     * @param updateUserDto 修改信息
     * @return 用户信息
     */
    TUser updateUser(UpdateUserDto updateUserDto);

    /** 修改密码
     * @param updatePwdDto 密码信息
     */
    int updatePassword(UpdatePwdDto updatePwdDto);

    /**
     * 重置密码
     * @param resetPwdDto 密码信息
     */
    int resetPassword(ResetPwdDto resetPwdDto);
}
