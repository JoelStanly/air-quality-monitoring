package com.awsiot.springboot.sensor;

import static io.restassured.RestAssured.given;

import java.util.Random;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.awsiot.springboot.util.FileUtil;

import io.restassured.http.ContentType;

public class MockPosting {
	
	JSONObject data = new JSONObject();
  @Test
  public void postData() {
	  @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	  Random rd = new Random();
	  boolean breakCode = false;
	  while(!breakCode) {
		  try {
			  	System.out.println("Enter the Sensor ID");
			  	data.put("sensorid", scan.next());
				data.put("c", FileUtil.randomLongValue());
				data.put("co",FileUtil.randomLongValue());
				data.put("co2", FileUtil.randomLongValue());
				data.put("o2", FileUtil.randomLongValue());
				data.put("so2", FileUtil.randomLongValue());
				data.put("safe", rd.nextBoolean());
				data.put("co2", FileUtil.randomLongValue());
				data.put("n", FileUtil.randomLongValue());
				data.put("co", FileUtil.randomLongValue());
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		  
			given().baseUri(SiteCheck.BASEURI + SiteCheck.SENSOR).contentType(ContentType.JSON).body(data.toString()).when()
					.post(SiteCheck.POST).then().statusCode(SiteCheck.NEWCREATED);
			
			System.out.println("Posted a value into the DB");
			
			System.out.println("Do you want to break?");
			breakCode = scan.nextBoolean();
			
	  }
	  
  }
}
