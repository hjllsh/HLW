package com.hlw.service;

import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
public interface UserService {
    User findUserById(Map info);
    void newUser(User user);
    void doModifyPass(String newPass, String userId);
    void doRecharge(Float manny, String userId);
    boolean doUpdatePersonalCenter(PersonalCenter personalCenter) ;
    boolean findPass(String userId, String password);
    void updateHeadshot(User user);
}
