package com.hlw.service.impl;

import com.hlw.dao.MyOrderDao;
import com.hlw.domain.MyOrders;
import com.hlw.domain.MyTrade;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyOrderServiceImpl implements MyOrderService {
    @Autowired
    MyOrderDao myOrderDao;

    public void addOrder(MyOrders order) {
        myOrderDao.addOrder(order);
    }

    public void updateUserAccount(User user) {
        myOrderDao.updateUserAccount(user.getUserId(),user.getAccount());
    }

    public void updatePersonalCenterAccount(PersonalCenter personalCenter) {
    myOrderDao.updatePersonalCenterAccount(personalCenter.getUserId(), personalCenter.getAccount());
    }

    public void updateGoodsNum(String goodId, int totalNum) {
        if (totalNum < 0){
            throw new RuntimeException("数量不足");
        }
        myOrderDao.updateGoodsNum(goodId,totalNum);
    }

    public int getGoodsNum(String goodsId) {
        return myOrderDao.getGoodsNum(goodsId);
    }

    public void insertMyTrade(MyOrders order){
        String sellerId = myOrderDao.selectSellerId(order.getGoodsId());
        MyTrade myTrade = new MyTrade(order.getGoodsName(), order.getLocation(),
                order.getPhonenumber(), order.getBuyNum(), order.getIsTransport(),
                order.getTotalPrice(), order.getOrderId(), sellerId);
        if(myTrade.getTransportFare().equals("true")){
            myTrade.setTransportFare("已购买");
        }else if(myTrade.getTransportFare().equals("false")){
            myTrade.setTransportFare("未购买");
        }
        myOrderDao.insertMyTrade(myTrade);
    }

}
