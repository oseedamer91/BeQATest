package com.api.proj.beAutomationTest;


import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import controller.RestController;
import model.Model;
import utils.EnumEndPoint;
import utils.Util;





public class BeTest {
	
	private RestController rc = null;
	private String username = null;
	private String password = null;
	
	@BeforeTest
	public void initSetup() {
		System.out.println("----- init setup -----");
		rc = new RestController();
	}
	
	@Test(priority = 1)
	public void registerUserTest() throws ClientProtocolException, IOException {
		
		System.out.println("************** Calling API request for register **************");
		
		Model modelHttpResponse = rc.registerUser();
		
		// save username & password
		username =  new JSONObject(new JSONObject(modelHttpResponse.getRequest()).get("user").toString()).get("username").toString();
		password = new JSONObject(modelHttpResponse.getRequest()).get("password").toString();
		
		JSONObject actual = new JSONObject(modelHttpResponse.getBodyResponse());
		JSONObject res = new JSONObject(actual.get("result").toString());
		
		// log request and response
		Util.logToConsole(EnumEndPoint.CREATE_USER_POST, modelHttpResponse);
		
		// make sure if any header exist
		Assert.assertNotNull(modelHttpResponse.getHeaderResponse()[0]);
		
		// make sure id exit and is of type string
		Assert.assertTrue(res.get("id") != null && res.get("id") instanceof String);
		
		// make sure contryId exit and is of type integer
		Assert.assertTrue(res.get("countryId") != null && res.get("countryId") instanceof Integer);	
		
	}
	
	@Test(priority = 2)
	public void loginUserTest() throws IOException {
		System.out.println("************** Calling API request for login **************");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Model modelHttpResponse = rc.loginUser(username,password);
		
		// log to console the request and response
		Util.logToConsole(EnumEndPoint.LOGIN_USER_POST, modelHttpResponse);
		
		JSONObject actual = new JSONObject(modelHttpResponse.getBodyResponse());
		JSONObject result = new JSONObject(actual.get("result").toString());
		JSONObject user = new JSONObject(result.get("user").toString());
		
		System.out.println();
		Assert.assertTrue(user.get("lastLoginDate") != null);
		System.out.println("lastLoginDate: " + format.format(user.get("lastLoginDate")));
	}


	@Test(priority = 3)
	public void registerUserTestWithParams() throws ClientProtocolException, IOException {
		
		System.out.println("************** Calling API request for register with username **************");
		
		System.out.println(username + " " + password);
		Model modelHttpResponse = rc.registerUser(username, password);
		
		// log request and response
		Util.logToConsole(EnumEndPoint.CREATE_USER_POST, modelHttpResponse);
				
		// save username & password
		JSONObject actual = new JSONObject(modelHttpResponse.getBodyResponse());
		JSONObject result = new JSONObject(actual.get("result").toString());
		JSONObject error = new JSONObject(result.get("error").toString());

		if(error.get("message") != null) {
			System.out.println("Exception error found: " + error.get("message").toString());
		}


	}

}
