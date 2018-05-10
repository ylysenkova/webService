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

    public Servlet getServler(String servletName) throws NoSuchObjectException {
        for (Servlet servlet : servlets) {
            if (servlet.getName().equalsIgnoreCase(servletName)) {
                return servlet;
            }
        }
        throw new NoSuchObjectException("Servlet not found");
    }

    public void addServlet(Servlet newServlet) {
        for (Servlet servlet : servlets) {
            if (!servlet.getName().equalsIgnoreCase(newServlet.getName())) {
                servlets.add(newServlet);
            }
        }
    }
}
