package com.hlw.service;

import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;

import java.util.HashMap;
import java.util.Map;


public interface UserService {
    public User findUserById(Map info);

    public void newUser(User user);

    void doModifyPass(String newPass, String userId);
    void doRecharge(Float manny, String userId);

    boolean findPass(String userId, String password);


}
