package com.ninjas.api.security;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) {
		passwordGenerator();

	}

	static void passwordGenerator() {

		URL url;
		try {
			url = new URL("https://api.api-ninjas.com/v1/passwordgenerator?length=16");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			connection.setRequestProperty("x-api-key", "TjE7T/Gs1TCXvUEzZBeZnw==ea7zJP0uVD6Bm1R3");
			InputStream responseStream = connection.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(responseStream);
			System.out.println(root.path("fact").asText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * static void aaa() { String theUrl =
	 * "https://api.api-ninjas.com/v1/passwordgenerator?length=16"; HttpClient
	 * httpclient = new HttpClient(); HttpGet request = new HttpGet(theUrl);
	 * request.addHeader("x-api-key", apiKey); HttpResponse response =
	 * httpclient.execute(request); }
	 */

	static void maquette() throws IOException {

		String serviceURL = "";
		URL myURL = new URL(serviceURL);
		HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();

		String userCredentials = "username:password";
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

		myURLConnection.setRequestProperty("Authorization", basicAuth);
		myURLConnection.setRequestMethod("POST");
		myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// myURLConnection.setRequestProperty("Content-Length", "" +
		// postData.getBytes().length);
		myURLConnection.setRequestProperty("Content-Language", "en-US");

		// Step 2: Add headers to the HttpURLConnection using setRequestProperty method.

		Map<String, String> headers = new HashMap<>();

		headers.put("X-CSRF-Token", "fetch");
		headers.put("content-type", "application/json");

		for (String headerKey : headers.keySet()) {
			myURLConnection.setRequestProperty(headerKey, headers.get(headerKey));
		}

		myURLConnection.setUseCaches(false);
		myURLConnection.setDoInput(true);
		myURLConnection.setDoOutput(true);
	}
	/*
	 * public static String getResponseFromJsonURL(String url) { String jsonResponse
	 * = null; if (CommonUtility.isNotEmpty(url)) { try {
	 *//************** For getting response from HTTP URL start ***************/
	/*
	 * URL object = new URL(url);
	 * 
	 * HttpURLConnection connection = (HttpURLConnection) object .openConnection();
	 * // int timeOut = connection.getReadTimeout(); connection.setReadTimeout(60 *
	 * 1000); connection.setConnectTimeout(60 * 1000); String
	 * authorization="xyz:xyz$123"; String
	 * encodedAuth="Basic "+Base64.encode(authorization.getBytes());
	 * connection.setRequestProperty("Authorization", encodedAuth); int responseCode
	 * = connection.getResponseCode(); //String responseMsg =
	 * connection.getResponseMessage();
	 * 
	 * if (responseCode == 200) { InputStream inputStr =
	 * connection.getInputStream(); String encoding =
	 * connection.getContentEncoding() == null ? "UTF-8" :
	 * connection.getContentEncoding(); jsonResponse = IOUtils.toString(inputStr,
	 * encoding);
	 *//************** For getting response from HTTP URL end ***************//*
																				 * 
																				 * } } catch (Exception e) {
																				 * e.printStackTrace();
																				 * 
																				 * } } return jsonResponse; }
																				 * 
																				 */
}
