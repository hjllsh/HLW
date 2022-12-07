package com.hlw.controller;

import com.hlw.constant.MessageConstant;
import com.hlw.constant.PageResult;
import com.hlw.constant.Pagination;
import com.hlw.constant.Result;
import com.hlw.domain.Goods;
import com.hlw.domain.GoodsImg;
import com.hlw.domain.GoodsList;
import com.hlw.service.GoodsListService;
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
@RequestMapping("/goods")
public class GoodsListController {
    @Autowired
    GoodsListService goodsListService;
    @RequestMapping("/showGoodsList")
    public PageResult showGoodsList(@RequestBody Pagination pagination, HttpSession session){
        System.out.println(pagination);
        PageResult<GoodsList> pageResult = goodsListService.showGoodsList(pagination);
        return pageResult;
    }
}
