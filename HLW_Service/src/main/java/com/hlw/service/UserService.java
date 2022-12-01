package com.hlw.service;

import com.hlw.domain.User;



public interface UserService {
    User findUserById(String userId);

    void newUser(User user);

    void doRecharge(Float manny, String userid);
}
