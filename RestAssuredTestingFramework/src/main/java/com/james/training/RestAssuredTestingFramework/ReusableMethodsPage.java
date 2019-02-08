package com.james.training.RestAssuredTestingFramework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethodsPage {
    
    private static String sessionId;
    private static String deleteId;

    //reads the bytes in the xml file and return a string
    public static String generateStringFromXMLResource(String path) throws IOException{
        
        return new String(Files.readAllBytes(Paths.get(path)));
        
    }
    
    public static XmlPath rawToXML(Response response)
    {
        //convert the raw xml data from response into string
        String xmlResp = response.asString();
        System.out.println(xmlResp);
        //convert string resp to xml
        XmlPath xml = new XmlPath(xmlResp);
        return xml;
        
    }
    
    public static JsonPath rawToJson(Response r)
    { 
        String respon=r.asString();
      //  System.out.println(respon);
        JsonPath json=new JsonPath(respon);
        return json;
    }

    public static String getSessionKEY ()
    {
        return sessionId;
    }

    public static void setSessionKEY (String sessionKey)
    {
       sessionId = sessionKey;
        
    }

    public static String getDeleteId ()
    {
        return deleteId;
    }

    public static void setDeleteId (String deleteId)
    {
        ReusableMethodsPage.deleteId = deleteId;
    }
    
    
}
