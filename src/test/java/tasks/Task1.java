package tasks;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Verify that position is in the list")
class Task1 {
	
	static private WebDriver driver;
	  
	@BeforeAll
	static public void setUp() {
	   driver = new ChromeDriver();
	}

	@Test
	@DisplayName("Verify that Junior SDET Engineer - Redbox Team is in the list")
	void test() throws InterruptedException {
		String baseUrl = "https://careers.interventure.info/";

		driver.get(baseUrl);
	    driver.manage().window().setSize(new Dimension(1311, 741));
		driver.findElement(By.linkText("Job openings")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button > .flex")).click();
			    
	    Thread.sleep(3000);
	    List<WebElement> jobs = driver.findElements(By.xpath("//ul[@class='block-grid']/li"));  	    
	    
  	    List<String> allJobDetails = new ArrayList<>();

  	    for (WebElement job : jobs) {
			allJobDetails.add(job.getText());
		}

  	    boolean flag = false;
	  	String filteredList = allJobDetails.stream()
	            .filter(entry -> entry.contains("Junior SDET Engineer - Redbox team\n" + 
	            		"QA/QE · Belgrade"))
	            .collect(Collectors.joining(", ", "", ""));;
  	    
	    if(!filteredList.isEmpty()) {
	    	flag = true;
	    };
	    
  	    assertTrue(flag, "The list should contain Junior SDET Engineer - Redbox team QA/QE · Belgrad position");
		
	}
}
