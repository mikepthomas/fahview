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
package com.fahview;

import com.fahview.controller.QueueReader;
import com.fahview.model.Queue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The main FAHView application class. This is the main class to the FAHView
 * program.
 *
 * @author <a href="mailto:michael4.thomas@live.uwe.ac.uk">Michael Thomas</a>
 */
public class App {

    // String to hold location of Folding@Home client
    private static String location;

    /**
     * The entry point to the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Properties props = new Properties();
                //try retrieve data from file
                try {
                    props.load(App.class.getResourceAsStream("/config.properties"));
                    location = props.getProperty("location");
                } //catch exception in case properties file does not exist
                catch (IOException e) {
                    System.err.println(e.getMessage());
                }

                // create new user interface
                final UI ui = new UI(location);
                ui.setVisible(true);

                // create queue
                Queue queue = new Queue(new QueueReader(location + "/queue.dat"));
                System.out.println(queue);

                // select the current index in table
                int current = queue.getCurrent();
                ui.getTable().getSelectionModel().setSelectionInterval(current, current);

                // set the current work unit data
                ui.setIssued(queue.getQueueIndex(current).getWuid().getIssue().toString());
                ui.setWorkServer(queue.getQueueIndex(current).getSvr2().getHostName());
                ui.setCollectionServer(queue.getQueueIndex(current).getCsip().getHostName());
                ui.setUserName(queue.getQueueIndex(current).getUname());
                ui.setTeamNumber(String.valueOf(queue.getQueueIndex(current).getTeamn()));
                ui.setCore(queue.getQueueIndex(current).getCore().getProject());

                // Fill the table
                for (int i = 0; i <= 9; i++) {
                    int status = queue.getQueueIndex(i).getStat();
                    String percentage = queue.getQueueIndex(i).getWuid().getPercentage();
                    int proj = queue.getQueueIndex(i).getWuid().getProj();
                    int run = queue.getQueueIndex(i).getWuid().getRun();
                    int clone = queue.getQueueIndex(i).getWuid().getClone();
                    int gen = queue.getQueueIndex(i).getWuid().getGen();
                    String project =
                            proj + " (Run "
                            + run + ", Clone "
                            + clone + ", Gen "
                            + gen + ")";
                    ui.setStatus(i, status);
                    ui.setPercentage(i, percentage);
                    ui.setProject(i, project);
                }
            }
        });
    }
}
