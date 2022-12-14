package com.hlw.controller;

import cn.hutool.db.sql.Order;
import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.Goods;
import com.hlw.domain.MyOrders;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.domain.*;
import com.hlw.service.FunctionService;
import com.hlw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;
    //     充值
    @RequestMapping("/recharge")
    public Result recharge(HttpSession session, Float money) {
        String userId = (String) session.getAttribute("userId");
        try {
            functionService.doRecharge(money, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.RECHARGE_FAIL);
        }
        return new Result(true, MessageConstant.RECHARGE_SUCCESS);
    }
    //     修改密码
    @RequestMapping("/modifyPass")
    public Result modifyPass (HttpSession session, String newPass){
        String userId = (String) session.getAttribute("userId");
        User user = (User) session.getAttribute("user");
        user.setPassword(newPass);
        session.setAttribute("user",user);
        try {
            functionService.doModifyPass(newPass, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.CHANGE_PASSWORD_FAIL);
        }
        return new Result(true, MessageConstant.CHANGE_PASSWORD_SUCCESS);
    }
    //        获取账号
    @RequestMapping("/getUserId")
    public String getUserId(HttpSession session){
        String userId = (String) session.getAttribute("userId");
        return userId;
    }
    //        获取密码
    @RequestMapping("/getPassword")
    public String getPassword(HttpSession session){
        User user = (User) session.getAttribute("user");
        String password = user.getPassword();
        return password;
    }
    //        获取个人中心信息
    @RequestMapping("/updatePersonalCenter")
    public Result updatePersonalCenter(HttpSession session, PersonalCenter personalCenter, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String userId = (String) session.getAttribute("userId");
        boolean flag = true;
        try {
            personalCenter.setUserId(userId);
            System.out.println(personalCenter);
            flag = functionService.doUpdatePersonalCenter(personalCenter);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
            return new Result(flag, MessageConstant.MODIFY_FAIL);
        }
        return new Result(flag, MessageConstant.MODIFY_SUCCESS);
    }
//    获取我发布的商品
    @RequestMapping("/getMyAllGoods")
    public Result getMyAllGoods(HttpSession session, Integer pageSize, Integer currentPage){
        String userId = (String) session.getAttribute("userId");
        boolean flag = true;
        try {
            List<Goods> list = functionService.getMyAllGoods(userId, pageSize, currentPage);
            return new Result(flag,list,MessageConstant.INQUIRE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            return new Result(flag, MessageConstant.INQUIRE_FAIL);
        }
    }
//    获取商品信息
    @RequestMapping("/getGoodsInfo")
    public Result getGoodsInfo(HttpSession session, String goodsId){
        try {
            System.out.println(goodsId);
            Goods goods = functionService.getGoodsInfo(goodsId);
            return new Result(true, goods, MessageConstant.INQUIRE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.INQUIRE_FAIL);
        }
    }
//    下架商品
    @RequestMapping("/deleteGoods")
    public Result deleteGoods(HttpSession session, String goodsId){
        boolean flag = true;
        try {
            functionService.deleteGoods(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            return new Result(flag, MessageConstant.SOLDOUT_FAIL);
        }
        return new Result(flag, MessageConstant.SOLDOUT_SUCCESS);
    }
//        查询我的所有商品总数
    @RequestMapping("/getMyTotalGoods")
    public Result getMyTotalGoods(HttpSession session){
        String userId = (String)session.getAttribute("userId");
        try {
            int total = functionService.getMyTotalGoods(userId);
            return new Result(true,total,MessageConstant.INQUIRE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,0,MessageConstant.INQUIRE_FAIL);
        }
    }

    //我买的
    @RequestMapping("/getAllOrders")
    public Result getAllOrders(HttpSession session, Integer pageSize, Integer currentPage){
        String userId = (String) session.getAttribute("userId");
        try {
            List<MyOrders> list=functionService.getAllOrders(userId, pageSize, currentPage);
            return new Result(true, list, MessageConstant.INQUIRE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.INQUIRE_FAIL);
        }
    }

    @RequestMapping("getTotalOrders")
    public Result getTotalOrders(HttpSession session){
        String userId = (String) session.getAttribute("userId");
        try {
            int total = functionService.getTotalOrders(userId);
            return new Result(true,total,MessageConstant.INQUIRE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,0,MessageConstant.INQUIRE_FAIL);
        }
    }
    //    获取我卖的订单
    @RequestMapping("/getMyTrade")
    public Result getMyTrade(HttpSession session, Integer pageSize, Integer currentPage){
        String userId = (String) session.getAttribute("userId");
        List<MyTrade> list = new ArrayList<MyTrade>();
        boolean flag = true;
        try {
            list = functionService.getMyTrade(userId, pageSize, currentPage);
            for (MyTrade myTrade: list){
                System.out.println(myTrade);
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            return new Result(flag, MessageConstant.INQUIRE_FAIL);
        }
        return new Result(flag, list, MessageConstant.INQUIRE_SUCCESS);
    }
//    获得我的所有卖出
    @RequestMapping("getMyTotalTrade")
    public Result getMyTotalTrade(HttpSession session){
        String userId = (String) session.getAttribute("userId");
        try {
            int count = functionService.getMyTotalTrade(userId);
            return new Result(true, count, MessageConstant.INQUIRE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.INQUIRE_FAIL);
        }
    }
//    获取商品信息
    @RequestMapping("/getMainInfo")
    public Result getMainInfo(HttpSession session, String goodsId){
        List<String> list = new ArrayList<String>();
        boolean flag = true;
        try {
            list = functionService.getMainInfo(goodsId);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(flag, MessageConstant.INQUIRE_FAIL);
        }
        return new Result(flag, list, MessageConstant.INQUIRE_SUCCESS);
    }
    @RequestMapping("showInfo")
    public void showInfo(HttpSession session,@RequestBody MyOrders myOrders){
        System.out.println(myOrders);
    }
}