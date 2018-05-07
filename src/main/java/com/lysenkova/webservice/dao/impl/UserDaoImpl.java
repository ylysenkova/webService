package com.lysenkova.webservice.dao.impl;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.util.PropertiesParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private PropertiesParser properties = new PropertiesParser("/db/database.properties");
    private String dbUrl = properties.getStringProperty("database.url");
    private String username = properties.getStringProperty("database.username");
    private String password = properties.getStringProperty("database.password");

    @Override
    public List<User> getAll() throws SQLException {

        List<User> users = new ArrayList<>();
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select id, first_name, last_name, salary from users");
        while(resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setSalary(resultSet.getDouble("salary"));
            users.add(user);
        }

        return users;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void edit(User user) {

    }

}
