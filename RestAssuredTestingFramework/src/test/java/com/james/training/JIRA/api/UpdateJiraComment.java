package com.james.training.JIRA.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.james.training.RestAssuredTestingFramework.HTTPPayloadPage;
import com.james.training.RestAssuredTestingFramework.ResourcesPage;
import com.james.training.RestAssuredTestingFramework.ReusableMethodsPage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateJiraComment extends ResourcesPage{

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
    
   // @Test(dependsOnMethods = "postJIRAAuthenticationTest", priority = 1)
    public void JiraAPICreateNewComment ()
    {
        String comment = "Inserting comment from the automation code";
        
        String jiraid = ReusableMethodsPage.getJiraId();

        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        Response res = given().header("Content-Type", "application/json").
                
                                header("Cookie", ReusableMethodsPage.getSessionKEY()).log().all().
                                pathParam("jiraid",jiraid).
                                body(HTTPPayloadPage.addJiraCommentPayloadData(comment)).
                       when().
                               post(ResourcesPage.addCommentToJiraBugResourceURL()). // id comes from new jira created
                       then().
                               statusCode(201).extract().response(); 
        
        JsonPath js= ReusableMethodsPage.rawToJson(res);
        String commentId=js.get("id");
        ReusableMethodsPage.setCommentID(commentId);
        System.out.println("Comment ID: " +commentId); //comment id = 10002

    }
    
    @Test(dependsOnMethods = "postJIRAAuthenticationTest")
    public void JiraAPIUpdateComment ()
    {
      //Jira Issue id=10030
      //Jira comment id = 10002     "/rest/api/2/issue/10030/comment/10002"
        String comment ="Updated version test of this defect";
        String jiraID = "10030"; 
        String commentID = "10002";

        RestAssured.baseURI = prop.getProperty("JIRA_LOCALHOST");
        
        Response res = given().header("Content-Type", "application/json").
                
                                header("Cookie", ReusableMethodsPage.getSessionKEY()).log().all().
                                
                                pathParams("commentid","10002").
                                
                                body(HTTPPayloadPage.addJiraCommentPayloadData(comment)).
                     when().
                                                                                             // "/rest/api/2/issue/10030/comment/10002"
                                put(ResourcesPage.updateCommentJiraBugResourceURL(jiraID)). //takes i jira-id , comment-id
                     then().
                                statusCode(200).extract().response();
                            
                                
                                
        
        JsonPath js= ReusableMethodsPage.rawToJson(res);
        String id=js.get("id");
        System.out.println("Comment ID: " +id); 

    }
  
}
