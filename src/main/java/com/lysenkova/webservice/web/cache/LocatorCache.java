package com.lysenkova.webservice.web.cache;

import com.lysenkova.webservice.dao.Dao;
import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.web.servlet.Servlet;

import java.util.ArrayList;
import java.util.List;

public class LocatorCache {
    private List<Servlet> servlets;
    private List<UserDao> daos;

    public LocatorCache() {
        servlets = new ArrayList<>();
        daos = new ArrayList<>();
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
}
