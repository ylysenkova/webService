package com.lysenkova.webservice.web.servicelocator;

import com.lysenkova.webservice.web.servlet.AddUserServlet;
import com.lysenkova.webservice.web.servlet.AllUserServlet;
import com.lysenkova.webservice.web.servlet.DeleteUserServlet;
import com.lysenkova.webservice.web.servlet.EditUserServlet;

import java.rmi.NoSuchObjectException;

public class InitialContext {
    private final static String ADD_USER_SERVLET = "AddUserServlet";
    private final static String ALL_USER_SERVLET = "AllUserServlet";
    private final static String EDIT_USER_SERVLET = "EditUserServlet";
    private final static String DELETE_USER_SERVLET = "DeleteUserServlet";

    public Object lookup(String servletName) throws NoSuchObjectException{
        if (servletName.equalsIgnoreCase(ADD_USER_SERVLET)) {
            return new AddUserServlet();
        } else if (servletName.equalsIgnoreCase(ALL_USER_SERVLET)) {
            return new AllUserServlet();
        } else if (servletName.equalsIgnoreCase(EDIT_USER_SERVLET)) {
            return new EditUserServlet();
        } else if (servletName.equalsIgnoreCase(DELETE_USER_SERVLET)) {
            return new DeleteUserServlet();
        }
        throw new NoSuchObjectException("Servlet not found.");
    }
}
