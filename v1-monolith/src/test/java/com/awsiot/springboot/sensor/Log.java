package com.awsiot.springboot.sensor;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Log {
	@Test
	public void logAll() {
		given().baseUri(SiteCheck.BASEURI+SiteCheck.SENSOR).when().get(SiteCheck.DATASTREAM).then().log().everything();
	}

	@Test
	public void logBody() {
		given().baseUri(SiteCheck.BASEURI+SiteCheck.SENSOR).when().get(SiteCheck.DATASTREAM).then().log().body();
	}

	@Test
	public void logHeader() {
		given().baseUri(SiteCheck.BASEURI+SiteCheck.SENSOR).when().get(SiteCheck.DATASTREAM).then().log().headers();
	}

	@Test
	public void logStatus() {
		given().baseUri(SiteCheck.BASEURI+SiteCheck.SENSOR).when().get(SiteCheck.DATASTREAM).then().log().status();
	}

	@Test
	public void logCookies() {
		given().baseUri(SiteCheck.BASEURI+SiteCheck.SENSOR).when().get(SiteCheck.DATASTREAM).then().log().cookies();
	}

	@Test
	public void logError() {
		given().baseUri(SiteCheck.BASEURI+SiteCheck.SENSOR).when().get(SiteCheck.DATASTREAM).then().log().ifError()
				.statusCode(SiteCheck.SUCCESSCODE);
	}


}
