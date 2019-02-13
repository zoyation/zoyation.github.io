package com.fruit.app.controller;

import com.fruit.app.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Locale;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 用户注册、登录、修改保存
 * Created by zoyation on 2017-08-29.
 */
///app/user
public class UserControllerTest extends BaseTest {
    /**
     * 发送验证码接口
     *
     * @param mobilePhone 手机号
     * @param viaCodeType 验证码类型
     */
    //@PostMapping(name="/sendViaCode/{viaCodeType}")
    @Test
    public void sendViaCode() throws Exception {
        //String mobilePhone, @PathParam("viaCodeType")EViaCodeType viaCodeType
        mvc.perform(MockMvcRequestBuilders.post("/app/user/sendViaCode/0").param("mobilePhone", "18511337432").locale(Locale.SIMPLIFIED_CHINESE)
                //.accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 校验验证码接口
     *
     * @param mobilePhone 手机号
     * @param viaCode     验证码
     * @param viaCodeType 验证码类型
     */
    @Test
    public void checkViaCode() throws Exception {
        //String mobilePhone, String viaCode, EViaCodeType viaCodeType
        mvc.perform(MockMvcRequestBuilders.post("/app/user/checkViaCode/0").param("mobilePhone", "18511337432").param("viaCode","118488").locale(Locale.SIMPLIFIED_CHINESE)
                //.accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 用户注册
     *
     * @param registerDto 注册信息
     */
    @Test
    public void saveRegister() {
//RegisterDto registerDto
    }

    /**
     * 用户登录
     *
     * @param loginDto 登录信息
     * @return 用户信息
     */
    @Test
    public void login() {
//LoginDto loginDto
    }

    /**
     * 修改个人信息
     *
     * @param updateUserDto 修改信息
     * @return 用户信息
     */
    @Test
    public void updateUser() {
        //UpdateUserDto updateUserDto
    }

    /**
     * 修改密码
     *
     * @param updatePwdDto 密码信息
     */
    @Test
    public void updatePassword() {
        //UpdatePwdDto updatePwdDto
    }

    /**
     * 重置密码
     *
     * @param resetPwdDto 密码信息
     */
    @Test
    public void resetPassword() {
        //ResetPwdDto resetPwdDto
    }
}
