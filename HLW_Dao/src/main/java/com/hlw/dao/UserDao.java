package com.hlw.dao;

import com.hlw.domain.Goods;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
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
    List<MyOrders> getAllOrders(@Param("size") Integer size, @Param("start") Integer start, @Param("queryString") String queryString);

    Integer getMyTotalGoods(@Param("userId") String userId);

    Integer getTotalOrders(@Param("userId") String userId);
}
