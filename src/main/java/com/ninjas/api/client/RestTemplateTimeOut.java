package com.ninjas.api.client;

import java.util.Arrays;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;



public class RestTemplateTimeOut {

	private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";

	private static ClientHttpRequestFactory getClientHttpRequestFactory() {

		// Create an instance of Apache HttpClient
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
		= new HttpComponentsClientHttpRequestFactory();

		int connectTimeout = 5000;
		int readTimeout = 5000;

		clientHttpRequestFactory.setConnectTimeout(connectTimeout);
		// clientHttpRequestFactory.set(readTimeout);

		return clientHttpRequestFactory;
	}

	public static void main(String[] args) {
		RestTemplateTimeOut springRestClient = new RestTemplateTimeOut();


		// Step3: get all employees
		RestTemplateTimeOut.getEmployees();


	}

	public void fetchProducts() {
		RestTemplate restTemplate = new RestTemplate(
				getClientHttpRequestFactory());

	}


	private static void getEmployees() {

		RestTemplate restTemplate = null;
		try {
			restTemplate = new RestTemplate(
					getClientHttpRequestFactory());


			System.out.println("--------get employees-----------");
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("X-Api-Key", "YOUR_API_KEY");
			headers.setContentType(MediaType.APPLICATION_JSON);


			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			System.out.println(new Date());
			ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
					String.class);

			System.out.println(result);
			System.out.println(result.getStatusCode());
			System.out.println(result.getStatusCodeValue());
			System.out.println(result.getHeaders());
			System.out.println(result.getBody());
			System.out.println(result.accepted().toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		System.out.println(new Date());

	}

}
