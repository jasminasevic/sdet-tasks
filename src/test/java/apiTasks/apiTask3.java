package apiTasks;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class apiTask3 {
  @Test
  public void f() {
	  final String KEYWORD3 = "Ser";
		
	  	//Get all countries
		Response response = given().get("https://restcountries.com/v3.1/all");
		JsonPath allCountriesJsonPath = response.jsonPath();
		
		List<String> allCountries = allCountriesJsonPath.get("name.official");
		System.out.println("All countries " + allCountries);
		
		//Get all countries with kw in name
		List<String> allCountriesWithKwSer = new ArrayList<String>();
				
		for (String c : allCountries) {
			if(c.contains(KEYWORD3)) {
				allCountriesWithKwSer.add(c);
				}
			}
				
		String expected = allCountriesWithKwSer.toString();
				
		System.out.println("All countries with kw Ser " + allCountriesWithKwSer);
  }
}
