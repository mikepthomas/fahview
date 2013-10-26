package com.googlecode.fahview.v6project.model;

/*
 * #%L
 * This file is part of FAHView-v6project.
 * %%
 * Copyright (C) 2011 - 2013 Michael Thomas <mikepthomas@outlook.com>
 * %%
 * FAHView is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * %
 * FAHView is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * %
 * You should have received a copy of the GNU General Public License
 * along with FAHView.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import com.googlecode.fahview.v6project.utilities.QueueReader;
import java.util.Date;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>WorkUnitImplTest class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 * @since 1.0
 */
public class WorkUnitImplTest extends TestCase {
    
    private WorkUnitImpl instance;
    
    /**
     * <p>Constructor for WorkUnitImplTest.</p>
     *
     * @param testName a {@link java.lang.String} object.
     */
    public WorkUnitImplTest(String testName) {
        super(testName);
    }

    /**
     * <p>suite.</p>
     *
     * @return a {@link junit.framework.Test} object.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(WorkUnitImplTest.class);
        return suite;
    }
    
    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String testFile = "src/test/java/com/googlecode/fahview/v6project/queue.dat";
        QueueReader testQueueReader = new QueueReader(testFile);
        instance = new QueueImpl(testQueueReader).getQueueIndex(8).getWuid();
    }
    
    /** {@inheritDoc} */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getProj method, of class WorkUnitImpl.
     */
    public void testGetProj() {
        System.out.println("getProj");
        int expResult = 7025;
        int result = instance.getProj();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRun method, of class WorkUnitImpl.
     */
    public void testGetRun() {
        System.out.println("getRun");
        int expResult = 0;
        int result = instance.getRun();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClone method, of class WorkUnitImpl.
     */
    public void testGetClone() {
        System.out.println("getClone");
        int expResult = 84;
        int result = instance.getClone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGen method, of class WorkUnitImpl.
     */
    public void testGetGen() {
        System.out.println("getGen");
        int expResult = 17;
        int result = instance.getGen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIssue method, of class WorkUnitImpl.
     */
    public void testGetIssue() {
        System.out.println("getIssue");
        Date expResult = new Date(1313415431000L);
        Date result = instance.getIssue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProj method, of class WorkUnitImpl.
     */
    public void testSetProj() {
        System.out.println("setProj");
        instance.setProj();
    }

    /**
     * Test of setRun method, of class WorkUnitImpl.
     */
    public void testSetRun() {
        System.out.println("setRun");
        instance.setRun();
    }

    /**
     * Test of setClone method, of class WorkUnitImpl.
     */
    public void testSetClone() {
        System.out.println("setClone");
        instance.setClone();
    }

    /**
     * Test of setGen method, of class WorkUnitImpl.
     */
    public void testSetGen() {
        System.out.println("setGen");
        instance.setGen();
    }

    /**
     * Test of setIssue method, of class WorkUnitImpl.
     */
    public void testSetIssue() {
        System.out.println("setIssue");
        instance.setIssue();
    }

    /**
     * Test of setCompleted method, of class WorkUnitImpl.
     */
    public void testSetCompleted() {
        System.out.println("setCompleted");
        String line = "[09:29:07] Completed 0 out of 10000000 steps  (0%)";
        instance.setCompleted(line);
    }

    /**
     * Test of getCompleted method, of class WorkUnitImpl.
     */
    public void testGetCompleted() {
        System.out.println("getCompleted");
        int expResult = 0;
        int result = instance.getCompleted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPercentage method, of class WorkUnitImpl.
     */
    public void testGetPercentage() {
        System.out.println("getPercentage");
        String expResult = "0%";
        String result = instance.getPercentage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProtein method, of class WorkUnitImpl.
     */
    public void testGetProtein() {
        System.out.println("getProtein");
        String expResult = null;
        String result = instance.getProtein();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSteps method, of class WorkUnitImpl.
     */
    public void testGetSteps() {
        System.out.println("getSteps");
        int expResult = 0;
        int result = instance.getSteps();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class WorkUnitImpl.
     */
    public void testUpdate() {
        System.out.println("update");
        instance.update();
    }
}
