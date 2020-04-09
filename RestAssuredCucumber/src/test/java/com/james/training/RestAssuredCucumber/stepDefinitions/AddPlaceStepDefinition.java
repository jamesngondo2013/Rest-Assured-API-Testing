package com.james.training.RestAssuredCucumber.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.james.training.RestAssuredCucumber.placesApi.pojo.AddPlace;
import com.james.training.RestAssuredCucumber.placesApi.pojo.Location;
import com.james.training.RestAssuredCucumber.utils.Payload;
import com.james.training.RestAssuredCucumber.utils.SpecBuilders;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPlaceStepDefinition {
	
	RequestSpecification res;
	Response response;

	@Given("^Add Place Payload$")
	public void add_Place_Payload() throws Throwable {
		Location location = new Location();
		location.setLat(-38.383489);
		location.setLng(33.426897);

		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setAddress("179 The Tramyard, Inchicore, Dublin 8");
		place.setLocation(location);
		place.setName("James Keith Chingotah");
		place.setPhone_number("+353 800 0000 11");
		place.setWebsite("www.j.ngondo.com");
		List<String> types = new ArrayList<String>();
		types.add("shop");
		types.add("shoe park");
		place.setTypes(types);
		place.setLanguage("Chichewa");

		//RestAssured.baseURI = "https://rahulshettyacademy.com";

		res = given().spec(SpecBuilders.getRequestSpecification()).log().all()
					  .body(Payload.addPlace());
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_with_http_request(String arg1, String arg2) throws Throwable {
		response = res.when()
							.post("maps/api/place/add/json").
						then()
							 .assertThat().log().all().spec(SpecBuilders.getResponseSpecification()).extract().response();
	}

	@Then("^the API call is successful with status code (\\d+)$")
	public void the_API_call_is_successful_with_status_code(int statusCode) throws Throwable {
	   
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String jsonkeyVal, String expectedVal) throws Throwable {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		
		assertEquals(js.get(jsonkeyVal).toString(),expectedVal);
	}

}
