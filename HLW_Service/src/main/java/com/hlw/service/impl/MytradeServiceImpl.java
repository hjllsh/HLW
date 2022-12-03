package com.hlw.service.impl;

import com.hlw.dao.MytradeDao;
import com.hlw.domain.PersonalCenter;
import com.hlw.service.MytradeService;
import org.springframework.beans.factory.annotation.Autowired;

public class MytradeServiceImpl implements MytradeService {
    @Autowired
    private MytradeDao mytradeDao;
    public PersonalCenter findMytradeByUserId(String userId) {
        return null;
    }
}
