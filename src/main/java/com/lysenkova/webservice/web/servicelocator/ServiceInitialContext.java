package com.lysenkova.webservice.web.servicelocator;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.dao.impl.UserDaoImpl;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.service.impl.UserServiceImpl;

public class ServiceInitialContext {
    private final static String USER_SERVICE = "UserServiceImpl";

    public UserService lookup(String service) {
        if (service.equalsIgnoreCase(USER_SERVICE)) {
            return new UserServiceImpl();
        }
        throw new RuntimeException("Dao Entity not found");
    }
}
