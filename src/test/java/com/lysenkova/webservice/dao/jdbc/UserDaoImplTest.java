package com.lysenkova.webservice.dao.jdbc;

import com.lysenkova.webservice.dao.UserDao;
import com.lysenkova.webservice.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void getAll() {
        List<User> users = userDao.getAll();

        for (User user : users) {
            assertNotEquals(0L, user.getId());
            assertNotNull(user.getFirstName());
            assertNotNull(user.getLastName());
            assertNotEquals(0d, user.getSalary());
        }
    }

    @Test
    public void add() {
        User user = new User();
        user.setFirstName("First");
        user.setLastName("Last");
        user.setSalary(2000.00);
        int expected = userDao.getAll().size() + 1;
        userDao.add(user);
        int actual = userDao.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        User user = userDao.getAll().get(0);
        int expected = userDao.getAll().size() - 1;
        userDao.remove(user);
        int actual = userDao.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void edit() {
        User user = new User();
        List<User> users = userDao.getAll();
        for (User user1 : users) {
            if (user1.getId() == 50) {
                user = user1;

            }
        }
        user.setSalary(4000.00);
        userDao.edit(user);
        double expected = 4000;
        double actual = 0;
        List<User> users2 = userDao.getAll();
        for (User user1 : users2) {
            if (user1.getId() == 50) {
                actual = user1.getSalary();

            }
        }
        assertEquals(expected, actual, 0);
    }
}