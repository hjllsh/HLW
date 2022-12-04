package com.hlw.service;

import com.hlw.domain.Goods;
import com.hlw.domain.PersonalCenter;

public interface FunctionService {

    boolean doUpdatePersonalCenter(PersonalCenter personalCenter);

    void doRecharge(Float manny, String userid);

    void  doModifyPass(String newPass, String userId);

    Goods getMyGoods(String userId);
}
