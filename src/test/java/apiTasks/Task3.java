package apiTasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Positive test scenario")
class Task3 {
	static final String KEYWORD = "Ser";
	
	@Test
	@DisplayName("Comparing two lists content")
	void test() {
		assertEquals(CountryList
					.getCountries(KEYWORD), 
				FilteredCountryList
					.getFilteredCountries(KEYWORD), "Lists should be equal");
	}

}
