package com.awsiot.springboot.sensorMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PostPutDelete {

	JSONObject data = new JSONObject();
	long sensorid = 8L;

	public PostPutDelete() {
		super();

		// Mock data to testing

		try {
			data.put("floor", 1);
			data.put("room", 2);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void postingData() {
		// Posting a data to the server

		given().baseUri(SiteCheck.BASEURI + SiteCheck.SENSOR).contentType(ContentType.JSON).body(data.toString()).when()
				.post(SiteCheck.POST).then().statusCode(SiteCheck.SUCCESSCODE);

	}

	@Test
	public void puttingData() {
		// Updating the entire data to the server
		given().baseUri(SiteCheck.BASEURI + SiteCheck.SENSOR).contentType(ContentType.JSON).body(data.toString()).when()
				.put(SiteCheck.PUT+"/2").then().statusCode(SiteCheck.SUCCESSCODE);

	}

	@Test
	public void deleteData() {
		// Deleting the data from the server

		given().baseUri(SiteCheck.BASEURI + SiteCheck.SENSOR).contentType(ContentType.JSON).when()
				.delete(SiteCheck.DELETE+"/2").then().statusCode(SiteCheck.SUCCESSCODE);

		System.out.println("The sensor that is Deleted");
	}

}
