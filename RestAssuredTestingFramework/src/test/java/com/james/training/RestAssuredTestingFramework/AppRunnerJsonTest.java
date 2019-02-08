package com.james.training.RestAssuredTestingFramework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;





/**
 * Unit test for simple App.
 */
public class AppRunnerJsonTest extends ResourcesPage
{
    private static String placeid;
    /*private Properties prop;
    private FileInputStream fis;
    
  @BeforeTest
    public void getData() throws IOException, FileNotFoundException{
     
        prop = new Properties();
        fis = new FileInputStream("C:\\Users\\I350380\\workspace\\RestAssuredTestingFramework\\src\\main\\java\\com\\config\\files\\config.properties");
        prop.load(fis);
        
    }*/
    
  //  @Test
    public void getJsonRequestTest( )
    {
        RestAssured.baseURI = prop.getProperty("HOST"); //get URI
        
        given().
                param("location","-33.8670522,151.1957362").
                param("radius","500").
                param("key",prop.getProperty("KEY")).
                
        when().
                    get(ResourcesPage.placeGetJsonDataResourceURL()).//get=resource type
                    
        then().
                    assertThat().statusCode(200).and().contentType(ContentType.JSON). //assertion with content-type JSON and stsatus code =200
                    and().
                    body("results[0].name", equalTo("Sydney")).and().     //traverse the json to get 'name' - otherwise it fails
                    body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                    header("server", "scaffolding on HTTPServer2");                                                            
    }
    
    @Test
    public void getJsonRequestExtractAllNamesAndLoggingTest( )
    {
        RestAssured.baseURI = prop.getProperty("HOST"); //get URI
        
        Response res = given().
                param("location","-33.8670522,151.1957362").
                param("radius","500").
                param("key",prop.getProperty("KEY")).
                log().all().   //logging
        when().
                    get(ResourcesPage.placeGetJsonDataResourceURL()).//get=resource type
                    
        then().
                    assertThat().statusCode(200).and().contentType(ContentType.JSON). //assertion with content-type JSON and stsatus code =200
                    and().
                    body("results[0].name", equalTo("Sydney")).and().     //traverse the json to get 'name' - otherwise it fails
                    body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                    header("server", "scaffolding on HTTPServer2").log().all().
                    extract().response(); 
        
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        int namesArraySize = js.get("results.size()");
        System.out.println("Number of Place Names: "+ namesArraySize);
        for (int i = 0; i < namesArraySize; i++) {
            System.out.println(js.get("results["+i+"].name"));
        }
    }
   // @Test
    public void postJsonRequestTest( )
    {   
        //get payloadBody from HTTPPayloadPage
        String payloadBody = HTTPPayloadPage.getPostDataPayloadJson();
    
        RestAssured.baseURI = prop.getProperty("HOST");
        
        //variable that holds the response
        Response res= given().
                queryParam("key", prop.getProperty("KEY")).
                
                body(payloadBody).
                
        when().
                post(ResourcesPage.placePostJsonDataResourceURL()).  
                
        then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).
                extract().response(); //extracts the response from the request and place it in 'res'
        
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        //get place_id
        placeid = js.get("place_id");
        System.out.println(placeid);
    }
    
  //  @Test(dependsOnMethods = "addRequestTest")
    public void deleteJsonRequestTest()
    {
        RestAssured.baseURI = prop.getProperty("HOST");
        
        given().
                queryParam("key", prop.getProperty("KEY")).
                
                body(HTTPPayloadPage.getDeleteDataPayloadJson(placeid)).   //take 'placeid' to the Delete request    
        
        when().
                post(ResourcesPage.placeDeleteJsonDataResourceURL()).
                
        then().
               assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
               body("status", equalTo("OK"));
    }
    

}
