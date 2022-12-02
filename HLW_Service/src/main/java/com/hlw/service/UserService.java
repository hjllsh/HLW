package com.hlw.service;

import com.hlw.domain.User;

import java.util.HashMap;
import java.util.Map;


public interface UserService {
    public User findUserById(Map info);

    public void newUser(User user);

    void doRecharge(Float manny, String userid);

    void doModifyPass(String newPass, String userId);
    void doRecharge(Float manny, String userid);

    boolean findPass(String userId, String password);
}
