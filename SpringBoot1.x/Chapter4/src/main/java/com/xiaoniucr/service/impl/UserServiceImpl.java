package com.xiaoniucr.service.impl;

import com.xiaoniucr.entity.User;
import com.xiaoniucr.rowmapper.UserRowMapper;
import com.xiaoniucr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Yang
 * @create 2019/07/26 16:11
 * @copyright www.xiaoniucr.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(String username, String password, int age, String address) {
        jdbcTemplate.update("insert into xn_user(username,password,age,address) values(?,?,?,?)",username,password,age,address);
    }

    @Override
    public void deleteByUsername(String username) {
        jdbcTemplate.update("delete from xn_user where username=?",username);
    }

    @Override
    public void deleteUsers() {
        jdbcTemplate.update("delete from xn_user");
    }

    @Override
    public void update(String username, String address) {
        jdbcTemplate.update("update xn_user set address=? where username=?",address,username);
    }

    @Override
    public User getUser(String username) {
        try{
            return jdbcTemplate.queryForObject("select * from xn_user where username=?", new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setAge(resultSet.getInt("age"));
                    user.setAddress(resultSet.getString("address"));
                    return user;
                }
            },username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<User> listUsers() {
        try{
            return jdbcTemplate.query("select * from xn_user",new UserRowMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }


    @Override
    public List<String> listUsernames() {
        /**
         * 注意：大部分人对queryForList这个方法存在误解
         * 实际上他的含义就是：查询某一列的数据，并返回这个列的集合，列的字段类型，只支持String，Integer这种，对自定义类型无效。
         */
        return jdbcTemplate.queryForList("select username from xn_user",String.class);
    }

    @Override
    public List<Map<String, Object>> listAsMap() {
        //查询所有数据，并将每一行的字段名和值封装成一个Map，多个行就是List<Map>的形式
        return jdbcTemplate.queryForList("select * from xn_user");
    }

    @Override
    public Map getUserAsMap(String username) {
        return jdbcTemplate.queryForMap("select * from xn_user where username=?",username);
    }


}
