package com.hlw.controller;

import cn.hutool.core.bean.BeanUtil;
import com.hlw.constant.MessageConstant;
import com.hlw.constant.Result;
import com.hlw.domain.Goods;
import com.hlw.domain.GoodsImg;
import com.hlw.domain.GoodsList;
import com.hlw.service.UploadService;
import com.hlw.utils.TimeUtils;
import com.hlw.utils.UuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    UploadService uploadService;
    @RequestMapping("/release")
    public Result release(@RequestBody Goods goods, HttpSession session){
        String userId= (String) session.getAttribute("userId");
        goods.setUserId(userId);
        try {
            goods.setReleaseTime(TimeUtils.changeTime(goods.getReleaseTime().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
            new Result(false,MessageConstant.RELEASE_PRODUCT_FAIL);
        }
        String goodsId= UuId.getUuId().substring(0,19);
        session.setAttribute("goodsId",goodsId);
        goods.setGoodsId(goodsId);
        ArrayList images = (ArrayList) session.getAttribute("images");
        String mainImg = (String) images.get(0);
        GoodsImg goodsImg = new GoodsImg(userId,goodsId,images);
//        GoodsList goodsList = new GoodsList();

        try {
            uploadService.releaseGoods(goods);
            uploadService.uploadImages(goodsImg);
            GoodsList goodsList = BeanUtil.copyProperties(goods, GoodsList.class);
            goodsList.setGoodsMainImg(mainImg);
            String storeName =  uploadService.findStoreName(userId);
            goodsList.setStoreName(storeName);
            uploadService.uploadGoodsList(goodsList);
            System.out.println(goods);
            System.out.println(goodsList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.RELEASE_PRODUCT_FAIL);
        }
        return new Result(true, MessageConstant.RELEASE_PRODUCT_SUCCESS);
    }

}
