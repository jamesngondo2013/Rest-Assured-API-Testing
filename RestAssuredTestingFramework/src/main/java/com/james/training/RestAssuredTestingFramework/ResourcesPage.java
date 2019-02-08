package com.james.training.RestAssuredTestingFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Base64.Encoder;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import io.restassured.config.EncoderConfig;

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
    public static String placePostJsonDataResourceURL(){
        
        String resPost = "/maps/api/place/add/json";
        
        return resPost;
    }
    
    //POST XML
    public static String placeXMLPostDataResourceURL(){
        
        String resPost = "/maps/api/place/add/xml";
        
        return resPost;
    }
    
    //DELETE
    public static String placeDeleteJsonDataResourceURL(){
        
        String resDelete = "/maps/api/place/delete/json";
        
        return resDelete;
    }
    
    //DELETE XML
    public static String placeXMLDeleteDataResourceURL(){
        
        String resDelete = "/maps/api/place/delete/xml";
        
        return resDelete;
    }
    
    //GET
    public static String placeGetJsonDataResourceURL(){
        
        String resGet = "/maps/api/place/nearbysearch/json";
        
        return resGet;
    }
    
    //GET XML
    public static String placeXMLGetDataResourceURL(){
        
        String resGet = "/maps/api/place/nearbysearch/xml";
        
        return resGet;
    }
    //add book Json
    public static String addBookPostJsonDataResourceURL ()
    {
       String addBook = "Library/Addbook.php";
       
        return addBook;
    }
    //delete book Json
    public static String deleteBookJsonDataResourceURL ()
    {
       String deleteBook = "Library/DeleteBook.php";
       
        return deleteBook;
    }
    //get book by either ID or Author Json
    public static String getBookJsonDataResourceURL(){
        
        String getBook = "Library/GetBook.php";
        
        return getBook;
    }
    public static String getJiraResourceURL(){
        
        String url = "/rest/auth/1/session";
        return url;
        
    }
    
    public static String postCreateBugJiraResourceURL(){
        
        String url = "/rest/api/2/issue";
        return url;
        
    }
    
    public static String deleteJiraBugResourceURL(String id){
        
        String url = "/rest/api/2/issue/"+id;
        return url;
        
    }
    
    public static String addCommentToJiraBugResourceURL(String id){
        
           String url = "/rest/api/2/issue/{"+id+"}/comment";
       
        return url;
        
    }
   
}
