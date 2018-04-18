package com.laowen.webadmin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${test-piror}")
    private String testPiror;

    //测试config下的配置会覆盖resources下面的
    @RequestMapping("/index")
    public String index() {
        return testPiror;
    }

}
