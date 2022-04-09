package tasks;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import pages.AllJobsListingPage;


@DisplayName("Verify that position is in the list")
class Task1 extends BaseUITest {

	@Test
	@DisplayName("Verify that Junior SDET Engineer - Redbox Team is in the list")
	void test() throws InterruptedException {
			
		AllJobsListingPage allJobsListingPage = new AllJobsListingPage(driver);
		
	    Thread.sleep(3000);
	    List<WebElement> jobs = allJobsListingPage.getJobsList(); 	    
	    
  	    List<String> allJobDetails = new ArrayList<>();

  	    for (WebElement job : jobs) {
			allJobDetails.add(job.getText());
		}

	  	String filteredList = allJobDetails.stream()
	            .filter(entry -> entry.contains("Junior SDET Engineer - Redbox team\n" + 
	            		"QA/QE · Belgrade"))
	            .collect(Collectors.joining());
  	    
  	    assertFalse(filteredList.isEmpty(), "The list should contain Junior SDET Engineer - Redbox team QA/QE · Belgrade position");
		
	}
}
