/**
 * 
 */
package com.james.training.JIRA.api;

import static io.restassured.RestAssured.given;

import java.net.URI;
import java.net.URLEncoder;

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

/**
 * @author james.ngondo
 *
 */
public class JIRATest extends ResourcesPage{

    @Test
    public void postJIRAAuthenticationTest()
    {    
        //System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
        String user="jamesngondogti";
        String pass="chingotah1980";
        
        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        //variable that holds the response
        Response res= given().
                header("Content-Type","application/json").
                body(HTTPPayloadPage.JiraAuthPayloadJson(user, pass)).log().all().
              
        when().
                post(ResourcesPage.getJiraResourceURL()).
                
        then().
                assertThat().statusCode(200).and().log().all().
                extract().response(); //extracts the response from the request and place it in 'res'
        
        JsonPath js = ReusableMethodsPage.rawToJson(res);
        String sessionName = js.get("session.name");
        String sessionValue = js.get("session.value");
        String sessionId = sessionName+"="+sessionValue;
        ReusableMethodsPage.setSessionKEY(sessionId);
        System.out.println(sessionId); 
       
    }
    
    @Test(dependsOnMethods = "postJIRAAuthenticationTest")
    public void postJiraCreateIssue()
    {    
        //System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        String projectKey = "RES";
        String summary = "Issue 5 for adding comment";
        String descripion = "Creating a bug";
        String issueType = "Bug";
        
        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        //variable that holds the response
        Response res= given().
                               header("Cookie",ReusableMethodsPage.getSessionKEY()).
                               header("Content-Type","application/json").
                               body(HTTPPayloadPage.JiraCreateBugPayloadJson(projectKey,summary,descripion,issueType)).
                               
                       when().log().all().
                               post(ResourcesPage.postCreateBugJiraResourceURL()).
                               
             then().statusCode(201).extract().response();
                            
        JsonPath js= ReusableMethodsPage.rawToJson(res);
        String id=js.get("id");
        //set delete id to be used later
        ReusableMethodsPage.setDeleteId(id);
        System.out.println("Issue Created with ID: " +id);
                              
    }
    
  //@Test(dependsOnMethods = "postJiraCreateIssue", priority = 1)
    public void addCommentJiraJsonRequestTest()
    {
        String comment = "This is a comment by James";
        
        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        //variable that holds the response
        Response res= given().
                            urlEncodingEnabled(false).
                               header("Cookie",ReusableMethodsPage.getSessionKEY()).
                               header("Content-Type","application/json").
                               body(HTTPPayloadPage.addJiraCommentPayloadData(comment)).                               
                       when().log().all().
                               post(ResourcesPage.addCommentToJiraBugResourceURL(ReusableMethodsPage.getDeleteId())).
                               
                       then().statusCode(201).extract().response();
    }
    
  @Test(dependsOnMethods = "postJiraCreateIssue", priority = 2)
    public void deleteJiraJsonRequestTest()
    {
      // System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
       RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        given().
                        header("Cookie",ReusableMethodsPage.getSessionKEY()).
                        header("Content-Type","application/json").
                
                        body(HTTPPayloadPage.deleteJiraBugDataPayloadJson(ReusableMethodsPage.getDeleteId())).   //take 'bookid' to the Delete request    
        
        when().                                                   //path parameter with id
                        delete(ResourcesPage.deleteJiraBugResourceURL(ReusableMethodsPage.getDeleteId())).
                
        then().
                       assertThat().statusCode(204).and().log().all();
               
    }
}
