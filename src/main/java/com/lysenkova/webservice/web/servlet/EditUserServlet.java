package com.lysenkova.webservice.web.servlet;

import com.lysenkova.webservice.web.servicelocator.ServiceLocator;
import com.lysenkova.webservice.web.templater.PageGenerator;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditUserServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService = ServiceLocator.getInstance().getService(UserService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in EditUserServlet");
        Map<String, Object> userPageVariables = new HashMap<>();
        long id = Long.parseLong(request.getPathInfo().replace("/", ""));
        User user = userService.getUserById(id);
        userPageVariables.put("user", user);

        response.getWriter().println(PageGenerator.instance().getPage("edit.ftl", userPageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post request in EditUserServlet.");
        Map<String, Object> userPageVariables = new HashMap<>();

        editUser(request);
        List<User> users = userService.getAll();
        userPageVariables.put("users", users);
        response.sendRedirect("/users");
    }

    private User editUser(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        User user = userService.getUserById(Long.parseLong(parameters.get("id")[0]));
        user.setFirstName(parameters.get("firstName")[0]);
        user.setLastName(parameters.get("lastName")[0]);
        user.setSalary(Double.parseDouble(parameters.get("salary")[0]));
        userService.edit(user);
        return user;
    }
}
