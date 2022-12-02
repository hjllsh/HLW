package com.hlw.dao;

import com.hlw.domain.User;

import java.util.HashMap;
import java.util.Map;

public interface UserDao {
    void findUserById(Integer id);

    void newUser(User user);

    Float findAccountById(String userid);

    void updateAccount(Map map);

    void updatePass(Map map);
}
