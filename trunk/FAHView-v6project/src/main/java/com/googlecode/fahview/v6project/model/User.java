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
 * <p>User class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class User implements java.io.Serializable {

    private Date date;
    private String name;
    private int newcredit, sum, team;

    /**
     * No-arg constructor (takes no arguments).
     */
    public User() {
    }

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of newcredit
     *
     * @return the value of newcredit
     */
    public int getNewcredit() {
        return newcredit;
    }

    /**
     * Set the value of newcredit
     *
     * @param newcredit new value of newcredit
     */
    public void setNewcredit(int newcredit) {
        this.newcredit = newcredit;
    }

    /**
     * Get the value of sum
     *
     * @return the value of sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * Set the value of sum
     *
     * @param sum new value of sum
     */
    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * Get the value of team
     *
     * @return the value of team
     */
    public int getTeam() {
        return team;
    }

    /**
     * Set the value of team
     *
     * @param team new value of team
     */
    public void setTeam(int team) {
        this.team = team;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "User{" + "date=" + date + ", name=" + name + ", newcredit=" + 
                newcredit + ", sum=" + sum + ", team=" + team + '}';
    }
    
}
