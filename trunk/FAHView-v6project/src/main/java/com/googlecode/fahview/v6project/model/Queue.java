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

/**
 * Interface to represent data stored about a Folding@home queue.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version 6.00
 */
public interface Queue {
    // <editor-fold defaultstate="collapsed" desc="position-constants">
    /**
     * Position in bytes of the Queue (client) version from the start of
     * {@code queue.dat}.
     *
     * @since 2.17
     * @see #getVersion()
     * @see #VERSION_LENGTH
     */
    int VERSION_POS = 0;
    /**
     * Position in bytes of the Current index number from the start of
     * {@code queue.dat}.
     *
     * @see #getCurrent()
     * @see #CURRENT_LENGTH
     */
    int CURRENT_POS = 4;
    /**
     * Position in bytes of Queue Index 0 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_0_POS = 8;
    /**
     * Position in bytes of Queue Index 1 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_1_POS = 720;
    /**
     * Position in bytes of Queue Index 2 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_2_POS = 1432;
    /**
     * Position in bytes of Queue Index 3 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_3_POS = 2144;
    /**
     * Position in bytes of Queue Index 4 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_4_POS = 2856;
    /**
     * Position in bytes of Queue Index 5 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_5_POS = 3568;
    /**
     * Position in bytes of Queue Index 6 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_6_POS = 4280;
    /**
     * Position in bytes of Queue Index 7 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_7_POS = 4992;
    /**
     * Position in bytes of Queue Index 8 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_8_POS = 5704;
    /**
     * Position in bytes of Queue Index 9 from the start of
     * {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_LENGTH
     */
    int QUEUE_INDEX_9_POS = 6416;
    /**
     * Position in bytes of the Performance Fraction from the start of
     * {@code queue.dat}.
     *
     * @since 3.24
     * @see #getPfract()
     * @see #PFRACT_LENGTH
     */
    int PFRACT_POS = 7128;
    /**
     * Position in bytes of the Performance fraction unit weight from the start
     * of {@code queue.dat}.
     *
     * @since 3.24
     * @see #getPunits()
     * @see #PUNITS_LENGTH
     */
    int PUNITS_POS = 7132;
    /**
     * Position in bytes of the Download rate sliding average from the start of
     * {@code queue.dat}.
     *
     * @since 4.00
     * @see #getDrate()
     * @see #DRATE_LENGTH
     */
    int DRATE_POS = 7136;
    /**
     * Position in bytes of the Download rate unit weight from the start of
     * {@code queue.dat}.
     *
     * @since 4.00
     * @see #getDunits()
     * @see #DUNITS_LENGTH
     */
    int DUNITS_POS = 7140;
    /**
     * Position in bytes of the Upload rate sliding average from the start of
     * {@code queue.dat}.
     *
     * @since 4.00
     * @see #getUrate()
     * @see #URATE_LENGTH
     */
    int URATE_POS = 7144;
    /**
     * Position in bytes of the Upload rate unit weight from the start of
     * {@code queue.dat}.
     *
     * @since 4.00
     * @see #getUunits()
     * @see #UUNITS_LENGTH
     */
    int UUNITS_POS = 7148;
    /**
     * Position in bytes of the Results successfully sent after upload failures
     * from the start of {@code queue.dat}.
     *
     * @since 5.00
     * @see #getSent()
     * @see #SENT_LENGTH
     */
    int SENT_POS = 7152;
    /**
     * Position in bytes of padding from the start of {@code queue.dat}
     * (All Zeros).
     *
     * @since 5.00
     * @see #Z7156_LENGTH
     */
    int Z7156_POS = 7156;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="length-constants">
    /**
     * Length in bytes of the Queue (client) version in {@code queue.dat}.
     *
     * @since 2.17
     * @see #getVersion()
     * @see #VERSION_POS
     */
    int VERSION_LENGTH = 4;
    /**
     * Length in bytes of the Current index number in {@code queue.dat}.
     *
     * @see #getCurrent()
     * @see #CURRENT_POS
     */
    int CURRENT_LENGTH = 4;
    /**
     * Length in bytes of a Queue Index in {@code queue.dat}.
     *
     * @see #getQueueIndex(int)
     * @see #QUEUE_INDEX_0_POS
     * @see #QUEUE_INDEX_1_POS
     * @see #QUEUE_INDEX_2_POS
     * @see #QUEUE_INDEX_3_POS
     * @see #QUEUE_INDEX_4_POS
     * @see #QUEUE_INDEX_5_POS
     * @see #QUEUE_INDEX_6_POS
     * @see #QUEUE_INDEX_7_POS
     * @see #QUEUE_INDEX_8_POS
     * @see #QUEUE_INDEX_9_POS
     *
     */
    int QUEUE_INDEX_LENGTH = 712;
    /**
     * Length in bytes of the Performance fraction in {@code queue.dat}.
     *
     * @since 3.24
     * @see #getPfract()
     * @see #PFRACT_POS
     */
    int PFRACT_LENGTH = 4;
    /**
     * Length in bytes of the Performance fraction unit weight in
     * {@code queue.dat}.
     *
     * @since 3.24
     * @see #getPunits()
     * @see #PUNITS_POS
     */
    int PUNITS_LENGTH = 4;
    /**
     * Length in bytes of the Download rate sliding average in
     * {@code queue.dat}.
     *
     * @since 4.00
     * @see #getDrate()
     * @see #DRATE_POS
     */
    int DRATE_LENGTH = 4;
    /**
     * Length in bytes of the Download rate unit weight in {@code queue.dat}.
     *
     * @since 4.00
     * @see #getDunits()
     * @see #DUNITS_POS
     */
    int DUNITS_LENGTH = 4;
    /**
     * Length in bytes of the Upload rate sliding average in {@code queue.dat}.
     *
     * @since 4.00
     * @see #getUrate()
     * @see #URATE_POS
     */
    int URATE_LENGTH = 4;
    /**
     * Length in bytes of the Upload rate unit weight in {@code queue.dat}.
     *
     * @since 4.00
     * @see #getUunits()
     * @see #UUNITS_POS
     */
    int UUNITS_LENGTH = 4;
    /**
     * Length in bytes of the Results successfully sent after upload failures in
     * {@code queue.dat}.
     *
     * @since 5.00
     * @see #getSent()
     * @see #SENT_POS
     */
    int SENT_LENGTH = 4;
    /**
     * Length in bytes of padding in {@code queue.dat} (All Zeros).
     *
     * @since 5.00
     * @see #Z7156_POS
     */
    int Z7156_LENGTH = 12;
    // </editor-fold>
    // <editor-fold desc="accessors">
    /**
     * Get the value of Queue (client) version.
     *
     * @return the value of version
     */
    int getVersion();
    /**
     * Get the value of Current index number.
     *
     * @return the value of current
     */
    int getCurrent();
    /**
     * Get the value of queueIndex at specified index.
     *
     * @param index the index required
     * @return the value of queueIndex at specified index
     */
    QueueIndexImpl getQueueIndex(int index);
    /**
     * Get the value of Performance fraction.
     *
     * @return the value of pfract
     */
    int getPfract();
    /**
     * Get the value of Performance fraction unit weight.
     *
     * @return the value of punits
     */
    int getPunits();
    /**
     * Get the value of Download rate sliding average.
     *
     * @return the value of drate
     */
    int getDrate();
    /**
     * Get the value of Download rate unit weight.
     *
     * @return the value of dunits
     */
    int getDunits();
    /**
     * Get the value of Upload rate sliding average.
     *
     * @return the value of urate
     */
    int getUrate();
    /**
     * Get the value of Upload rate unit weight.
     *
     * @return the value of uunits
     */
    int getUunits();
    /**
     * Get the value of Results Sent.
     *
     * @return the value of sent
     */
    int getSent();
    // </editor-fold>

    /**
     * Update all values.
     */
    void update();
}
