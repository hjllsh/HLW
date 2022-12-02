package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.Goods;
import com.hlw.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    UploadService uploadService;
    @RequestMapping("/release")
    public Result release(@RequestBody Goods goods, HttpSession session){
        String userId= (String) session.getAttribute("userId");
        goods.setUserId(userId);
        String goodsId= (String) session.getAttribute("goodsId");
        goodsId="123456";
        goods.setGoodsId(goodsId);
        try {
            uploadService.releaseGoods(goods);
            System.out.println(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.RELEASE_PRODUCT_FAIL);
        }
        return new Result(true, MessageConstant.RELEASE_PRODUCT_SUCCESS);
    }
}
