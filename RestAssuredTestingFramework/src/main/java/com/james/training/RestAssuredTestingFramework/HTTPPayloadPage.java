package com.james.training.RestAssuredTestingFramework;


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
    //delete data
    public static String getDeleteDataPayloadJson(String id)
    {
        String body ="{"+
                "\"place_id\":\""+id+"\""+                         
            "}";
        
        return body;
    }
    
    //delete book by id - json payload request
    public static String deleteBookDataPayloadJson(String id)
    {
        String body ="{"+
                "\"ID\":\""+id+"\""+                         
            "}";
        
        return body;
    }
    
    //add book isle and isbn to payload request
    public String addBookToPayload(String isbn,String aisle){
        
        String payload ="{\r\n\r\n\"name\":\"Java Propgramming\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\": \""+aisle+"\",\r\n\"author\":\"James Ngondo\"\r\n}\r\n";
        
        return payload;
    }
   
    //add all book attributes to payload request
    public String addBookToPayload(String isbn,String aisle,String book_name,String author){
           
        String payload ="{\r\n\r\n\"name\":\""+book_name+"\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\": \""+aisle+"\",\r\n\"author\":\""+author+"\"\r\n}\r\n";
        
        return payload;
    }
    
    
   
    
    
   
}
