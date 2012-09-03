package com.fahview.xml;

import com.fahview.model.User;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.xml.transform.OutputKeys;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

public class RetrieveExample {

    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {

        final String driver = "org.exist.xmldb.DatabaseImpl";

        // initialize database driver
        Class cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res = null;
        try {
            // get the collection
            col = DatabaseManager.getCollection(URI + "/db");
            col.setProperty(OutputKeys.INDENT, "no");
            res = (XMLResource) col.getResource("test.xml");

            if (res == null) {
                System.out.println("document not found!");
            } else {
                System.out.println(res.getContent());
                
                String XML = (String)res.getContent();
                InputStream is = new ByteArrayInputStream(XML.getBytes("UTF-8"));
                XMLDecoder decoder = new XMLDecoder(is);
                User u = (User) decoder.readObject();
                System.out.println(u);
                decoder.close();
            }
        }
        finally {
            //dont forget to clean up!            
            if (col != null) {
                try {
                    col.close();
                }
                catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
    }
}