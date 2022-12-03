package com.hlw.service.impl;

import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.UserService;
import com.hlw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User findUserById(Map info) {
        try {
            return userDao.findUserById(info);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void newUser(User user) {
        userDao.newUser(user);
    }

    public void doRecharge(Float money, String userId) {
        Float oldMoney = userDao.findAccountById(userId);
        Float newAccount = oldMoney + money;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("newAccount",newAccount);
        userDao.updateAccount(map);
    }
    public void doModifyPass(String newPass, String userId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("newPass",newPass);
        userDao.updatePass(map);
    }

    public boolean findPass(String userId, String password) {
        boolean flag = true;
        try {
            HashMap<String,String> info = new HashMap<String, String>();
            info.put("userId",userId);
            info.put("password",password);
            userDao.findPass(info);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
            return flag;
        }
        return flag;
    }

    public boolean doUpdatePersonalCenter(PersonalCenter personalCenter){
        boolean flag = true;
        try {
            userDao.updatePersonalCenter(updatePersonalCenter);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
            return flag;
        }
        return flag;
    }
}
