package tasks;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class Task1 {
	
	static private WebDriver driver;
	  
	@BeforeAll
	static public void setUp() {
	   driver = new ChromeDriver();
	}

	@Test
	@DisplayName("Verify that Junior SDET Engineer - Redbox Team is in the list")
	void test() {
		String baseUrl = "https://careers.interventure.info/";

		driver.get(baseUrl);
	    driver.manage().window().setSize(new Dimension(1311, 741));
	    driver.findElement(By.cssSelector(".sm\\3Aml-10 .truncate")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button > .flex")).click();
	    WebElement element = driver.findElement(By.cssSelector(".flex > .careersite-button > .flex"));
	    Actions builder = new Actions(driver);
	    builder
	    	.moveToElement(element)
	    	.perform();
		driver
			.manage()
			.timeouts()
			.implicitlyWait(Duration.ofSeconds(20));
		
	    
	    List<WebElement> listOfJobs = driver.findElements(By.cssSelector("#section-jobs > div.mx-auto.text-lg.block-max-w--md > ul"));
	    System.out.println("Lista: " + listOfJobs.toString());
	    
	    Iterator<WebElement> itr = listOfJobs.iterator();
	    while(itr.hasNext()) {
	        System.out.println(itr.next().getText());
	    }
	    
	    
	    System.out.println("Title: " + driver.getTitle());
	   
	    
//	    List<WebElement> jobs = driver.findElements(By.xpath("//ul[@class='block-grid']/li"));
//  	    System.out.println("SIZE " + jobs.size());
//  	    int jobsSize = jobs.size();
//	    
//  	    for (WebElement job : jobs) {
//			System.out.println(job);
//		}
  	    
		  
	}
}
