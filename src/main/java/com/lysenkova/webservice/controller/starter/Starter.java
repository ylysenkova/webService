package com.lysenkova.webservice.controller.starter;

import com.lysenkova.webservice.controller.servlet.AddUserServlet;
import com.lysenkova.webservice.controller.servlet.AllUserServlet;
import com.lysenkova.webservice.controller.servlet.DeleteUserServlet;
import com.lysenkova.webservice.controller.servlet.EditUserServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Starter {
    public static void main(String[] args) throws Exception {
        AllUserServlet allUserServlet = new AllUserServlet();
        AddUserServlet addUserServlet = new AddUserServlet();
        EditUserServlet editUserServlet = new EditUserServlet();
        DeleteUserServlet deleteUserServlet = new DeleteUserServlet();

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
