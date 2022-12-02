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
//    注册获取邮箱验证码
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
//    注册账户
    @RequestMapping("/register")
    public Result register(HttpSession session, User user){
        System.out.println(user);
        session.removeAttribute("emailCode");
        String substring = UuId.getUuId().substring(0, 15);
        user.setAccount(0.0F);
        user.setUserName(substring);
        user.setHeadshot("http://rm9hwdyan.hn-bkt.clouddn.com/610984CD01335934A904CD531CCBB579.jpg");
        System.out.println(user);
        userService.newUser(user);
        return new Result(true,MessageConstant.ENROLL_SUCCESS);
    }
//    登录功能
    @RequestMapping("/login")
    public Result login(HttpSession session, LoginUser loginUser){
        session.removeAttribute("code");
        Map<String, String> info = new HashMap<String, String>();
        info.put("userId",loginUser.getUserId());
        info.put("password",loginUser.getPassword());
        User user = userService.findUserById(info);
        session.setAttribute("user",user);
        System.out.println(user);
        String password = user.getPassword();
        if (user != null) {
        session.setAttribute("userId",loginUser.getUserId());
            return new Result(true,MessageConstant.LOGIN_SUCCESS);
        } else {
            return new Result(false,MessageConstant.LOGIN_FAIL);
        }
    }
//    找回密码发送邮箱
    @RequestMapping("/getEmail")
    public Result getEmail(User user){
        System.out.println(user);
        HashMap<String, String> info = new HashMap<String, String>();
        info.put("userId",user.getUserId());
        info.put("password",null);
        User realUser = userService.findUserById(info);
        System.out.println(realUser);
        if (realUser == null){
            return new Result(false,"用户名不存在");
        }
        if (user.getEmail().equals(user.getEmail())){
            String emailCode = Email.getEmailCheckCode();
            Email.sendEmail(realUser.getEmail(),"找回密码","<div>hlw交易平台找回密码的验证码为："+ emailCode +"(5分钟内有效)</div>",true);
                return new Result(true, emailCode, MessageConstant.SEND_EMAIL_SUCCESS);
            }else {
                return new Result(false,MessageConstant.SEND_EMAIL_FAIL);
            }
    }
//    找回密码的修改密码
    @RequestMapping("/findPass")
    public Result findPass(User user){
        boolean flag = userService.findPass(user.getUserId(), user.getPassword());
        if (flag){
            return new Result(flag,MessageConstant.CHANGE_PASSWORD_SUCCESS);
        }else {
            return new Result(flag,MessageConstant.CHANGE_PASSWORD_FAIL);
        }
    }

    @RequestMapping("/showHeadshot")
    public Result showHeadshot(HttpSession session) {
        User user = (User)session.getAttribute("user");
        String headshot = user.getHeadshot();
        return new Result(true,headshot,"头像查询成功");
    }
}
