package tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DisplayName("Get the list of positions")
class Task2 extends BaseUITest {
	
	@Test
	@DisplayName("Get the list of open QA/QE positions in Belgrade")
	void test() throws InterruptedException {
		
		driver.get(getBaseURL());
		
		driver.findElement(By.linkText("Job openings")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button .truncate")).click();

	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@title='Departments']")).click();
	    driver.findElement(By.xpath("//*[@title='Departments']/..//*[@data-value='QA/QE']")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@title='Locations']")).click();
	    driver.findElement(By.xpath("//*[@title='Locations']/..//*[@data-value='Belgrade']")).click();
	    
	    Thread.sleep(3000);
	    List<WebElement> jobs = driver.findElements(By.xpath("//ul[@class='block-grid']/li"));  	    
	    
  	    List<String> allJobDetails = new ArrayList<>();

  	    for (WebElement job : jobs) {
  	    	if(job.getText().contains("QA/QE · Belgrade"))
  	    	{ 
  	    		allJobDetails.add(job.getText());
  	    	}
		}
  	    
  	    assertTrue(!allJobDetails.isEmpty(), "The list should contain all QA/QE positions in Belgrade");
  	    
 	    
  	    List<String> jobTitles = new ArrayList<>();
 	    for(int i = 0; i< allJobDetails.size(); i++) {
 	    	//System.out.println("First element " + allJobDetails.get(i).split("\n")[0]);
 	    	String jobTitle = allJobDetails.get(i).split("\n")[0];
 	    	jobTitles.add(jobTitle);
 	    }
 	    System.out.print(jobTitles); 	    
 	}
}
