/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.shelf;

import com.nepal.lms.bll.ShelfBLL;
import com.nepal.lms.entity.shelf.Shelf;
import com.nepal.lms.entity.user.UserParams;
import com.nepal.lms.ui.login.Login;
import java.util.List;
import java.util.prefs.Preferences;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Suzn
 */
public class ShelfDAOImplTest {
    
    public ShelfDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isShelfAvailable method, of class ShelfDAOImpl.
     */
    @Test
    public void testIsShelfAvailable() throws Exception {
        System.out.println("isShelfAvailable");
        Preferences prefs = Preferences.userRoot().node(Login.class.getName());
                prefs.clear();
    }

    /**
     * Test of save method, of class ShelfDAOImpl.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Shelf t = new Shelf(3, "A1");
        int expResult = t.getId();
        int result = ShelfBLL.insertShelf(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of append method, of class ShelfDAOImpl.
     */
    @Test
    public void testAppend() throws Exception {
        System.out.println("append");
        Shelf t = new Shelf(1, "B4");
        int expResult = t.getId();
        int result = ShelfBLL.insertShelf(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ShelfDAOImpl.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Shelf t = null;
        ShelfDAOImpl instance = null;
        int expResult = 0;
        int result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ShelfDAOImpl.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Shelf t = null;
        ShelfDAOImpl instance = null;
        int expResult = 0;
        int result = instance.remove(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ShelfDAOImpl.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        ShelfDAOImpl instance = null;
        Shelf expResult = null;
        Shelf result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ShelfDAOImpl.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ShelfDAOImpl instance = null;
        List<Shelf> expResult = null;
        List<Shelf> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
