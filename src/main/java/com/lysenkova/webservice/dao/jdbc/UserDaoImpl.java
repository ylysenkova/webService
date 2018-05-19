package com.lysenkova.webservice.dao.jdbc;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.dao.mapper.UserMapper;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.util.PropertiesParser;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static String GET_ALL_SQL = "select id, first_name, last_name, salary from users";
    private final static String ADD_USER_SQL = "insert into users (first_name, last_name, salary) values(?, ?, ?)";
    private final static String EDIT_USER_SQL = "update users set first_name = ?, last_name = ?, salary = ? where id = ?";
    private final static String REMOVE_USER_SQL = "delete from users where id = ?";
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final static UserMapper USER_MAPPER  = new UserMapper();

    private DataSource dataSource;
//    private String dbUrl = dataSource.getStringProperty("database.url");
//    private String username = properties.getStringProperty("database.username");
//    private String password = properties.getStringProperty("database.password");



    @Override
    public List<User> getAll() {
        LOGGER.info("Getting all users.");
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL)){

            while (resultSet.next()) {
                User user = USER_MAPPER.mapRow(resultSet);
                users.add(user);
            }
            LOGGER.trace("Got users {}", users);
        } catch (SQLException e) {
            LOGGER.error("SQL error during getting all users. ", e);
            throw new RuntimeException("SQL error during getting all users. ", e);
        }

        return users;
    }

    @Override
    public void add(User user) {
        LOGGER.info("Adding user {}", user);
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_SQL, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.executeUpdate();
            LOGGER.trace("Added user {}", user);
        } catch (SQLException e) {
            LOGGER.info("SQL error during add user {}", user, e);
            throw new RuntimeException("SQL error during add user {}", e);
        }

    }

    @Override
    public void remove(User user) {
        LOGGER.info("Removing user {}", user);
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER_SQL)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
            LOGGER.trace("Removed user {}", user);
        } catch (SQLException e) {
            LOGGER.info("SQL error during remove user {}", user, e);
            throw new RuntimeException("SQL error during remove user {}", e);
        }
    }

    @Override
    public void edit(User user) {
        LOGGER.info("Editing user {}", user);
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_SQL)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDouble(3, user.getSalary());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
            LOGGER.trace("Edited user {}", user);
        } catch (SQLException e) {
            LOGGER.info("SQL error during edit user {}", user, e);
            throw new RuntimeException("SQL error during edit user {}", e);
        }
    }

    public void setDataSource(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }


}
