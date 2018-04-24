package com.laowen.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: ${todo}
 * @author: wenshiwei
 * @date: 2018-04-24
 */
@Component
public class TestApp {

    @Value("${x2018.url}")
    private String xx;

    @Value("${test-piror}")
    private String x3;

    public void fn(){
        System.out.println(xx);
    }

}
