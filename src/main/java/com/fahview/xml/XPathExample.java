package com.fahview.xml;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;

public class XPathExample {

    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";

    /**
     * args[0] Should be the name of the collection to access args[1] Should be
     * the XPath expression to execute
     */
    public static void main(String args[]) throws Exception {

        final String driver = "org.exist.xmldb.DatabaseImpl";

        // initialize database driver
        Class cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;
        try {
            col = DatabaseManager.getCollection(URI + "/db/shakespeare/plays");
            XPathQueryService xpqs = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpqs.setProperty("indent", "yes");

            ResourceSet result = xpqs.query("xmldb:document()//SPEECH");
            ResourceIterator i = result.getIterator();
            Resource res = null;
            while (i.hasMoreResources()) {
                res = i.nextResource();
                System.out.println(res.getContent());
            }
        }
        finally {
            //dont forget to cleanup
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