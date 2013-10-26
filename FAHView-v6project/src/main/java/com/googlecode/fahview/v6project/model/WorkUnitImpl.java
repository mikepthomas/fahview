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
 * Class to represent data stored about a Folding@home work unit.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version 6.00
 */
public class WorkUnitImpl implements WorkUnit {
    private int proj; // 0 Project number (LE)
    private int run; // 2 Run (LE)
    private int clone; // 4 Clone (LE)
    private int gen; // 6 Generation (LE)
    private Date issue; // 8 WU issue time (LE)

    private String protein, percentage;
    private int completed, steps;
    
    private int indexNumber, position;
    private QueueReader reader;

    /**
     * Work Unit constructor. Sets the initial values.
     *
     * @param indexNumber a int.
     * @param reader a {@link com.googlecode.fahview.v6project.utilities.QueueReader} object.
     * @throws java.lang.InstantiationException if any.
     */
    public WorkUnitImpl(int indexNumber, QueueReader reader) throws InstantiationException {
        percentage = "0%";
        this.indexNumber = indexNumber;
        switch (indexNumber) {
            case 0:
                position = QueueImpl.QUEUE_INDEX_0_POS + QueueIndexImpl.WUID_POS;
                break;
            case 1:
                position = QueueImpl.QUEUE_INDEX_1_POS + QueueIndexImpl.WUID_POS;
                break;
            case 2:
                position = QueueImpl.QUEUE_INDEX_2_POS + QueueIndexImpl.WUID_POS;
                break;
            case 3:
                position = QueueImpl.QUEUE_INDEX_3_POS + QueueIndexImpl.WUID_POS;
                break;
            case 4:
                position = QueueImpl.QUEUE_INDEX_4_POS + QueueIndexImpl.WUID_POS;
                break;
            case 5:
                position = QueueImpl.QUEUE_INDEX_5_POS + QueueIndexImpl.WUID_POS;
                break;
            case 6:
                position = QueueImpl.QUEUE_INDEX_6_POS + QueueIndexImpl.WUID_POS;
                break;
            case 7:
                position = QueueImpl.QUEUE_INDEX_7_POS + QueueIndexImpl.WUID_POS;
                break;
            case 8:
                position = QueueImpl.QUEUE_INDEX_8_POS + QueueIndexImpl.WUID_POS;
                break;
            case 9:
                position = QueueImpl.QUEUE_INDEX_9_POS + QueueIndexImpl.WUID_POS;
                break;
            default:
                throw new InstantiationException("Queue index should be 0-9.");
        }
        this.reader = reader;
        update();
    }

    /** {@inheritDoc} */
    @Override
    public int getProj() {
        return proj;
    }
    
    /** {@inheritDoc} */
    @Override
    public int getRun() {
        return run;
    }
    
    /** {@inheritDoc} */
    @Override
    public int getClone() {
        return clone;
    }
    
    /** {@inheritDoc} */
    @Override
    public int getGen() {
        return gen;
    }
    
    /** {@inheritDoc} */
    @Override
    public Date getIssue() {
        return issue;
    }

    /**
     * Set the value of Project Number
     */
    protected void setProj() {
        proj = reader.readLEUShort(PROJ_POS + position, PROJ_LENGTH);
    }

    /**
     * Set the value of Run
     */
    protected void setRun() {
        run = reader.readLEUShort(RUN_POS + position, RUN_LENGTH);
    }

    /**
     * Set the value of Clone
     */
    protected void setClone() {
        clone = reader.readLEUShort(CLONE_POS + position, CLONE_LENGTH);
    }

    /**
     * Set the value of Generation
     */
    protected void setGen() {
        gen = reader.readLEUShort(GEN_POS + position, GEN_LENGTH);
    }

    /**
     * Set the value of Issued
     */
    protected void setIssue() {
        long epoch = reader.readLEUInt(ISSUE_POS + position, ISSUE_LENGTH);
        issue = new Date(epoch * 1000);
    }

    /**
     * Set the number of steps completed
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setCompleted(String line) {
        String[] values = line.split(" ");
        completed = Integer.parseInt(values[2]);
        steps = Integer.parseInt(values[5]);
        percentage = values[8].substring(1, values[8].length() - 1);
    }

    /**
     * <p>Getter for the field <code>completed</code>.</p>
     *
     * @return a int.
     */
    public int getCompleted() {
        return completed;
    }

    /**
     * <p>Getter for the field <code>percentage</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPercentage() {
        return percentage;
    }

    /**
     * <p>Getter for the field <code>protein</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getProtein() {
        return protein;
    }

    /**
     * <p>Getter for the field <code>steps</code>.</p>
     *
     * @return a int.
     */
    public int getSteps() {
        return steps;
    }
    
    /**
     * {@inheritDoc}
     *
     * Generate a String representation of the WorkUnitImpl
     */
    @Override
    public String toString() {
        String result = "";
        result += "queue.index[" + indexNumber + "].wuid.proj\t" + getProj();
        result += "\nqueue.index[" + indexNumber + "].wuid.run\t" + getRun();
        result += "\nqueue.index[" + indexNumber + "].wuid.clone\t" + getClone();
        result += "\nqueue.index[" + indexNumber + "].wuid.gen\t" + getGen();
        result += "\nqueue.index[" + indexNumber + "].wuid.issue\t" + getIssue();
        return result;
    }
    
    /** {@inheritDoc} */
    @Override
    public final void update() {
        setProj();
        setRun();
        setClone();
        setGen();
        setIssue();
    }
}
