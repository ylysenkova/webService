package com.lysenkova.webservice.dao.mapper;

import com.lysenkova.webservice.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setSalary(resultSet.getDouble("salary"));
        return user;
    }
}
