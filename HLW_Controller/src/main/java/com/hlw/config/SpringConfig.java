package com.hlw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@ComponentScan({"com.hlw.service","com.hlw.dao"})
@PropertySource("classpath:druid.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableTransactionManagement//开启事务
public class SpringConfig {
}
