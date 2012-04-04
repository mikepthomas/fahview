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

/**
 * Class to represent data stored about a Folding@Home client.
 * 
 * @author <a href="mailto:michael4.thomas@live.uwe.ac.uk">Michael Thomas</a>
 */
public class Client {
    private Queue queue;

    private String location, type;

    private String edition, version, launchDirectory, executable, arguments;
    private String userName, userID;
    private int machineID, teamNo;

    public Client(String location) {
        this.location = location;
        //queue = new Queue(location + "queue.dat");
    }

    protected void setArguments(String line) {
        arguments = trimFilePath(line);
    }

    protected void setEdition(String line) {
        edition = (line.replace("#", "")).trim();
    }

    protected void setExecutable(String line) {
        executable = trimFilePath(line);
    }

    protected void setLaunchDirectory(String line) {
        launchDirectory = trimFilePath(line);
    }

    protected void setMachineID(String line) {
        machineID = Integer.valueOf(trimAttribute(line));
    }

    protected void setUserID(String line) {
        userID = trimAttribute(line);
    }

    protected void setUserName(String line) {
        String user = line.substring(line.lastIndexOf(":") + 2, line.indexOf("(") - 1);
        userName = user;
        String team = line.substring(line.lastIndexOf(" ") + 1, line.indexOf(")"));
        teamNo = Integer.parseInt(team);
    }

    protected void setVersion(String line) {
        version = line.trim();
    }

    public String getArguments() {
        return arguments;
    }

    public String getEdition() {
        return edition;
    }

    public String getExecutable() {
        return executable;
    }

    public String getLaunchDirectory() {
        return launchDirectory;
    }

    public int getTeamNo() {
        return teamNo;
    }

    public int getMachineID() {
        return machineID;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getVersion() {
        return version;
    }

    private String trimAttribute(String line) {
        return line = line.substring(line.lastIndexOf(":") + 2);
    }

    private String trimFilePath(String line) {
        return line = line.substring(line.indexOf(":") + 2);
    }

    public String getLocation() {
        return location;
    }
}
