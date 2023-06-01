package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC002_AddLearner extends RESTAssuredBase{
	
	@BeforeTest 
	public void setValues() {
		testCaseName = "Add Learner (API)";
		testDescription = "Add new learner";
		authors = "Babu";
		category = "API";
		nodes="Learner";
	}

	@Test
	public void addLearner() {		
		
		String file = "{\r\n"
				+ "    \"title\": \"Mr.\",\r\n"
				+ "    \"firstName\": \"Babu\",\r\n"
				+ "    \"middleName\": \"\",\r\n"
				+ "    \"lastName\": \"Manickam\",\r\n"
				+ "    \"age\": 45,\r\n"
				+ "    \"address\": \"Chennai\",\r\n"
				+ "    \"email\": \"hello@testleaf.com\",\r\n"
				+ "    \"gender\": \"M\",\r\n"
				+ "    \"mobile\": \"9390839290\",\r\n"
				+ "    \"phoneNumber\": \"9390839290\"\r\n"
				+ "}";
		
		Response response = postWithJsonAsBody(file, "learner/add");
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 201);
		verifyContentWithKey(response, "message", "Learner Successfully Added");
	}


}




















