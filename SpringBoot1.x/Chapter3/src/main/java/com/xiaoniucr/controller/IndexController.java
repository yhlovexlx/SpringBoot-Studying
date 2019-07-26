package com.xiaoniucr.controller;

import com.xiaoniucr.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

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

    @RequestMapping("/findAll")
    public String findAll(ModelMap map){

        User u1 = new User();
        u1.setId(1);
        u1.setUsername("张三");
        u1.setPassword("123456");

        User u2 = new User();
        u2.setId(2);
        u2.setUsername("李四");
        u2.setPassword("123456");

        Set<User> userList = new HashSet<User>();
        userList.add(u1);
        userList.add(u2);
        map.put("userList",userList);
        return "user";
    }

}
