package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.MyOrderService;
import com.hlw.utils.UuId;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/order")
public class MyOrderController {
    @Autowired
    MyOrderService myOrderService;
    //提交表单
    @RequestMapping("/buy")
    public Result buy(@RequestBody MyOrders order, HttpSession session) {
        String userid = (String)session.getAttribute("userId");
        order.setOrderId(UuId.getUuId().substring(10,20));
        order.setUserId(userid);
        Date date = new Date();
        // 创建日期格式化对象,在获取格式化对象时可以指定风格
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = df.format(date);
        order.setBuyTime(str);
        System.out.println(order);
        myOrderService.addOrder(order);
        User user = (User)session.getAttribute("user");
        Float account = user.getAccount();
        if (account - order.getTotalPrice() < 0){
            return new Result(false,MessageConstant.PURCHASE_FAIL);
        }
        user.setAccount(account - order.getTotalPrice());
        session.setAttribute("user",user);
        myOrderService.updateUserAccount(user);
        PersonalCenter personalCenter = (PersonalCenter)session.getAttribute("personalCenter");
        personalCenter.setAccount(account - order.getTotalPrice());
        session.setAttribute("personalCenter",personalCenter);
        myOrderService.updatePersonalCenterAccount(personalCenter);
        int oldNum = myOrderService.getGoodsNum(order.getGoodsId());
        int totalNum = oldNum - order.getBuyNum();
        try{
            myOrderService.updateGoodsNum(order.getGoodsId(),totalNum);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.PURCHASE_FAIL);
        }

        return new Result(true, MessageConstant.PURCHASE_SUCCESS);
    }
}