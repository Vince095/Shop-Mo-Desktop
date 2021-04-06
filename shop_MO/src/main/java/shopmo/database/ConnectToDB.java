package shopmo.database;

import com.mongodb.*;
import models.StoreApi;

import java.net.UnknownHostException;

import static models.StoreApi.dbUrl;

public class ConnectToDB {

    private String host;
    private int port;
    private String url;

    public void connect(){
        host = "localhost";
        port = 27017;

        MongoClient client = new MongoClient(
               new MongoClientURI(dbUrl) );

        DB database = client.getDB("shopMO");

        DBCollection collection = database.getCollection("users");

        DBObject document = collection.find().next();


        System.out.println("connected to " + collection.getFullName() + document);

    }

}
