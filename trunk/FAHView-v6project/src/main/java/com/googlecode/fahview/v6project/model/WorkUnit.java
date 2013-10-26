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

import java.util.Date;

/**
 * Interface to represent data stored about a Folding@home work unit.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version 6.00
 */
public interface WorkUnit {
    // <editor-fold defaultstate="collapsed" desc="position-constants">
    /**
     * Position in bytes of the Project Number from the start of
     * {@code queue.dat}.
     *
     * @see #getProj()
     * @see #PROJ_LENGTH
     */
    int PROJ_POS = 0;
    /**
     * Position in bytes of the Run Number from the start of
     * {@code queue.dat}.
     *
     * @see #getRun()
     * @see #RUN_LENGTH
     */
    int RUN_POS = 2;
    /**
     * Position in bytes of the Clone Number from the start of
     * {@code queue.dat}.
     *
     * @see #getClone()
     * @see #CLONE_LENGTH
     */
    int CLONE_POS = 4;
    /**
     * Position in bytes of the Generation Number from the start of
     * {@code queue.dat}.
     *
     * @see #getGen()
     * @see #GEN_LENGTH
     */
    int GEN_POS = 6;
    /**
     * Position in bytes of the Issued date from the start of
     * {@code queue.dat}.
     *
     * @see #getIssue()
     * @see #ISSUE_LENGTH
     */
    int ISSUE_POS = 8;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="length-constants">
    /**
     * Length in bytes of the Project Number in {@code queue.dat}.
     *
     * @see #getProj()
     * @see #PROJ_POS
     */
    int PROJ_LENGTH = 2;
    /**
     * Length in bytes of the Run Number in {@code queue.dat}.
     *
     * @see #getRun()
     * @see #RUN_POS
     */
    int RUN_LENGTH = 2;
    /**
     * Length in bytes of the Clone Number in {@code queue.dat}.
     *
     * @see #getClone()
     * @see #CLONE_POS
     */
    int CLONE_LENGTH = 2;
    /**
     * Length in bytes of the Generation Number in {@code queue.dat}.
     *
     * @see #getGen()
     * @see #GEN_POS
     */
    int GEN_LENGTH = 2;
    /**
     * Length in bytes of the Issued date in {@code queue.dat}.
     *
     * @see #getIssue()
     * @see #ISSUE_POS
     */
    int ISSUE_LENGTH = 8;
    // </editor-fold>
    // <editor-fold desc="accessors">
    /**
     * Get the value of the Project Number.
     *
     * @return the value of proj
     */
    int getProj();

    /**
     * Get the value of Run.
     *
     * @return the value of run
     */
    int getRun();

    /**
     * Get the value of Clone.
     *
     * @return the value of clone
     */
    int getClone();

    /**
     * Get the value of Generation.
     *
     * @return the value of gen
     */
    int getGen();

    /**
     * Get the value of Issued.
     *
     * @return the value of issue
     */
    Date getIssue();
    // </editor-fold>

    /**
     * Update all values.
     */
    void update();
}
