package com.hlw.service.impl;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlw.dao.UserDao;
import com.hlw.domain.Goods;
import com.hlw.domain.PersonalCenter;
import com.hlw.service.FunctionService;
import org.apache.ibatis.annotations.Param;
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
            List<Goods> list = userDao.getMyAllGoods(size,start,queryString);
            System.out.println(list.size());
            for (Goods goods : list) {
                System.out.println(goods);
            }

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

    public Integer getMyTotalGoods(String userId) {
        Integer total = userDao.getMyTotalGoods(userId);
        return total;
    }
}
