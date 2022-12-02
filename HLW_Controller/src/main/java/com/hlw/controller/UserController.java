package com.hlw.controller;

import com.hlw.constant.LoginUser;
import com.hlw.constant.MessageConstant;
import com.hlw.domain.User;
import com.hlw.constant.Result;
import com.hlw.service.UserService;
import com.hlw.utils.Email;
import com.hlw.utils.UuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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
        Map<String, String> info = new HashMap<String, String>();
        info.put("userId",loginUser.getUserId());
        info.put("password",loginUser.getPassword());
        User user = userService.findUserById(info);
        System.out.println(user);
        String password = user.getPassword();
        if (user != null) {
        session.setAttribute("userId",loginUser.getUserId());
            return new Result(true,MessageConstant.LOGIN_SUCCESS);
        } else {
            return new Result(false,MessageConstant.LOGIN_SUCCESS);
        }
    }

}
