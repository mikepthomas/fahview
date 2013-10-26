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

import java.net.InetAddress;
import java.net.URL;
import java.util.Date;

/**
 * Interface to represent data stored about a Folding@home queue index.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version 6.00
 */
public interface QueueIndex {
    // <editor-fold defaultstate="collapsed" desc="position-constants">
    /**
     * Position in bytes of Status from the start of {@code queue.dat}.
     */
    int STAT_POS = 0;
    /**
     * Position in bytes of Pad for Windows from the start of {@code queue.dat}.
     *
     * @since 4.01 Pad for others
     * @since 6.01 Number of SMP Cores to use
     * @deprecated Use {@link #CORES_POS}
     */
    int Z004_POS = 4;
    /**
     * Position in bytes of Time data from the start of {@code queue.dat}.
     */
    int TDATA_POS = 8;
    /**
     * Position in bytes of Server IP address from the start of
     * {@code queue.dat}.
     *
     * @deprecated As of 3.00 replaced by {@link #SVR2_POS}
     */
    int SVR1_POS = 40;
    /**
     * Position in bytes of Upload status from the start of {@code queue.dat}.
     */
    int USTAT_POS = 44;
    /**
     * Position in bytes of Web address for core downloads from the start of
     * {@code queue.dat}.
     */
    int URL_POS = 48;
    /**
     * Position in bytes of Misc1a from the start of {@code queue.dat}.
     */
    int M176_POS = 176;
    /**
     * Position in bytes of Core_xx number (hex) from the start of
     * {@code queue.dat}.
     */
    int CORE_POS = 180;
    /**
     * Position in bytes of Misc1b from the start of {@code queue.dat}.
     */
    int M184_POS = 184;
    /**
     * Position in bytes of wudata_xx.dat file size from the start of
     * {@code queue.dat}.
     */
    int DSIZ_POS = 188;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z192_POS = 192;
    /**
     * Position in bytes of Work unit ID information from the start of
     * {@code queue.dat}.
     */
    int WUID_POS = 208;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z224_POS = 224;
    /**
     * Position in bytes of Machine ID  from the start of {@code queue.dat}.
     */
    int MID_POS = 260;
    /**
     * Position in bytes of Server IP address from the start of
     * {@code queue.dat}.
     */
    int SVR2_POS = 264;
    /**
     * Position in bytes of Server port number from the start of
     * {@code queue.dat}.
     */
    int PORT_POS = 268;
    /**
     * Position in bytes of Work unit type from the start of {@code queue.dat}.
     */
    int TYPE_POS = 272;
    /**
     * Position in bytes of User Name from the start of {@code queue.dat}.
     */
    int UNAME_POS = 336;
    /**
     * Position in bytes of Team Number from the start of {@code queue.dat}.
     */
    int TEAMN_POS = 400;
    /**
     * Position in bytes of Stored ID for unit (UserID + MachineID)  from the
     * start of {@code queue.dat}.
     */
    int UID_POS = 464;
    /**
     * Position in bytes of Benchmark from the start of {@code queue.dat}.
     *
     * @since 3.24
     */
    int BENCH_POS = 472;
    /**
     * Position in bytes of Misc3b from the start of {@code queue.dat}.
     *
     * @deprecated 3.24
     */
    int M476_POS = 476;
    /**
     * Position in bytes of CPU type from the start of {@code queue.dat}.
     */
    int CPU_TYPE_POS = 480;
    /**
     * Position in bytes of OS type from the start of {@code queue.dat}.
     */
    int OS_TYPE_POS = 484;
    /**
     * Position in bytes of CPU species from the start of {@code queue.dat}.
     */
    int CPU_SPEC_POS = 488;
    /**
     * Position in bytes of OS species from the start of {@code queue.dat}.
     */
    int OS_SPEC_POS = 492;
    /**
     * Position in bytes of Allowed time to return (seconds) from the start of
     * {@code queue.dat}.
     */
    int EXPIRE_POS = 496;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z500_POS = 500;
    /**
     * Position in bytes of Client type required from the start of
     * {@code queue.dat}.
     */
    int CLTYPE_POS = 504;
    /**
     * Position in bytes of Assignment info present flag from the start of
     * {@code queue.dat}.
     */
    int AIFLAG_POS = 508;
    /**
     * Position in bytes of Assignment timestamp from the start of
     * {@code queue.dat}.
     */
    int AITIME_POS = 512;
    /**
     * Position in bytes of Assignment info from the start of {@code queue.dat}.
     */
    int AIDATA_POS = 516;
    /**
     * Position in bytes of Collection server IP address from the start of
     * {@code queue.dat}.
     *
     * @since 5.00
     */
    int CSIP_POS = 520;
    /**
     * Position in bytes of Download started time from the start of
     * {@code queue.dat}.
     *
     * @since 5.00
     */
    int DSTART_POS = 524;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z528_POS = 528;
    /**
     * Position in bytes of Misc4a from the start of {@code queue.dat}.
     */
    int M532_POS = 532;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z536_POS = 536;
    /**
     * Position in bytes of Number of SMP cores from the start of
     * {@code queue.dat}.
     *
     * @since 5.91
     */
    int CORES_POS = 544;
    /**
     * Position in bytes of Tag of Work Unit from the start of
     * {@code queue.dat}.
     *
     * @since 5.00
     */
    int TAG_POS = 548;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z564_POS = 564;
    /**
     * Position in bytes of Passkey from the start of {@code queue.dat}.
     *
     * @since 6.00
     */
    int PASSKEY_POS = 580;
    /**
     * Position in bytes of Flops per CPU (core) from the start of
     * {@code queue.dat}.
     *
     * @since 6.00
     */
    int FLOPS_POS = 612;
    /**
     * Position in bytes of Available memory from the start of
     * {@code queue.dat}.
     *
     * @since 6.00
     */
    int MEMORY_POS = 616;
    /**
     * Position in bytes of Available GPU memory from the start of
     * {@code queue.dat}.
     *
     * @since 6.20
     */
    int GPU_MEMORY_POS = 620;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     */
    int Z624_POS = 624;
    /**
     * Position in bytes of WU expiration time from the start of
     * {@code queue.dat}.
     */
    int DUE_POS = 688;
    /**
     * Position in bytes of Packet size limit from the start of
     * {@code queue.dat}.
     *
     * @since 5.00
     */
    int PLIMIT_POS = 704;
    /**
     * Position in bytes of Number of upload failures from the start of
     * {@code queue.dat}.
     *
     * @since 5.00
     */
    int UPLOADS_POS = 708;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="length-constants">
    /**
     * Length in bytes of the Status in {@code queue.dat}.
     *
     * @see #getStat()
     * @see #STAT_POS
     */
    int STAT_LENGTH = 4;
    /**
     * Length in bytes of the Pad for Windows in {@code queue.dat}.
     *
     * @since 4.01 Pad for others
     * @since 6.01 Number of SMP Cores to use
     * @deprecated Use {@link #CORES_POS}
     */
    int Z004_LENGTH = 4;
    /**
     * Length in bytes of the Time data in {@code queue.dat}.
     *
     * @see #getTdata()
     * @see #TDATA_POS
     */
    int TDATA_LENGTH = 32;
    /**
     * Length in bytes of the Server IP address in {@code queue.dat}.
     *
     * @deprecated As of 3.00 replaced by {@link #SVR2_POS}
     */
    int SVR1_LENGTH = 4;
    /**
     * Length in bytes of the Upload Status in {@code queue.dat}.
     *
     * @see #getUstat()
     * @see #USTAT_POS
     */
    int USTAT_LENGTH = 4;
    /**
     * Length in bytes of the Web address for core downloads in
     * {@code queue.dat}.
     *
     * @see #getUrl()
     * @see #URL_POS
     */
    int URL_LENGTH = 128;
    /**
     * Length in bytes of the Misc1a in {@code queue.dat}.
     *
     * @see #M176_POS
     */
    int M176_LENGTH = 4;
    /**
     * Length in bytes of the Core_xx number (hex) in {@code queue.dat}.
     *
     * @see #getCore()
     * @see #CORE_POS
     */
    int CORE_LENGTH = 4;
    /**
     * Length in bytes of the Misc1b in {@code queue.dat}.
     *
     * @see #M184_POS
     */
    int M184_LENGTH = 4;
    /**
     * Length in bytes of the wudata_xx.dat file size in {@code queue.dat}.
     *
     * @see #getDsiz()
     * @see #DSIZ_POS
     */
    int DSIZ_LENGTH = 4;
    /**
     * Length in bytes of the z192 in {@code queue.dat}.
     *
     * @see #Z192_POS
     */
    int Z192_LENGTH = 16;
    /**
     * Length in bytes of the Work unit ID information in {@code queue.dat}.
     *
     * @see #getWuid()
     * @see #WUID_POS
     */
    int WUID_LENGTH = 16;
    /**
     * Length in bytes of the z224 in {@code queue.dat}.
     *
     * @see #Z224_POS
     */
    int Z224_LENGTH = 36;
    /**
     * Length in bytes of the Machine ID in {@code queue.dat}.
     *
     * @see #getMid()
     * @see #MID_POS
     */
    int MID_LENGTH = 4;
    /**
     * Length in bytes of the Server IP address in {@code queue.dat}.
     *
     * @see #getSvr2()
     * @see #SVR2_POS
     */
    int SVR2_LENGTH = 4;
    /**
     * Length in bytes of the Server port number in {@code queue.dat}.
     *
     * @see #getPort()
     * @see #PORT_POS
     */
    int PORT_LENGTH = 4;
    /**
     * Length in bytes of the Work unit type in {@code queue.dat}.
     *
     * @see #getType()
     * @see #TYPE_POS
     */
    int TYPE_LENGTH = 64;
    /**
     * Length in bytes of the User Name in {@code queue.dat}.
     *
     * @see #getUname()
     * @see #UNAME_POS
     */
    int UNAME_LENGTH = 64;
    /**
     * Length in bytes of the Team Number in {@code queue.dat}.
     *
     * @see #getTeamn()
     * @see #TEAMN_POS
     */
    int TEAMN_LENGTH = 64;
    /**
     * Length in bytes of the Stored ID for unit (UserID + MachineID)
     * in {@code queue.dat}.
     *
     * @see #getUid()
     * @see #UID_POS
     */
    int UID_LENGTH = 8;
    /**
     * Length in bytes of the Benchmark in {@code queue.dat}.
     *
     * @since 3.24
     * @see #getBench()
     * @see #BENCH_POS
     */
    int BENCH_LENGTH = 4;
    /**
     * Length in bytes of Misc3b in {@code queue.dat}.
     *
     * @deprecated 3.24
     */
    int M476_LENGTH = 4;
    /**
     * Length in bytes of the CPU type in {@code queue.dat}.
     *
     * @see #getCpuType()
     * @see #CPU_TYPE_POS
     */
    int CPU_TYPE_LENGTH = 4;
    /**
     * Length in bytes of the OS type in {@code queue.dat}.
     *
     * @see #getOsType()
     * @see #OS_TYPE_POS
     */
    int OS_TYPE_LENGTH = 4;
    /**
     * Length in bytes of the CPU species in {@code queue.dat}.
     *
     * @see #getCpuSpec()
     * @see #CPU_SPEC_POS
     */
    int CPU_SPEC_LENGTH = 4;
    /**
     * Length in bytes of the OS species in {@code queue.dat}.
     *
     * @see #getOsSpec()
     * @see #OS_SPEC_POS
     */
    int OS_SPEC_LENGTH = 4;
    /**
     * Length in bytes of the Allowed time to return (seconds)
     * in {@code queue.dat}.
     *
     * @see #getExpire()
     * @see #EXPIRE_POS
     */
    int EXPIRE_LENGTH = 4;
    /**
     * Length in bytes of the z500 in {@code queue.dat}.
     *
     * @see #Z500_POS
     */
    int Z500_LENGTH = 4;
    /**
     * Length in bytes of the Client type required in {@code queue.dat}.
     *
     * @see #getCltype()
     * @see #CLTYPE_POS
     */
    int CLTYPE_LENGTH = 4;
    /**
     * Length in bytes of the Assignment info present flag in {@code queue.dat}.
     *
     * @see #getAiflag()
     * @see #AIFLAG_POS
     */
    int AIFLAG_LENGTH = 4;
    /**
     * Length in bytes of the Assignment timestamp in {@code queue.dat}.
     *
     * @see #getAitime()
     * @see #AITIME_POS
     */
    int AITIME_LENGTH = 4;
    /**
     * Length in bytes of the Assignment info in {@code queue.dat}.
     *
     * @see #getAidata()
     * @see #AIDATA_POS
     */
    int AIDATA_LENGTH = 4;
    /**
     * Length in bytes of the Collection server IP address in {@code queue.dat}.
     *
     * @since 5.00
     * @see #getCsip()
     * @see #CSIP_POS
     */
    int CSIP_LENGTH = 4;
    /**
     * Length in bytes of the Download started time in {@code queue.dat}.
     *
     * @since 5.00
     * @see #getDstart()
     * @see #DSTART_POS
     */
    int DSTART_LENGTH = 4;
    /**
     * Length in bytes of the z528 in {@code queue.dat}.
     *
     * @see #Z528_POS
     */
    int Z528_LENGTH = 4;
    /**
     * Length in bytes of the Misc4a in {@code queue.dat}.
     *
     * @see #M532_POS
     */
    int M532_LENGTH = 4;
    /**
     * Length in bytes of the z536 in {@code queue.dat}.
     *
     * @see #Z536_POS
     */
    int Z536_LENGTH = 8;
    /**
     * Length in bytes of the Number of SMP cores in {@code queue.dat}.
     *
     * @since 5.91
     * @see #getCores()
     * @see #CORES_POS
     */
    int CORES_LENGTH = 4;
    /**
     * Length in bytes of the Tag of Work Unit in {@code queue.dat}.
     *
     * @since 5.00
     * @see #getCores()
     * @see #CORES_POS
     */
    int TAG_LENGTH = 16;
    /**
     * Length in bytes of the z564 in {@code queue.dat}.
     *
     * @see #Z564_POS
     */
    int Z564_LENGTH = 16;
    /**
     * Length in bytes of the Passkey in {@code queue.dat}.
     *
     * @since 6.00
     * @see #getPasskey()
     * @see #PASSKEY_POS
     */
    int PASSKEY_LENGTH = 32;
    /**
     * Length in bytes of the Flops per CPU (core) in {@code queue.dat}.
     *
     * @since 6.00
     * @see #getFlops()
     * @see #FLOPS_POS
     */
    int FLOPS_LENGTH = 4;
    /**
     * Length in bytes of the Available memory in {@code queue.dat}.
     *
     * @since 6.00
     * @see #getMemory()
     * @see #MEMORY_POS
     */
    int MEMORY_LENGTH = 4;
    /**
     * Length in bytes of the Available GPU memory in {@code queue.dat}.
     *
     * @since 6.20
     * @see #getGpuMemory()
     * @see #GPU_MEMORY_POS
     */
    int GPU_MEMORY_LENGTH = 4;
    /**
     * Length in bytes of the z624 in {@code queue.dat}.
     *
     * @see #Z624_POS
     */
    int Z624_LENGTH = 64;
    /**
     * Length in bytes of the WU expiration time in {@code queue.dat}.
     *
     * @see #getDue()
     * @see #DUE_POS
     */
    int DUE_LENGTH = 16;
    /**
     * Length in bytes of the Packet size limit in {@code queue.dat}.
     *
     * @since 5.00
     * @see #getPlimit()
     * @see #PLIMIT_POS
     */
    int PLIMIT_LENGTH = 4;
    /**
     * Length in bytes of the Number of upload failures in {@code queue.dat}.
     *
     * @since 5.00
     * @see #getUploads()
     * @see #UPLOADS_POS
     */
    int UPLOADS_LENGTH = 4;
    // </editor-fold>
    // <editor-fold desc="Accessors">
    /**
     * Get the value of Status.
     *
     * @return the value of stat
     */
    int getStat();
    /**
     * Get the value of Time data.
     *
     * @return the value of tdata
     */
    Date getTdata();
    /**
     * Get the value of Server IP address.
     *
     * @return the value of svr1
     */
    InetAddress getSvr1();
    /**
     * Get the value of Upload status.
     *
     * @return the value of ustat
     */
    int getUstat();
    /**
     * Get the value of Web address for core download.
     *
     * @return the value of url
     */
    URL getUrl();
    /**
     * Get the value of Core_xx number (hex).
     *
     * @return the value of core
     */
    Core getCore();
    /**
     * Get the value of wudata_xx.dat file size.
     *
     * @return the value of dsiz
     */
    int getDsiz();
    /**
     * Get the value of Work unit ID information.
     *
     * @return the value of wuid
     */
    WorkUnitImpl getWuid();
    /**
     * Get the value of Machine ID.
     *
     * @return the value of mid
     */
    int getMid();
    /**
     * Get the value of Server IP address.
     *
     * @return the value of svr2
     */
    InetAddress getSvr2();
    /**
     * Get the value of Server port number.
     *
     * @return the value of port
     */
    int getPort();
    /**
     * Get the value of Work unit type.
     *
     * @return the value of type
     */
    String getType();
    /**
     * Get the value of User Name.
     *
     * @return the value of uname
     */
    String getUname();
    /**
     * Get the value of Team Number.
     *
     * @return the value of teamn
     */
    int getTeamn();
    /**
     * Get the value of Stored ID for unit (UserID + MachineID).
     *
     * @return the value of uid
     */
    long getUid();
    /**
     * Get the value of Benchmark.
     *
     * @since 3.24
     * @return the value of bench
     */
    int getBench();
    /**
     * Get the value of CPU type.
     *
     * @since 3.00
     * @return the value of cpu_type
     */
    String getCpuType();
    /**
     * Get the value of OS type.
     *
     * @since 3.00
     * @return the value of os_type
     */
    String getOsType();
    /**
     * Get the value of CPU species.
     *
     * @return the value of cpu_spec
     */
    String getCpuSpec();
    /**
     * Get the value of OS species.
     *
     * @return the value of os_spec
     */
    String getOsSpec();
    /**
     * Get the value of Allowed time to return (seconds).
     *
     * @return the value of expire
     */
    Date getExpire();
    /**
     * Get the value of Client type required (usually 0).
     *
     * @return the value of cltype
     */
    int getCltype();
    /**
     * Get the value of Assignment info present flag.
     *
     * @return the value of aiflag
     */
    boolean getAiflag();
    /**
     * Get the value of Assignment timestamp.
     *
     * @return the value of aitime
     */
    Date getAitime();
    /**
     * Get the value of Assignment info.
     *
     * @return the value of aidata
     */
    long getAidata();
    /**
     * Get the value of Collection server IP address.
     *
     * @return the value of csip
     */
    InetAddress getCsip();
    /**
     * Get the value of Download started time.
     *
     * @since 5.00
     * @return the value of dstart
     */
    Date getDstart();
    /**
     * Get the value of Number of SMP cores.
     *
     * @since 5.91
     * @return the value of cores
     */
    int getCores();
    /**
     * Get the value of Tag of Work Unit.
     *
     * @since 5.00
     * @return the value of tag
     */
    String getTag();
    /**
     * Get the value of Passkey.
     *
     * @since 6.00
     * @return the value of passkey
     */
    String getPasskey();
    /**
     * Get the value of Flops per CPU (core).
     *
     * @since 6.00
     * @return the value of flops
     */
    int getFlops();
    /**
     * Get the value of Available memory.
     *
     * @since 6.00
     * @return the value of memory
     */
    int getMemory();
    /**
     * Get the value of Available GPU memory.
     *
     * @since 6.20
     * @return the value of gpu_memory
     */
    int getGpuMemory();
    /**
     * Get the value of WU expiration time.
     *
     * @return the value of due
     */
    Date getDue();
    /**
     * Get the value of Packet size limit.
     *
     * @since 5.00
     * @return the value of plimit
     */
    int getPlimit();
    /**
     * Get the value of Number of upload failures.
     *
     * @since 5.00
     * @return the value of uploads
     */
    int getUploads();
    // </editor-fold>

    /**
     * Update all values.
     */
    void update();
}
