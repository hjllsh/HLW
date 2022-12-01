package com.hlw.service.impl;

import com.hlw.domain.User;
import com.hlw.service.UserService;
import com.hlw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
