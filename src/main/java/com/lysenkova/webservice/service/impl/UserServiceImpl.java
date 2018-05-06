package com.lysenkova.webservice.service.impl;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public List<User> getAll() throws SQLException {
        return userDao.getAll();
    }
}
