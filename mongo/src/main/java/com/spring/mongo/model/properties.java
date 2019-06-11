package com.spring.mongo.model;

import java.io.File;
import java.io.InputStream;

import com.spring.mongo.daos.propDaos;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Properties")
public class properties {


private String type ;
private String city;
private String pincode;
private String price;
private String no_of_bedrooms;
private String keyf;
private String location;
private String desc;
private File path;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNo_of_bedrooms() {
        return no_of_bedrooms;
    }

    public void setNo_of_bedrooms(String no_of_bedrooms) {
        this.no_of_bedrooms = no_of_bedrooms;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

public properties(String type, String city, String pincode, String price, String no_of_bedrooms,String keyf, String location, String desc)
{
 this.city = city;
 this.desc = desc;
 this.no_of_bedrooms = no_of_bedrooms;
 this.pincode = pincode;
 this.price = price;
 this.type = type;
 this.location = location;
 this.keyf= keyf;
//  this.path = path;
}

    public String getKeyf() {
        return keyf;
    }

    public void setKeyf(String keyf) {
        this.keyf = keyf;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    

    

}
   

  