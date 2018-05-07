package com.lysenkova.webservice.dao.impl;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void add() {
        User user = new User();
        user.setFirstName("Meredit");
        user.setLastName("Grey");
        user.setSalary(5000);

        UserDao userDao = new UserDaoImpl();
        userDao.add(user);
    }
}