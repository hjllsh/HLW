package com.hlw.controller;

import cn.hutool.http.HttpResponse;
import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.MyPersonalCenterService;
import com.hlw.service.UserService;
import com.hlw.utils.QiniuUtils;
import com.hlw.utils.UuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/myPersional")
public class MyPersonalCenterController {
    @Autowired
    private MyPersonalCenterService myPersonalCenterService;
    @Autowired
    private UserService userService;

    @RequestMapping("/changeHeadshot")
    public Result changeHeadshot(HttpServletResponse response,HttpServletRequest request, HttpSession session, @RequestParam("headshot")MultipartFile file){
//        获取原始文件名
        String originalFileName = file.getOriginalFilename();
//        获取文件后缀名
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") - 1);
//        设置文件名
        String fileName = UuId.getUuId() + suffix;
        User user = (User)session.getAttribute("user");
//        更新数据session
        user.setHeadshot("http://rm9hwdyan.hn-bkt.clouddn.com/"+fileName);
        session.setAttribute("user",user);
        PersonalCenter personalCenter = (PersonalCenter) session.getAttribute("personalCenter");
        personalCenter.setHeadshot("http://rm9hwdyan.hn-bkt.clouddn.com/"+fileName);
        myPersonalCenterService.updateMyHeadshot(personalCenter);
        userService.updateHeadshot(user);
        try {
//            上传图片
            QiniuUtils.upload2Qiniu(file.getBytes(),fileName);
//            上传成功
            return new Result(true, fileName, MessageConstant.CHANGE_AVATAR_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.CHANGE_AVATAR_FAIL);
        }
    }

    @RequestMapping("/getMyPersionalCenterInfo")
    @ResponseBody
    public Result showMytrade(HttpSession session){
        String userId = (String)session.getAttribute("userId");
        System.out.println(userId);
        PersonalCenter personalCenter = myPersonalCenterService.findMyPersonalByUserId(userId);
        System.out.println(personalCenter);
        session.setAttribute("personalCenter",personalCenter);
        return new Result(true,personalCenter,MessageConstant.INQUIRE_SUCCESS);
    }

    @RequestMapping("/uploadImages")
    public Result uploadImages(HttpServletResponse response,HttpServletRequest request, HttpSession session, @RequestParam("headshot")MultipartFile file){
//        获取原始文件名
        String originalFileName = file.getOriginalFilename();
//        获取文件后缀名
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") - 1);
//        设置文件名
        String fileName = UuId.getUuId() + suffix;
        try {
//            上传图片
            QiniuUtils.upload2Qiniu(file.getBytes(),fileName);
//            上传成功,存入session
            ArrayList<String> images = (ArrayList) session.getAttribute("images");
            if (images == null){
                images = new ArrayList<String>();
            }
            images.add("http://rm9hwdyan.hn-bkt.clouddn.com/"+fileName);
            session.setAttribute("images",images);
            return new Result(true, fileName, MessageConstant.CHANGE_AVATAR_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.CHANGE_AVATAR_FAIL);
        }
    }
}
