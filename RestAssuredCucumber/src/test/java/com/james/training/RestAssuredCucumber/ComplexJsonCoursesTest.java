package com.james.training.RestAssuredCucumber;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.james.training.RestAssuredCucumber.placesApi.pojo.AddPlace;
import com.james.training.RestAssuredCucumber.placesApi.pojo.Location;
import com.james.training.RestAssuredCucumber.pojo.Api;
import com.james.training.RestAssuredCucumber.pojo.GetCourse;
import com.james.training.RestAssuredCucumber.utils.Payload;
import com.james.training.RestAssuredCucumber.utils.ReusableMethodsPage;
import com.james.training.RestAssuredCucumber.utils.SpecBuilders;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ComplexJsonCoursesTest {

	@Test
	public void getComplexJsonCourses() {

		JsonPath js = new JsonPath(Payload.coursePrice());
		// Print No of courses returned by API

		int count = js.getInt("courses.size()");
		System.out.println("Total Courses: " + count);
		// Print Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Total Purchase Amount: " + totalAmount);
		// Print Title of the first course

		String titleFirstCourse = js.get("courses[2].title");
		System.out.println("1st Course Title: " + titleFirstCourse);

		// Print All course titles and their respective Prices

		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			System.out.println("Course Title: " + courseTitles);
			System.out.println("Course Price: " + js.get("courses[" + i + "].price").toString());
			System.out.println("----");

		}
		// Print no of copies sold by RPA Course

		String courseTitles = null;
		int copies = 0;

		for (int i = 0; i < count; i++) {

			courseTitles = js.get("courses[" + i + "].title");

			if (courseTitles.equalsIgnoreCase("RPA")) {
				copies = js.get("courses[" + i + "].copies");
				// System.out.println("Copies: " + copies);
				break;
			}

		}
		System.out.println("No. of copies sold by " + courseTitles + ": " + copies);

		// Print Total Amount for purchases
		double totalAmountSum=0.00;

		for (int i = 0; i < count; i++) {

			int numOfCopies = js.get("courses[" + i + "].copies");
			int price = js.get("courses[" + i + "].price");
			totalAmountSum += numOfCopies*price;

		}
		
		System.out.println("Total Amount Sum: " + totalAmountSum);
		Assert.assertEquals(totalAmount, totalAmountSum); 

	}
	
	@Test
	public void testPOJODeserializationJsonCourses() throws IOException {
		String[] courseTitles = { "Rest Assured Java", "SoupUI web services testing" };
		//JsonPath js = new JsonPath(ReadJsonFile.getJsonString());
		/*
		GetCourse response=	given().queryParam("key", "qaclick123").expect().defaultParser(Parser.JSON)
				
							.when()
								.get(Payload.getPlace()).as(GetCourse.class);
		*/
		ObjectMapper mapper = new ObjectMapper();

		//JSON file to Java object
		GetCourse obj = mapper.readValue(new File("C:\\Users\\i350380\\eclipse-workspace\\RestAssuredCucumber\\files\\get_courses.json"), GetCourse.class);

		System.out.println("LinkedIn URL: "+ obj.getLinkedIn());
		
		System.out.println("Courses:");
		List<Api> apiCourses = obj.getCourses().getApi();
		
		for (int i = 0; i < apiCourses.size(); i++) {
			System.out.println("Course Title: " + obj.getCourses().getApi().get(i).getCourseTitle() + "--> Price: " + apiCourses.get(i).getPrice());
			
			//if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Java")) {
			//	System.out.println("Price :" + apiCourses.get(i).getPrice());
				
			//}
		}
		
		//assert courseTitles
		List<String> actualList = new ArrayList<String>();
		for (int i = 0; i < apiCourses.size(); i++) {
			actualList.add(apiCourses.get(i).getCourseTitle());
		}
		List<String> expectedList = Arrays.asList(courseTitles);
		
		Assert.assertTrue(actualList.equals(expectedList));
		
	}
	
	@Test
	public void placesApiSerialization() {
		
		// Given() - All the input details / params tec
		// when() - I submit API -POST/GET/DELETE/UPDATE
		// Then - Validate the response

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

		RequestSpecification res = given().spec(SpecBuilders.getRequestSpecification()).log().all()
										.body(Payload.addPlace());
		
		Response response=		res.when()
										.post("maps/api/place/add/json").
									then()
										.assertThat().log().all().spec(SpecBuilders.getResponseSpecification()).extract().response();

		System.out.println(response.asString());
		JsonPath js = ReusableMethodsPage.rawToJson(response); // for parsing Json
		String placeId = js.getString("place_id");

		System.out.println(placeId);
		
	}


}
