package com.xiaoniucr.rowmapper;


import com.xiaoniucr.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mr.Yang
 * @create 2019/07/27 16:42
 * @copyright www.xiaoniucr.com
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User u = new User();
        u.setId(resultSet.getInt("id"));
        u.setUsername(resultSet.getString("username"));
        u.setAge(resultSet.getInt("age"));
        u.setPassword(resultSet.getString("password"));
        u.setAddress(resultSet.getString("address"));
        return u;
    }
}
