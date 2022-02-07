package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bad status code")
class Task1 {
	static final String KEYWORD = "Austr";
	
	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		
		String url = "https://restcountries.com/v3.1/name/" + KEYWORD;
			
		int expectedStatusCode = 404;
		int actualStatusCode = given()
				.get(url)
				.getStatusCode();
		
		assertEquals(expectedStatusCode, actualStatusCode, "Status code should be 404");
	}
}
