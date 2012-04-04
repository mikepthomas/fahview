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

import com.fahview.controller.QueueReader;
import java.util.Date;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 */
public class WorkUnitTest extends TestCase {
    
    private WorkUnit instance;
    
    public WorkUnitTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(WorkUnitTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String testFile = "src/test/java/com/fahview/queue.dat";
        QueueReader testQueueReader = new QueueReader(testFile);
        instance = new Queue(testQueueReader).getQueueIndex(8).getWuid();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getProj method, of class WorkUnit.
     */
    public void testGetProj() {
        System.out.println("getProj");
        int expResult = 7025;
        int result = instance.getProj();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRun method, of class WorkUnit.
     */
    public void testGetRun() {
        System.out.println("getRun");
        int expResult = 0;
        int result = instance.getRun();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClone method, of class WorkUnit.
     */
    public void testGetClone() {
        System.out.println("getClone");
        int expResult = 84;
        int result = instance.getClone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGen method, of class WorkUnit.
     */
    public void testGetGen() {
        System.out.println("getGen");
        int expResult = 17;
        int result = instance.getGen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIssue method, of class WorkUnit.
     */
    public void testGetIssue() {
        System.out.println("getIssue");
        Date expResult = new Date(1313415431000L);
        Date result = instance.getIssue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProj method, of class WorkUnit.
     */
    public void testSetProj() {
        System.out.println("setProj");
        instance.setProj();
    }

    /**
     * Test of setRun method, of class WorkUnit.
     */
    public void testSetRun() {
        System.out.println("setRun");
        instance.setRun();
    }

    /**
     * Test of setClone method, of class WorkUnit.
     */
    public void testSetClone() {
        System.out.println("setClone");
        instance.setClone();
    }

    /**
     * Test of setGen method, of class WorkUnit.
     */
    public void testSetGen() {
        System.out.println("setGen");
        instance.setGen();
    }

    /**
     * Test of setIssue method, of class WorkUnit.
     */
    public void testSetIssue() {
        System.out.println("setIssue");
        instance.setIssue();
    }

    /**
     * Test of setCompleted method, of class WorkUnit.
     */
    public void testSetCompleted() {
        System.out.println("setCompleted");
        String line = "";
        instance.setCompleted(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompleted method, of class WorkUnit.
     */
    public void testGetCompleted() {
        System.out.println("getCompleted");
        int expResult = 0;
        int result = instance.getCompleted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercentage method, of class WorkUnit.
     */
    public void testGetPercentage() {
        System.out.println("getPercentage");
        String expResult = "";
        String result = instance.getPercentage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtein method, of class WorkUnit.
     */
    public void testGetProtein() {
        System.out.println("getProtein");
        String expResult = "";
        String result = instance.getProtein();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSteps method, of class WorkUnit.
     */
    public void testGetSteps() {
        System.out.println("getSteps");
        int expResult = 0;
        int result = instance.getSteps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class WorkUnit.
     */
    public void testUpdate() {
        System.out.println("update");
        instance.update();
    }
}
