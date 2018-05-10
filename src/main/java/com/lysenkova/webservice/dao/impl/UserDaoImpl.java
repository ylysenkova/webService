package com.lysenkova.webservice.dao.impl;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.dao.mapper.UserMapper;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.util.PropertiesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static String GET_ALL_SQL = "select id, first_name, last_name, salary from users";
    private final static String ADD_USER_SQL = "insert into users (first_name, last_name, salary) values(?, ?, ?)";
    private final static String EDIT_USER_SQL = "update users set first_name = ?, last_name = ?, salary = ? where id = ?";
    private final static String REMOVE_USER_SQL = "delete from users where id = ?";
    private final static Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private PropertiesParser properties = new PropertiesParser("/db/database.properties");

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
            UserMapper userMapper = new UserMapper();
            while (resultSet.next()) {
                User user = userMapper.mapRow(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.debug("SQL error during getting all users. ", e);
        }

        return users;
    }

    @Override
    public void add(User user) {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("SQL error during add user. ", e);
        }

    }

    @Override
    public void remove(User user)  {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER_SQL);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("SQL error during remove user. ", e);
        }
    }

    @Override
    public void edit(User user) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("SQL error during edit user. ", e);
        }
    }

    private Connection getConnection() throws SQLException {
         String dbUrl = properties.getStringProperty("database.url");
         String username = properties.getStringProperty("database.username");
         String password = properties.getStringProperty("database.password");

         Connection connection = DriverManager.getConnection(dbUrl, username, password);
         return connection;
    }

}
