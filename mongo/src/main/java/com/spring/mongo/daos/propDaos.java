
package com.spring.mongo.daos;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;


import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spring.mongo.model.properties;
import com.spring.mongo.repository.propertiesrepo;

/**
 * propDaos
 */
public class propDaos {

    /**
     *
     */

    private propertiesrepo Propertiesrepo;
    protected MongoDatabase db;
    protected MongoDatabase testDb;
    private MongoCollection<Document> propertiesCollection;
    @Autowired
    GridFsOperations gridOperations;

    public propDaos(propertiesrepo PropertiesRepo) {
        this.Propertiesrepo = PropertiesRepo;
    }
    private String imageFileId = "";
    public Boolean insert(properties Pro) throws FileNotFoundException {
        Propertiesrepo.insert(new properties(Pro.getType(), Pro.getCity(), Pro.getPincode(), Pro.getPrice(),
                Pro.getNo_of_bedrooms(),Pro.getKeyf(),Pro.getLocation(), Pro.getDesc()));
             
                return true;

    }

    public List getProp(properties pro) throws IOException {

        Document dd = null;
        String mongoUri = "mongodb+srv://king:kingglov@cluster0-8qc9a.mongodb.net/Rightmove";
        String databaseName = "Rightmove";
        db = MongoClients.create(mongoUri).getDatabase(databaseName);
        propertiesCollection = db.getCollection("Properties");
       
         Document qur = new Document();
         if(pro.getNo_of_bedrooms()!=""){
              qur.append("no_of_bedrooms", pro.getNo_of_bedrooms());
         }
         if(!pro.getType().equals("Any"))
         {
             qur.append("type", pro.getType());
         }
         
         qur.append("city",pro.getCity());

    
        List<Document> results = new ArrayList<>();
        propertiesCollection.find(qur).projection(new Document("_id", 0)).into(results);
       
        return results;
     }       

   
}