package com.awsiot.springboot.sensorMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class SiteCheck {
	
	
	public static String BASEURI = "http://localhost:8080/api";
	public static String SENSOR = "/sensormap"; 	
	public static String DATASTREAM = "/all";
	public static String POST = "/post";
	public static String PUT = "/update";
	public static String DELETE = "/delete";
	
	public static int NOTFOUND = 404;
	public static int NEWCREATED = 201;
	public static int SUCCESSCODE = 200;
	
	
	
	@Test
	public void getDataReceivedStatus() {
		
		given()
			.baseUri(BASEURI+SENSOR).
		when()
			.get(DATASTREAM).
		then()
			.statusCode(SUCCESSCODE);
		
	}
	
	@Test
	public void testingDataStreamResponse() {
		given()
			.baseUri(BASEURI+SENSOR).
		when()
			.get(DATASTREAM).
		then()
			.extract()
			.response();
	}

	
}