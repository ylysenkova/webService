package com.lysenkova.webservice.service;

import com.lysenkova.webservice.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAll();

    void add(User user);

    User getUserById(long id);

    void edit(User user);

    void remove(User user);

    String getName();
}
