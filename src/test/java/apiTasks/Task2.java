package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

class Task2 {

	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		final String KEYWORD2 = "United";
		
	  	//Get all countries
		Response response = given().get("https://restcountries.com/v3.1/all");
		JsonPath allCountriesJsonPath = response.jsonPath();
		
		List<String> allCountries = allCountriesJsonPath.get("name.official");
		System.out.println("All countries " + allCountries);
		
		//Get all countries with kw in name
		List<String> allCountriesWithKwUnited = new ArrayList<String>();
		
		for (String c : allCountries) {
			if(c.contains(KEYWORD2)) {
				allCountriesWithKwUnited.add(c);
			}
		}
		
		String expected = allCountriesWithKwUnited.toString();
		
		System.out.println("All countries with kw United " + allCountriesWithKwUnited);
		
		//Get filtered countries with kw
		String url = "https://restcountries.com/v3.1/name/" + KEYWORD2;
			
		Response filteredCountries = given()
				.get(url);
			
		JsonPath filteredCountriesJsonPath = filteredCountries.jsonPath();
		List<String> allFilteredCountries = filteredCountriesJsonPath.get("name.official");		
			
		System.out.println("Countries filtered with kw United "  + allFilteredCountries);
		String actual = allFilteredCountries.toString();
		
		//Check if two lists are the not the same
		assertNotSame(expected, actual, "Lists should not be equal");
	}

}
