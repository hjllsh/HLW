package com.hlw.utils;

import cn.hutool.extra.mail.MailUtil;

public class Email {
    public static void sendEmail(String sendTo, String code){

        MailUtil.send(sendTo, "找回密码", "dasd"+code, false);
    }


}
