package com.laowen.webadmin.controller.auth;

import com.laowen.auth.domain.SysResources;
import com.laowen.auth.service.SysResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/resources")
public class SysResourcesController {

    @Autowired
    private SysResourcesService sysResourcesService;

    @RequestMapping("/index")
    public String index() {
        return "/auth/resources/index";
    }


    @RequestMapping("/list")
    @ResponseBody
    public Map list() {
        Map<String, Object> map = new HashMap<>();
        List<SysResources> list = sysResourcesService.selectList(new SysResources());
        map.put("rows",list);
        map.put("total",10938);
        return map;
    }


}
