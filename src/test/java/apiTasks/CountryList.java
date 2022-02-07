package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CountryList {
	
	public static String getCountries(String keyword){
		//Get all countries
		String url = "https://restcountries.com/v3.1/all";
		
		Response response = given()
				.get(url);
		
		int expectedStatusCode = 200;
		int actualStatusCode = response
				.getStatusCode();
		
		assertEquals(expectedStatusCode, actualStatusCode, "Status code should be 200");
		
		JsonPath allCountriesJsonPath = response.jsonPath();
				
		List<String> allCountries = allCountriesJsonPath.get("name.official");
		
		//Get all countries with keyword in name
		List<String> allCountriesWithKeyword = new ArrayList<String>();
				
		for (String country : allCountries) {
			if(country.contains(keyword)) {
				allCountriesWithKeyword.add(country);
			}
		}
				
		return allCountriesWithKeyword.toString();
				
	}
}
