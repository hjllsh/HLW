package com.hlw.dao;

import com.hlw.domain.User;
public interface UserDao {
    User findUserById(String userId);

    void newUser(User user);

}
