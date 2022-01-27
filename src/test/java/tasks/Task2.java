package tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Task2 {

	static private WebDriver driver;
	  
	@BeforeAll
	static public void setUp() {
	   driver = new ChromeDriver();
	}
	
	@Test
	@DisplayName("Get the list of open QA/QE positions in Belgrade")
	void test() throws InterruptedException {
		String baseUrl = "https://careers.interventure.info/";
		driver.get(baseUrl);
		
	    driver.manage().window().setSize(new Dimension(1311, 741));
	    driver.findElement(By.cssSelector(".sm\\3Aml-10 .truncate")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button .truncate")).click();

	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@title='Departments']")).click();
	    driver.findElement(By.xpath("//*[@title='Departments']/..//*[@data-value='QA/QE']")).click();
	    
	    driver.findElement(By.xpath("//*[@title='Locations']")).click();
	    driver.findElement(By.xpath("//*[@title='Locations']/..//*[@data-value='Belgrade']")).click();
	    
	    Thread.sleep(3000);
	    List<WebElement> jobs = driver.findElements(By.xpath("//ul[@class='block-grid']/li"));  	    
	    
  	    List<String> allJobDetails = new ArrayList<>();

  	    for (WebElement job : jobs) {
			allJobDetails.add(job.getText());
			System.out.println(job.getText());
		}
	}

}
