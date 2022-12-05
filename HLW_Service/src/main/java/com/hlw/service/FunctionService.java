package com.hlw.service;

import com.hlw.domain.Goods;
import com.hlw.domain.PersonalCenter;

import java.util.List;
import java.util.Map;

public interface FunctionService {

    boolean doUpdatePersonalCenter(PersonalCenter personalCenter);

    void doRecharge(Float manny, String userid);

    void  doModifyPass(String newPass, String userId);

    List<Goods> getMyAllGoods(String userId, Integer pageSize, Integer currentPage);

    void deleteGoods(String goodsId);
}
