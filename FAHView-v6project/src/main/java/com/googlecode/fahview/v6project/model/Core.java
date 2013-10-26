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

/**
 * Class to represent data stored about a Folding@home core.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class Core {
    
    private int indexNumber, position;
    private int coreNo;
    private String project;
    private QueueReader reader;
    
    private String fileName, type, version;
    private Date date;

    /**
     * Core constructor. sets the initial values
     *
     * @param indexNumber a int.
     * @param reader a {@link com.googlecode.fahview.v6project.utilities.QueueReader} object.
     * @throws java.lang.InstantiationException if any.
     */
    public Core(int indexNumber, QueueReader reader) throws InstantiationException {
        this.indexNumber = indexNumber;
        switch (indexNumber) {
            case 0:
                position = QueueImpl.QUEUE_INDEX_0_POS + QueueIndexImpl.CORE_POS;
                break;
            case 1:
                position = QueueImpl.QUEUE_INDEX_1_POS + QueueIndexImpl.CORE_POS;
                break;
            case 2:
                position = QueueImpl.QUEUE_INDEX_2_POS + QueueIndexImpl.CORE_POS;
                break;
            case 3:
                position = QueueImpl.QUEUE_INDEX_3_POS + QueueIndexImpl.CORE_POS;
                break;
            case 4:
                position = QueueImpl.QUEUE_INDEX_4_POS + QueueIndexImpl.CORE_POS;
                break;
            case 5:
                position = QueueImpl.QUEUE_INDEX_5_POS + QueueIndexImpl.CORE_POS;
                break;
            case 6:
                position = QueueImpl.QUEUE_INDEX_6_POS + QueueIndexImpl.CORE_POS;
                break;
            case 7:
                position = QueueImpl.QUEUE_INDEX_7_POS + QueueIndexImpl.CORE_POS;
                break;
            case 8:
                position = QueueImpl.QUEUE_INDEX_8_POS + QueueIndexImpl.CORE_POS;
                break;
            case 9:
                position = QueueImpl.QUEUE_INDEX_9_POS + QueueIndexImpl.CORE_POS;
                break;
            default:
                throw new InstantiationException("Queue index should be 0-9.");
        }
        this.reader = reader;
        update();
    }

    /**
     * <p>Getter for the field <code>coreNo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCoreNo() {
        return Integer.toHexString(coreNo).toUpperCase();
    }
    
    /**
     * <p>Getter for the field <code>project</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getProject() {
        return project;
    }
    
    /**
     * <p>Setter for the field <code>coreNo</code>.</p>
     */
    protected void setCoreNo() {
        coreNo = (int) reader.readLEUInt(position, QueueIndexImpl.CORE_LENGTH);
    }
    
    /**
     * <p>Setter for the field <code>project</code>.</p>
     */
    protected void setProject() {
        switch(coreNo) {
            case 0x10:  // GPU
                project = "GROGPU";
                break;
            case 0x11:  // GPU2 (ATI CAL / NVIDIA CUDA)
                project = "GROGPU2";
                break;
            case 0x12:  // GPU2 (ATI Development)
                project = "ATI-DEV";
                break;
            case 0x13:  // GPU2 (NVIDIA Development)
                project = "NVIDIA-DEV";
                break;
            case 0x14:  // GPU2 (NVIDIA Development)
                project = "GROGPU2-MT";
                break;
            case 0x15:  // GPU3 (OpenMM)
                project = "OPENMMGPU";
                break;
            case 0x16:  // GPU3 (OpenMM/OpenCL)
                project = "OPENMM_OPENCL";
                break;
            case 0x20:  // SHARPEN
                project = "SHARPEN";
                break;
            case 0x65:  // Tinker
                project = "TINKER";
                break;
            case 0x78:  // Gromacs
                project = "GROMACS";
                break;
            case 0x79:  // Double-precision Gromacs
                project = "DGROMACS";
                break;
            case 0x7a:  // GB Gromacs (Generalized Born implicit solvent)
                project = "GBGROMACS";
                break;
            case 0x7b:  // Double-precision Gromacs B
                project = "DGROMACSB";
                break;
            case 0x7c:  // Double-precision Gromacs C
                project = "DGROMACSC";
                break;
            case 0x80:  // Gromacs SREM
                project = "GROST";
                break;
            case 0x81:  // Gromacs Simulated Tempering
                project = "GROSIMT";
                break;
            case 0x82:  // Amber
                project = "AMBER";
                break;
            case 0x96:  // QMD
                project = "QMD";
                break;
            case 0xa0:  // Gromacs 3.3
                project = "GROMACS33";
                break;
            case 0xa1:  // Gromacs SMP (V1.71)
                project = "GRO-SMP";
                break;
            case 0xa2:  // Gromacs CVS / Gromacs SMP (V1.90)
                project = "GROCVS";
                break;
            case 0xa3:  // Gromacs SMP2 / Gromacs SMP (V2.13)
                project = "GRO-A3";
                break;
            case 0xa4:  // Gromacs GB (V2.06)
                project = "GRO-A4";
                break;
            case 0xa5:  // Gromacs SMP (V2.27)
                project = "GRO-A5";
                break;
            case 0xa6:  // Gromacs SMP (V2.28)
                project = "GRO-A6";
                break;
            case 0xb4:  // ProtoMol
                project = "ProtoMol";
                break;
            default:
                project = "Unknown";
                break;
        }
    }

    /**
     * <p>Setter for the field <code>fileName</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setFileName(String line) {
        fileName = trimAttribute(line);
    }

    /**
     * <p>Getter for the field <code>fileName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * <p>trimAttribute.</p>
     *
     * @param line a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    private String trimAttribute(String line) {
        return line = line.substring(line.lastIndexOf(":") + 2);
    }

    /**
     * <p>update.</p>
     */
    public final void update() {
        setCoreNo();
        setProject();
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString() {
        String result = "";
        result += "queue.index[" + indexNumber + "].core.coreNo\t" + getCoreNo();
        result += "\nqueue.index[" + indexNumber + "].core.project\t" + getProject();
        return result;
    }
}
