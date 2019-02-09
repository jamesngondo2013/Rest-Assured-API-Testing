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

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author james.ngondo
 *
 */
public class CreateJIRAIssueTest extends ResourcesPage{

    @Test
    public void postJIRAAuthenticationTest()
    {    
        //System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
        String user=prop.getProperty("JIRA_USER");
        String pass=prop.getProperty("JIRA_PASS");
        
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
                               
                       then().
                               statusCode(201).extract().response();
                            
        JsonPath js= ReusableMethodsPage.rawToJson(res);
        String id=js.get("id");
        //set delete id to be used later
        ReusableMethodsPage.setJiraId(id);
        System.out.println("Issue Created with ID: " +id);
                              
    }
    
  //  @Test(dependsOnMethods = "postJiraCreateIssue", priority = 1)
    public void JiraAPICreateNewComment ()
    {
        String comment = "Inserting comment from the automation code";

        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        Response res = given().header("Content-Type", "application/json").
                
                                header("Cookie", ReusableMethodsPage.getSessionKEY()).log().all().
                                
                                body(HTTPPayloadPage.addJiraCommentPayloadData(comment)).log().all().
                       when().
                               post(ResourcesPage.addCommentToJiraBugResourceURL(ReusableMethodsPage.getJiraId())).
                       then().
                               statusCode(201).extract().response();
        
        JsonPath js= ReusableMethodsPage.rawToJson(res);
        String commentId=js.get("id");
        ReusableMethodsPage.setCommentID(commentId);
        System.out.println("Comment ID: " +commentId); //comment id = 10002

    }
    
   // @Test(dependsOnMethods = "JiraAPICreateNewComment", priority = 2)
    public void JiraAPIUpdateComment ()
    {
      //Jira Issue id=10030
      //Jira comment id = 10002     "/rest/api/2/issue/10030/comment/10002"
        String comment ="Updated version 1 of this defect";
        String jiraID = "10030";
        String commentID = "10002";

        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        Response res = given().header("Content-Type", "application/json").
                
                                header("Cookie", ReusableMethodsPage.getSessionKEY()).log().all().
                                
                                pathParams("commentid",ReusableMethodsPage.getCommentId()).
                                
                                body(HTTPPayloadPage.addJiraCommentPayloadData(comment)).
                     when().
                                put(ResourcesPage.updateCommentJiraBugResourceURL(ReusableMethodsPage.getJiraId())).
                     then().
                                statusCode(200).extract().response();
                               
        JsonPath js= ReusableMethodsPage.rawToJson(res);
        String id=js.get("id");
        System.out.println("Comment ID: " +id); 

    }
    
  // @Test(dependsOnMethods = "postJiraCreateIssue", priority = 2)
    public void deleteJiraJsonRequestTest()
    {
      // System.err.println("Running Test=> "+" "+AppRunnerMysqlDrivenTest.class.getName() + this + " -> on thread [" + Thread.currentThread().getId() + "]");
        
       RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
                    given().
                                    header("Cookie",ReusableMethodsPage.getSessionKEY()).
                                    header("Content-Type","application/json").
                            
                                    body(HTTPPayloadPage.deleteJiraBugDataPayloadJson(ReusableMethodsPage.getJiraId())).   //take 'bookid' to the Delete request    
                    
                    when().                                                   //path parameter with id
                                    delete(ResourcesPage.deleteJiraBugResourceURL(ReusableMethodsPage.getJiraId())).
                            
                    then().
                                   assertThat().statusCode(204).and().log().all();
               
    } 

}
