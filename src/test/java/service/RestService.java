package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

public class RestService {
	
	public final static Gson gson = new Gson();
	
	public static HttpResponse sendPost(String endpoint, String requestBody) throws ClientProtocolException, IOException {

		HttpClient   httpClient    = HttpClientBuilder.create().build();
		HttpPost     post          = new HttpPost(endpoint);
		StringEntity postingString = null;
		
		try {
			postingString = new StringEntity(requestBody);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		post.setEntity(postingString);
		post.setHeader("Content-Type", "application/json");
		HttpResponse  response = httpClient.execute(post);
		
		return response;
	}
}
