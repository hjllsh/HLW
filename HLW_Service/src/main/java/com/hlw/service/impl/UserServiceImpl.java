package com.hlw.service.impl;

import com.hlw.service.UserService;
import com.hlw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public void findUserById(Integer id) {
        userDao.findUserById(id);
        System.out.println("user service ..."+id);
    }

    public void doCharge(String id, Float manny){
        Float account = userDao.findAccountById(id);
        Float newAccount = account + manny;
/*        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("newAccount", newAccount);*/
        userDao.UpdateAccoumtByid(id, newAccount);

    }
}
