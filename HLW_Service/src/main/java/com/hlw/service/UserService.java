package com.hlw.service;

import com.hlw.domain.User;

public interface UserService {
    void findUserById(Integer id);

    void newUser(User user);

}
