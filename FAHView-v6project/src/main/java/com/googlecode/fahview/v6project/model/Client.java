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
 * Class to represent data stored about a Folding@home client.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class Client {
    private QueueImpl queue;

    private String location, type;

    private String edition, version, launchDirectory, executable, arguments;
    private String userName, userID;
    private int machineID, teamNo;

    /**
     * <p>Constructor for Client.</p>
     *
     * @param location a {@link java.lang.String} object.
     */
    public Client(String location) {
        this.location = location;
        //queue = new QueueImpl(location + "queue.dat");
    }

    /**
     * <p>Setter for the field <code>arguments</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setArguments(String line) {
        arguments = trimFilePath(line);
    }

    /**
     * <p>Setter for the field <code>edition</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setEdition(String line) {
        edition = (line.replace("#", "")).trim();
    }

    /**
     * <p>Setter for the field <code>executable</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setExecutable(String line) {
        executable = trimFilePath(line);
    }

    /**
     * <p>Setter for the field <code>launchDirectory</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setLaunchDirectory(String line) {
        launchDirectory = trimFilePath(line);
    }

    /**
     * <p>Setter for the field <code>machineID</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setMachineID(String line) {
        machineID = Integer.valueOf(trimAttribute(line));
    }

    /**
     * <p>Setter for the field <code>userID</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setUserID(String line) {
        userID = trimAttribute(line);
    }

    /**
     * <p>Setter for the field <code>userName</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setUserName(String line) {
        String user = line.substring(line.lastIndexOf(":") + 2, line.indexOf("(") - 1);
        userName = user;
        String team = line.substring(line.lastIndexOf(" ") + 1, line.indexOf(")"));
        teamNo = Integer.parseInt(team);
    }

    /**
     * <p>Setter for the field <code>version</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    protected void setVersion(String line) {
        version = line.trim();
    }

    /**
     * <p>Getter for the field <code>arguments</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getArguments() {
        return arguments;
    }

    /**
     * <p>Getter for the field <code>edition</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEdition() {
        return edition;
    }

    /**
     * <p>Getter for the field <code>executable</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getExecutable() {
        return executable;
    }

    /**
     * <p>Getter for the field <code>launchDirectory</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLaunchDirectory() {
        return launchDirectory;
    }

    /**
     * <p>Getter for the field <code>teamNo</code>.</p>
     *
     * @return a int.
     */
    public int getTeamNo() {
        return teamNo;
    }

    /**
     * <p>Getter for the field <code>machineID</code>.</p>
     *
     * @return a int.
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     * <p>Getter for the field <code>userID</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * <p>Getter for the field <code>userName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <p>Getter for the field <code>version</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getVersion() {
        return version;
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
     * <p>trimFilePath.</p>
     *
     * @param line a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    private String trimFilePath(String line) {
        return line = line.substring(line.indexOf(":") + 2);
    }

    /**
     * <p>Getter for the field <code>location</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLocation() {
        return location;
    }
}
