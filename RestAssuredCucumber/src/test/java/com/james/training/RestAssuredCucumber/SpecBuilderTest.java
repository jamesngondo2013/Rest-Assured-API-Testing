package com.james.training.RestAssuredCucumber;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.RestAssuredCucumber.utils.Payload;
import com.james.training.RestAssuredCucumber.utils.ReusableMethodsPage;
import com.james.training.RestAssuredCucumber.utils.SpecBuilders;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SpecBuilderTest {
	
	@Test
	public void placesApi() {
		
		//Given()  - All the input details / params tec
		//when()   - I submit API -POST/GET/DELETE/UPDATE
		//Then     - Validate the response
		
		//RestAssured.baseURI= "https://rahulshettyacademy.com";
				
		Response response  =        given()
										.spec(SpecBuilders.getRequestSpecification()).log().all()
										.body(Payload.addPlace()).
									when()
										.post("maps/api/place/add/json").
									then()
										.assertThat().spec(SpecBuilders.getResponseSpecification()).extract().response();
				
			System.out.println(response.asString());
			JsonPath js= ReusableMethodsPage.rawToJson(response); //for parsing Json
			String placeId=js.getString("place_id");
				
			System.out.println(placeId);
		
		//Update Place
		String newAddress = "Summer Walk, Africa";
		
							given()
								.spec(SpecBuilders.getRequestSpecification()).log().all()
								.body(Payload.updatePlace(placeId, newAddress)).
							when()
								.put("maps/api/place/update/json").
							then()
								.assertThat().log().all().spec(SpecBuilders.getUpdateResponseSpecification());
		
		//Get Place
		
	Response getPlaceResponse=	given().spec(SpecBuilders.getPlaceIdRequestSpecification("place_id", placeId)).
								when()
									.get(Payload.getPlace()).
								then()
									.assertThat().log().all().spec(SpecBuilders.getPlaceResponseSpecification()).extract().response();
	
	JsonPath js1=ReusableMethodsPage.rawToJson(getPlaceResponse);
	String actualAddress =js1.getString("address");
	System.out.println("Actual Address: "+actualAddress);
	Assert.assertEquals(actualAddress, newAddress); // pass
	//Assert.assertEquals(actualAddress, "Pacific ocean"); //fails
	//Cucumber Junit, Testng
	}
}
