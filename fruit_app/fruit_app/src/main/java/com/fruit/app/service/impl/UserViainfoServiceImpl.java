package com.fruit.app.service.impl;

import com.fruit.app.component.MessageTemplate;
import com.fruit.app.component.MobileMessage;
import com.fruit.app.dao.TUserViainfoMapper;
import com.fruit.app.model.TUserViainfo;
import com.fruit.app.model.TUserViainfoExample;
import com.fruit.app.service.IUserViainfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户验证信息
 * Created by zoyation on 2017-09-04.
 */
@Service
public class UserViainfoServiceImpl extends BaseService implements IUserViainfoService{
    private static final Logger logger = LoggerFactory.getLogger(UserViainfoServiceImpl.class);
    @Autowired
    private TUserViainfoMapper userViainfoDao;

    @Resource(type = MobileMessage.class)
    private MessageTemplate mobileMessage;
    @Override
    public boolean sendMobileViaCode(String mobilePhone, String viaInfo) {
        mobileMessage.sendMsg(mobilePhone,viaInfo);
        return true;
    }

    @Override
    public int saveViaInfo(TUserViainfo userViainfo) {
        return userViainfoDao.insert(userViainfo);
    }

    @Override
    public long countByExample(TUserViainfoExample example) {
        return userViainfoDao.countByExample(example);
    }
}
