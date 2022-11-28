package com.hlw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.hlw.service","com.hlw.dao"})
@PropertySource("druid.propertise")
//@Import({})
public class SpringConfig {
}
