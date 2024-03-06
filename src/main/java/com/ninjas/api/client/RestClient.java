package com.ninjas.api.client;

import java.util.Arrays;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class RestClient {

	private
	static 
	final String 
	GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";

	private
	static 
	final String 
	GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";

	private
	static 
	final String 
	CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";

	private
	static 
	final String 
	UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";

	private
	static 
	final String 
	DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";

	private
	static RestTemplate 
	restTemplate = new RestTemplate();


	public static void main(String[] args) {
		RestClient springRestClient =
				new RestClient();


		springRestClient.getNinjas();


		springRestClient.getOptionsForAllow();


	}
	
	private
	void getNinjas() {

		System.out.println("--------get Ninjas-----------");

		String url= 
				"https://api.api-ninjas.com/v1/chucknorris";
		url = "https://api.api-ninjas.com/v1/passwordgenerator?length=16";

		HttpHeaders headers =
				new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		headers.set("X-Api-Key",
				"TjE7T/Gs1TCXvUEzZBeZnw==ea7zJP0uVD6Bm1R3");

		headers.setContentType(MediaType.APPLICATION_JSON);



		HttpEntity<String> entity =
				new HttpEntity<String>("parameters",
						headers);


		ResponseEntity<String> result =	restTemplate.exchange(url, HttpMethod.GET,entity,	String.class);


		System.out.println(result);
		System.out.println(result.getStatusCode());
		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getHeaders());
		System.out.println(result.getBody());
		System.out.println(result.accepted().toString());


	}


	private
	void getOptionsForAllow() {

		System.out.println("--------get optionsForAllow-----------");

		Set<HttpMethod> optionsForAllow =
				restTemplate.optionsForAllow(GET_EMPLOYEES_ENDPOINT_URL);

		HttpHeaders httpHeaders =
				restTemplate.headForHeaders(GET_EMPLOYEES_ENDPOINT_URL);


		System.out.println("optionsForAllow="+optionsForAllow);

		System.out.println("httpHeaders="+httpHeaders);

	}


}
