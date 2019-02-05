package com.james.training.RestAssuredTestingFramework;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class AppRunnerXMLTest extends ResourcesPage{

  //  @Test
    public void getXMLRequestTest( )
    { 
        RestAssured.baseURI = prop.getProperty("HOST"); //get URI
        
       Response res = given().
            param("location","-33.8670522,151.1957362").
            param("radius","500").
            param("key",prop.getProperty("KEY")).
        
        when().
            get(ResourcesPage.placeXMLGetData()).//get=resource type
            
        then().
            assertThat().statusCode(200).and().contentType(ContentType.XML). //assertion with content-type JSON and stsatus code =200
            and().
            body("PlaceSearchResponse.result[0].name", equalTo("Sydney")).extract().response();     //traverse the json to get 'name' - otherwise it fails
                 //   body("PlaceSearchResponse.result[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                 //   header("server", "scaffolding on HTTPServer2");  
        
        XmlPath xml = ReusableMethodsPage.rawToXML(res);
        JsonPath js = ReusableMethodsPage.rawToJson(res);
    //    String result = xml.getString("PlaceSearchResponse.place_id");
      //  System.out.println(res);
    }
    
    @Test
    public void getXMLRequestAllNamesArrayTest( )
    { 
        RestAssured.baseURI = prop.getProperty("HOST"); //get URI
        
       Response res = given().
            param("location","-33.8670522,151.1957362").
            param("radius","500").
            param("key",prop.getProperty("KEY")).
        
        when().
            get(ResourcesPage.placeXMLGetData()).//get=resource type
            
        then().
            assertThat().statusCode(200).and().contentType(ContentType.XML). //assertion with content-type JSON and stsatus code =200
            and().
            body("PlaceSearchResponse.result[0].name", equalTo("Sydney")).extract().response();     //traverse the json to get 'name' - otherwise it fails
                 //   body("PlaceSearchResponse.result[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                 //   header("server", "scaffolding on HTTPServer2");  
        
        XmlPath xml = ReusableMethodsPage.rawToXML(res);
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        String result = xml.getString("PlaceSearchResponse.place_id");
       // System.out.println(res);
        
        int items = xml.get("PlaceSearchResponse.result.name.size()");
        //print number of place names
        System.out.println("Number of Place Names: "+items);
        //get all names
        for (int i = 0; i < items; i++) {
            System.out.println(xml.get("PlaceSearchResponse.result["+i+"].name"));
        }
    }
    
    // @Test
    public void postXMLRequestTest( ) throws IOException
    {   
        //get xml payloadBody from HTTPPayloadPage
        //we want to post this string
        String postData = ReusableMethodsPage.generateStringFromXMLResource(prop.getProperty("XMLPATH"));
       
        RestAssured.baseURI = prop.getProperty("HOST");
        
        //variable that holds the response
        Response response = given().
                queryParam("key", prop.getProperty("KEY")).
                
                body(postData).
                
        when().
                post(ResourcesPage.placeXMLPostData()).  
                
        then().
                assertThat().statusCode(200).and().contentType(ContentType.XML).and().extract().response(); //extracts the response from the request and place it in 'res'
        
        //convert raw string to xml data from response
        XmlPath xml = ReusableMethodsPage.rawToXML(response);
       // String result = xml.getString("PlaceAddResponse.place_id");
       // System.out.println(result);
    }
   
}
