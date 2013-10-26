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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to represent data stored about a Folding@home queue.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version 6.00
 */
public class QueueImpl implements Queue {

    private int version; // QueueImpl (client) version (as of v2.17)
    private int current; // Current index number
    private QueueIndexImpl[] index; // QueueImpl Indices
    private int pfract; // Performance fraction (as of v3.24)
    private int punits; // Performance fraction unit weight (as of v3.24)
    private int drate; // Download rate sliding average (as of v4.00)
    private int dunits; // Download rate unit weight (as of v4.00)
    private int urate; // Upload rate sliding average (as of v4.00)
    private int uunits; // Upload rate unit weight (as of v4.00)
    private int sent; // Results successfully sent (after upload failures) (as of v5.00)
    private byte[] z7156; // All zeros after queue conversion (as of v5.00)
    
    private QueueReader reader;

    /**
     * Constructor to initialize variables
     *
     * @param reader QueueReader for {@code queue.dat}
     */
    public QueueImpl(QueueReader reader) {
        this.reader = reader;
        update();
    }

    /** {@inheritDoc} */
    @Override
    public int getVersion() {
        return version;
    }

    /** {@inheritDoc} */
    @Override
    public int getCurrent() {
        return current;
    }

    /** {@inheritDoc} */
    @Override
    public QueueIndexImpl getQueueIndex(int index) {
        return this.index[index];
    }

    /** {@inheritDoc} */
    @Override
    public int getPfract() {
        return pfract;
    }

    /** {@inheritDoc} */
    @Override
    public int getPunits() {
        return punits;
    }

    /** {@inheritDoc} */
    @Override
    public int getDrate() {
        return drate;
    }

    /** {@inheritDoc} */
    @Override
    public int getDunits() {
        return dunits;
    }

    /** {@inheritDoc} */
    @Override
    public int getUrate() {
        return urate;
    }

    /** {@inheritDoc} */
    @Override
    public int getUunits() {
        return uunits;
    }

    /** {@inheritDoc} */
    @Override
    public int getSent() {
        return sent;
    }

    /**
     * Set the value of QueueImpl (client) version
     */
    protected void setVersion() {
        version = (int) reader.readLEUInt(VERSION_POS, VERSION_LENGTH);
    }

    /**
     * Set the value of Current index number
     */
    protected void setCurrent() {
        current = (int) reader.readLEUInt(CURRENT_POS, CURRENT_LENGTH);
    }
    
    /**
     * Set the QueueImpl Indices
     */
    protected void setIndex() {
        try {
            index = new QueueIndexImpl[10];
            index[0] = new QueueIndexImpl(0, reader);
            index[1] = new QueueIndexImpl(1, reader);
            index[2] = new QueueIndexImpl(2, reader);
            index[3] = new QueueIndexImpl(3, reader);
            index[4] = new QueueIndexImpl(4, reader);
            index[5] = new QueueIndexImpl(5, reader);
            index[6] = new QueueIndexImpl(6, reader);
            index[7] = new QueueIndexImpl(7, reader);
            index[8] = new QueueIndexImpl(8, reader);
            index[9] = new QueueIndexImpl(9, reader);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(QueueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Set the value of Performance fraction
     */
    protected void setPfract() {
        pfract = (int) reader.readLEUInt(PFRACT_POS, PFRACT_LENGTH);
    }

    /**
     * Set the value of Performance fraction unit weight
     */
    protected void setPunits() {
        punits = (int) reader.readLEUInt(PUNITS_POS, PUNITS_LENGTH);
    }

    /**
     * Set the value of Download rate sliding average
     */
    protected void setDrate() {
        drate = (int) reader.readLEUInt(DRATE_POS, DRATE_LENGTH);
    }

    /**
     * Set the value of Download rate unit weight
     */
    protected void setDunits() {
        dunits = (int) reader.readLEUInt(DUNITS_POS, DUNITS_LENGTH);
    }

    /**
     * Set the value of Upload rate sliding average
     */
    protected void setUrate() {
        urate = (int) reader.readLEUInt(URATE_POS, URATE_LENGTH);
    }

    /**
     * Set the value of Upload rate unit weight
     */
    protected void setUunits() {
        uunits = (int) reader.readLEUInt(UUNITS_POS, UUNITS_LENGTH);
    }

    /**
     * Set the value of Results Sent
     */
    protected void setSent() {
        sent = (int) reader.readLEUInt(SENT_POS, SENT_LENGTH);
    }

    /**
     * Set the value of z7156
     */
    protected void setZ7156() {
        z7156 = reader.read(Z7156_POS, Z7156_LENGTH);
        boolean notZero = false;
        for (int i = 0; i < z7156.length; i++) {
            if (z7156[i] != 0) {
                notZero = true;
            }
        }
        if (notZero) {
            System.err.println("WARNING: Z7156 is not all zero");
        }
    }
    
    /**
     * {@inheritDoc}
     *
     * Generate a String representation of the QueueImpl
     */
    @Override
    public String toString() {
        String result = "";
        result += "queue.version\t" + getVersion();
        result += "\nqueue.current\t" + getCurrent();
        result += "\n" + getQueueIndex(0);
        result += "\n" + getQueueIndex(1);
        result += "\n" + getQueueIndex(2);
        result += "\n" + getQueueIndex(3);
        result += "\n" + getQueueIndex(4);
        result += "\n" + getQueueIndex(5);
        result += "\n" + getQueueIndex(6);
        result += "\n" + getQueueIndex(7);
        result += "\n" + getQueueIndex(8);
        result += "\n" + getQueueIndex(9);
        result += "\nqueue.pfract\t" + getPfract();
        result += "\nqueue.punits\t" + getPunits();
        result += "\nqueue.drate\t" + getDrate();
        result += "\nqueue.dunits\t" + getDunits();
        result += "\nqueue.urate\t" + getUrate();
        result += "\nqueue.uunits\t" + getUunits();
        result += "\nqueue.sent\t" + getSent();
        return result;
    }
    
    /** {@inheritDoc} */
    @Override
    public final void update() {
        setVersion();
        setCurrent();
        setIndex();
        setPfract();
        setPunits();
        setDrate();
        setDunits();
        setUrate();
        setUunits();
        setSent();
        setZ7156();
    }
}
