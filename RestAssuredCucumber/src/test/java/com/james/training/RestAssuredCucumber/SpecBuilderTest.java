package com.james.training.RestAssuredCucumber;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.RestAssuredCucumber.utils.Payload;
import com.james.training.RestAssuredCucumber.utils.ReusableMethodsPage;
import com.james.training.RestAssuredCucumber.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SpecBuilderTest extends Utils{
	
	@Test
	public void placesApi() throws IOException {
		
		//Given()  - All the input details / params tec
		//when()   - I submit API -POST/GET/DELETE/UPDATE
		//Then     - Validate the response
		
		//RestAssured.baseURI= "https://rahulshettyacademy.com";
				
		Response response  =        given()
										.spec(getRequestSpecification()).log().all()
										.body(Payload.addPlace()).
									when()
										.post("maps/api/place/add/json").
									then()
										.assertThat().spec(getResponseSpecification()).extract().response();
				
			System.out.println(response.asString());
			JsonPath js= ReusableMethodsPage.rawResponseToJson(response); //for parsing Json
			String placeId=js.getString("place_id");
				
			System.out.println(placeId);
		
		//Update Place
		String newAddress = "Summer Walk, Africa";
		
							given()
								.spec(getRequestSpecification()).log().all()
								.body(Payload.updatePlace(placeId, newAddress)).
							when()
								.put("maps/api/place/update/json").
							then()
								.assertThat().log().all().spec(getUpdateResponseSpecification());
		
		//Get Place
		
	Response getPlaceResponse=	given().spec(getRequestSpecification()).queryParam("place_id", placeId)
								.when()
									.get(Payload.getPlace()).
								then()
									.assertThat().log().all().spec(getPlaceResponseSpecification()).extract().response();
	
	JsonPath js1=ReusableMethodsPage.rawResponseToJson(getPlaceResponse);
	String actualAddress =js1.getString("address");
	System.out.println("Actual Address: "+actualAddress);
	Assert.assertEquals(actualAddress, newAddress); // pass
	//Assert.assertEquals(actualAddress, "Pacific ocean"); //fails
	//Cucumber Junit, Testng
	}
}
