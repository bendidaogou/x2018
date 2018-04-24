package com.laowen.webadmin;

import com.laowen.auth.TestApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebAppTests {

    @Autowired
    private TestApp testApp;

    @Test
    public void contextLoads() {
        testApp.fn();

    }

}
