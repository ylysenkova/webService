package com.lysenkova.webservice.starter;

import com.lysenkova.webservice.web.servicelocator.ServiceLocator;
import com.lysenkova.webservice.web.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Starter {
    public static void main(String[] args) throws Exception {
        Servlet addUserServlet = ServiceLocator.getServlet("AddUserServlet");
        Servlet allUserServlet = ServiceLocator.getServlet("AllUserServlet");
        Servlet editUserServlet = ServiceLocator.getServlet("EditUserServlet");
        Servlet deleteUserServlet = ServiceLocator.getServlet("DeleteUserServlet");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allUserServlet), "/users");
        context.addServlet(new ServletHolder(addUserServlet), "/user/add");
        context.addServlet(new ServletHolder(editUserServlet), "/user/edit/*");
        context.addServlet(new ServletHolder(deleteUserServlet), "/user/remove/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
