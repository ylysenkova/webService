package com.lysenkova.webservice.service;

import com.lysenkova.webservice.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAll() throws SQLException;
}
