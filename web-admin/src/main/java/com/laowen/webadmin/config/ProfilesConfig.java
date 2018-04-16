package com.laowen.webadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载配置
 */
@Configuration
@ImportResource({"classpath:config/property-config.xml"})
public class ProfilesConfig {

}
