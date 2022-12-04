package com.hlw.service.impl;

import com.hlw.dao.UserDao;
import com.hlw.domain.PersonalCenter;
import com.hlw.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FunctionServiceImpImpl implements FunctionService {
    @Autowired
    private UserDao userDao;
    public boolean doUpdatePersonalCenter(PersonalCenter personalCenter) {
        boolean flag = true;
        try {
            userDao.updatePersonalCenter(personalCenter);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            return flag;
        }
        return flag;
    }
    public void doRecharge(Float money, String userId) {
        Float oldMoney = userDao.findAccountById(userId);
        Float newAccount = oldMoney + money;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("newAccount",newAccount);
        userDao.updatePersonalCenterAccount(map);
        userDao.updateUserAccount(map);
    }
    public void doModifyPass(String newPass, String userId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("newPass",newPass);
        userDao.updatePass(map);
    }
}
