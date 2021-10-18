package controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import model.Model;
import model.User;
import model.login.LoginUser;
import model.register.RegisterUser;
import service.RestService;
import utils.EnumEndPoint;
import utils.Util;

public class RestController {
	
	Gson gson = Util.gson;
	
	
	public Model registerUser(String username, String password) {
		HttpResponse response = null;
		Model modelHttpResponse = null;
		
		User user = createUser();
		
		if(username != null)
			user.setUsername(username);
		
		RegisterUser registerUser = new RegisterUser();
		// create login
		registerUser.setApiVersion("5.3.0");
		registerUser.setPartnerId(3197);
		registerUser.setPassword(password != null ? password : "password_SlLVWDLl");
		
		registerUser.setUser(user);
		
		try {
			// API Call
			response = RestService.sendPost(EnumEndPoint.CREATE_USER_POST.getValue(), gson.toJson(registerUser));
			modelHttpResponse = new Model(gson.toJson(registerUser),
					response.getAllHeaders(),
					EntityUtils.toString(response.getEntity()), null);	
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return modelHttpResponse;
	}
	
	// This method will create and register user to 
	public Model registerUser() {
		return registerUser(null,null);
	}


	private User createUser() {
		User user = new User();
		user.setObjectType("KalturaOTTUser");
		user.setUsername("BeTester_" + Util.getRandomNumber(1, 10000000));
		user.setFirstName("ott_user_lWkiwzTJJGYI");
		user.setLastName("3444444444412123");
		user.setEmail("BeqasTestingsd@gmail.com");
		user.setAddress("orrs_test_lost in some address");
		user.setCity("uncharted 2 among thieves lost city");
		user.setCountryId(5);
		user.setExternalId(Util.getRandomNumber(1, 10000000) +"");
		return user;
	}


	// this method will check if user exit and return it.
	public Model loginUser(String username, String password) {
		LoginUser loginUser = new LoginUser();
		
		loginUser.setApiVersion("5.3.0");
		loginUser.setPartnerId(3197);
		loginUser.setUsername(username);
		loginUser.setPassword(password);

		HttpResponse response = null;
		Model modelHttpResponse = null;
		
		try {
			// API Call
			response = RestService.sendPost(EnumEndPoint.LOGIN_USER_POST.getValue(), gson.toJson(loginUser));
			modelHttpResponse = new Model(gson.toJson(loginUser),
					response.getAllHeaders(),
					EntityUtils.toString(response.getEntity()),null);	
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return modelHttpResponse;
	}
	
	
	

	
	
}