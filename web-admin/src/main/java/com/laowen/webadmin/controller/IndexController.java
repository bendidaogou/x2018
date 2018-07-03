package com.laowen.webadmin.controller;

import com.alibaba.fastjson.JSON;
import com.laowen.auth.service.SysResourcesService;
import com.laowen.webadmin.model.auth.SysResourcesVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private SysResourcesService sysResourcesService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "ziran");

        //region 二级菜单
        List<SysResourcesVO> menuList = JSON.parseArray(
                JSON.toJSONString(sysResourcesService.selectMenuList())
                , SysResourcesVO.class
        );
        menuList = buildTreeLeftMenu(menuList);
        String strMenu = buildLeftMenu(menuList);
        //endregion

        model.addAttribute("strMenu", strMenu);
        return "index";
    }

    /**
     * 菜单html结构，二级结构
     *
     * @param menuList
     * @return
     */
    private String buildLeftMenu(List<SysResourcesVO> menuList) {
        StringBuilder sb = new StringBuilder();
        for (SysResourcesVO vo : menuList) {
            sb.append("<li class=\"treeview\">\n");
            sb.append("          <a href=\"#\">\n");
            sb.append("            <i class=\"fa fa-folder\"></i> <span>" + vo.getResourcesName() + "</span>\n");
            sb.append("            <span class=\"pull-right-container\">\n");
            sb.append("              <i class=\"fa fa-angle-left pull-right\"></i>\n");
            sb.append("            </span>\n");
            sb.append("          </a>\n");
            if (null != vo.getChildren()) {
                sb.append("          <ul class=\"treeview-menu\">\n");
                for (SysResourcesVO child : vo.getChildren()) {
                    sb.append("            <li><a href=\"#\" " + (StringUtils.isBlank(child.getResourcesUrl()) ? "" : "url=\"" + child.getResourcesUrl() + "\"") + "><i class=\"fa fa-circle-o\"></i>" + child.getResourcesName() + "</a></li>\n");
                }
                sb.append("          </ul>\n");
            }
            sb.append("        </li>");
        }
        return sb.toString();
    }

    /**
     * 菜单树
     *
     * @param menuList
     * @return
     */
    private List<SysResourcesVO> buildTreeLeftMenu(List<SysResourcesVO> menuList) {
        List<SysResourcesVO> treeList = new ArrayList<>();
        for (SysResourcesVO vo : menuList) {
            if ("0".equals(vo.getResourcesPid())) {
                treeList.add(vo);
            }
            for (SysResourcesVO vo2 : menuList) {
                if (vo2.getResourcesPid().equals(vo.getResourcesId())) {
                    if (null == vo.getChildren()) {
                        vo.setChildren(new ArrayList<>());
                    }
                    vo.getChildren().add(vo2);
                }
            }
        }
        return treeList;
    }

}
