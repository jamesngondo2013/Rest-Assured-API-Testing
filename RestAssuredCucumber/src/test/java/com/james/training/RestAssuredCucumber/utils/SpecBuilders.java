package com.james.training.RestAssuredCucumber.utils;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {

	public static RequestSpecification getRequestSpecification() {
	    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	    requestSpecBuilder.setBaseUri("https://rahulshettyacademy.com");
	    requestSpecBuilder.addQueryParam("key", "qaclick123");
	    requestSpecBuilder.setContentType(ContentType.JSON);
	    return requestSpecBuilder.build();
	}
	
	public static RequestSpecification getPlaceIdRequestSpecification(String id, String placeId) {
	    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	    requestSpecBuilder.setBaseUri("https://rahulshettyacademy.com");
	    requestSpecBuilder.addQueryParam("key", "qaclick123");
	    requestSpecBuilder.addQueryParam(id,placeId);
	    requestSpecBuilder.setContentType(ContentType.JSON);
	    return requestSpecBuilder.build();
	}
	
	public static ResponseSpecification getUpdateResponseSpecification() {
	    ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    builder.expectStatusCode(200);
	    builder.expectContentType(ContentType.JSON);
	    builder.expectBody("msg", equalTo("Address successfully updated"));
	    return builder.build();
	}
	
	public static ResponseSpecification getPlaceResponseSpecification() {
	    ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    builder.expectStatusCode(200);
	    builder.expectContentType(ContentType.JSON);
	    builder.expectHeader("server", "Apache/2.4.18 (Ubuntu)");
	    return builder.build();
	}
	
	public static ResponseSpecification getResponseSpecification() {
	    ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    builder.expectStatusCode(200);
	    builder.expectContentType(ContentType.JSON);
	    builder.expectBody("scope", equalTo("APP"));
	    builder.expectHeader("server", "Apache/2.4.18 (Ubuntu)");
	    return builder.build();
	}
}
