/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBKnowledgeConn;

import javafx.collections.ObservableList;
import knowledgebase.ContentInfo;
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
public class DBAccessTest {
    
    public DBAccessTest() {
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
     * Test of dataSelect method, of class DBAccess.
     */
    @Test
    public void testDataSelect() {
        System.out.println("dataSelect");
        DBAccess instance = new DBAccess();
        ObservableList<ContentInfo> expResult = null;
        ObservableList<ContentInfo> result = instance.dataSelect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataManagement method, of class DBAccess.
     */
    @Test
    public void testDataManagement() {
        System.out.println("dataManagement");
        int id = 0;
        String sDesc = "";
        String dDesc = "";
        DBAction action = null;
        DBAccess instance = new DBAccess();
        instance.dataManagement(id, sDesc, dDesc, action);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
