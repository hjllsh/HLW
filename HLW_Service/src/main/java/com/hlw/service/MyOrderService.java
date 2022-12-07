package com.hlw.service;

import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;


public interface MyOrderService {
    void addOrder(MyOrders order);

    void updateUserAccount(User user);

    void updatePersonalCenterAccount(PersonalCenter personalCenter);

    void  updateGoodsNum(String goodsId,int totalNum);

    int getGoodsNum(String goodsId);

}
