package com.hlw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.hlw.controller","com.hlw.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
