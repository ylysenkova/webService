package com.lysenkova.webservice.dao.impl;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.util.PropertiesParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static String GET_ALL_SQL = "select id, first_name, last_name, salary from users";
    private final static String ADD_USER_SQL = "insert into users (first_name, last_name, salary) values(?, ?, ?)";
    private final static String EDIT_USER_SQL = "update users set first_name = ?, last_name = ?, salary = ? where id = ?";

    private PropertiesParser properties = new PropertiesParser("/db/database.properties");
    private String dbUrl = properties.getStringProperty("database.url");
    private String username = properties.getStringProperty("database.username");
    private String password = properties.getStringProperty("database.password");

    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setSalary(resultSet.getDouble("salary"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void add(User user) {
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void edit(User user) {
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
