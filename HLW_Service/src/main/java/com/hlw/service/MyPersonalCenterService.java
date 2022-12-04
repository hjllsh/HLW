package com.hlw.service;

import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;

import java.util.List;

public interface MyPersonalCenterService {
    PersonalCenter findMyPersonalByUserId(String userId);

    void initMyPersonalCenter(User user);
//    List<MyOrders> getAllOrder(MyOrders myOrders);

    void updateMyHeadshot(PersonalCenter personalCenter);


}
