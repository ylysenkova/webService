package com.lysenkova.webservice.web.servicelocator;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.dao.impl.UserDaoImpl;

public class DaoInitialContext {
    private final static String USER_DAO = "UserDaoImpl";

    public UserDao lookup(String daoEntity) {
        if (daoEntity.equalsIgnoreCase(USER_DAO)) {
            return new UserDaoImpl();
        }
        throw new RuntimeException("Dao Entity not found");
    }
}
