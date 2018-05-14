package com.lysenkova.webservice.web.servicelocator;

import com.lysenkova.webservice.dao.Dao;
import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.web.cache.LocatorCache;
import com.lysenkova.webservice.web.servlet.Servlet;

public class ServiceLocator<T> {
    private static LocatorCache servletCache = new LocatorCache();

    private ServiceLocator() {
    }

    public static Servlet getServlet(String servletName) {
        Servlet servlet = servletCache.getServlet(servletName);
        if (servlet == null) {
            ServletInitialContext context = new ServletInitialContext();
            servlet = context.lookup(servletName);
            servletCache.addServlet(servlet);
        }
        return servlet;

    }

    public static UserDao getJDBCEntity(String daoEntity) {
        UserDao dao = servletCache.getJDBCEntity(daoEntity);
        if (dao == null) {
            DaoInitialContext context = new DaoInitialContext();
            dao = context.lookup(daoEntity);
            servletCache.addJDBCEntity(dao);
        }
        return dao;
    }

    public static UserService getService(String service) {
        UserService serviceCached = servletCache.getService(service);
        if (serviceCached == null) {
            ServiceInitialContext context = new ServiceInitialContext();
            serviceCached = context.lookup(service);
            servletCache.addService(serviceCached);
        }
        return serviceCached;
    }

}
