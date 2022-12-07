package com.hlw.dao;

import cn.hutool.db.sql.Order;
import com.hlw.domain.MyOrders;
import org.apache.ibatis.annotations.Param;

public interface MyOrderDao {

    void addOrder(MyOrders order);

    void updateUserAccount(String userId, Float account);

    void updatePersonalCenterAccount(String userId, Float account);
}
