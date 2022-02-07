package apiTasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bad response")
class Task2 {
	static final String KEYWORD = "United";
	
	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		assertNotEquals(CountryList
					.getCountries(KEYWORD), 
				FilteredCountryList
					.getFilteredCountries(KEYWORD), "Lists should not be equal");
	}

}
