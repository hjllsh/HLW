package com.hlw.controller;

import com.hlw.constant.LoginUser;
import com.hlw.constant.MessageConstant;
import com.hlw.domain.User;
import com.hlw.constant.Result;
import com.hlw.service.UserService;
import com.hlw.utils.Email;
import com.hlw.utils.UuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result upload(Object o){
        System.out.println(o);
        return new Result(false,"123");
    }

    @RequestMapping("/getEmailCheckCode")
    public Result getCheckCode(HttpSession session,String email){
        String emailCode = Email.getEmailCheckCode();
        session.setAttribute("emailCode",emailCode);
        try {
            Email.sendEmail(email, "用户注册:","<div>hlw交易平台注册码为："+ emailCode +"(5分钟内有效)</div>",true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.SEND_EMAIL_FAIL);
        }
        return new Result(true, emailCode, MessageConstant.SEND_EMAIL_SUCCESS);
    }
    @RequestMapping("/register")
    public Result register(HttpSession session, User user){
        System.out.println(user);
        session.removeAttribute("emailCode");
        String substring = UuId.getUuId().substring(0, 15);
        user.setUserName(substring);
        user.setHeadshot("default.jpg");
        System.out.println(user);
        userService.newUser(user);
        return new Result(true,MessageConstant.ENROLL_SUCCESS);
    }
    @RequestMapping("/login")
    public Result login(HttpSession session, LoginUser loginUser){
        session.removeAttribute("code");
        System.out.println(loginUser);
        User user = userService.findUserById(loginUser.getUserId());
        System.out.println(user);
        String password = user.getPassword();
        if (password != null && password.equals(loginUser.getPassword())) {
            return new Result(true,MessageConstant.LOGIN_SUCCESS);
        } else {
            return new Result(false,MessageConstant.LOGIN_SUCCESS);
        }
//        session.setAttribute("userId",loginUser.getUserId());
    }

}
