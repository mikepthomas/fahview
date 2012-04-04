/*
 * Copyright (C) 2011 Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 *
 * This file is part of FAHView.
 *
 * FAHView is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FAHView is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with FAHView.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fahview.model;

import com.fahview.controller.QueueReader;
import java.util.Date;

/**
 * Class to represent data stored about a Folding@Home core.
 * 
 * @author <a href="mailto:michael4.thomas@live.uwe.ac.uk">Michael Thomas</a>
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
     * @param indexNumber
     * @param reader
     * @throws InstantiationException 
     */
    public Core(int indexNumber, QueueReader reader) throws InstantiationException {
        this.indexNumber = indexNumber;
        switch (indexNumber) {
            case 0:
                position = Queue.QUEUE_INDEX_0_POS + QueueIndex.CORE_POS;
                break;
            case 1:
                position = Queue.QUEUE_INDEX_1_POS + QueueIndex.CORE_POS;
                break;
            case 2:
                position = Queue.QUEUE_INDEX_2_POS + QueueIndex.CORE_POS;
                break;
            case 3:
                position = Queue.QUEUE_INDEX_3_POS + QueueIndex.CORE_POS;
                break;
            case 4:
                position = Queue.QUEUE_INDEX_4_POS + QueueIndex.CORE_POS;
                break;
            case 5:
                position = Queue.QUEUE_INDEX_5_POS + QueueIndex.CORE_POS;
                break;
            case 6:
                position = Queue.QUEUE_INDEX_6_POS + QueueIndex.CORE_POS;
                break;
            case 7:
                position = Queue.QUEUE_INDEX_7_POS + QueueIndex.CORE_POS;
                break;
            case 8:
                position = Queue.QUEUE_INDEX_8_POS + QueueIndex.CORE_POS;
                break;
            case 9:
                position = Queue.QUEUE_INDEX_9_POS + QueueIndex.CORE_POS;
                break;
            default:
                throw new InstantiationException("Queue index should be 0-9.");
        }
        this.reader = reader;
        update();
    }

    public String getCoreNo() {
        return Integer.toHexString(coreNo).toUpperCase();
    }
    
    public String getProject() {
        return project;
    }
    
    protected void setCoreNo() {
        coreNo = (int) reader.readLEUInt(position, QueueIndex.CORE_LENGTH);
    }
    
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
    
    
    
    protected void setFileName(String line) {
        fileName = trimAttribute(line);
    }

    public String getFileName() {
        return fileName;
    }

    private String trimAttribute(String line) {
        return line = line.substring(line.lastIndexOf(":") + 2);
    }

    
    
    
    
    public final void update() {
        setCoreNo();
        setProject();
    }
    
    @Override
    public String toString() {
        String result = "";
        result += "queue.index[" + indexNumber + "].core.coreNo\t" + getCoreNo();
        result += "\nqueue.index[" + indexNumber + "].core.project\t" + getProject();
        return result;
    }
}
