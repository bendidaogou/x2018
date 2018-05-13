package com.laowen.webadmin.controller.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.laowen.auth.domain.SysResources;
import com.laowen.auth.service.SysResourcesService;
import com.laowen.webadmin.common.TableData;
import com.laowen.webadmin.model.auth.SysResourcesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/resources")
public class SysResourcesController {

    @Autowired
    private SysResourcesService sysResourcesService;

    @RequestMapping("/index")
    public String index() {
        return "/auth/resources/index";
    }

    //权限列表
    @RequestMapping("/perm/list")
    @ResponseBody
    public TableData list(String menuId) {
        List<SysResources> sysResources = sysResourcesService.selectPermList(menuId);
        List<SysResourcesVO> voList = JSON.parseObject(JSON.toJSONString(sysResources), new TypeReference<List<SysResourcesVO>>() {
        });
        return new TableData() {{
            setRows(voList);
            setTotal(voList.size());
        }};
    }

    //菜单列表
    @RequestMapping("/menu/list")
    @ResponseBody
    public TableData menu() {
        List<SysResources> sysResources = sysResourcesService.selectMenuList();
        List<SysResourcesVO> voList = JSON.parseObject(JSON.toJSONString(sysResources), new TypeReference<List<SysResourcesVO>>() {
        });
        return new TableData() {{
            setRows(voList);
            setTotal(voList.size());
        }};
    }


}
