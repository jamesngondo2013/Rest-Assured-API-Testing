package com.james.training.RestAssuredCucumber.stepDefinitions;

import java.io.IOException;

import cucumber.api.java.Before;

public class Hooks {

	@Before("@deletePlace")
	public void beforeScenario() throws IOException {
		
		//write code to get place_id
		//execute this code only when place_is is null
		AddPlaceStepDefinition step = new AddPlaceStepDefinition();
		
		if (AddPlaceStepDefinition.placeId==null) {
			step.add_Place_Payload_with("Cool Jay", "Yao", "Mangochi, Malawi");
			step.user_calls_with_http_request("addPlaceAPI", "POST");
			step.verify_that_place_id_created_maps_to_using("Cool Jay", "getPlaceAPI");
		}
		
	}
}
