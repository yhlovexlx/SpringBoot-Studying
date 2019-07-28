package com.xiaoniucr;

import com.xiaoniucr.entity.User;
import com.xiaoniucr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


/**
 * SpringBoot1.4之前可以使用如下注解
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringApplicationConfiguration(Application.class)
*/


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter4Application.class)
@Slf4j
public class Chapter4ApplicationTests {


    @Autowired
    private UserService userService;

    @Before
    public void before() throws Exception{
        userService.deleteUsers();
    }

    @After
    public void after() throws Exception{
        log.info("do something after testing... ");
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testInsert(){
        userService.insert("张三","123456",18,"深圳");
        userService.insert("李四","123456",19,"深圳");
        Assert.assertEquals(2,userService.listUsernames().size());
    }

    @Test
    public void testDelete(){
        userService.insert("张三","123456",18,"深圳");
        userService.deleteByUsername("张三");
        User user = userService.getUser("张三");
        Assert.assertEquals(null,user);
    }

    @Test
    public void testUpdate(){
        userService.insert("张三","123456",18,"深圳");
        userService.update("张三","上海");
        User user = userService.getUser("张三");
        Assert.assertEquals("上海",user.getAddress());
    }

    @Test
    public void testGet(){

        userService.insert("张三","123456",18,"深圳");
        User user = userService.getUser("张三");
        Assert.assertNotEquals(null,user);
    }


    @Test
    public void testGetAll(){

        userService.insert("张三","123456",18,"深圳");
        List<User> userList = userService.listUsers();
        Assert.assertEquals(1,userList.size());
    }

    @Test
    public void testListAsMap(){

        userService.insert("张三","123456",18,"深圳");
        List<Map<String,Object>> list = userService.listAsMap();
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("深圳",list.get(0).get("address"));
    }

    @Test
    public void testGetAsMap(){

        userService.insert("张三","123456",18,"深圳");
        Map<String,Object> map = userService.getUserAsMap("张三");
        Assert.assertEquals("深圳",map.get("address"));
    }



}
