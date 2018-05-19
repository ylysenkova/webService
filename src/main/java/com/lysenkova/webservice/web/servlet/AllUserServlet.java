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

public class AllUserServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService = ServiceLocator.getInstance().getService(UserService.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in AllUserServlet");
        Map<String, Object> userPageVariables = new HashMap<>();
        List<User> users = userService.getAll();
        userPageVariables.put("users", users);

        response.getWriter().println(PageGenerator.instance().getPage("users.ftl", userPageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
