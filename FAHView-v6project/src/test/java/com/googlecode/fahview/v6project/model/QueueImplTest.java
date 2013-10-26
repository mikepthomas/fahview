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
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>QueueImplTest class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 * @since 1.0
 */
public class QueueImplTest extends TestCase {
    
    private QueueReader testFile = new QueueReader("src/test/java/com/googlecode/fahview/v6project/queue.dat");
    
    /**
     * <p>Constructor for QueueImplTest.</p>
     *
     * @param testName a {@link java.lang.String} object.
     */
    public QueueImplTest(String testName) {
        super(testName);
    }

    /**
     * <p>suite.</p>
     *
     * @return a {@link junit.framework.Test} object.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(QueueImplTest.class);
        return suite;
    }
    
    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    /** {@inheritDoc} */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getVersion method, of class QueueImpl.
     */
    public void testGetVersion() {
        System.out.println("getVersion");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 600;
        int result = instance.getVersion();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrent method, of class QueueImpl.
     */
    public void testGetCurrent() {
        System.out.println("getCurrent");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 8;
        int result = instance.getCurrent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQueueIndex method, of class QueueImpl.
     *
     * @throws java.lang.InstantiationException if any.
     */
    public void testGetQueueIndex() throws InstantiationException {
        System.out.println("getQueueIndex");
        int index = 8;
        QueueImpl instance = new QueueImpl(testFile);
        String expResult =
                "queue.index[8].stat\t1\n" +
                "queue.index[8].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[8].core.coreNo\tA4\n" +
                "queue.index[8].core.project\tGRO-A4\n" +
                "queue.index[8].dsiz\t53578\n" +
                "queue.index[8].wuid.proj\t7025\n" +
                "queue.index[8].wuid.run\t0\n" +
                "queue.index[8].wuid.clone\t84\n" +
                "queue.index[8].wuid.gen\t17\n" +
                "queue.index[8].wuid.issue\tMon Aug 15 14:37:11 BST 2011\n" +
                "queue.index[8].svr2\t/129.74.85.15\n" +
                "queue.index[8].port\t8080\n" +
                "queue.index[8].type\tFolding@home\n" +
                "queue.index[8].uname\tmontycrabapple\n" +
                "queue.index[8].teamn\t39299\n" +
                "queue.index[8].csip\t/129.74.85.16\n" +
                "queue.index[8].cores\t0\n" +
                "queue.index[8].tag\t\n" +
                "queue.index[8].passkey\t\n" +
                "queue.index[8].memory\t3017";
        String result = instance.getQueueIndex(index).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPfract method, of class QueueImpl.
     */
    public void testGetPfract() {
        System.out.println("getPfract");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 1060130272;
        int result = instance.getPfract();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPunits method, of class QueueImpl.
     */
    public void testGetPunits() {
        System.out.println("getPunits");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 4;
        int result = instance.getPunits();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDrate method, of class QueueImpl.
     */
    public void testGetDrate() {
        System.out.println("getDrate");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 128596;
        int result = instance.getDrate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDunits method, of class QueueImpl.
     */
    public void testGetDunits() {
        System.out.println("getDunits");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 4;
        int result = instance.getDunits();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUrate method, of class QueueImpl.
     */
    public void testGetUrate() {
        System.out.println("getUrate");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 213406;
        int result = instance.getUrate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUunits method, of class QueueImpl.
     */
    public void testGetUunits() {
        System.out.println("getUunits");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 4;
        int result = instance.getUunits();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSent method, of class QueueImpl.
     */
    public void testGetSent() {
        System.out.println("getSent");
        QueueImpl instance = new QueueImpl(testFile);
        int expResult = 0;
        int result = instance.getSent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVersion method, of class QueueImpl.
     */
    public void testSetVersion() {
        System.out.println("setVersion");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setVersion();
    }

    /**
     * Test of setCurrent method, of class QueueImpl.
     */
    public void testSetCurrent() {
        System.out.println("setCurrent");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setCurrent();
    }

    /**
     * Test of setIndex method, of class QueueImpl.
     */
    public void testSetIndex() {
        System.out.println("setIndex");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setIndex();
    }

    /**
     * Test of setPfract method, of class QueueImpl.
     */
    public void testSetPfract() {
        System.out.println("setPfract");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setPfract();
    }

    /**
     * Test of setPunits method, of class QueueImpl.
     */
    public void testSetPunits() {
        System.out.println("setPunits");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setPunits();
    }

    /**
     * Test of setDrate method, of class QueueImpl.
     */
    public void testSetDrate() {
        System.out.println("setDrate");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setDrate();
    }

    /**
     * Test of setDunits method, of class QueueImpl.
     */
    public void testSetDunits() {
        System.out.println("setDunits");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setDunits();
    }

    /**
     * Test of setUrate method, of class QueueImpl.
     */
    public void testSetUrate() {
        System.out.println("setUrate");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setUrate();
    }

    /**
     * Test of setUunits method, of class QueueImpl.
     */
    public void testSetUunits() {
        System.out.println("setUunits");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setUunits();
    }

    /**
     * Test of setSent method, of class QueueImpl.
     */
    public void testSetSent() {
        System.out.println("setSent");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setSent();
    }

    /**
     * Test of setZ7156 method, of class QueueImpl.
     */
    public void testSetZ7156() {
        System.out.println("setZ7156");
        QueueImpl instance = new QueueImpl(testFile);
        instance.setZ7156();
    }

    /**
     * Test of toString method, of class QueueImpl.
     */
    public void testToString() {
        System.out.println("toString");
        QueueImpl instance = new QueueImpl(testFile);
        String expResult =
                "queue.version\t600\n" +
                "queue.current\t8\n" +
                "queue.index[0].stat\t0\n" +
                "queue.index[0].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[0].core.coreNo\tA4\n" +
                "queue.index[0].core.project\tGRO-A4\n" +
                "queue.index[0].dsiz\t52119\n" +
                "queue.index[0].wuid.proj\t7015\n" +
                "queue.index[0].wuid.run\t1\n" +
                "queue.index[0].wuid.clone\t82\n" +
                "queue.index[0].wuid.gen\t5\n" +
                "queue.index[0].wuid.issue\tTue Jul 12 14:37:13 BST 2011\n" +
                "queue.index[0].svr2\t/129.74.85.15\n" +
                "queue.index[0].port\t8080\n" +
                "queue.index[0].type\tFolding@home\n" +
                "queue.index[0].uname\tmontycrabapple\n" +
                "queue.index[0].teamn\t39299\n" +
                "queue.index[0].csip\t/129.74.85.16\n" +
                "queue.index[0].cores\t0\n" +
                "queue.index[0].tag\t\n" +
                "queue.index[0].passkey\t\n" +
                "queue.index[0].memory\t3017\n" +
                "queue.index[1].stat\t0\n" +
                "queue.index[1].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[1].core.coreNo\tA4\n" +
                "queue.index[1].core.project\tGRO-A4\n" +
                "queue.index[1].dsiz\t55933\n" +
                "queue.index[1].wuid.proj\t7001\n" +
                "queue.index[1].wuid.run\t2\n" +
                "queue.index[1].wuid.clone\t336\n" +
                "queue.index[1].wuid.gen\t3\n" +
                "queue.index[1].wuid.issue\tWed Jul 13 08:32:16 BST 2011\n" +
                "queue.index[1].svr2\t/129.74.85.15\n" +
                "queue.index[1].port\t8080\n" +
                "queue.index[1].type\tFolding@home\n" +
                "queue.index[1].uname\tmontycrabapple\n" +
                "queue.index[1].teamn\t39299\n" +
                "queue.index[1].csip\t/129.74.85.16\n" +
                "queue.index[1].cores\t0\n" +
                "queue.index[1].tag\t\n" +
                "queue.index[1].passkey\t\n" +
                "queue.index[1].memory\t3017\n" +
                "queue.index[2].stat\t0\n" +
                "queue.index[2].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[2].core.coreNo\tA4\n" +
                "queue.index[2].core.project\tGRO-A4\n" +
                "queue.index[2].dsiz\t275600\n" +
                "queue.index[2].wuid.proj\t10437\n" +
                "queue.index[2].wuid.run\t102\n" +
                "queue.index[2].wuid.clone\t0\n" +
                "queue.index[2].wuid.gen\t41\n" +
                "queue.index[2].wuid.issue\tFri Jul 15 14:29:52 BST 2011\n" +
                "queue.index[2].svr2\t/171.64.65.81\n" +
                "queue.index[2].port\t8080\n" +
                "queue.index[2].type\tFolding@home\n" +
                "queue.index[2].uname\tmontycrabapple\n" +
                "queue.index[2].teamn\t39299\n" +
                "queue.index[2].csip\t/171.67.108.26\n" +
                "queue.index[2].cores\t0\n" +
                "queue.index[2].tag\t\n" +
                "queue.index[2].passkey\t\n" +
                "queue.index[2].memory\t3017\n" +
                "queue.index[3].stat\t0\n" +
                "queue.index[3].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[3].core.coreNo\tA4\n" +
                "queue.index[3].core.project\tGRO-A4\n" +
                "queue.index[3].dsiz\t650518\n" +
                "queue.index[3].wuid.proj\t7802\n" +
                "queue.index[3].wuid.run\t0\n" +
                "queue.index[3].wuid.clone\t334\n" +
                "queue.index[3].wuid.gen\t0\n" +
                "queue.index[3].wuid.issue\tThu Jul 21 11:18:55 BST 2011\n" +
                "queue.index[3].svr2\t/171.64.65.100\n" +
                "queue.index[3].port\t8080\n" +
                "queue.index[3].type\tFolding@home\n" +
                "queue.index[3].uname\tmontycrabapple\n" +
                "queue.index[3].teamn\t39299\n" +
                "queue.index[3].csip\t/171.67.108.49\n" +
                "queue.index[3].cores\t0\n" +
                "queue.index[3].tag\t\n" +
                "queue.index[3].passkey\t\n" +
                "queue.index[3].memory\t3017\n" +
                "queue.index[4].stat\t0\n" +
                "queue.index[4].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[4].core.coreNo\t78\n" +
                "queue.index[4].core.project\tGROMACS\n" +
                "queue.index[4].dsiz\t376535\n" +
                "queue.index[4].wuid.proj\t6883\n" +
                "queue.index[4].wuid.run\t327\n" +
                "queue.index[4].wuid.clone\t10\n" +
                "queue.index[4].wuid.gen\t27\n" +
                "queue.index[4].wuid.issue\tFri Aug 05 14:47:26 BST 2011\n" +
                "queue.index[4].svr2\t/171.67.108.33\n" +
                "queue.index[4].port\t8080\n" +
                "queue.index[4].type\tFolding@home\n" +
                "queue.index[4].uname\tmontycrabapple\n" +
                "queue.index[4].teamn\t39299\n" +
                "queue.index[4].csip\t/171.67.108.26\n" +
                "queue.index[4].cores\t0\n" +
                "queue.index[4].tag\t\n" +
                "queue.index[4].passkey\t\n" +
                "queue.index[4].memory\t3017\n" +
                "queue.index[5].stat\t0\n" +
                "queue.index[5].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[5].core.coreNo\t78\n" +
                "queue.index[5].core.project\tGROMACS\n" +
                "queue.index[5].dsiz\t374190\n" +
                "queue.index[5].wuid.proj\t6884\n" +
                "queue.index[5].wuid.run\t883\n" +
                "queue.index[5].wuid.clone\t5\n" +
                "queue.index[5].wuid.gen\t5\n" +
                "queue.index[5].wuid.issue\tMon Aug 08 13:47:30 BST 2011\n" +
                "queue.index[5].svr2\t/171.67.108.33\n" +
                "queue.index[5].port\t8080\n" +
                "queue.index[5].type\tFolding@home\n" +
                "queue.index[5].uname\tmontycrabapple\n" +
                "queue.index[5].teamn\t39299\n" +
                "queue.index[5].csip\t/171.67.108.26\n" +
                "queue.index[5].cores\t0\n" +
                "queue.index[5].tag\t\n" +
                "queue.index[5].passkey\t\n" +
                "queue.index[5].memory\t3017\n" +
                "queue.index[6].stat\t0\n" +
                "queue.index[6].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[6].core.coreNo\tA4\n" +
                "queue.index[6].core.project\tGRO-A4\n" +
                "queue.index[6].dsiz\t55033\n" +
                "queue.index[6].wuid.proj\t10085\n" +
                "queue.index[6].wuid.run\t0\n" +
                "queue.index[6].wuid.clone\t20\n" +
                "queue.index[6].wuid.gen\t16\n" +
                "queue.index[6].wuid.issue\tMon Aug 08 15:48:15 BST 2011\n" +
                "queue.index[6].svr2\t/129.74.85.15\n" +
                "queue.index[6].port\t8080\n" +
                "queue.index[6].type\tFolding@home\n" +
                "queue.index[6].uname\tmontycrabapple\n" +
                "queue.index[6].teamn\t39299\n" +
                "queue.index[6].csip\t/129.74.85.16\n" +
                "queue.index[6].cores\t0\n" +
                "queue.index[6].tag\t\n" +
                "queue.index[6].passkey\t\n" +
                "queue.index[6].memory\t3017\n" +
                "queue.index[7].stat\t0\n" +
                "queue.index[7].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[7].core.coreNo\tA4\n" +
                "queue.index[7].core.project\tGRO-A4\n" +
                "queue.index[7].dsiz\t53082\n" +
                "queue.index[7].wuid.proj\t7023\n" +
                "queue.index[7].wuid.run\t2\n" +
                "queue.index[7].wuid.clone\t194\n" +
                "queue.index[7].wuid.gen\t16\n" +
                "queue.index[7].wuid.issue\tThu Aug 11 10:28:59 BST 2011\n" +
                "queue.index[7].svr2\t/129.74.85.15\n" +
                "queue.index[7].port\t8080\n" +
                "queue.index[7].type\tFolding@home\n" +
                "queue.index[7].uname\tmontycrabapple\n" +
                "queue.index[7].teamn\t39299\n" +
                "queue.index[7].csip\t/129.74.85.16\n" +
                "queue.index[7].cores\t0\n" +
                "queue.index[7].tag\t\n" +
                "queue.index[7].passkey\t\n" +
                "queue.index[7].memory\t3017\n" +
                "queue.index[8].stat\t1\n" +
                "queue.index[8].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[8].core.coreNo\tA4\n" +
                "queue.index[8].core.project\tGRO-A4\n" +
                "queue.index[8].dsiz\t53578\n" +
                "queue.index[8].wuid.proj\t7025\n" +
                "queue.index[8].wuid.run\t0\n" +
                "queue.index[8].wuid.clone\t84\n" +
                "queue.index[8].wuid.gen\t17\n" +
                "queue.index[8].wuid.issue\tMon Aug 15 14:37:11 BST 2011\n" +
                "queue.index[8].svr2\t/129.74.85.15\n" +
                "queue.index[8].port\t8080\n" +
                "queue.index[8].type\tFolding@home\n" +
                "queue.index[8].uname\tmontycrabapple\n" +
                "queue.index[8].teamn\t39299\n" +
                "queue.index[8].csip\t/129.74.85.16\n" +
                "queue.index[8].cores\t0\n" +
                "queue.index[8].tag\t\n" +
                "queue.index[8].passkey\t\n" +
                "queue.index[8].memory\t3017\n" +
                "queue.index[9].stat\t0\n" +
                "queue.index[9].url\thttp://www.stanford.edu/~pande/Win32/x86\n" +
                "queue.index[9].core.coreNo\tA4\n" +
                "queue.index[9].core.project\tGRO-A4\n" +
                "queue.index[9].dsiz\t53128\n" +
                "queue.index[9].wuid.proj\t7026\n" +
                "queue.index[9].wuid.run\t0\n" +
                "queue.index[9].wuid.clone\t125\n" +
                "queue.index[9].wuid.gen\t1\n" +
                "queue.index[9].wuid.issue\tThu Jul 07 15:36:20 BST 2011\n" +
                "queue.index[9].svr2\t/129.74.85.15\n" +
                "queue.index[9].port\t8080\n" +
                "queue.index[9].type\tFolding@home\n" +
                "queue.index[9].uname\tmontycrabapple\n" +
                "queue.index[9].teamn\t39299\n" +
                "queue.index[9].csip\t/129.74.85.16\n" +
                "queue.index[9].cores\t0\n" +
                "queue.index[9].tag\t\n" +
                "queue.index[9].passkey\t\n" +
                "queue.index[9].memory\t3017\n" +
                "queue.pfract\t1060130272\n" +
                "queue.punits\t4\n" +
                "queue.drate\t128596\n" +
                "queue.dunits\t4\n" +
                "queue.urate\t213406\n" +
                "queue.uunits\t4\n" +
                "queue.sent\t0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class QueueImpl.
     */
    public void testUpdate() {
        System.out.println("update");
        QueueImpl instance = new QueueImpl(testFile);
        instance.update();
    }
}
