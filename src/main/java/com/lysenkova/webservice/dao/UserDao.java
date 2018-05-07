package com.lysenkova.webservice.dao;

import com.lysenkova.webservice.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAll ();
    void add(User user);
    void remove(User user);
    void edit(User user);
}
