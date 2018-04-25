package com.laowen.webadmin.controller;

import com.laowen.auth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping("/{name}")
    public String index(@PathVariable("name") String name, Model model) {
        sysUserService.insert(null);
        model.addAttribute("name", "world");
        return "";
    }
}
