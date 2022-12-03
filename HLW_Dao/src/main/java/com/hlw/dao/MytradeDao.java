package com.hlw.dao;

import com.hlw.domain.PersonalCenter;

public interface MytradeDao {
    PersonalCenter findMytradeByUserId(String userId);
}
