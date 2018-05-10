package com.lysenkova.webservice.dao.mapper;

import com.lysenkova.webservice.entity.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserMapperTest {

    @Test
    public void mapRow() throws SQLException {
        UserMapper userMapper = new UserMapper();

        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.getLong("id")).thenReturn(1L);
        when(mockResultSet.getString("first_name")).thenReturn("Yana");
        when(mockResultSet.getString("last_name")).thenReturn("Lysenkova");
        when(mockResultSet.getDouble("salary")).thenReturn(2000.00);
        User actual = userMapper.mapRow(mockResultSet);

        assertNotNull(actual);
        assertEquals(1,actual.getId());
        assertEquals("Yana", actual.getFirstName());
        assertEquals("Lysenkova", actual.getLastName());
        assertEquals(2000.00, actual.getSalary(), 0);
    }
}