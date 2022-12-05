package com.hlw.service.impl;

import com.hlw.dao.UserDao;
import com.hlw.domain.Goods;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FunctionServiceImpImpl implements FunctionService {
    @Autowired
    private UserDao userDao;
    public boolean doUpdatePersonalCenter(PersonalCenter personalCenter) {
        boolean flag = true;
        try {
            userDao.updatePersonalCenter(personalCenter);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            return flag;
        }
        return flag;
    }
    public void doRecharge(Float money, String userId) {
        Float oldMoney = userDao.findAccountById(userId);
        Float newAccount = oldMoney + money;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("newAccount",newAccount);
        userDao.updatePersonalCenterAccount(map);
        userDao.updateUserAccount(map);
    }
    public void doModifyPass(String newPass, String userId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("newPass",newPass);
        userDao.updatePass(map);
    }

    public List<Goods> getMyAllGoods(String userId, Integer pageSize, Integer currentPage) {
        try {
//            PageHelper.startPage(currentPage,3);
//            Page<Goods> page = userDao.getMyAllGoods(userId);
//            System.out.println(page.getTotal());
//            System.out.println(page.getResult());
//            List<Goods> list=page.getResult();
//            for (Goods goods : list) {
//                System.out.println(goods);
//            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteGoods(String goodsId) {
        try {
            userDao.deleteGoods(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MyOrders> getAllOrders(String userId) {
        return userDao.getAllOrder(userId);
    }
}
