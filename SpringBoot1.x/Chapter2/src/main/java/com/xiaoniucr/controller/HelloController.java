package com.xiaoniucr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Yang
 * @create 2019/07/21 10:07
 * @copyright www.xiaoniucr.com
 */
//此注解相当于@Controller+@ResponseBody
@RestController
public class HelloController {

    /**
     * 浏览器直接输出字符串
     * @return
     */
    @RequestMapping(value = "sayHello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello kitty，welcome to the world of spring boot..";
    }
}
