package apiTasks;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;

public class apiTask1 {
  
  @Test
  @DisplayName("Get all countries and filter those that contain Austr")
  public void f() {
	  
	  	final String KEYWORD1 = "Austr";
		
	  	//Get all countries
		Response response = given().get("https://restcountries.com/v3.1/all");
		JsonPath jsonPath = response.jsonPath();
		
		List<String> countries = jsonPath.get("name.official");
		System.out.println("All countries " + countries);
		
		//Get all countries with kw Austr in name
		List<String> allCountriesWithKwAustr = new ArrayList<String>();
		
		for (String c : countries) {
			if(c.contains(KEYWORD1)) {
				allCountriesWithKwAustr.add(c);
			}
		}
		
		System.out.println(allCountriesWithKwAustr);
		
		
  }
}
