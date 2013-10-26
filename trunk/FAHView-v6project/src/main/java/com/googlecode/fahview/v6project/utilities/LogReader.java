package com.googlecode.fahview.v6project.utilities;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to extract data from Folding@home client log files.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class LogReader {
    private File FAHlogTxt;
    private final String COMPLETED_REGEX = "\\[(\\d{2,2}):(\\d{2,2}):(\\d{2,2})\\] Completed (\\d{1,}) out of (\\d{1,}) steps  ?\\((\\d{1,2})\\%?\\)";
    private int logPosition = 0;
    
    /**
     * <p>Constructor for LogReader.</p>
     *
     * @param location a {@link java.lang.String} object.
     */
    public LogReader(String location) {
            FAHlogTxt = new File(location + "/FAHLog-Prev.txt");


                // Static Messages
//                if (line.contains("Edition")) client.setEdition(line);
//                if (line.contains("Folding@home Client Version")) client.setVersion(line);
//                if (line.contains("Launch directory: ")) client.setLaunchDirectory(line);
//                if (line.contains("Service: ") | line.contains("Executable: ")) client.setExecutable(line);
//                if (line.contains("Arguments: ")) client.setArguments(line);
//
//                // Client Data
//                if (line.contains("User name: ")) client.setUserName(line);
//                if (line.contains("User ID: ")) client.setUserID(line);
//                if (line.contains("Machine ID: ")) client.setMachineID(line);

                // Queue Data
                //if (line.contains("Working on queue slot")) setLogPosition(line);

                // Work Unit Data
                //if (line.contains("Project: ")) client.queue.getQueueIndex(logPosition).wuid.setProject(line);
                //if (line.contains("Protein: ")) client.queue.getQueueIndex(logPosition).wuid.setProtein(line);
                // [??:??:??] Completed ????? out of ????? steps  (??%)
//                if (Pattern.matches(COMPLETED_REGEX, line)) client.queue.getQueueIndex(logPosition).wuid.setCompleted(line);
            

            // Client
//            System.out.println(client.getEdition());
//            System.out.println(client.getVersion());
//            System.out.println(client.getLaunchDirectory());
//            System.out.println(client.getExecutable());
//            System.out.println(client.getArguments());
//            System.out.println(client.getUserName());
//            System.out.println(client.getTeamNo());
//            System.out.println(client.getUserID());
//            System.out.println(client.getMachineID());

    }

    /**
     * <p>Setter for the field <code>logPosition</code>.</p>
     *
     * @param line a {@link java.lang.String} object.
     */
    private void setLogPosition(String line) {
        String values[] = line.split(" ");
        this.logPosition = Integer.parseInt(values[5]);
        System.out.println(logPosition);
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString() {
        String contents = "";
        try {
            Scanner scan = new Scanner(FAHlogTxt);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                contents += (line + "\n");
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(LogReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contents;
    }
}
