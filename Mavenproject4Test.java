/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class Mavenproject4Test {
    
    public Mavenproject4Test() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Mavenproject4.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "";
        boolean expResult = false;
        boolean result = Mavenproject4.checkUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        boolean expResult = false;
        boolean result = Mavenproject4.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellNumber method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testCheckCellNumber() {
        System.out.println("checkCellNumber");
        String number = "";
        boolean expResult = false;
        boolean result = Mavenproject4.checkCellNumber(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String storedUsername = "";
        String storedPassword = "";
        String enteredUsername = "";
        String enteredPassword = "";
        boolean expResult = false;
        boolean result = Mavenproject4.loginUser(storedUsername, storedPassword, enteredUsername, enteredPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessages method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testSendMessages() {
        System.out.println("sendMessages");
        Mavenproject4.sendMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cell = "";
        boolean expResult = false;
        boolean result = Mavenproject4.checkRecipientCell(cell);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageID = "";
        int messageNumber = 0;
        String messageText = "";
        String expResult = "";
        String result = Mavenproject4.createMessageHash(messageID, messageNumber, messageText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        Message message = null;
        String expResult = "";
        String result = Mavenproject4.sentMessage(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessageDetails method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testPrintMessageDetails() {
        System.out.println("printMessageDetails");
        Message message = null;
        Mavenproject4.printMessageDetails(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = Mavenproject4.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRecentMessages method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testShowRecentMessages() {
        System.out.println("showRecentMessages");
        Mavenproject4.showRecentMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message message = null;
        Mavenproject4.storeMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateMessageID method, of class Mavenproject4.
     */
    @org.junit.jupiter.api.Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        String expResult = "";
        String result = Mavenproject4.generateMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
