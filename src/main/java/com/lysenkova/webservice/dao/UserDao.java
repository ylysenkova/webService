package com.lysenkova.webservice.dao;

import com.lysenkova.webservice.entity.User;

import java.util.List;

public interface UserDao extends Dao {
    List<User> getAll ();
    void add(User user);
    void remove(User user);
    void edit(User user);
}
