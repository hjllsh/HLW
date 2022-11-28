package com.hlw.controller;

import com.hlw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String findUserById(){
        int id = 6;
        userService.findUserById(id);
        return "hello user";
    }
    @PostMapping
    public String upload(Object o){
        System.out.println(o);
        return "123";
    }
}
