package com.hlw.controller;

import com.hlw.constant.Result;
import com.hlw.domain.MyOrders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mytrade")
public class MytradeController {
    @RequestMapping("/order")
    public Result order(MyOrders orders){
        return null;
    }
}
