package com.lysenkova.webservice;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.dao.jdbc.JdbcUserDao;
import com.lysenkova.webservice.service.UserService;
import com.lysenkova.webservice.service.impl.UserServiceImpl;
import com.lysenkova.webservice.servicelocator.ServiceLocator;
import com.lysenkova.webservice.web.servlet.AddUserServlet;
import com.lysenkova.webservice.web.servlet.AllUserServlet;
import com.lysenkova.webservice.web.servlet.DeleteUserServlet;
import com.lysenkova.webservice.web.servlet.EditUserServlet;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Properties;

public class Starter {
    public static void main(String[] args) throws Exception {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));

        JdbcUserDao userDao = new JdbcUserDao();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("database.url"));
        dataSource.setUser(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));
        userDao.setDataSource(dataSource);

        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.register(UserDao.class, userDao);
        serviceLocator.register(UserService.class, new UserServiceImpl());



        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new AllUserServlet()), "/users");
        context.addServlet(new ServletHolder(new AddUserServlet()), "/user/add");
        context.addServlet(new ServletHolder(new EditUserServlet()), "/user/edit/*");
        context.addServlet(new ServletHolder(new DeleteUserServlet()), "/user/remove/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
