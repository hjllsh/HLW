package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.Store;
import com.hlw.service.SellerService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    //提交表单
    @RequestMapping("/submit")
    public Result submit(@RequestBody Store store,HttpSession session){
        String userid = (String)session.getAttribute("userid");
        userid="123";
        store.setUserId(userid);
        try {
            sellerService.sellerAdd(store);
            System.out.println(store);
        } catch (Exception e) {
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.SELLER_CERTIFICATION_FAIL);
        }
        return new Result(true,MessageConstant.SELLER_CERTIFICATION_SUCCESS);
    }
}
