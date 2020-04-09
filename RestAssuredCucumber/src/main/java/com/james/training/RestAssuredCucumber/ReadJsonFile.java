package com.james.training.RestAssuredCucumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {

	public static String getJsonString () throws IOException {

		/// RestAssuredCucumber/files/get_courses.json

		File file = new File("C:\\Users\\i350380\\eclipse-workspace\\RestAssuredCucumber\\files\\get_courses.json");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String json;
		while ((json = br.readLine()) != null) {
			System.out.println(json);
		}
		
		return json;

	}

}
