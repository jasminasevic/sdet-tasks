package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FilteredCountryList {

	public static String getFilteredCountries(String keyword){

		String url = "https://restcountries.com/v3.1/name/" + keyword;
	
		Response filteredCountries = given()
					.get(url);
				
		int expectedStatusCode = 200;
		int actualStatusCode = filteredCountries
				.getStatusCode();
				
		assertEquals(expectedStatusCode, actualStatusCode, "Status code should be 200");
							
		JsonPath filteredCountriesJsonPath = filteredCountries.jsonPath();
		List<String> allFilteredCountries = filteredCountriesJsonPath.get("name.official");		
							
		String actual = allFilteredCountries.toString();
		return actual;
	}
	
}
