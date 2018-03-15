/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBKnowledgeConn;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michel
 */
public class DBConnectionTest {
    
    public DBConnectionTest() {
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
     * Test of getMySQLConnection method, of class DBConnection.
     */
    @Test
    public void testGetMySQLConnection() {
        System.out.println("getMySQLConnection");
        Connection expResult = null;
        Connection result = DBConnection.getMySQLConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statusConnection method, of class DBConnection.
     */
    @Test
    public void testStatusConnection() {
        System.out.println("statusConnection");
        String expResult = "";
        String result = DBConnection.statusConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CloseConnection method, of class DBConnection.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("CloseConnection");
        boolean expResult = false;
        boolean result = DBConnection.CloseConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RestartConnection method, of class DBConnection.
     */
    @Test
    public void testRestartConnection() {
        System.out.println("RestartConnection");
        Connection expResult = null;
        Connection result = DBConnection.RestartConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
