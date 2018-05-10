package com.lysenkova.webservice.controller.servlet;

import com.lysenkova.webservice.controller.templater.PageGenerator;
import com.lysenkova.webservice.entity.User;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        try{
        Map<String, Object> userPageVariables = createPageVariablesMap(request);
        List<User> users = userService.getAll();
        userPageVariables.put("users", users);

        response.getWriter().println(PageGenerator.instance().getPage("users.ftl", userPageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
        }catch(RuntimeException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> userPageVariables = new HashMap<>();
        userPageVariables.put("parameters", request.getParameterMap().toString());

        return userPageVariables;
    }
}
