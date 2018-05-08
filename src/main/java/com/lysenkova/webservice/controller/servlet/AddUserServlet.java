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

public class AddUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> addPageVariables = createAddPageVariablesMap(request);
        addPageVariables.put("message", "");

        response.getWriter().println(PageGenerator.instance().getPage("add.ftl", addPageVariables));
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> addPageVariables = createAddPageVariablesMap(request);

        String message = request.getParameter("message");

        response.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        addPageVariables.put("message", message == null ? "" : message);

        addUser(request);
        List<User> users = userService.getAll();
        addPageVariables.put("users", users);
        response.getWriter().println(PageGenerator.instance().getPage("users.ftl", addPageVariables));
    }

    private static Map<String, Object> createAddPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> addPageVariables = new HashMap<>();
        addPageVariables.put("method", request.getMethod());
        addPageVariables.put("URL", request.getRequestURL().toString());
//        pageVariables.put("pathInfo", request.getPathInfo());
        addPageVariables.put("sessionId", request.getSession().getId());
        addPageVariables.put("parameters", request.getParameterMap().toString());
        return addPageVariables;
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
