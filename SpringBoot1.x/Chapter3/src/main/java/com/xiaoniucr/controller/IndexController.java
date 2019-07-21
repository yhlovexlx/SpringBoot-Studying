package com.xiaoniucr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.Yang
 * @create 2019/07/21 17:38
 * @copyright www.xiaoniucr.com
 */
@Controller
public class IndexController {



    @RequestMapping("/index")
    public String index(ModelMap map){
        map.put("username","张三");
        return "index";
    }
}
