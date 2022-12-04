package com.hlw.service.impl;

import com.hlw.dao.PersonalCenterDao;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.MyPersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPersonalCenterServiceImpl implements MyPersonalCenterService {
    @Autowired
    private PersonalCenterDao personalCenterDao;
    public PersonalCenter findMyPersonalByUserId(String userId) {
        return personalCenterDao.findMyPersonalByUserId(userId);
    }

    public void initMyPersonalCenter(User user) {
        com.hlw.domain.PersonalCenter personalCenter = new com.hlw.domain.PersonalCenter();
        personalCenter.setUserId(user.getUserId());
        personalCenter.setAccount(user.getAccount());
        personalCenter.setUserName(user.getUserName());
        personalCenter.setEmail(user.getEmail());
        personalCenter.setHeadshot(user.getHeadshot());
        personalCenter.setPersonalDesc("这个人很懒，什么都没留下...");
        this.personalCenterDao.initMyPersonalCenter(personalCenter);
    }
}
