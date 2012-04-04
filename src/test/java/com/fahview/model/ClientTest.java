/*
 * Copyright (C) 2012 Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fahview.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 */
public class ClientTest extends TestCase {
    
    public ClientTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ClientTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of setArguments method, of class Client.
     */
    public void testSetArguments() {
        System.out.println("setArguments");
        String line = "";
        Client instance = null;
        instance.setArguments(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEdition method, of class Client.
     */
    public void testSetEdition() {
        System.out.println("setEdition");
        String line = "";
        Client instance = null;
        instance.setEdition(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExecutable method, of class Client.
     */
    public void testSetExecutable() {
        System.out.println("setExecutable");
        String line = "";
        Client instance = null;
        instance.setExecutable(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLaunchDirectory method, of class Client.
     */
    public void testSetLaunchDirectory() {
        System.out.println("setLaunchDirectory");
        String line = "";
        Client instance = null;
        instance.setLaunchDirectory(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMachineID method, of class Client.
     */
    public void testSetMachineID() {
        System.out.println("setMachineID");
        String line = "";
        Client instance = null;
        instance.setMachineID(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserID method, of class Client.
     */
    public void testSetUserID() {
        System.out.println("setUserID");
        String line = "";
        Client instance = null;
        instance.setUserID(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Client.
     */
    public void testSetUserName() {
        System.out.println("setUserName");
        String line = "";
        Client instance = null;
        instance.setUserName(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVersion method, of class Client.
     */
    public void testSetVersion() {
        System.out.println("setVersion");
        String line = "";
        Client instance = null;
        instance.setVersion(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArguments method, of class Client.
     */
    public void testGetArguments() {
        System.out.println("getArguments");
        Client instance = null;
        String expResult = "";
        String result = instance.getArguments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdition method, of class Client.
     */
    public void testGetEdition() {
        System.out.println("getEdition");
        Client instance = null;
        String expResult = "";
        String result = instance.getEdition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExecutable method, of class Client.
     */
    public void testGetExecutable() {
        System.out.println("getExecutable");
        Client instance = null;
        String expResult = "";
        String result = instance.getExecutable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaunchDirectory method, of class Client.
     */
    public void testGetLaunchDirectory() {
        System.out.println("getLaunchDirectory");
        Client instance = null;
        String expResult = "";
        String result = instance.getLaunchDirectory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamNo method, of class Client.
     */
    public void testGetTeamNo() {
        System.out.println("getTeamNo");
        Client instance = null;
        int expResult = 0;
        int result = instance.getTeamNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMachineID method, of class Client.
     */
    public void testGetMachineID() {
        System.out.println("getMachineID");
        Client instance = null;
        int expResult = 0;
        int result = instance.getMachineID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserID method, of class Client.
     */
    public void testGetUserID() {
        System.out.println("getUserID");
        Client instance = null;
        String expResult = "";
        String result = instance.getUserID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class Client.
     */
    public void testGetUserName() {
        System.out.println("getUserName");
        Client instance = null;
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class Client.
     */
    public void testGetVersion() {
        System.out.println("getVersion");
        Client instance = null;
        String expResult = "";
        String result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Client.
     */
    public void testGetLocation() {
        System.out.println("getLocation");
        Client instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
