package com.awsiot.springboot.sensorMap;

import static io.restassured.RestAssured.given;

import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class MockPosting {
	
	JSONObject data = new JSONObject();
  @Test
  public void postData() {
	  @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	  boolean breakCode = false;
	  while(!breakCode) {
		  try {
				data.put("floor", (int)Math.random()*(3-1+1)+1);
				data.put("room", (int)Math.random()*(4-1+1)+1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		  
			given().baseUri(SiteCheck.BASEURI + SiteCheck.SENSOR).contentType(ContentType.JSON).body(data.toString()).when()
					.post(SiteCheck.POST).then().statusCode(SiteCheck.SUCCESSCODE);
			
			System.out.println("Posted a value into the DB");
			
			System.out.println("Do you want to break?");
			breakCode = scan.nextBoolean();
			
	  }
	  
  }
}
