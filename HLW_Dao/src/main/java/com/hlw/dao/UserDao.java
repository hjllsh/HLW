package com.hlw.dao;

import com.hlw.domain.User;

public interface UserDao {
    void findUserById(Integer id);

    void newUser(User user);

}
