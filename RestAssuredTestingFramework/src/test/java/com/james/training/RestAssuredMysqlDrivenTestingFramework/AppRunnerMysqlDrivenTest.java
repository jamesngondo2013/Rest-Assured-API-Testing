package com.james.training.RestAssuredMysqlDrivenTestingFramework;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.james.training.RestAssuredTestingFramework.BookDetails;
import com.james.training.RestAssuredTestingFramework.HTTPPayloadPage;
import com.james.training.RestAssuredTestingFramework.ResourcesPage;
import com.james.training.RestAssuredTestingFramework.ReusableMethodsPage;

import common.data.provider.RestAssuredCommonDataProvider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AppRunnerMysqlDrivenTest extends ResourcesPage{

    private HTTPPayloadPage payload;

   // @Test(dataProvider = "getBookDataDB", dataProviderClass = RestAssuredCommonDataProvider.class, priority = 1)
      public void postJsonRequestAddBookTest(String isbn, String aisle)
      {    
          System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
          
          payload = new HTTPPayloadPage();
          
          RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
          
          //variable that holds the response
          Response res= given().
                  header("Content-Type","application/json").
                  body(payload.addBookToPayload(isbn,aisle)).
                
          when().
                  post(ResourcesPage.addBookPostJsonData()).
                  
          then().
                  assertThat().statusCode(200).and().
                  extract().response(); //extracts the response from the request and place it in 'res'
          
          JsonPath js = ReusableMethodsPage.rawToJson(res);
          String bookID = js.get("ID");
        //  System.out.println("BookID: "+ bookID); 
          
          //set book id
          BookDetails.setBookid (bookID);
         
      }
    
    @Test(dataProvider = "getDBDataAllFields", dataProviderClass = RestAssuredCommonDataProvider.class, priority = 1)
    public void postJsonRequestAddBookaLLFieldsTest(String isbn, String aisle,String book_name, String author )
    {    
        System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
        payload = new HTTPPayloadPage();
        
        RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
        
        //variable that holds the response
        Response res= given().
                header("Content-Type","application/json").
                body(payload.addBookToPayload(isbn,aisle, book_name,author)).
        when().
                post(ResourcesPage.addBookPostJsonData()).
                
        then().
                assertThat().statusCode(200).and().
                extract().response(); //extracts the response from the request and place it in 'res'
        
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        String bookID = js.get("ID");
        System.out.println("BookID: "+ bookID); 
        
        //set book id
      //  payload.setBookid (bookID);
        BookDetails.setBookid(bookID);
  
    }
    
    @Test(dataProvider="deleteBookID", dataProviderClass = RestAssuredCommonDataProvider.class,dependsOnMethods = "postJsonRequestAddBookaLLFieldsTest", priority=2)
    public void deleteBookJsonRequestTest(String bookid)
    {
       //bookid = B19815502,J198207101,G19811701,S19801100
       System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
       RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
        
        given().
        header("Content-Type","application/json").
                
                body(HTTPPayloadPage.deleteBookDataPayloadJson(bookid)).   //take 'bookid' to the Delete request    
        
        when().
                post(ResourcesPage.deleteBookJsonData()).
                
        then().
               assertThat().statusCode(200).and().log().all();
               
    }
    
}
