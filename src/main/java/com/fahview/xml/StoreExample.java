package com.fahview.xml;

import com.fahview.model.User;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

public class StoreExample {
    
    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";
    
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
            col = getOrCreateCollection("/db");
            
            User u = new User();
            u.setName("montycrabapple");
            u.setTeam(39299);
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            XMLEncoder encoder = new XMLEncoder(os);
            encoder.writeObject(u);
            encoder.close();
            System.out.println(new String(os.toByteArray()));
            
            res = (XMLResource)col.createResource("test.xml", "XMLResource");
            res.setContent(new String(os.toByteArray()));
            System.out.print("storing document " + res.getId() + "...");
            col.storeResource(res);
            System.out.println("ok.");
        } finally {
            //dont forget to cleanup
            if(col != null) {
                try { col.close(); } catch(XMLDBException xe) {xe.printStackTrace();}
            }
        }
    }
    
    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0);
    }
    
    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {
        
        Collection col = DatabaseManager.getCollection(URI + collectionUri);
        if(col == null) {
            if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String pathSegments[] = collectionUri.split("/");
            if(pathSegments.length > 0) {

                StringBuilder path = new StringBuilder();
                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }

                Collection start = DatabaseManager.getCollection(URI + path);
                if(start == null) {
                    //collection does not exist, so create
                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parent = DatabaseManager.getCollection(URI + parentPath);
                    CollectionManagementService mgt = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);
                    col.close();
                    parent.close();
                } else {
                    start.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}