package com.lysenkova.webservice.web.cache;

import com.lysenkova.webservice.dao.Dao;
import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.web.servlet.Servlet;

import java.util.ArrayList;
import java.util.List;

public class LocatorCache {
    private List<Servlet> servlets;
    private List<UserDao> daos;
    private List<UserService> services;

    public LocatorCache() {
        servlets = new ArrayList<>();
        daos = new ArrayList<>();
        services = new ArrayList<>();
    }

    public Servlet getServlet(String servletName) {
        for (Servlet servlet : servlets) {
            if (servlet.getName().equalsIgnoreCase(servletName)) {
                return servlet;
            }
        }
        return null;
    }

    public void addServlet(Servlet newServlet) {
        for (Servlet servlet : servlets) {
            if (!servlet.getName().equalsIgnoreCase(newServlet.getName())) {
                servlets.add(newServlet);
            }
        }
    }

    public UserDao getJDBCEntity(String daoEntity) {
        for (UserDao dao : daos) {
            if (dao.getName().equalsIgnoreCase(daoEntity)) {
                return dao;
            }
        }
        return null;
    }

    public void addJDBCEntity(UserDao dao) {
        for (UserDao daoElement : daos) {
            if (!daoElement.getName().equals(dao.getName())) {
                daos.add(dao);
            }
        }
    }

    public UserService getService(String service) {
        for (UserService userService : services) {
            if (userService.getName().equalsIgnoreCase(service)) {
                return userService;
            }
        }
        return null;
    }

    public void addService(UserService serviceCached) {
        for (UserService service : services) {
            if (!service.getName().equals(serviceCached.getName())) {
                services.add(serviceCached);
            }
        }
    }
}
