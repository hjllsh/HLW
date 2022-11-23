package com.hlw.dao.impl;

import com.hlw.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void findUserById(Integer id) {
        System.out.println("user dao ..."+id);
    }
}
