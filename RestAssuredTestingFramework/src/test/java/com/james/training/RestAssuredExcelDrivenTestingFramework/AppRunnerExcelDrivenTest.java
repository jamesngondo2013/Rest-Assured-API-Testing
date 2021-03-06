package com.james.training.RestAssuredExcelDrivenTestingFramework;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.james.training.RestAssuredMysqlDrivenTestingFramework.AppRunnerMysqlDrivenTest;
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

  ///This test deals with ALL items - book-name, isbn, aisle,author
  @Test(dataProvider = "getAllBookFieldsExcelData", dataProviderClass = RestAssuredCommonDataProvider.class, priority = 1)
    public void postJsonRequestAddAllBookFieldsTest(String isbn, String aisle,String book_name, String author  )
    {   
      System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
      
        payload = new HTTPPayloadPage();
        
        RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
        
        //variable that holds the response
        Response res= given().
                header("Content-Type","application/json").
                body(payload.addBookToPayload(isbn,aisle,book_name, author)).
                
        when().
                post(ResourcesPage.addBookPostJsonDataResourceURL()).
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
  
    ///This test only deals with 2 items - isbn, aisle
 // @Test(dataProvider = "getBookExcelData", dataProviderClass = RestAssuredCommonDataProvider.class, priority = 1)
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
              post(ResourcesPage.addBookPostJsonDataResourceURL()).
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
  
  @Test(dataProvider="deleteBookID", dataProviderClass = RestAssuredCommonDataProvider.class,dependsOnMethods = "postJsonRequestAddAllBookFieldsTest", priority=2)
  public void deleteBookJsonRequestTest(String bookid)
  {
     //bookid = V19804102,A19800100,J19803102,C19805101,G19801101,K19802100
     System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
      
     RestAssured.baseURI = prop.getProperty("RAHUL_SERVER");
      
      given().
      header("Content-Type","application/json").
              
              body(HTTPPayloadPage.deleteBookDataPayloadJson(bookid)).   //take 'bookid' to the Delete request    
      
      when().
              post(ResourcesPage.deleteBookJsonDataResourceURL()).
              
      then().
             assertThat().statusCode(200).and().log().all();
             
  }
  
  
  
}
