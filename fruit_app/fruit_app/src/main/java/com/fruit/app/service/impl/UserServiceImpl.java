package com.fruit.app.service.impl;

import com.fruit.app.component.MessageTemplate;
import com.fruit.app.component.MobileMessage;
import com.fruit.app.constant.MessageConstants;
import com.fruit.app.dao.TUserMapper;
import com.fruit.app.enums.EDataFrom;
import com.fruit.app.enums.ESuccessFlag;
import com.fruit.app.enums.EViaCodeType;
import com.fruit.app.exception.BusinessException;
import com.fruit.app.model.TUser;
import com.fruit.app.model.TUserExample;
import com.fruit.app.model.TUserViainfo;
import com.fruit.app.model.TUserViainfoExample;
import com.fruit.app.service.IUserService;
import com.fruit.app.service.IUserViainfoService;
import com.fruit.app.util.ViaCodeUtil;
import com.fruit.common.dto.param.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户管理
 * Created by zoyation on 2017-08-26.
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * 验证码过期时间
     */
//    public static final int EXPIRE_TIME = 1000 * 60 * 5;

    @Autowired
    private TUserMapper userDao;

    @Autowired
    private IUserViainfoService userViainfoService;

    @Resource(type = MobileMessage.class)
    private MessageTemplate mobileMessage;

    @Override
    public MessageTemplate.MsgResult sendViaCode(String mobilePhone, EViaCodeType viaCodeType) {
        String formatMsgCode = "";
        TUserExample searchUser = new TUserExample();
        searchUser.createCriteria().andMobilePhoneEqualTo(mobilePhone);
        List<TUser> users = userDao.selectByExample(searchUser);
        int userSize = users.size();
        switch (viaCodeType) {
            case REGISTER:
                //手机号已注册
                if (userSize > 0) {
                    throw new BusinessException(MessageConstants.MOBILE_PHONE_EXISTS, localeMessageSource.getMessage(MessageConstants.MOBILE_PHONE_EXISTS));
                }
                formatMsgCode = MessageConstants.REGISTER_CODE_MSG;
                break;
            case LOGIN:
                formatMsgCode = MessageConstants.LOGIN_CODE_MSG;
                break;
            case FIND_PASSWORD:
                //手机号不存在
                if (userSize == 0) {
                    throw new BusinessException(MessageConstants.MOBILE_PHONE_NOT_EXISTS, localeMessageSource.getMessage(MessageConstants.MOBILE_PHONE_NOT_EXISTS));
                }
                formatMsgCode = MessageConstants.FIND_PASSWORD_CODE_MSG;
                break;
            default:
                throw new BusinessException(MessageConstants.VIA_TYPE_MISMATCH, localeMessageSource.getMessage(MessageConstants.VIA_TYPE_MISMATCH));
        }
        //格式化验证信息
        String randomViaCode = ViaCodeUtil.createRandom();
        String viaInfo = String.format(localeMessageSource.getMessage(formatMsgCode), randomViaCode);

        //发送验证信息
        MessageTemplate.MsgResult msgResult = this.mobileMessage.sendMsg(mobilePhone, viaInfo);

        //保存验证信息
        TUserViainfo userViainfo = new TUserViainfo();
        if (userSize > 0) {
            TUser user = users.get(0);
            userViainfo.setUserId(user.getId());
        }
        userViainfo.setViaType((byte) viaCodeType.ordinal());
        userViainfo.setReceiver(mobilePhone);
        userViainfo.setViaText(randomViaCode);
        Date createDate = new Date();
        userViainfo.setCreateDate(createDate);
        userViainfo.setExpireDate(new Date(createDate.getTime() + propertiesConfig.getExpireTime()));
        userViainfo.setDataFrom((byte) EDataFrom.ANDROID.ordinal());
        userViainfo.setSendMsg(viaInfo);

        if (msgResult.isSuccess()) {
            userViainfo.setSuccessFlag((byte) ESuccessFlag.TRUE.ordinal());
        } else {
            userViainfo.setSuccessFlag((byte) ESuccessFlag.FALSE.ordinal());
            userViainfo.setSendError(msgResult.getErrorCode() + "->" + msgResult.getMsg());
        }
        this.userViainfoService.saveViaInfo(userViainfo);
        return msgResult;
    }

    @Override
    public boolean checkViaCode(String mobilePhone, String viaCode, EViaCodeType viaCodeType) {
        TUserViainfoExample viainfoExample = new TUserViainfoExample();
        TUserViainfoExample.Criteria criteria = viainfoExample.createCriteria();
        criteria.andReceiverEqualTo(mobilePhone);
        criteria.andViaTextEqualTo(viaCode);
        criteria.andViaTypeEqualTo((byte) viaCodeType.ordinal());
        //未过期
        criteria.andExpireDateGreaterThan(new Date());
        long countByExample = userViainfoService.countByExample(viainfoExample);
        return countByExample > 0L;
    }

    @Override
    public int saveRegister(RegisterDto registerDto) {
        TUser user = new TUser();
        TUserExample searchUser = new TUserExample();
        searchUser.createCriteria().andMobilePhoneEqualTo(registerDto.getMobilePhone());
        List<TUser> users = userDao.selectByExample(searchUser);
        if (users.size() > 0) {
            throw new BusinessException(MessageConstants.USER_EXISTS, localeMessageSource.getMessage(MessageConstants.USER_EXISTS));
        }
        BeanUtils.copyProperties(registerDto, user);
        user.setCreateDate(new Date());
        return userDao.insert(user);
    }

    @Override
    public TUser updateUser(UpdateUserDto updateUserDto) {
        TUser user = new TUser();
        TUserExample searchUser = new TUserExample();
        searchUser.createCriteria().andMobilePhoneEqualTo(updateUserDto.getMobilePhone());
        List<TUser> users = userDao.selectByExample(searchUser);
        if (users.size() == 0) {
            throw new BusinessException(MessageConstants.USER_NOT_EXISTS, localeMessageSource.getMessage(MessageConstants.USER_NOT_EXISTS));
        }
        BeanUtils.copyProperties(updateUserDto, user);
        user.setUpdateDate(new Date());
        userDao.updateByExampleSelective(user, searchUser);
        return user;
    }

    @Override
    public TUser login(LoginDto loginDto) {
        TUserExample searchUser = new TUserExample();
        TUserExample.Criteria criteria = searchUser.createCriteria();
        criteria.andMobilePhoneEqualTo(loginDto.getMobilePhone());
        List<TUser> mobileUser = userDao.selectByExample(searchUser);

        criteria.andPasswordEqualTo(loginDto.getPassword());
        List<TUser> passwordUser = userDao.selectByExample(searchUser);

        if (mobileUser.size() == 0) {
            throw new BusinessException(MessageConstants.USER_NOT_EXISTS, localeMessageSource.getMessage(MessageConstants.USER_NOT_EXISTS));
        }

        if (passwordUser.size() == 0) {
            throw new BusinessException(MessageConstants.PASSWORD_MISMATCH, localeMessageSource.getMessage(MessageConstants.PASSWORD_MISMATCH));
        }

        return passwordUser.get(0);
    }


    @Override
    public int updatePassword(UpdatePwdDto updatePwdDto) {
        if (StringUtils.isEmpty(updatePwdDto.getPassword())) {
            throw new BusinessException(MessageConstants.PASSWORD_EMPTY, localeMessageSource.getMessage(MessageConstants.PASSWORD_EMPTY));
        }
        TUser user = new TUser();

        TUserExample searchUser = new TUserExample();
        searchUser.createCriteria().andMobilePhoneEqualTo(updatePwdDto.getMobilePhone());
        List<TUser> users = userDao.selectByExample(searchUser);

        if (users.size() == 0) {
            throw new BusinessException(MessageConstants.USER_NOT_EXISTS, localeMessageSource.getMessage(MessageConstants.USER_NOT_EXISTS));
        }
        BeanUtils.copyProperties(updatePwdDto, user);
        user.setUpdateDate(new Date());
        return userDao.updateByExampleSelective(user, searchUser);
    }

    @Override
    public int resetPassword(ResetPwdDto resetPwdDto) {
        if (StringUtils.isEmpty(resetPwdDto.getPassword())) {
            throw new BusinessException(MessageConstants.PASSWORD_EMPTY, localeMessageSource.getMessage(MessageConstants.PASSWORD_EMPTY));
        }
        TUser user = new TUser();
        TUserExample searchUser = new TUserExample();
        searchUser.createCriteria().andMobilePhoneEqualTo(resetPwdDto.getMobilePhone());
        List<TUser> users = userDao.selectByExample(searchUser);
        if (users.size() == 0) {
            throw new BusinessException(MessageConstants.USER_NOT_EXISTS, localeMessageSource.getMessage(MessageConstants.USER_NOT_EXISTS));
        }
        BeanUtils.copyProperties(resetPwdDto, user);
        user.setUpdateDate(new Date());
        return userDao.updateByExampleSelective(user, searchUser);
    }
}
