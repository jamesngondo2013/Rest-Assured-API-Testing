package com.james.training.RestAssuredExcelDrivenTestingFramework;

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

public class AppRunnerExcelDrivenTest extends ResourcesPage{
    private HTTPPayloadPage payload;

  @Test(dataProvider = "getBookExcelData", dataProviderClass = RestAssuredCommonDataProvider.class, priority = 1)
    public void postJsonRequestAddBookTest(String book_name,String isbn, String aisle, String author  )
    {     
        payload = new HTTPPayloadPage();
        
        RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
        
        //variable that holds the response
        Response res= given().
                header("Content-Type","application/json").
                body(payload.addBookToPayload(book_name,isbn,aisle, author)).
                
        when().
                post(ResourcesPage.addBookPostJsonData()).
                //post("Library/Addbook.php").
                
        then().
                assertThat().statusCode(200).and().log().all().
                extract().response(); //extracts the response from the request and place it in 'res'
        
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        String bookID = js.get("ID");
        System.out.println("BookID: "+ bookID); 
        
        //set book id
        BookDetails.setBookid (bookID);
       
    }
  
  @Test(dependsOnMethods = "postJsonRequestAddBookTest")
  public void deleteBookJsonRequestTest()
  {
     // payload = new HTTPPayloadPage();
      
      RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
      
      given().
      header("Content-Type","application/json").
              
           //   body(HTTPPayloadPage.deleteBookDataPayloadJson(payload.getBookid())).   //take 'placeid' to the Delete request    
      
      when().
              post(ResourcesPage.deleteBookJsonData()).
              
      then().
             assertThat().statusCode(200).and().log().all();
             
  }
  
  
}
