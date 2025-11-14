package com.webboard.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.webboard.mapper")
public class MyBatisConfig {
}
