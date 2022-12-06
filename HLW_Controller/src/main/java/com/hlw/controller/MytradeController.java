package com.hlw.controller;

import com.hlw.domain.MyOrders;
import com.hlw.service.MyPersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mytrade")
public class MytradeController {
    @Autowired
    private MyPersonalCenterService myPersonalCenterService;
    @GetMapping("/orders")
    public List<MyOrders> orders(MyOrders myOrders){
        return null;
    }
}
