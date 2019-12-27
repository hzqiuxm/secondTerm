package com.ziniuxiaozhu.jiemi.secondTerm.gateways.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright © 2019年 secondTerm. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * 公共接口
 * @date 2019/12/26 12:46
 */
@Controller
public class CommonController {

    @RequestMapping("/first")
    public String index(ModelMap map){
        map.addAttribute("message", "欢迎来到解密第二弹");
        return "hello";
    }

    @RequestMapping("/second")
    @PostMapping
    public String second(@RequestParam String answer,ModelMap map){
        map.addAttribute("answer", answer);
        Object attribute = map.getAttribute("answer");
        if("入答案".equals(attribute)){
            return "second";
        }else {
            return "error";
        }
    }

    @RequestMapping("/forerror")
    public String error(ModelMap map){

        return "error";
    }
}
