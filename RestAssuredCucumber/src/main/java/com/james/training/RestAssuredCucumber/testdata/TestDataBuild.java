package com.james.training.RestAssuredCucumber.testdata;

import java.util.ArrayList;
import java.util.List;

import com.james.training.RestAssuredCucumber.placesApi.pojo.AddPlace;
import com.james.training.RestAssuredCucumber.placesApi.pojo.Location;

public class TestDataBuild {

	/*
	 * POJO - Serialization
	 */
	public static AddPlace addPlace(String name, String language, String address) {

		Location location = new Location();
		location.setLat(-38.383489);
		location.setLng(33.426897);

		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setAddress(address);
		place.setLocation(location);
		place.setName(name);
		place.setPhone_number("+353 800 0000 11");
		place.setWebsite("www.j.ngondo.com");
		List<String> types = new ArrayList<String>();
		types.add("shop");
		types.add("shoe park");
		place.setTypes(types);
		place.setLanguage(language);

		return place;
	}
}
