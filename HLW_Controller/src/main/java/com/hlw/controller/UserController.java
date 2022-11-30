package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.domain.User;
import com.hlw.constant.Result;
import com.hlw.service.UserService;
import com.hlw.utils.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String findUserById(){
        int id = 6;
        userService.findUserById(id);
        return "hello user";
    }
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
            return new Result(false,MessageConstant.ENROLL_FAIL);
        }
        return new Result(true, emailCode, MessageConstant.ENROLL_SUCCESS);
    }
    @RequestMapping("/register")
    public Result register(HttpSession session, User user){
        session.removeAttribute("emailCode");
        System.out.println(user);
        userService.newUser(user);
        return new Result(false,"123");
    }
}
