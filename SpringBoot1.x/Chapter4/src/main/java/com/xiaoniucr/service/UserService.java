package com.xiaoniucr.service;

import com.xiaoniucr.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Yang
 * @create 2019/07/26 15:37
 * @copyright www.xiaoniucr.com
 */
public interface UserService {

    void insert(String username,String password,int age,String address);

    void deleteByUsername(String username);

    void deleteUsers();

    void update(String username,String address);

    User getUser(String username);

    List<User> listUsers();

    List<String> listUsernames();

    List<Map<String,Object>> listAsMap();

    Map getUserAsMap(String username);

    User getObject(String username);


}
