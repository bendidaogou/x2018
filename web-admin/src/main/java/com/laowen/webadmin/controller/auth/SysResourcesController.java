package com.laowen.webadmin.controller.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.laowen.auth.domain.SysResources;
import com.laowen.auth.service.SysResourcesService;
import com.laowen.common.utils.CommonUtil;
import com.laowen.common.utils.Result;
import com.laowen.webadmin.common.TableData;
import com.laowen.webadmin.model.auth.SysResourcesVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //权限添加
    @RequestMapping(path = "/perm/edit", method = {RequestMethod.POST})
    @ResponseBody
    public Result add(SysResourcesVO sysResourcesVO) {
        SysResources sysResources = new SysResources();
        BeanUtils.copyProperties(sysResourcesVO, sysResources);
        int effects = 0;
        if (StringUtils.isBlank(sysResourcesVO.getResourcesId())) {
            effects = sysResourcesService.insertOne(sysResources);
        } else {
            effects = sysResourcesService.updateById(sysResources);
        }
        Result result = new Result();
        if (1 == effects) {
            result.setSuccessTag(true);
        } else {
            log.error("----操作失败,影响行:{}, 入参:{}", effects, sysResourcesVO);
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
