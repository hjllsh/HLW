package com.hlw.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CheckCodeController {
    @RequestMapping(value = "/checkCode",method = RequestMethod.GET)
    public void getCheckCode(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(140, 70);

        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            lineCaptcha.write(response.getOutputStream());
            session.setAttribute("code",lineCaptcha.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/checkUserCode",method = RequestMethod.GET)
    @ResponseBody
    public String getUserCheckCode(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        String code =(String) session.getAttribute("code");
        session.removeAttribute("code");
        return code;
    }
}
