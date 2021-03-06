package com.james.training.RestAssuredCucumber;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.RestAssuredCucumber.utils.Payload;
import com.james.training.RestAssuredCucumber.utils.ReusableMethodsPage;

import static io.restassured.RestAssured.given;

public class PlacesApiTest 
{
	@Test
	public void placesApi() {
		
		//Given()  - All the input details / params tec
		//when()   - I submit API -POST/GET/DELETE/UPDATE
		//Then     - Validate the response
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
				
		Response response  =        given()
										.log().all()
										.queryParam("key", "qaclick123")
										.header("Content-Type","application/json")
										.body(Payload.addPlace()).
									when()
										.post("maps/api/place/add/json").
									then()
										.assertThat().statusCode(200).body("scope", equalTo("APP"))
										.header("server", "Apache/2.4.18 (Ubuntu)").extract().response();
				
			System.out.println(response.asString());
			JsonPath js= ReusableMethodsPage.rawResponseToJson(response); //for parsing Json
			String placeId=js.getString("place_id");
				
			System.out.println(placeId);
		
		//Update Place
		String newAddress = "Summer Walk, Africa";
		
							given().log().all()
								.queryParam("key", "qaclick123")
								.header("Content-Type","application/json")
								.body(Payload.updatePlace(placeId, newAddress)).
							when()
								.put("maps/api/place/update/json").
							then()
								.assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get Place
		
	Response getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
									.queryParam("place_id",placeId).
								when()
									.get(Payload.getPlace()).
								then()
									.assertThat().log().all().statusCode(200).extract().response();
	
	JsonPath js1=ReusableMethodsPage.rawResponseToJson(getPlaceResponse);
	String actualAddress =js1.getString("address");
	System.out.println(actualAddress);
	Assert.assertEquals(actualAddress, newAddress); // pass
	//Assert.assertEquals(actualAddress, "Pacific ocean"); //fails
	//Cucumber Junit, Testng
	}
	
	@Test
	public void placesApiJsonHashMap() {
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		
		Map<String, Object> mapLocation = new HashMap<>();
		mapLocation.put("lat", 12);
		mapLocation.put("lng", -32);
		Map<String, Object> jsonMapPlacesApiLocation = new HashMap<>();
		jsonMapPlacesApiLocation.put("location", mapLocation);
		jsonMapPlacesApiLocation.put("accuracy", 50);
		jsonMapPlacesApiLocation.put("name", "Bishop Shanks");
		jsonMapPlacesApiLocation.put("phone_number", "+353 89951000");
		jsonMapPlacesApiLocation.put("address", "90 Killen, Ireland");
		
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		jsonMapPlacesApiLocation.put("types", types);
		jsonMapPlacesApiLocation.put("website", "www.techonologywolves.com");
		jsonMapPlacesApiLocation.put("language","Tumbuka");
		
		Response response  =        given()
										.log().all()
										.queryParam("key", "qaclick123")
										.header("Content-Type","application/json")
										.body(jsonMapPlacesApiLocation).
									when()
										.post("maps/api/place/add/json").
									then()
										.assertThat().statusCode(200).body("scope", equalTo("APP"))
										.header("server", "Apache/2.4.18 (Ubuntu)").extract().response();
				
			System.out.println(response.asString());
			JsonPath js= ReusableMethodsPage.rawResponseToJson(response); //for parsing Json
			String placeId=js.getString("place_id");
				
			System.out.println(placeId);
	}
}
