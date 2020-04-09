package com.james.training.RestAssuredCucumber.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.james.training.RestAssuredCucumber.placesApi.pojo.AddPlace;
import com.james.training.RestAssuredCucumber.placesApi.pojo.Location;
import com.james.training.RestAssuredCucumber.testdata.TestDataBuild;
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
	
	RequestSpecification res;
	Response response;
	
	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_Place_Payload_with(String name, String language, String address) throws Throwable {
		res = given().spec(getRequestSpecification())
				  .body(TestDataBuild.addPlace(name,language,address));
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_with_http_request(String arg1, String arg2) throws Throwable {
		response = res.when()
							.post("maps/api/place/add/json").
						then()
							 .assertThat().spec(getResponseSpecification()).extract().response();
	}

	@Then("^the API call is successful with status code (\\d+)$")
	public void the_API_call_is_successful_with_status_code(int statusCode) throws Throwable {
	   
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String jsonkeyVal, String expectedVal) throws Throwable {
		String resp = response.asString();
		JsonPath js = ReusableMethodsPage.rawStringToJson(resp);
		//assert
		assertEquals(js.get(jsonkeyVal).toString(),expectedVal);
	}

}
