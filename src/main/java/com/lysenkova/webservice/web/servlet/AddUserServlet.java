package com.lysenkova.webservice.web.servlet;

import com.lysenkova.webservice.web.servicelocator.ServiceLocator;
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
import java.util.List;
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
        Map<String, Object> addPageVariables = new HashMap<>();

        response.setContentType("text/html;charset=utf-8");

        addUser(request);
        List<User> users = userService.getAll();
        addPageVariables.put("users", users);
        response.sendRedirect("/users");
    }

    private void addUser(HttpServletRequest request) {
        User user = new User();
        Map<String, String[]> parameters = request.getParameterMap();

        user.setFirstName(parameters.get("firstName")[0]);
        user.setLastName(parameters.get("lastName")[0]);
        user.setSalary(Double.parseDouble(parameters.get("salary")[0]));
        userService.add(user);
    }

}
