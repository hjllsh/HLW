package com.hlw.dao;

import com.hlw.domain.PersonalCenter;

public interface PersonalCenterDao {
    PersonalCenter findMyPersonalByUserId(String userId);

    void initMyPersonalCenter(com.hlw.domain.PersonalCenter personalCenter);

    void updateMyHeadshot(PersonalCenter personalCenter);
}
