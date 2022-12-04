package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.PersonalCenter;
import com.hlw.domain.User;
import com.hlw.service.MyPersonalCenterService;
import com.hlw.utils.QiniuUtils;
import com.hlw.utils.UuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/myPersional")
public class MyPersonalCenterController {
    @Autowired
    private MyPersonalCenterService myPersonalCenterService;
    @Autowired
    private UserController userController;
    @RequestMapping("/changeHeadshot")
    public Result changeHeadshot(HttpSession session, @RequestParam("headshot")MultipartFile file){
//        获取原始文件名
        String originalFileName = file.getOriginalFilename();
//        获取文件后缀名
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") - 1);
//        设置文件名
        String fileName = UuId.getUuId() + suffix;
        User user = (User)session.getAttribute("user");
//        更新数据session
        user.setHeadshot(fileName);
        session.setAttribute("user",user);
//        调用userController的方法
        userController.showHeadshot(session);
        userController.updatePersonalCenter(session,(PersonalCenter) session.getAttribute("personalCenter"));

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
    public Result showMytrade(HttpSession session){
        String userId = (String)session.getAttribute("userId");
        System.out.println(userId);
        PersonalCenter personalCenter = myPersonalCenterService.findMyPersonalByUserId(userId);
        session.setAttribute("personalCenter",personalCenter);
        return new Result(true,personalCenter,MessageConstant.INQUIRE_SUCCESS);
    }


}
