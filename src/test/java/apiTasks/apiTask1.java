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
		JsonPath allCountriesJsonPath = response.jsonPath();
		
		List<String> allCountries = allCountriesJsonPath.get("name.official");
		System.out.println("All countries " + allCountries);
		
		//Get all countries with kw in name
		List<String> allCountriesWithKwAustr = new ArrayList<String>();
		
		for (String c : allCountries) {
			if(c.contains(KEYWORD1)) {
				allCountriesWithKwAustr.add(c);
			}
		}
		
		String expected = allCountriesWithKwAustr.toString();
		
		System.out.println("All countries with kw " + allCountriesWithKwAustr);
		
		//Get filtered countries with kw
		String url = "https://restcountries.com/v3.1/name/" + KEYWORD1;
			
		Response filteredCountries = given()
				.get(url);
			
		JsonPath filteredCountriesJsonPath = filteredCountries.jsonPath();
		List<String> allFilteredCountries = filteredCountriesJsonPath.get("name.official");		
			
		System.out.println("Countries filtered with kw "  + allFilteredCountries);
		String actual = allFilteredCountries.toString();
		
		//Check if two lists are the same
		try {
			assertNotSame(expected, actual, "Lists are not the same");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
  	}
}
