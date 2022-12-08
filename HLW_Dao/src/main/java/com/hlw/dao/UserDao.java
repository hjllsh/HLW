package com.hlw.dao;

import com.hlw.domain.Goods;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.github.pagehelper.Page;
import com.hlw.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.ImportResource;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User findUserById(Map info);

    public void newUser(User user);

    public Float findAccountById(String userid);

    void updatePersonalCenterAccount(Map map);

    void updateUserAccount(Map map);

    void updatePass(Map map);

    void findPass(Map info);

    void updatePersonalCenter(PersonalCenter personalCenter);

    void updateHeadshot(User user);

    public List<Goods> getMyAllGoods(@Param("size") Integer size, @Param("start") Integer start, @Param("queryString") String queryString);

    void deleteGoods(String goodsId);

    void deleteImg(String goodsId);

    void deleteGoodsList(String goodsId);

    List<MyOrders> getAllOrders(@Param("size") Integer size, @Param("start") Integer start, @Param("queryString") String queryString);

    List<MyTrade> getMyTrade(@Param("size") Integer size, @Param("start") Integer start, @Param("userId") String userId);

    Integer getMyTotalGoods(@Param("userId") String userId);

    int getMyTotalTrade(String userId);

    List<String> getMainInfo(String goodsId);

    Integer getTotalOrders(@Param("userId") String userId);

    Goods getGoodsInfo(String goodsId);

    void updatePartUser(@Param("email") String email,@Param("userName") String userName,@Param("headshot") String headshot, @Param("userId") String userId);
}
