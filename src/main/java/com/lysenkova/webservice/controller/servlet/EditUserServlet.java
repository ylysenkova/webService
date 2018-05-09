package com.lysenkova.webservice.controller.servlet;

import com.lysenkova.webservice.controller.templater.PageGenerator;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> editUserVariablesMap = createPageVariablesMap(request);
        editUserVariablesMap.put("message", "");
        long id = Long.parseLong(request.getParameterMap().get("id")[0]);
        User user = userService.getUserById(id);
        editUserVariablesMap.put("users", user);

        response.getWriter().println(PageGenerator.instance().getPage("edit.ftl", editUserVariablesMap));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> editUserVariablesMap = createPageVariablesMap(request);
        String message = request.getParameter("message");
        response.setContentType("text/html;charset=utf-8");
        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        editUserVariablesMap.put("message", message == null ? "" : message);
        editUser(request);
        List<User> users = userService.getAll();
        editUserVariablesMap.put("users", users);
        response.getWriter().println(PageGenerator.instance().getPage("users.ftl", editUserVariablesMap));
    }

    private Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> userPageVariables = new HashMap<>();
        userPageVariables.put("method", request.getMethod());
        userPageVariables.put("URL", request.getRequestURL().toString());
//        pageVariables.put("pathInfo", request.getPathInfo());
        userPageVariables.put("sessionId", request.getSession().getId());
        userPageVariables.put("parameters", request.getParameterMap().toString());

        return userPageVariables;
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
