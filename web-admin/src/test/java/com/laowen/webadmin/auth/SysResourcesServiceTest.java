package com.laowen.webadmin.auth;

import com.laowen.auth.domain.SysResources;
import com.laowen.auth.service.SysResourcesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysResourcesServiceTest {

    @Autowired
    private SysResourcesService sysResourcesService;

    @Test
    public void test01() {
        List<SysResources> list = sysResourcesService.selectList(new SysResources() {{
            setResourcesName("角色");
        }});
        System.out.println(list);
    }

}
