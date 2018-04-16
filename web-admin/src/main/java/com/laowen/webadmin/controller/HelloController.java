package com.laowen.webadmin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${test-piror}")
    private String testPiror;

    @ResponseBody
    @RequestMapping("/{name}")
    public String index(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", "world");
        return testPiror;
    }
}
