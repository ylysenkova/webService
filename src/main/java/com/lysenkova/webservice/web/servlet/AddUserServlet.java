package com.lysenkova.webservice.web.servlet;

import com.lysenkova.webservice.servicelocator.ServiceLocator;
import com.lysenkova.webservice.web.templater.PageGenerator;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddUserServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService = ServiceLocator.getInstance().getService(UserService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in AddUserServlet");
        Map<String, Object> addPageVariables = new HashMap<>();

        response.getWriter().println(PageGenerator.instance().getPage("add.ftl", addPageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post request in AddUserServlet");

        response.setContentType("text/html;charset=utf-8");
        addUser(request);
        response.sendRedirect("/users");
    }

    private void addUser(HttpServletRequest request) {
        User user = new User();

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setSalary(Double.parseDouble(request.getParameter("salary").replace(",", ".")));
        userService.add(user);
    }

}
