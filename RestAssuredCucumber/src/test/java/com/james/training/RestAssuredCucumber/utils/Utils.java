package com.james.training.RestAssuredCucumber.utils;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	private static PrintStream log;
	private Properties prop;
	private FileInputStream fis;
	
	public RequestSpecification getRequestSpecification() throws IOException {
		log = new PrintStream(new FileOutputStream("logging.txt",true));
	    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	    requestSpecBuilder.setBaseUri(getDataconfigProperties().getProperty("baseURL"));
	    requestSpecBuilder.addQueryParam("key", getDataconfigProperties().getProperty("KEY"));
	    requestSpecBuilder.setContentType(ContentType.JSON);
	    //add logging functionality to requestSpecBuilder object - log both request and response to text file
	    requestSpecBuilder.addFilter(RequestLoggingFilter.logRequestTo(log));
	    requestSpecBuilder.addFilter(ResponseLoggingFilter.logResponseTo(log));
	    return requestSpecBuilder.build();
	}
	
	public RequestSpecification getPlaceIdRequestSpecification(String id, String placeId) throws FileNotFoundException, IOException {
	    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	    requestSpecBuilder.setBaseUri(getDataconfigProperties().getProperty("baseURL"));
	    requestSpecBuilder.addQueryParam("key", getDataconfigProperties().getProperty("KEY"));
	    requestSpecBuilder.addQueryParam(id,placeId);
	    requestSpecBuilder.setContentType(ContentType.JSON);
	    return requestSpecBuilder.build();
	}
	
	public ResponseSpecification getUpdateResponseSpecification() {
	    
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    builder.expectStatusCode(200);
	    builder.expectContentType(ContentType.JSON);
	    builder.expectBody("msg", equalTo("Address successfully updated"));
	    return builder.build();
	}
	
	public ResponseSpecification getPlaceResponseSpecification() {
	    ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    builder.expectStatusCode(200);
	    builder.expectContentType(ContentType.JSON);
	    builder.expectHeader("server", "Apache/2.4.18 (Ubuntu)");
	    return builder.build();
	}
	
	public ResponseSpecification getResponseSpecification() {
	    ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    builder.expectStatusCode(200);
	    builder.expectContentType(ContentType.JSON);
	    builder.expectBody("scope", equalTo("APP"));
	    builder.expectHeader("server", "Apache/2.4.18 (Ubuntu)");
	    return builder.build();
	}
	
	 public Properties getDataconfigProperties() throws IOException, FileNotFoundException{
	        
	        prop = new Properties();
	        fis = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
	        prop.load(fis);
			return prop;
	        
	    }
}
