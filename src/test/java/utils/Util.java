package utils;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import model.Model;

public class Util {
	
	public final static Gson gson = new Gson();
	
	public static void logToConsole(EnumEndPoint endpoint, Model modelHttpReqest) throws IOException {
		// log request
		System.out.println("Request: ");
		System.out.println("Url: " + endpoint.getValue());
		System.out.println("Data: " + modelHttpReqest.getRequest());
		
		System.out.println("Response: ");
		System.out.println("Headers: " + Arrays.toString(modelHttpReqest.getHeaderResponse()));
		System.out.println("Body: " + modelHttpReqest.getBodyResponse());
	}
	
	public static int getRandomNumber(int min, long max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
}
