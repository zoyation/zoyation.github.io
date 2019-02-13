package com.fruit.app.controller;

import com.fruit.app.component.MessageTemplate;
import com.fruit.app.constant.MessageConstants;
import com.fruit.app.enums.EUserType;
import com.fruit.app.enums.EViaCodeType;
import com.fruit.app.exception.BusinessException;
import com.fruit.app.service.IUserService;
import com.fruit.common.dto.param.*;
import com.fruit.common.dto.result.AppJsonResult;
import com.fruit.common.util.RegexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理
 * Created by zoyation on 2017-08-26.
 */
@RestController
@RequestMapping("/app/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    /**
     * 发送验证码接口
     *
     * @param mobilePhone      手机号
     * @param viaCodeTypeValue 验证码类型 0 ,1,2 注册，登录，找回密码
     */
    @PostMapping(name = "sendViaCode", value = "/sendViaCode/{viaCodeType}")
    public AppJsonResult<String> sendViaCode(@RequestParam(value = "mobilePhone", required = true) String mobilePhone, @PathVariable(value = "viaCodeType", required = true) Integer viaCodeTypeValue) {
        AppJsonResult<String> jsonResult = new AppJsonResult<String>();
        //转换验证码类型为枚举
        EViaCodeType viaCodeType = geteViaCodeType(viaCodeTypeValue);
        checkViaCodeType(viaCodeType);
        checkMobile(mobilePhone);
        //验证验证码类型，手机号码格式
        MessageTemplate.MsgResult msgResult = this.userService.sendViaCode(mobilePhone, viaCodeType);
        jsonResult.setSuccess(msgResult.isSuccess());
        jsonResult.setMsg(msgResult.getMsg());
        jsonResult.setError(msgResult.getErrorCode());
        return jsonResult;
    }

    /**
     * 校验验证类型
     *
     * @param viaCodeType 验证类型
     */
    private void checkViaCodeType(EViaCodeType viaCodeType) {
        if (viaCodeType == null) {
            throw new BusinessException(MessageConstants.VIA_TYPE_MISMATCH, localeMessageSource.getMessage(MessageConstants.VIA_TYPE_MISMATCH));
        }
    }

    /**
     * 校验手机号
     *
     * @param mobilePhone 手机号
     */
    private void checkMobile(String mobilePhone) {
        if (!RegexUtils.checkMobile(mobilePhone)) {
            throw new BusinessException(MessageConstants.MOBILE_PHONE_MISMATCH, localeMessageSource.getMessage(MessageConstants.MOBILE_PHONE_MISMATCH));
        }
    }

    /**
     * 通过验证码类型获取验证码枚举值
     *
     * @param viaCodeTypeValue 验证码类型值
     * @return 验证码枚举值
     */
    private EViaCodeType geteViaCodeType(Integer viaCodeTypeValue) {
        EViaCodeType viaCodeType = null;
        switch (viaCodeTypeValue) {
            case 0:
                viaCodeType = EViaCodeType.REGISTER;
                break;
            case 1:
                viaCodeType = EViaCodeType.LOGIN;
                break;
            case 2:
                viaCodeType = EViaCodeType.FIND_PASSWORD;
                break;
        }
        return viaCodeType;
    }

    /**
     * 校验验证码接口
     *
     * @param mobilePhone 手机号
     * @param viaCode     验证码
     * @param viaCodeType 验证码类型
     */
    @PostMapping(name = "checkViaCode", value = "/checkViaCode/{viaCodeType}")
    public AppJsonResult<String> checkViaCode(@RequestParam(value = "mobilePhone", required = true) String mobilePhone, @RequestParam(value = "viaCode", required = true) String viaCode, @PathVariable(value = "viaCodeType", required = true) Integer viaCodeType) {
        AppJsonResult<String> appJsonResult = new AppJsonResult<String>();
        //转换验证码类型为枚举
        EViaCodeType eViaCodeType = geteViaCodeType(viaCodeType);
        checkViaCodeType(eViaCodeType);
        checkMobile(mobilePhone);
        boolean checkResult = this.userService.checkViaCode(mobilePhone, viaCode, eViaCodeType);
        appJsonResult.setSuccess(checkResult);
        if (!checkResult) {
            appJsonResult.setError(MessageConstants.VIA_CODE_MISMATCH);
            appJsonResult.setMsg(localeMessageSource.getMessage(MessageConstants.VIA_CODE_MISMATCH));
        }
        return appJsonResult;
    }

    /**
     * 用户注册
     *
     * @param registerInfo 注册信息
     * @param userType 用户类型
     */
    @PostMapping(name = "saveRegister", value = "/saveRegister/{userType}")
    public AppJsonResult<String> saveRegister(@RequestBody RegisterDto registerInfo, @PathVariable(value = "userType", required = true) Integer userType) {
        AppJsonResult<String> appJsonResult = new AppJsonResult<String>();
        EUserType eUserType = getUserType(userType);
        checkUserType(eUserType);
        registerInfo.setUserType(userType.byteValue());
        userService.saveRegister(registerInfo);
        return appJsonResult;
    }

    /**
     * 通过验证码类型获取验证码枚举值
     *
     * @param userType 用户类型值
     * @return 验证码枚举值
     */
    private EUserType getUserType(Integer userType) {
        EUserType eUserType = null;
        switch (userType) {
            case 0:
                eUserType = EUserType.CUSTOMER;
                break;
            case 1:
                eUserType = EUserType.SELLER;
                break;
        }
        return eUserType;
    }

    /**
     * 校验用类型
     * @param userType 用户类型
     */
    private void checkUserType(EUserType userType) {
        if (userType == null) {
            throw new BusinessException(MessageConstants.USER_TYPE_MISMATCH, localeMessageSource.getMessage(MessageConstants.USER_TYPE_MISMATCH));
        }
    }

    /**
     * 用户登录
     *
     * @param loginDto 登录信息
     * @return 用户信息
     */
    @PostMapping(name = "login", value = "/login")
    public AppJsonResult<String> login(LoginDto loginDto) {
        userService.login(loginDto);
        return new AppJsonResult<String>();
    }

    /**
     * 修改个人信息
     *
     * @param updateUserDto 修改信息
     * @return 用户信息
     */
    @PostMapping(name = "updateUser", value = "/updateUser")
    public AppJsonResult<String> updateUser(UpdateUserDto updateUserDto) {
        userService.updateUser(updateUserDto);
        return new AppJsonResult<String>();
    }

    /**
     * 修改密码
     *
     * @param updatePwdDto 密码信息
     */
    @PostMapping(name = "updatePwd", value = "/updatePwd")
    public AppJsonResult<String> updatePwd(UpdatePwdDto updatePwdDto) {
        userService.updatePassword(updatePwdDto);
        return new AppJsonResult<String>();
    }

    /**
     * 重置密码
     *
     * @param resetPwdDto 密码信息
     */
    @PostMapping(name = "resetPwd", value = "/resetPwd")
    public AppJsonResult<String> resetPwd(ResetPwdDto resetPwdDto) {
        userService.resetPassword(resetPwdDto);
        return new AppJsonResult<String>();
    }
}
