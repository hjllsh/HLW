package com.hlw.utils;

import cn.hutool.extra.mail.MailUtil;

public class Email {
    public static void sendEmail(String sendTo, String title, String ContentCode, boolean isHtml){
        MailUtil.send(sendTo, title, ContentCode, isHtml);
    }
    public static String getEmailCheckCode(){
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<6; i++){
            int random = (int)(Math.random() * 10);
            buffer.append(""+random);
        }
        return buffer.toString();
    }

}
