package com.lysenkova.webservice.web.servicelocator;

import com.lysenkova.webservice.web.cache.ServletCache;
import com.lysenkova.webservice.web.servlet.Servlet;

import java.rmi.NoSuchObjectException;

public class ServiceLocator {
    private static ServletCache servletCache = new ServletCache();

    public static Servlet getServlet(String servletName) throws NoSuchObjectException {
        Servlet servlet = servletCache.getServlet(servletName);
        if (servlet == null) {
            InitialContext context = new InitialContext();
            servlet = (Servlet) context.lookup(servletName);
            servletCache.addServlet(servlet);
        }
        return servlet;

    }

}
