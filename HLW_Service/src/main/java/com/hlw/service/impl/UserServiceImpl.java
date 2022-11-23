package com.hlw.service.impl;

import com.hlw.service.UserService;
import com.hlw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public void findUserById(Integer id) {
        userDao.findUserById(id);
        System.out.println("user service ..."+id);
    }
}
