package com.lysenkova.webservice.service.impl;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.servicelocator.ServiceLocator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = ServiceLocator.getInstance().getService(UserDao.class);

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getById(long id) {
        List<User> users = getAll();
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public void remove(User user) {
        userDao.remove(user);
    }

}
