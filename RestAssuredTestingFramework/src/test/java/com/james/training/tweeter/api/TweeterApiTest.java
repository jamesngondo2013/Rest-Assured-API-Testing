package com.james.training.tweeter.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.james.training.RestAssuredTestingFramework.ResourcesPage;
import com.james.training.RestAssuredTestingFramework.ReusableMethodsPage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TweeterApiTest extends ResourcesPage{

    
    @Test
    public void postTweetOAuthTest()
    {    
        //System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
        String ConsumerKey  =prop.getProperty("Tweeter_ConsumerKey");
        String ConsumerSecret = prop.getProperty("Tweeter_ConsumerSecret");
        String Token = prop.getProperty("Tweeter_AccessToken");
        String TokenSecret = prop.getProperty("Tweeter_AccessTokenSecret");
        
        String tweet_text = "You're at your best when you're authentic to your core (the part of something that is central to its existence or character) and you have to be what you are and not what people call you!!";
        
        
        RestAssured.baseURI = prop.getProperty("TWEETER_BASE_URL");
        
        //variable that holds the response
        Response res= given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
                              queryParam("status", tweet_text).
                      when().
                              post(ResourcesPage.postTweetResourceURL()).then().extract().response();
            
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        String text = js.get("text").toString();
        String tweet_id = js.get("id").toString();
        System.out.println("POSTED NEW TWEET: " +text);
        System.out.println("POSTED NEW TWEET ID: " +tweet_id);
        
        ReusableMethodsPage.setTweetID(tweet_id);
       
    }
    
    @Test
    public void getTweetOAuthTest()
    {    
        //System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
        String ConsumerKey  =prop.getProperty("Tweeter_ConsumerKey");
        String ConsumerSecret = prop.getProperty("Tweeter_ConsumerSecret");
        String Token = prop.getProperty("Tweeter_AccessToken");
        String TokenSecret = prop.getProperty("Tweeter_AccessTokenSecret");
        
        
        RestAssured.baseURI = prop.getProperty("TWEETER_BASE_URL");
        
        //variable that holds the response
        Response res= given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
                              queryParam("count", "1").
                      when().
                              get(ResourcesPage.getTweetResourceURL()).then().extract().response();
            
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        String tweet_text = js.get("text").toString();
        String tweet_id = js.get("id").toString();
        System.out.println("GET TWEET: " +tweet_text);
        System.out.println("GET TWEET ID: " +tweet_id);
       
    }   
    
  //  @Test(dependsOnMethods = "postTweetOAuthTest")
    public void deleteTweetOAuthTest()
    {    
        //System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
        String ConsumerKey  =prop.getProperty("Tweeter_ConsumerKey");
        String ConsumerSecret = prop.getProperty("Tweeter_ConsumerSecret");
        String Token = prop.getProperty("Tweeter_AccessToken");
        String TokenSecret = prop.getProperty("Tweeter_AccessTokenSecret");
        
        String tweet_id = ReusableMethodsPage.getTweetID();
        
        
        RestAssured.baseURI = prop.getProperty("TWEETER_BASE_URL");
        
        //variable that holds the response
        Response res= given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
                        
                      when().
                              post(ResourcesPage.deleteTweetResourceURL(tweet_id)).then().extract().response();
       
    }
    
    
}
