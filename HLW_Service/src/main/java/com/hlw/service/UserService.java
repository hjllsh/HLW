package com.hlw.service;

import com.hlw.domain.User;

public interface UserService {
    void findUserById(Integer id);

    void newUser(User user);

    void doRecharge(Float manny, String userid);

    void doModifyPass(String newPass, String userId);
}
