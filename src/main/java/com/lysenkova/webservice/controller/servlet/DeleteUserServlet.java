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

public class DeleteUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> removeUserVariablesMap = createPageVariablesMap(request);
        String message = request.getParameter("message");
        response.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        removeUserVariablesMap.put("message", message);
        removeUser(request);
        List<User> users = userService.getAll();
        removeUserVariablesMap.put("users", users);
        response.getWriter().println(PageGenerator.instance().getPage("users.ftl", removeUserVariablesMap));
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

    private void removeUser(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        User user = userService.getUserById(Long.parseLong(parameters.get("id")[0]));
        userService.remove(user);
    }
}
