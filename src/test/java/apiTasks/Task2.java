package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@DisplayName("Bad response")
class Task2 {

	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		final String KEYWORD = "United";
		
		//Get all countries
		String expected = CountryList.getCountries(KEYWORD);
		
		//Get filtered countries with keyword
		String url = "https://restcountries.com/v3.1/name/" + KEYWORD;
			
		int expectedStatusCode = 200;
		int actualStatusCode = given().get(url).getStatusCode();
		
		assertEquals(expectedStatusCode, actualStatusCode, "Status code should be 200");
		
		Response filteredCountries = given()
				.get(url);
			
		JsonPath filteredCountriesJsonPath = filteredCountries.jsonPath();
		List<String> allFilteredCountries = filteredCountriesJsonPath.get("name.official");		
			
		String actual = allFilteredCountries.toString();
		
		//Check if two lists are the not the same
		assertNotEquals(expected, actual, "Lists should not be equal");
	}

}
