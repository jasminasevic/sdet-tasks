package apiTasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Positive test scenario")
class Task3 {

	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		final String KEYWORD = "Ser";
		
		String expected = CountryList
				.getCountries(KEYWORD);
		
		String actual = FilteredCountryList
				.getFilteredCountries(KEYWORD);
				
		assertEquals(expected, actual, "Lists should be equal");
	}

}
