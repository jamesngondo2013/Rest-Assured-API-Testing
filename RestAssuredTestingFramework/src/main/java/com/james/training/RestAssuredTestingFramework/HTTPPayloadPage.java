package com.james.training.RestAssuredTestingFramework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTTPPayloadPage {

    public static String getPostDataPayloadJson()
    {
        String body ="{"+
                "\"location\":"+
            "\"lat\": -33.8669711,"+
            "\"lng\": 151.1958751 "+       
            "},"+
            "\"accuracy\": 50,"+
            "\"name\": \"James Ngondo House\","+
            "\"phone\": \"+353(0)89953354999\","+
            "\"address\": \"Spa Road, Dublin 8, Ireland\","+
            "\"types\": [\"Bibles\"],"+
            "\"website\": \"http://www.jamesngondo.com/\","+
            "\"language\": \"Chichewa\""+
           "}";
        
        return body;
    }
    
    public static String getDeleteDataPayloadJson(String id)
    {
        String body ="{"+
                "\"place_id\":\""+id+"\""+                         
            "}";
        
        return body;
    }
   
}
