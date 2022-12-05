package com.hlw.controller;

import com.hlw.constant.LoginUser;
import com.hlw.constant.MessageConstant;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.constant.Result;
import com.hlw.service.MyPersonalCenterService;
import com.hlw.service.UserService;
import com.hlw.utils.Email;
import com.hlw.utils.UuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MyPersonalCenterService myPersonalCenterService;

    //    注册获取邮箱验证码
    @RequestMapping("/getEmailCheckCode")
    public Result getCheckCode(HttpSession session, String email) {
        String emailCode = Email.getEmailCheckCode();
        session.setAttribute("emailCode", emailCode);
        try {
            Email.sendEmail(email, "用户注册:", "<div>hlw交易平台注册码为：" + emailCode + "(5分钟内有效)</div>", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_EMAIL_FAIL);
        }
        return new Result(true, emailCode, MessageConstant.SEND_EMAIL_SUCCESS);
    }

    //    注册账户
    @RequestMapping("/register")
    public Result register(HttpSession session, User user) {
        System.out.println(user);
        session.removeAttribute("emailCode");
        String substring = UuId.getUuId().substring(6, 14);
        //账户初始化值
        user.setAccount(0.0F);
        //默认名称
        user.setUserName(substring);
        //默认头像
        user.setHeadshot("http://rm9hwdyan.hn-bkt.clouddn.com/610984CD01335934A904CD531CCBB579.jpg");
        System.out.println(user);
        userService.newUser(user);
        myPersonalCenterService.initMyPersonalCenter(user);
        return new Result(true, MessageConstant.ENROLL_SUCCESS);
    }

//    登录功能
        @RequestMapping("/login")
        public Result login (HttpSession session, LoginUser loginUser){
            session.removeAttribute("code");
            Map<String, String> info = new HashMap<String, String>();
            info.put("userId", loginUser.getUserId());
            info.put("password", loginUser.getPassword());
            User user = userService.findUserById(info);
            session.setAttribute("user", user);
//            System.out.println(user);
//            String password = user.getPassword();
            if (user != null) {
                session.setAttribute("userId", loginUser.getUserId());
                return new Result(true, MessageConstant.LOGIN_SUCCESS);
            } else {
                return new Result(false, MessageConstant.LOGIN_FAIL);
            }
        }
//    找回密码发送邮箱
        @RequestMapping("/getEmail")
        public Result getEmail (User user){
            System.out.println(user);
            HashMap<String, String> info = new HashMap<String, String>();
            info.put("userId", user.getUserId());
            info.put("password", null);
            User realUser = userService.findUserById(info);
            System.out.println(realUser);
            if (realUser == null) {
                return new Result(false, "用户名不存在");
            }
            if (user.getEmail().equals(user.getEmail())) {
                String emailCode = Email.getEmailCheckCode();
                Email.sendEmail(realUser.getEmail(), "找回密码", "<div>hlw交易平台找回密码的验证码为：" + emailCode + "(5分钟内有效)</div>", true);
                return new Result(true, emailCode, MessageConstant.SEND_EMAIL_SUCCESS);
            } else {
                return new Result(false, MessageConstant.SEND_EMAIL_FAIL);
            }
        }
//    找回密码的修改密码
        @RequestMapping("/findPass")
        public Result findPass (User user){
            boolean flag = userService.findPass(user.getUserId(), user.getPassword());
            if (flag) {
                return new Result(flag, MessageConstant.CHANGE_PASSWORD_SUCCESS);
            } else {
                return new Result(flag, MessageConstant.CHANGE_PASSWORD_FAIL);
            }
        }
//    头像查询
        @RequestMapping("/showHeadshot")
        public Result showHeadshot (HttpSession session){
            User user = (User) session.getAttribute("user");
            String headshot = user.getHeadshot();
            String userName = user.getUserName();
            List<String> list = new ArrayList<String>();
            list.add(headshot);
            list.add(userName);
            return new Result(true, list, "头像查询成功");
        }
//     充值
        @RequestMapping("/recharge")
        public Result recharge(HttpSession session, Float money) {
            String userId = (String) session.getAttribute("userId");
            try {
                userService.doRecharge(money, userId);
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
                userService.doModifyPass(newPass, userId);
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
//        更新个人中心信息
        @RequestMapping("/updatePersonalCenter")
        public Result updatePersonalCenter(HttpSession session,@RequestBody PersonalCenter personalCenter) {
            String userId = (String) session.getAttribute("userId");
            personalCenter.setUserId(userId);
            if (personalCenter != null) {
                boolean flag = userService.doUpdatePersonalCenter(personalCenter);
                //更新成功后改变session的值
                User user = (User)session.getAttribute("user");
                user.setUserName(personalCenter.getUserName());
                session.setAttribute("user",user);
                return new Result(true, MessageConstant.MODIFY_SUCCESS);
            } else {
                return new Result(false, MessageConstant.MODIFY_FAIL);
            }
        }
}
