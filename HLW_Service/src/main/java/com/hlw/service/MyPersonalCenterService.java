package com.hlw.service;

import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;

public interface MyPersonalCenterService {
    PersonalCenter findMyPersonalByUserId(String userId);

    void initMyPersonalCenter(User user);
}
