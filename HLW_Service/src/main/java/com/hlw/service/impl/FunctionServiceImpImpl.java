package com.hlw.service.impl;



import com.hlw.dao.UserDao;
import com.hlw.domain.Goods;
import com.hlw.domain.GoodsImg;
import com.hlw.domain.MyTrade;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
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

    public List<Goods> getMyAllGoods(String queryString, Integer size, Integer start) {
        try {
            List<Goods> list = userDao.getMyAllGoods(size,(start-1)*size,queryString);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Goods>();
        }
    }

    public void deleteGoods(String goodsId) {
        try {
            userDao.deleteGoods(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  List<MyTrade> getMyTrade(String userId, Integer pageSize, Integer currentPage){
        try {

            return userDao.getMyTrade(pageSize, (currentPage-1)*pageSize,userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getMyTotalTrade(String userId) {
        try {
            return userDao.getMyTotalTrade(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<GoodsImg> getMainInfo(String goodsId) {
        try {
            return userDao.getMainInfo(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getMyTotalGoods(String userId) {
        Integer total = userDao.getMyTotalGoods(userId);
        return total;
    }

    public List<MyOrders> getAllOrders(String queryString, Integer size, Integer start) {
        try {
            start=(start-1)*size;
            List<MyOrders> list = userDao.getAllOrders(size,start,queryString);
            System.out.println(list.size());
            for (MyOrders myOrders : list) {
                System.out.println(myOrders);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<MyOrders>();
        }
    }

    public Integer getTotalOrders(String userId) {
        Integer total = userDao.getTotalOrders(userId);
        return total;
    }
}
