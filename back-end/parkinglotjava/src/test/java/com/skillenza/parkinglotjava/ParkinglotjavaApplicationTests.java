package com.skillenza.parkinglotjava;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotjavaApplicationTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveParking() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/api/parkings"), HttpMethod.GET, entity,
				String.class);
		String expected = "[{\"id\":1,\"lot\":\2\",\"vehicleNumber\":\1\",\"createdAt\":\"2018-06-12T10:00:00.000+0000\",\"parkingDuration\":\60\"}]";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void testCreateParkingLot() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/api/parkings"), HttpMethod.POST, entity,
				String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/api/parkings"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
