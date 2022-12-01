package com.hlw.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class CheckCodeController {
    @RequestMapping("/checkCode")
    public void getCheckCode(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(140, 70);

        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            lineCaptcha.write(response.getOutputStream());
            session.setAttribute("code",lineCaptcha.getCode());
            System.out.println(lineCaptcha.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/pages/checkCode",method = RequestMethod.GET)
    public void getCheckCodeFirst(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(140, 70);

        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            lineCaptcha.write(response.getOutputStream());
            session.setAttribute("code",lineCaptcha.getCode());
            System.out.println(lineCaptcha.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping( "/checkUserCode")
    public Result checkUserCode(HttpSession session, String checkCode){
        String code = (String)session.getAttribute("code");
        System.out.println(checkCode);
        if (checkCode.equals(code)){
            return new Result(true,MessageConstant.VALIDATECODE_SUCCESS);
        } else {
            return new Result(false, MessageConstant.VALIDATECODE_FAIL);
        }
    }
}
