/*
 * Copyright (C) 2012 Michael Thomas <michael4.thomas@live.uwe.ac.uk>
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
package com.fahview.sql;

import com.fahview.App;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Program to test input of <a
 * href="http://fah-web.stanford.edu/daily_user_summary.txt">
 * daily_user_summary.txt</a> into an SQL database.
 *
 * @author <a href="mailto:michael4.thomas@live.uwe.ac.uk">Michael Thomas</a>
 */
public class User {

    /**
     * The entry point to the program.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(
                "Copyright 2011, Mike Thomas");
        try {
            Statement stmt;
            Properties props = new Properties();

            props.load(App.class.getResourceAsStream("/config.properties"));

            //Register the JDBC driver for MySQL.
            Class.forName(props.getProperty("driver"));

            //Define URL of database server for
            // database named mysql on the localhost
            // with the default port number 3306.
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("URL: " + url);
            System.out.println("Connection: " + con);

            //Get a Statement object
            stmt = con.createStatement();

            //Execute SQL
            stmt.executeUpdate("USE FAHView;");
            stmt.executeUpdate("TRUNCATE TABLE daily_user_summary;");

            InputStream in = App.class.getResourceAsStream("/daily_user_summary.txt");
            InputStreamReader read = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(read);

            System.out.println(buf.readLine());
            System.out.println(buf.readLine() + "\n");

            while (buf.ready()) {
                String line = buf.readLine();
                line = line.replace("\"", "\\\"");
                String[] array = line.split("\t");

                String name = array[0];
                String newcredit = array[1];
                String sum = array[2];
                String team = "0";//array[3];

                //Execute SQL
                stmt.executeUpdate(
                        "INSERT INTO daily_user_summary "
                        + "(name, newcredit, sum, team) "
                        + "VALUES (\"" + name + "\", " + newcredit + ", " + sum + ", " + team + ");");

            }
        }
        catch (ClassNotFoundException | SQLException | IOException e) {
            e.getMessage();
        } //end catch
    } //end main
}
