package com.lysenkova.webservice.web.servlet;

import com.lysenkova.webservice.web.templater.PageGenerator;
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

public class DeleteUserServlet extends HttpServlet implements Servlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
        Map<String, Object> removeUserVariablesMap = createPageVariablesMap(request);
//        response.setContentType("text/html;charset=utf-8");

        removeUser(request);
        List<User> users = userService.getAll();
        removeUserVariablesMap.put("users", users);
        response.getWriter().println(PageGenerator.instance().getPage("users.ftl", removeUserVariablesMap));
        }catch(RuntimeException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public String getName() {
        return DeleteUserServlet.class.getName();
    }

    private Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> userPageVariables = new HashMap<>();
        userPageVariables.put("parameters", request.getParameterMap().toString());

        return userPageVariables;
    }

    private void removeUser(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        User user = userService.getUserById(Long.parseLong(parameters.get("id")[0]));
        userService.remove(user);
    }
}
