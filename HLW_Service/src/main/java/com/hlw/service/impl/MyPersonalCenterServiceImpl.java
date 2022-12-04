package com.hlw.service.impl;

import com.hlw.dao.PersonalCenterDao;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.MyPersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyPersonalCenterServiceImpl implements MyPersonalCenterService {
    @Autowired
    private PersonalCenterDao personalCenterDao;
    public PersonalCenter findMyPersonalByUserId(String userId) {
        return personalCenterDao.findMyPersonalByUserId(userId);
    }

    public void initMyPersonalCenter(User user) {
        PersonalCenter personalCenter = new PersonalCenter();
        personalCenter.setUserId(user.getUserId());
        personalCenter.setAccount(user.getAccount());
        personalCenter.setUserName(user.getUserName());
        personalCenter.setEmail(user.getEmail());
        personalCenter.setHeadshot(user.getHeadshot());
        personalCenter.setPersonalDesc("这个人很懒，什么都没留下...");
        System.out.println(personalCenter);
        personalCenterDao.initMyPersonalCenter(personalCenter);
    }

    public void updateMyHeadshot(PersonalCenter personalCenter) {
        personalCenterDao.updateMyHeadshot(personalCenter);
    }

//    public List<MyOrders> getAllOrder(MyOrders myOrders) {
//        return null;
//    }
}
