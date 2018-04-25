package com.laowen.auth.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.laowen.auth.dao")
public class MapperConfig {

}
