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
import java.net.*;
import java.util.Date;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>QueueIndexImplTest class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 * @since 1.0
 */
public class QueueIndexImplTest extends TestCase {

    private QueueReader reader;
    private QueueIndexImpl instance;

    /**
     * <p>Constructor for QueueIndexImplTest.</p>
     *
     * @param testName a {@link java.lang.String} object.
     */
    public QueueIndexImplTest(String testName) {
        super(testName);
    }

    /**
     * <p>suite.</p>
     *
     * @return a {@link junit.framework.Test} object.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(QueueIndexImplTest.class);
        return suite;
    }

    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String testFile = "src/test/java/com/googlecode/fahview/v6project/queue.dat";
        reader = new QueueReader(testFile);
        instance = new QueueImpl(reader).getQueueIndex(8);
    }

    /** {@inheritDoc} */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getStat method, of class QueueIndexImpl.
     */
    public void testGetStat() {
        System.out.println("getStat");
        int expResult = 1;
        int result = instance.getStat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTdata method, of class QueueIndexImpl.
     */
    public void testGetTdata() {
        System.out.println("getTdata");
        Date expResult = null;
        Date result = instance.getTdata();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSvr1 method, of class QueueIndexImpl.
     */
    public void testGetSvr1() {
        System.out.println("getSvr1");
        String expResult = "svr1 replaced by svr2.";
        try {
            instance.getSvr1();
        } catch (UnsupportedOperationException ex) {
            String result = ex.getMessage();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getUstat method, of class QueueIndexImpl.
     */
    public void testGetUstat() {
        System.out.println("getUstat");
        int expResult = 0;
        int result = instance.getUstat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUrl method, of class QueueIndexImpl.
     *
     * @throws java.net.MalformedURLException if any.
     */
    public void testGetUrl() throws MalformedURLException {
        System.out.println("getUrl");
        URL expResult = new URL("http://www.stanford.edu/~pande/Win32/x86");
        URL result = instance.getUrl();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCore method, of class QueueIndexImpl.
     */
    public void testGetCore() {
        System.out.println("getCore");
        String expResult = "queue.index[8].core.coreNo\tA4\n" +
                "queue.index[8].core.project\tGRO-A4";
        String result = instance.getCore().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDsiz method, of class QueueIndexImpl.
     */
    public void testGetDsiz() {
        System.out.println("getDsiz");
        int expResult = 53578;
        int result = instance.getDsiz();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWuid method, of class QueueIndexImpl.
     *
     * @throws java.lang.InstantiationException if any.
     */
    public void testGetWuid() throws InstantiationException {
        System.out.println("getWuid");
        String expResult = new WorkUnitImpl(8, reader).toString();
        String result = instance.getWuid().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMid method, of class QueueIndexImpl.
     */
//    public void testGetMid() {
//        System.out.println("getMid");
//        int expResult = 1;
//        int result = instance.getMid();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getSvr2 method, of class QueueIndexImpl.
     *
     * @throws java.net.UnknownHostException if any.
     */
    public void testGetSvr2() throws UnknownHostException {
        System.out.println("getSvr2");
        Inet4Address expResult = (Inet4Address) InetAddress.getByName("129.74.85.15");
        Inet4Address result = instance.getSvr2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPort method, of class QueueIndexImpl.
     */
    public void testGetPort() {
        System.out.println("getPort");
        int expResult = 8080;
        int result = instance.getPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class QueueIndexImpl.
     */
    public void testGetType() {
        System.out.println("getType");
        String expResult = "Folding@home";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUname method, of class QueueIndexImpl.
     */
    public void testGetUname() {
        System.out.println("getUname");
        String expResult = "montycrabapple";
        String result = instance.getUname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTeamn method, of class QueueIndexImpl.
     */
    public void testGetTeamn() {
        System.out.println("getTeamn");
        int expResult = 39299;
        int result = instance.getTeamn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUid method, of class QueueIndexImpl.
     */
//    public void testGetUid() {
//        System.out.println("getUid");
//        long expResult = 7088895741356248849L;
//        long result = instance.getUid();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getBench method, of class QueueIndexImpl.
     */
//    public void testGetBench() {
//        System.out.println("getBench");
//        int expResult = 0;
//        int result = instance.getBench();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getCpuType method, of class QueueIndexImpl.
     */
    public void testGetCpuType() {
        System.out.println("getCpuType");
        String expResult = "Unknown";
        String result = instance.getCpuType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOsType method, of class QueueIndexImpl.
     */
    public void testGetOsType() {
        System.out.println("getOsType");
        String expResult = "Unknown";
        String result = instance.getOsType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCpuSpec method, of class QueueIndexImpl.
     */
//    public void testGetCpuSpec() {
//        System.out.println("getCpuSpec");
//        int expResult = 687;
//        String result = instance.getCpuSpec();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getOsSpec method, of class QueueIndexImpl.
     */
//    public void testGetOsSpec() {
//        System.out.println("getOsSpec");
//        int expResult = 8;
//        String result = instance.getOsSpec();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getExpire method, of class QueueIndexImpl.
     */
//    public void testGetExpire() {
//        System.out.println("getExpire");
//        Date expResult = new Date(950400L);
//        Date result = instance.getExpire();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getCltype method, of class QueueIndexImpl.
     */
//    public void testGetCltype() {
//        System.out.println("getCltype");
//        int expResult = 0;
//        int result = instance.getCltype();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getAiflag method, of class QueueIndexImpl.
     */
//    public void testGetAiflag() {
//        System.out.println("getAiflag");
//        boolean expResult = true;
//        boolean result = instance.getAiflag();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getAitime method, of class QueueIndexImpl.
     */
//    public void testGetAitime() {
//        System.out.println("getAitime");
//        Date expResult = new Date(920509205L);
//        Date result = instance.getAitime();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getAidata method, of class QueueIndexImpl.
     */
//    public void testGetAidata() {
//        System.out.println("getAidata");
//        long expResult = 3335489684L;
//        long result = instance.getAidata();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getCsip method, of class QueueIndexImpl.
     *
     * @throws java.net.UnknownHostException if any.
     */
    public void testGetCsip() throws UnknownHostException {
        System.out.println("getCsip");
        Inet4Address expResult = (Inet4Address) InetAddress.getByName("129.74.85.16");
        Inet4Address result = instance.getCsip();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDstart method, of class QueueIndexImpl.
     */
//    public void testGetDstart() {
//        System.out.println("getDstart");
//        Date expResult = new Date(0L);
//        Date result = instance.getDstart();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getCores method, of class QueueIndexImpl.
     */
    public void testGetCores() {
        System.out.println("getCores");
        int expResult = 0;
        int result = instance.getCores();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTag method, of class QueueIndexImpl.
     */
    public void testGetTag() {
        System.out.println("getTag");
        String expResult = "";
        String result = instance.getTag();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPasskey method, of class QueueIndexImpl.
     */
    public void testGetPasskey() {
        System.out.println("getPasskey");
        String expResult = "";
        String result = instance.getPasskey();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlops method, of class QueueIndexImpl.
     */
//    public void testGetFlops() {
//        System.out.println("getFlops");
//        int expResult = 1060130272;
//        int result = instance.getFlops();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getMemory method, of class QueueIndexImpl.
     */
    public void testGetMemory() {
        System.out.println("getMemory");
        int expResult = 3017;
        int result = instance.getMemory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGpuMemory method, of class QueueIndexImpl.
     */
//    public void testGetGpuMemory() {
//        System.out.println("getGpuMemory");
//        int expResult = 0;
//        int result = instance.getGpuMemory();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getDue method, of class QueueIndexImpl.
     */
//    public void testGetDue() {
//        System.out.println("getDue");
//        Date expResult = null;
//        Date result = instance.getDue();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getPlimit method, of class QueueIndexImpl.
     */
//    public void testGetPlimit() {
//        System.out.println("getPlimit");
//        int expResult = 524286976;
//        int result = instance.getPlimit();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getUploads method, of class QueueIndexImpl.
     */
//    public void testGetUploads() {
//        System.out.println("getUploads");
//        int expResult = 0;
//        int result = instance.getUploads();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of setStat method, of class QueueIndexImpl.
     */
    public void testSetStat() {
        System.out.println("setStat");
        instance.setStat();
    }

    /**
     * Test of setTdata method, of class QueueIndexImpl.
     */
//    public void testSetTdata() {
//        System.out.println("setTdata");
//        instance.setTdata();
//    }

    /**
     * Test of setUstat method, of class QueueIndexImpl.
     */
//    public void testSetUstat() {
//        System.out.println("setUstat");
//        instance.setUstat();
//    }

    /**
     * Test of setUrl method, of class QueueIndexImpl.
     */
    public void testSetUrl() {
        System.out.println("setUrl");
        instance.setUrl();
    }

    /**
     * Test of setCore method, of class QueueIndexImpl.
     */
    public void testSetCore() {
        System.out.println("setCore");
        instance.setCore();
    }

    /**
     * Test of setDsiz method, of class QueueIndexImpl.
     */
    public void testSetDsiz() {
        System.out.println("setDsiz");
        instance.setDsiz();
    }

    /**
     * Test of setWuid method, of class QueueIndexImpl.
     */
    public void testSetWuid() {
        System.out.println("setWuid");
        instance.setWuid();
    }

    /**
     * Test of setMid method, of class QueueIndexImpl.
     */
//    public void testSetMid() {
//        System.out.println("setMid");
//        instance.setMid();
//    }

    /**
     * Test of setSvr2 method, of class QueueIndexImpl.
     */
    public void testSetSvr2() {
        System.out.println("setSvr2");
        instance.setSvr2();
    }

    /**
     * Test of setPort method, of class QueueIndexImpl.
     */
    public void testSetPort() {
        System.out.println("setPort");
        instance.setPort();
    }

    /**
     * Test of setType method, of class QueueIndexImpl.
     */
    public void testSetType() {
        System.out.println("setType");
        instance.setType();
    }

    /**
     * Test of setUname method, of class QueueIndexImpl.
     */
    public void testSetUname() {
        System.out.println("setUname");
        instance.setUname();
    }

    /**
     * Test of setTeamn method, of class QueueIndexImpl.
     */
    public void testSetTeamn() {
        System.out.println("setTeamn");
        instance.setTeamn();
    }

    /**
     * Test of setUID method, of class QueueIndexImpl.
     */
//    public void testSetUID() {
//        System.out.println("setUID");
//        instance.setUID();
//    }

    /**
     * Test of setBench method, of class QueueIndexImpl.
     */
//    public void testSetBench() {
//        System.out.println("setBench");
//        instance.setBench();
//    }

    /**
     * Test of setCpuType method, of class QueueIndexImpl.
     */
//    public void testSetCpuType() {
//        System.out.println("setCpuType");
//        instance.setCpuType();
//    }

    /**
     * Test of setOsType method, of class QueueIndexImpl.
     */
//    public void testSetOsType() {
//        System.out.println("setOsType");
//        instance.setOsType();
//    }

    /**
     * Test of setCpuSpec method, of class QueueIndexImpl.
     */
//    public void testSetCpuSpec() {
//        System.out.println("setCpuSpec");
//        instance.setCpuSpec();
//    }

    /**
     * Test of setOsSpec method, of class QueueIndexImpl.
     */
//    public void testSetOsSpec() {
//        System.out.println("setOsSpec");
//        instance.setOsSpec();
//    }

    /**
     * Test of setExpire method, of class QueueIndexImpl.
     */
//    public void testSetExpire() {
//        System.out.println("setExpire");
//        instance.setExpire();
//    }

    /**
     * Test of setCltype method, of class QueueIndexImpl.
     */
//    public void testSetCltype() {
//        System.out.println("setCltype");
//        instance.setCltype();
//    }

    /**
     * Test of setAiflag method, of class QueueIndexImpl.
     */
//    public void testSetAiflag() {
//        System.out.println("setAiflag");
//        instance.setAiflag();
//    }

    /**
     * Test of setAitime method, of class QueueIndexImpl.
     */
//    public void testSetAitime() {
//        System.out.println("setAitime");
//        instance.setAitime();
//    }

    /**
     * Test of setAidata method, of class QueueIndexImpl.
     */
//    public void testSetAidata() {
//        System.out.println("setAidata");
//        instance.setAidata();
//    }

    /**
     * Test of setCsip method, of class QueueIndexImpl.
     */
    public void testSetCsip() {
        System.out.println("setCsip");
        instance.setCsip();
    }

    /**
     * Test of setDstart method, of class QueueIndexImpl.
     */
//    public void testSetDstart() {
//        System.out.println("setDstart");
//        instance.setDstart();
//    }

    /**
     * Test of setCores method, of class QueueIndexImpl.
     */
    public void testSetCores() {
        System.out.println("setCores");
        instance.setCores();
    }

    /**
     * Test of setTag method, of class QueueIndexImpl.
     */
    public void testSetTag() {
        System.out.println("setTag");
        instance.setTag();
    }

    /**
     * Test of setPasskey method, of class QueueIndexImpl.
     */
    public void testSetPasskey() {
        System.out.println("setPasskey");
        instance.setPasskey();
    }

    /**
     * Test of setFlops method, of class QueueIndexImpl.
     */
//    public void testSetFlops() {
//        System.out.println("setFlops");
//        instance.setFlops();
//    }

    /**
     * Test of setMemory method, of class QueueIndexImpl.
     */
    public void testSetMemory() {
        System.out.println("setMemory");
        instance.setMemory();
    }

    /**
     * Test of setGpuMemory method, of class QueueIndexImpl.
     */
//    public void testSetGpuMemory() {
//        System.out.println("setGpuMemory");
//        instance.setGpuMemory();
//    }

    /**
     * Test of setDue method, of class QueueIndexImpl.
     */
//    public void testSetDue() {
//        System.out.println("setDue");
//        instance.setDue();
//    }

    /**
     * Test of setPlimit method, of class QueueIndexImpl.
     */
//    public void testSetPlimit() {
//        System.out.println("setPlimit");
//        instance.setPlimit();
//    }

    /**
     * Test of setUploads method, of class QueueIndexImpl.
     */
//    public void testSetUploads() {
//        System.out.println("setUploads");
//        instance.setUploads();
//    }

    /**
     * Test of toString method, of class QueueIndexImpl.
     */
    public void testToString() {
        System.out.println("toString");
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
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class QueueIndexImpl.
     */
    public void testUpdate() {
        System.out.println("update");
        instance.update();
    }
}
