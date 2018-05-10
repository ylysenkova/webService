package com.lysenkova.webservice.web.cache;

import com.lysenkova.webservice.web.servlet.Servlet;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;

public class ServletCache {
    private List<Servlet> servlets;

    public ServletCache() {
        servlets = new ArrayList<>();
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
}
