package apiTasks;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bad status code")
class Task1 {

	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		final String KEYWORD = "Austr";
		
		String url = "https://restcountries.com/v3.1/name/" + KEYWORD;
			
		int expectedStatusCode = 404;
		int actualStatusCode = given()
				.get(url)
				.getStatusCode();
		
		assertEquals(expectedStatusCode, actualStatusCode, "Status code should be 404");
	}
}
