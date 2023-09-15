package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC001_VerifyLogin extends RESTAssuredBase{
	
	@BeforeTest 
	public void setValues() {
		testCaseName = "Login (API)";
		testDescription = "Verify Login Credentials";
		authors = "Babu";
		category = "API";
		nodes="Login";
	}

	@Test
	public void verifyLogin() {		
		
		String file = "{\r\n"
				+ "    \"userName\": \"Babu\",\r\n"
				+ "    \"password\": \"admin\"\r\n"
				+ "}";
		
		Response response = postWithJsonAsBody(file, "login");
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 200);
		verifyContentWithKey(response, "message", "Verified User Successfully");
	}


}




















