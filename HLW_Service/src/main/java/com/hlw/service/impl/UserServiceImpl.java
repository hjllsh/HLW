package com.hlw.service.impl;

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
    public User findUserById(String userId) {
        return userDao.findUserById(userId);
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
}
