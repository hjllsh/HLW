package com.hlw.service;

import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MyPersonalCenterService {
    PersonalCenter findMyPersonalByUserId(String userId);

    void initMyPersonalCenter(User user);

    void updateMyHeadshot(PersonalCenter personalCenter);


}
