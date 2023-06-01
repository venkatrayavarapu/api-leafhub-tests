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
		dataFileName = "TC002";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void addLearner(File file) {		
				
		Response response = postWithBodyAsFileAndUrl(file, "learner/add");
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 201);
		verifyContentWithKey(response, "message", "Learner Successfully Added");
	}


}




















