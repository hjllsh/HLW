package com.hlw.dao;

import com.github.pagehelper.Page;
import com.hlw.domain.Goods;
import com.hlw.domain.MyTrade;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;

import java.util.HashMap;
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

    Page<Goods> getMyAllGoods(String userId);

    void deleteGoods(String goodsId);

    List<MyTrade> getMyTrade(String userId);
}
