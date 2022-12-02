package com.hlw.dao;

import com.hlw.domain.User;

import java.util.HashMap;
import java.util.Map;

public interface UserDao {
    public User findUserById(Map info);

    public void newUser(User user);

    public Float findAccountById(String userid);

    public void updateAccount(Map map);

    void findPass(Map info);
}
