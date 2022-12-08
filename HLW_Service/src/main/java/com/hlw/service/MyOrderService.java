package com.hlw.service;

import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import org.springframework.transaction.annotation.Transactional;


public interface MyOrderService {
    @Transactional
    void addOrder(MyOrders order);
    @Transactional
    void updateUserAccount(User user);
    @Transactional
    void updatePersonalCenterAccount(PersonalCenter personalCenter);
    @Transactional
    void  updateGoodsNum(String goodsId,int totalNum);
    @Transactional
    int getGoodsNum(String goodsId);

}
