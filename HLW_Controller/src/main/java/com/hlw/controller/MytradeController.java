package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.service.MytradeService;
import com.hlw.utils.QiniuUtils;
import com.hlw.utils.UuId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.management.MemoryManagerMXBean;

@RestController
@RequestMapping("/mytrade")
public class MytradeController {

    private MytradeService mytradeService;
    @RequestMapping("/changeHeadshot")
    public Result changeHeadshot(HttpSession session, @RequestParam("headshot")MultipartFile file){
//        获取原始文件名
        String originalFileName = file.getOriginalFilename();
//        获取文件后缀名
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") - 1);
//        设置文件名
        String fileName = UuId.getUuId() + suffix;
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
//    @RequestMapping("/showMytrade")
//    public Result showMytrade()

}
