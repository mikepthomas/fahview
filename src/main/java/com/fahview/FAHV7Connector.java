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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

/**
 * Program to test Java connectivity to Folding@Home version 7 client API.
 *
 * @see <a href="https://fah-web.stanford.edu/projects/FAHClient/wiki/ClientRemoteInterface">
 * FAH Wiki - Client Remote Interface</a>
 * @author <a href="mailto:michael4.thomas@live.uwe.ac.uk">Michael Thomas</a>
 */
public class FAHV7Connector {

    /**
     * The entry point to the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        Properties props = new Properties();

        try {
            props.load(App.class.getResourceAsStream("/config.properties"));
            String host = props.getProperty("host");
            int port = Integer.valueOf(props.getProperty("port"));
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            e.getMessage();
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println(in.readLine());

        while (( userInput = stdIn.readLine() ) != null) {
            out.println(userInput);
            while (in.ready()) {
                System.out.println(in.readLine());
            }

        }

        out.close();
        in.close();
        socket.close();
    }
}
