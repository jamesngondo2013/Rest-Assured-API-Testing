package com.james.training.RestAssuredCucumber.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.james.training.RestAssuredCucumber.placesApi.pojo.AddPlace;
import com.james.training.RestAssuredCucumber.placesApi.pojo.Location;
import com.james.training.RestAssuredCucumber.testdata.TestDataBuild;
import com.james.training.RestAssuredCucumber.utils.APIResources;
import com.james.training.RestAssuredCucumber.utils.Payload;
import com.james.training.RestAssuredCucumber.utils.ReusableMethodsPage;
import com.james.training.RestAssuredCucumber.utils.Utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPlaceStepDefinition extends Utils{
	
	private RequestSpecification res;
	private Response response;
	private JsonPath js;
	
	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_Place_Payload_with(String name, String language, String address) throws Throwable {
		res = given().spec(getRequestSpecification())
				  .body(TestDataBuild.addPlace(name,language,address));
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_with_http_request(String apiResource, String httpMethod) throws Throwable {
		//get enum values
		APIResources resource = APIResources.valueOf(apiResource);
		
		System.out.println("API Resource called: " +resource.getResource());
		
		if (httpMethod.equalsIgnoreCase("POST")) {
			response = res.when()
								.post(resource.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("GET")) {
			response = res.when()
					.get(resource.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("PUT")) {
			response = res.when()
					.put(resource.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("DELETE")){
			response = res.when()
					.delete(resource.getResource());
		}
		//response = res.when()
		//					.post(resource.getResource()).
		//				then()
		//					 .assertThat().spec(getResponseSpecification()).extract().response();
	}

	@Then("^the API call is successful with status code (\\d+)$")
	public void the_API_call_is_successful_with_status_code(int statusCode) throws Throwable {
	   
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String jsonkey, String expectedVal) throws Throwable {
		
		String actualVal = getJsonPathKeyValue(response, jsonkey);
		//assert
		assertEquals(actualVal,expectedVal);
	}
	
	@Then("^verify that place_id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	public void verify_that_place_id_created_maps_to_using(String expectedName, String apiResource) throws Throwable {
		
		String placeId = getJsonPathKeyValue(response, "place_id");
		
		res = given().spec(getRequestSpecification()).queryParam("place_id", placeId);
		
		user_calls_with_http_request(apiResource, "GET");
		
		String actualName = getJsonPathKeyValue(response, "name");
		System.out.println("ActualName :" + actualName);
		assertEquals(actualName,expectedName);
	}

}
