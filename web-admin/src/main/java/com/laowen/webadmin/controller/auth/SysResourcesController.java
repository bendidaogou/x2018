package com.laowen.webadmin.controller.auth;

import com.alibaba.fastjson.JSON;
import com.laowen.auth.domain.SysResources;
import com.laowen.auth.service.SysResourcesService;
import com.laowen.common.utils.CommonUtil;
import com.laowen.common.utils.Result;
import com.laowen.webadmin.common.TableData;
import com.laowen.webadmin.model.auth.SysResourcesVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sys/resources")
public class SysResourcesController {

    @Autowired
    private SysResourcesService sysResourcesService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("dialogId", CommonUtil.getLenStr(8));
        return "/auth/resources/index";
    }

    //region 权限

    //权限列表
    @RequestMapping("/perm/list")
    @ResponseBody
    public TableData list(String menuId) {
        //List<SysResources> permList = sysResourcesService.selectPermList(menuId);
        List<SysResourcesVO> permList = JSON.parseArray(
                JSON.toJSONString(sysResourcesService.selectPermList(menuId))
                , SysResourcesVO.class
        );
        return new TableData() {{
            setRows(permList);
            setTotal(permList.size());
        }};
    }

    //权限添加
    @RequestMapping(path = "/perm/edit", method = {RequestMethod.POST})
    @ResponseBody
    public Result add(SysResourcesVO perm) {

        int effects = 0;
        if (StringUtils.isBlank(perm.getResourcesId())) {
            effects = sysResourcesService.insertOne(perm);
        } else {
            effects = sysResourcesService.updateById(perm);
        }
        Result result = new Result();
        if (1 == effects) {
            result.setSuccessTag(true);
        } else {
            log.error("----操作失败,影响行:{}, 入参:{}", effects, perm);
            result.setMsg("操作失败");
        }
        return result;
    }

    //权限删除
    @RequestMapping(path = "/perm/del", method = {RequestMethod.POST})
    @ResponseBody
    public Result add(String resourcesId) {
        int effects = sysResourcesService.deleteById(resourcesId);
        Result result = new Result();
        if (1 == effects) {
            result.setSuccessTag(true);
        } else {
            log.error("----操作失败,影响行:{}, resourcesId:{}", effects, resourcesId);
            result.setMsg("操作失败");
        }
        return result;
    }
    //endregion


    //region 菜单

    //资源菜单
    @RequestMapping("/menu/list")
    @ResponseBody
    public TableData menu() {
        //List<SysResources> menuList = sysResourcesService.selectMenuList();
        List<SysResourcesVO> menuList = JSON.parseArray(
                JSON.toJSONString(sysResourcesService.selectMenuList())
                , SysResourcesVO.class
        );
        return new TableData() {{
            setRows(menuList);
            setTotal(menuList.size());
        }};
    }

    //endregion

}
