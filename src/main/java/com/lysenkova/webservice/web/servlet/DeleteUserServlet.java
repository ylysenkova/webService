package com.lysenkova.webservice.web.servlet;

import com.lysenkova.webservice.web.servicelocator.ServiceLocator;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DeleteUserServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService = ServiceLocator.getInstance().getService(UserService.class);

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post request in DeleteUserServlet. Deleting user {}", request.getParameter("id"));
        removeUser(request);
        response.sendRedirect("/users");
    }

    private void removeUser(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        User user = userService.getUserById(Long.parseLong(parameters.get("id")[0]));
        userService.remove(user);
    }
}
