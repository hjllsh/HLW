package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.Goods;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.FunctionService;
import com.hlw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

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
    @RequestMapping("/getMyGoods")
    public Result getMyGoods(HttpSession session){
        String userId = (String) session.getAttribute("userId");
        boolean flag = true;
        try {
            functionService.getMyGoods(userId);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
            return new Result(flag, MessageConstant.INQUIRE_FAIL);
        }
        return new Result(flag, MessageConstant.INQUIRE_SUCCESS);
    }
}