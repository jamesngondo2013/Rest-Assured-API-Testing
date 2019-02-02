package com.james.training.RestAssuredTestingFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

/**
 * james.ngondo
 * AIzaSyBnRxEhsvsazxsB_LsmLp6G9tcUdd_4qeQ
 *
 */
public class ResourcesPage {
    
    protected Properties prop;
    protected FileInputStream fis;
    
    @BeforeTest
    public void getData() throws IOException, FileNotFoundException{
        
        prop = new Properties();
        fis = new FileInputStream("C:\\Users\\I350380\\workspace\\RestAssuredTestingFramework\\src\\main\\java\\com\\config\\files\\config.properties");
        prop.load(fis);
        
    }
   
    //POST
    public static String placePostJsonData(){
        
        String resPost = "/maps/api/place/add/json";
        
        return resPost;
    }
    
    //POST XML
    public static String placeXMLPostData(){
        
        String resPost = "/maps/api/place/add/xml";
        
        return resPost;
    }
    
    //DELETE
    public static String placeDeleteJsonData(){
        
        String resDelete = "/maps/api/place/delete/json";
        
        return resDelete;
    }
    
    //DELETE XML
    public static String placeXMLDeleteData(){
        
        String resDelete = "/maps/api/place/delete/xml";
        
        return resDelete;
    }
    
    //GET
    public static String placeGetJsonData(){
        
        String resGet = "/maps/api/place/nearbysearch/json";
        
        return resGet;
    }
    
    //GET XML
    public static String placeXMLGetData(){
        
        String resGet = "/maps/api/place/nearbysearch/xml";
        
        return resGet;
    }
   
}
