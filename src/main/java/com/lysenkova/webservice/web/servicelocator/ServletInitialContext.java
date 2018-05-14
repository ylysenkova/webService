package com.lysenkova.webservice.web.servicelocator;

import com.lysenkova.webservice.web.servlet.*;

public class ServletInitialContext {
    private final static String ADD_USER_SERVLET = "AddUserServlet";
    private final static String ALL_USER_SERVLET = "AllUserServlet";
    private final static String EDIT_USER_SERVLET = "EditUserServlet";
    private final static String DELETE_USER_SERVLET = "DeleteUserServlet";



    public Servlet lookup(String servletName) {
        if (servletName.equalsIgnoreCase(ADD_USER_SERVLET)) {
            return new AddUserServlet();
        } else if (servletName.equalsIgnoreCase(ALL_USER_SERVLET)) {
            return new AllUserServlet();
        } else if (servletName.equalsIgnoreCase(EDIT_USER_SERVLET)) {
            return new EditUserServlet();
        } else if (servletName.equalsIgnoreCase(DELETE_USER_SERVLET)) {
            return new DeleteUserServlet();
        }
        throw new RuntimeException("Servlet not found");
    }


}
