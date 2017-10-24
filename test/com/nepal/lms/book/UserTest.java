/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.book;

import com.nepal.lms.dao.user.UserDAO;
import com.nepal.lms.dao.user.UserDAOImpl;
import com.nepal.lms.entity.role.Role;
import com.nepal.lms.entity.user.UserInfo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class UserTest {
    
    static UserDAO userDAO;
    
    @BeforeClass
    public static void setup(){
        userDAO = new UserDAOImpl();
    }
    
    @Test
    public void insertUserTestCase(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setName("Leela");
        userInfo.setUsername("Student");
        userInfo.setPassword("passowrd");
        userInfo.setRole(new Role(2, "student"));
        
        Assert.assertEquals(userInfo.getId(), userDAO.save(userInfo));
        
    }
    
}
