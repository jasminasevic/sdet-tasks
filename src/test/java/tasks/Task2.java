package tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import pages.AllJobsListingPage;

@DisplayName("Get the list of positions")
class Task2 extends BaseUITest {
	
	@Test
	@DisplayName("Get the list of open QA/QE positions in Belgrade")
	void test() throws InterruptedException {

		AllJobsListingPage allJobsListingPage = new AllJobsListingPage(driver);
		
	    Thread.sleep(1000);
	    allJobsListingPage.clickDepartmentsDdlist();
	    allJobsListingPage.clickSpecificDepartmentValue();
	 
	    Thread.sleep(1000);
	    allJobsListingPage.clickLocationsDdlist();
	    allJobsListingPage.clickSpecificLocationValue();
	 
	    Thread.sleep(1000);
	    List<WebElement> jobs = allJobsListingPage.getJobsList();
	    		
  	    List<String> allJobDetails = new ArrayList<>();

  	    for (WebElement job : jobs) {
  	    	if(job.getText().contains("QA/QE · Belgrade"))
  	    	{ 
  	    		allJobDetails.add(job.getText());
  	    	}
		}
  	    
  	    assertFalse(allJobDetails.isEmpty(), "The list should contain all QA/QE positions in Belgrade");
  	    
 	    
  	    List<String> jobTitles = new ArrayList<>();
 	    for(int i = 0; i< allJobDetails.size(); i++) {
 	    	String jobTitle = allJobDetails.get(i).split("\n")[0];
 	    	jobTitles.add(jobTitle);
 	    }
 	    System.out.print(jobTitles); 	    
 	}
}
