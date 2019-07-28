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
//日志组件
@Slf4j
public class Chapter4ApplicationTests {


    @Autowired
    private UserService userService;

    /**
     * 执行单元测试方法之前
     * @throws Exception
     */
    @Before
    public void before() throws Exception{
        userService.deleteUsers();
    }

    /**
     * 执行完单元测试方法之后
     * @throws Exception
     */
    @After
    public void after() throws Exception{
        log.info("do something after testing... ");
    }

    @Test
    public void contextLoads() {
    }

    /**
     * 测试插入数据
     */
    @Test
    public void testInsert(){
        userService.insert("张三","123456",18,"深圳");
        userService.insert("李四","123456",19,"深圳");
        Assert.assertEquals(2,userService.listUsernames().size());
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDelete(){
        userService.insert("张三","123456",18,"深圳");
        userService.deleteByUsername("张三");
        User user = userService.getUser("张三");
        Assert.assertEquals(null,user);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void testUpdate(){
        userService.insert("张三","123456",18,"深圳");
        userService.update("张三","上海");
        User user = userService.getUser("张三");
        Assert.assertEquals("上海",user.getAddress());
    }

    /**
     * 测试获取单条记录，返回对象
     */
    @Test
    public void testGet(){

        userService.insert("张三","123456",18,"深圳");
        User user = userService.getUser("张三");
        Assert.assertNotEquals(null,user);
    }


    /**
     * 测试获取所有记录，返回对象集合
     */
    @Test
    public void testGetAll(){

        userService.insert("张三","123456",18,"深圳");
        List<User> userList = userService.listUsers();
        Assert.assertEquals(1,userList.size());
    }

    /**
     * 测试获取所有对象，返回Map集合，每一个map对应一条记录
     * map中的key和value分别对应字段名和值
     */
    @Test
    public void testListAsMap(){

        userService.insert("张三","123456",18,"深圳");
        List<Map<String,Object>> list = userService.listAsMap();
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("深圳",list.get(0).get("address"));
    }

    /**
     * 测试获取单条记录，返回一个map
     * map中的key和value分别对应字段名和值
     */
    @Test
    public void testGetAsMap(){

        userService.insert("张三","123456",18,"深圳");
        Map<String,Object> map = userService.getUserAsMap("张三");
        Assert.assertEquals("深圳",map.get("address"));
    }


    /**
     * 测试RowMapper的一个封装基础
     */
    @Test
    public void testGetObject(){
        userService.insert("张三","123456",18,"深圳");
        User user = userService.getObject("张三");
        Assert.assertNotEquals(null,user);
    }



}
