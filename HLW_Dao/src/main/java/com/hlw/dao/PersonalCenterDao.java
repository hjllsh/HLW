package com.hlw.dao;

import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;

import java.util.List;

public interface PersonalCenterDao {
    PersonalCenter findMyPersonalByUserId(String userId);

    void updateMyHeadshot(PersonalCenter personalCenter);

    void initMyPersonalCenter(PersonalCenter personalCenter);
//    List<MyOrders> getAllOrder(MyOrders myOrders);
}
