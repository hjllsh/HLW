package com.hlw.config;

import com.hlw.controller.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.hlw.controller","com.hlw.config"})
//开启json格式自动转换
@EnableWebMvc
public class SpringMvcConfig {


}
