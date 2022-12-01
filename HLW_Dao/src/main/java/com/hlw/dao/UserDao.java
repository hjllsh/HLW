package com.hlw.dao;

import com.hlw.domain.User;

import java.util.HashMap;
import java.util.Map;

public interface UserDao {
    User findUserById(String userId);

    void newUser(User user);

    Float findAccountById(String userid);

    void updateAccount(Map map);
}
