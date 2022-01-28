package apiTasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bad response")
class Task2 {

	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		final String KEYWORD = "United";
		
		String expected = CountryList
				.getCountries(KEYWORD);
		
		String actual = FilteredCountryList
				.getFilteredCountries(KEYWORD);
		
		assertNotEquals(expected, actual, "Lists should not be equal");
	}

}
