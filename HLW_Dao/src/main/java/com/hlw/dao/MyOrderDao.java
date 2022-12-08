package com.hlw.dao;

import cn.hutool.db.sql.Order;
import com.hlw.domain.MyOrders;
import com.hlw.domain.MyTrade;
import org.apache.ibatis.annotations.Param;

public interface MyOrderDao {

    void addOrder(MyOrders order);

    void updateUserAccount(@Param("userId") String userId, @Param("account")Float account);

    void updatePersonalCenterAccount(@Param("userId") String userId, @Param("account") Float account);

    void updateGoodsNum(@Param("goodsId")String goodId, @Param("totalNum") int totalNum);

    int getGoodsNum(@Param("goodsId") String goodsId);

    void insertMyTrade(MyTrade myTrade);

    String selectSellerId(String goodsId);
}
