package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class apiTask2 {
  @Test
  @DisplayName("Get all countries and filter those that contain United")
  public void f() {
	  	final String KEYWORD1 = "United";
		
	  	//Get all countries
		Response response = given().get("https://restcountries.com/v3.1/all");
		JsonPath allCountriesJsonPath = response.jsonPath();
		
		List<String> allCountries = allCountriesJsonPath.get("name.official");
		System.out.println("All countries " + allCountries);
		
		//Get all countries with kw in name
		List<String> allCountriesWithKwUnited = new ArrayList<String>();
		
		for (String c : allCountries) {
			if(c.contains(KEYWORD1)) {
				allCountriesWithKwUnited.add(c);
			}
		}
		
		String expected = allCountriesWithKwUnited.toString();
		
		System.out.println("All countries with kw United " + allCountriesWithKwUnited);
		
		
	}
}
