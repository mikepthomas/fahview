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
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to represent data stored about a Folding@home queue index.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version 6.00
 */
public class QueueIndexImpl implements QueueIndex {

    private int stat; // Status
    private int z004; // Pad for Windows, others as of v4.01, as of v6.01 number of SMP Cores to use (LE)
    private Date tdata; // Time data (epoch 0000 1jan00 UTC)
    private int ustat; // Upload status
    private URL url; // Web address for core downloads
    private int m176; // Misc1a
    private Core core; // Core_xx number (hex)
    private int m184; // Misc1b
    private int dsiz; // wudata_xx.dat file size
    private byte[] z192; // z192
    private WorkUnitImpl wuid;
    private byte[] z224;
    private int mid; // Machine ID (LE or BE, was only LE before v5 work servers)
    private Inet4Address svr2; // Server IP address
    private int port; // Server port number
    private String type; // Work unit type
    private String uname; // User Name
    private int teamn; // Team Number
    private long uid; // Stored ID for unit (UserID + MachineID) (LE or BE, usually BE, always BE for v5 work servers)
    private int bench; // Benchmark (as of v3.24) (LE)
    private int m476; // Misc3b (unused as of v3.24) (LE); Benchmark (as of v5.00) (BE)
    private int cpu_type; // CPU type (LE or BE, sometimes 0) since 3.00
    private int os_type; // OS type (LE or BE, sometimes 0) since 3.00
    private int cpu_spec; // CPU species (LE or BE, sometimes 0) since 3.00
    private int os_spec; // OS species (LE or BE, sometimes 0) since 3.00
    private Date expire; // Allowed time to return (seconds)
    private byte[] z500;
    private int cltype; // Client type required (usually 0) (LE or BE)
    private boolean aiflag; // Assignment info present flag (LE or BE)
    private Date aitime; // Assignment timestamp (LE or BE)
    private long aidata; // Assignment info (LE or BE)
    private Inet4Address csip; // Collection server IP address (as of v5.00) (LE)
    private Date dstart; // Download started time (as of v5.00) (BE)
    private byte[] z528;
    private int m532; // Misc4a (LE or BE)
    private byte[] z536;
    private int cores; // Number of SMP cores (as of v5.91) (BE)
    private String tag; // Tag of Work Unit (as of v5.00)
    private byte[] z564;
    private String passkey; // Passkey (as of v6.00)
    private int flops; // Flops per CPU (core) (as of v6.00) (BE)
    private int memory; // Available memory (as of v6.00) (BE)
    private int gpu_memory; // Available GPU memory (as of v6.20) (LE)
    private byte[] z624;
    private Date due; // WU expiration time
    private int plimit; // Packet size limit (as of v5.00)
    private int uploads; // Number of upload failures (as of v5.00)
    
    private int indexNumber, position;
    private QueueReader reader;

    /**
     * <p>Constructor for QueueIndexImpl.</p>
     *
     * @param indexNumber a int.
     * @param reader a {@link com.googlecode.fahview.v6project.utilities.QueueReader} object.
     * @throws java.lang.InstantiationException if any.
     */
    public QueueIndexImpl(int indexNumber, QueueReader reader) throws InstantiationException {
        this.indexNumber = indexNumber;
        switch (indexNumber) {
            case 0:
                position = QueueImpl.QUEUE_INDEX_0_POS;
                break;
            case 1:
                position = QueueImpl.QUEUE_INDEX_1_POS;
                break;
            case 2:
                position = QueueImpl.QUEUE_INDEX_2_POS;
                break;
            case 3:
                position = QueueImpl.QUEUE_INDEX_3_POS;
                break;
            case 4:
                position = QueueImpl.QUEUE_INDEX_4_POS;
                break;
            case 5:
                position = QueueImpl.QUEUE_INDEX_5_POS;
                break;
            case 6:
                position = QueueImpl.QUEUE_INDEX_6_POS;
                break;
            case 7:
                position = QueueImpl.QUEUE_INDEX_7_POS;
                break;
            case 8:
                position = QueueImpl.QUEUE_INDEX_8_POS;
                break;
            case 9:
                position = QueueImpl.QUEUE_INDEX_9_POS;
                break;
            default:
                throw new InstantiationException("Queue index should be 0-9.");
        }
        this.reader = reader;
        update();
    }

    /** {@inheritDoc} */
    @Override
    public int getStat() {
        return stat;
    }

    /** {@inheritDoc} */
    @Override
    public Date getTdata() {
        return tdata;
    }

    /** {@inheritDoc} */
    @Override
    public Inet4Address getSvr1() {
        throw new UnsupportedOperationException("svr1 replaced by svr2.");
    }

    /** {@inheritDoc} */
    @Override
    public int getUstat() {
        return ustat;
    }

    /** {@inheritDoc} */
    @Override
    public URL getUrl() {
        return url;
    }

    /** {@inheritDoc} */
    @Override
    public Core getCore() {
        return core;
    }

    /** {@inheritDoc} */
    @Override
    public int getDsiz() {
        return dsiz;
    }

    /** {@inheritDoc} */
    @Override
    public WorkUnitImpl getWuid() {
        return wuid;
    }

    /** {@inheritDoc} */
    @Override
    public int getMid() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public Inet4Address getSvr2() {
        return svr2;
    }

    /** {@inheritDoc} */
    @Override
    public int getPort() {
        return port;
    }

    /** {@inheritDoc} */
    @Override
    public String getType() {
        return type;
    }

    /** {@inheritDoc} */
    @Override
    public String getUname() {
        return uname;
    }

    /** {@inheritDoc} */
    @Override
    public int getTeamn() {
        return teamn;
    }

    /** {@inheritDoc} */
    @Override
    public long getUid() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int getBench() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public String getCpuType() {
        String cpu = null;
        switch (cpu_type) {
            case 100000:
                cpu = "x86";
                break;
            case 100085:
                cpu = "x86";
                break;
            case 100086:
                cpu = "i86";
                break;
            case 100087:
                cpu = "Pentium IV";
                break;
            case 100186:
                cpu = "i186";
                break;
            case 100286:
                cpu = "i286";
                break;
            case 100386:
                cpu = "i386";
                break;
            case 100486:
                cpu = "i486";
                break;
            case 100586:
                cpu = "Pentium";
                break;
            case 100587:
                cpu = "Pentium MMX";
                break;
            case 100686:
                cpu = "Pentium Pro";
                break;
            case 100687:
                cpu = "Pentium II/III";
                break;
            case 101000:
                cpu = "Cyrix x86";
                break;
            case 102000:
                cpu = "AMD x86";
                break;
            case 200000:
                cpu = "PowerPC";
                break;
            case 1100000:
                cpu = "IA64";
                break;
            case 1600000:
                cpu = "AMD64";
                break;
            default:
                cpu = "Unknown";
                break;
        }
        return cpu;
    }

    /** {@inheritDoc} */
    @Override
    public String getOsType() {
        String os = null;
        switch (os_type) {
            case 100000:
                os = "Windows";
                break;
            case 100001:
                os = "Win95";
                break;
            case 100002:
                os = "Win95_OSR2";
                break;
            case 100003:
                os = "Win98";
                break;
            case 100004:
                os = "Win98SE";
                break;
            case 100005:
                os = "WinME";
                break;
            case 100006:
                os = "WinNT";
                break;
            case 100007:
                os = "Win2K";
                break;
            case 100008:
                os = "WinXP";
                break;
            case 100009:
                os = "Win2K3";
                break;
            case 200000:
                os = "MacOS";
                break;
            case 300000:
                os = "OSX";
                break;
            case 400000:
                os = "Linux";
                break;
            case 700000:
                os = "FreeBSD";
                break;
            case 800000:
                os = "OpenBSD";
                break;
            case 1800000:
                os = "Win64";
                break;
            case 1900000:
                os = "OS2";
                break;
            default:
                os = "Unknown";
                break;
        }
        return os;
    }

    /** {@inheritDoc} */
    @Override
    public String getCpuSpec() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public String getOsSpec() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public Date getExpire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int getCltype() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public boolean getAiflag() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public Date getAitime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public long getAidata() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public Inet4Address getCsip() {
        return csip;
    }

    /** {@inheritDoc} */
    @Override
    public Date getDstart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int getCores() {
        return cores;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return tag;
    }

    /** {@inheritDoc} */
    @Override
    public String getPasskey() {
        return passkey;
    }

    /** {@inheritDoc} */
    @Override
    public int getFlops() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int getMemory() {
        return memory;
    }

    /** {@inheritDoc} */
    @Override
    public int getGpuMemory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public Date getDue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int getPlimit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int getUploads() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Status Mutator
     */
    protected void setStat() {
        stat = (int) reader.readLEUInt(STAT_POS + position, STAT_LENGTH);
    }

    /**
     * Set the value of Time data
     */
    protected void setTdata() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Set the value of Upload status
     */
    protected void setUstat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Set the value of Web address for core download
     */
    protected void setUrl() {
        try {
            url = new URL("http://" + reader.readString(URL_POS + position, URL_LENGTH));
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(QueueIndexImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Set the value of Core_xx number (hex)
     */
    protected void setCore() {
        try {
            core = new Core(indexNumber, reader);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(QueueIndexImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Set the value of wudata_xx.dat file size
     */
    protected void setDsiz() {
        dsiz = (int) reader.readLEUInt(DSIZ_POS + position, DSIZ_LENGTH);
    }

    /**
     * <p>Setter for the field <code>wuid</code>.</p>
     */
    protected void setWuid() {
        try {
            wuid = new WorkUnitImpl(indexNumber, reader);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(QueueIndexImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>Setter for the field <code>mid</code>.</p>
     */
    protected void setMid() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>svr2</code>.</p>
     */
    protected void setSvr2() {
        try {
            svr2 = (Inet4Address) Inet4Address.getByAddress(reader.readIP(SVR2_POS + position));
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(QueueIndexImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>Setter for the field <code>port</code>.</p>
     */
    protected void setPort() {
        port = (int) reader.readLEUInt(PORT_POS + position, PORT_LENGTH);
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     */
    protected void setType() {
        type = reader.readString(TYPE_POS + position, TYPE_LENGTH);
    }

    /**
     * <p>Setter for the field <code>uname</code>.</p>
     */
    protected void setUname() {
        uname = reader.readString(UNAME_POS + position, UNAME_LENGTH);
    }

    /**
     * <p>Setter for the field <code>teamn</code>.</p>
     */
    protected void setTeamn() {
        teamn = Integer.valueOf(reader.readString(TEAMN_POS + position, TEAMN_LENGTH));
    }

    /**
     * <p>setUID.</p>
     */
    protected void setUID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>bench</code>.</p>
     */
    protected void setBench() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>setCpuType.</p>
     */
    protected void setCpuType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>setOsType.</p>
     */
    protected void setOsType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>setCpuSpec.</p>
     */
    protected void setCpuSpec() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>setOsSpec.</p>
     */
    protected void setOsSpec() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>expire</code>.</p>
     */
    protected void setExpire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>cltype</code>.</p>
     */
    protected void setCltype() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>aiflag</code>.</p>
     */
    protected void setAiflag() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>aitime</code>.</p>
     */
    protected void setAitime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>aidata</code>.</p>
     */
    protected void setAidata() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>csip</code>.</p>
     */
    protected void setCsip() {
        try {
            csip = (Inet4Address) Inet4Address.getByAddress(reader.readIP(CSIP_POS + position));
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(QueueIndexImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>Setter for the field <code>dstart</code>.</p>
     */
    protected void setDstart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>cores</code>.</p>
     */
    protected void setCores() {
        cores = (int) reader.readLEUInt(CORES_POS + position, CORES_LENGTH);
    }

    /**
     * <p>Setter for the field <code>tag</code>.</p>
     */
    protected void setTag() {
        tag = reader.readString(TAG_POS + position, TAG_LENGTH);
    }

    /**
     * <p>Setter for the field <code>passkey</code>.</p>
     */
    protected void setPasskey() {
        passkey = reader.readString(PASSKEY_POS + position, PASSKEY_LENGTH);
    }

    /**
     * <p>Setter for the field <code>flops</code>.</p>
     */
    protected void setFlops() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>memory</code>.</p>
     */
    protected void setMemory() {
        memory = (int) reader.readBEUInt(MEMORY_POS + position, MEMORY_LENGTH);
    }

    /**
     * <p>setGpuMemory.</p>
     */
    protected void setGpuMemory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>due</code>.</p>
     */
    protected void setDue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>plimit</code>.</p>
     */
    protected void setPlimit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p>Setter for the field <code>uploads</code>.</p>
     */
    protected void setUploads() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * {@inheritDoc}
     *
     * Generate a String representation of the QueueImpl
     */
    @Override
    public String toString() {
        String result = "";
        result += "queue.index[" + indexNumber + "].stat\t" + getStat();
        result += "\nqueue.index[" + indexNumber + "].url\t" + getUrl();
        result += "\n" + getCore();
        result += "\nqueue.index[" + indexNumber + "].dsiz\t" + getDsiz();
        result += "\n" + getWuid();
        result += "\nqueue.index[" + indexNumber + "].svr2\t" + getSvr2();
        result += "\nqueue.index[" + indexNumber + "].port\t" + getPort();
        result += "\nqueue.index[" + indexNumber + "].type\t" + getType();
        result += "\nqueue.index[" + indexNumber + "].uname\t" + getUname();
        result += "\nqueue.index[" + indexNumber + "].teamn\t" + getTeamn();
        result += "\nqueue.index[" + indexNumber + "].csip\t" + getCsip();
        result += "\nqueue.index[" + indexNumber + "].cores\t" + getCores();
        result += "\nqueue.index[" + indexNumber + "].tag\t" + getTag();
        result += "\nqueue.index[" + indexNumber + "].passkey\t" + getPasskey();
        result += "\nqueue.index[" + indexNumber + "].memory\t" + getMemory();
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final void update() {
        setStat();
        setUrl();
        setCore();
        setDsiz();
        setWuid();
        setSvr2();
        setPort();
        setType();
        setUname();
        setTeamn();
        setCsip();
        setCores();
        setTag();
        setPasskey();
        setMemory();
    }
}
