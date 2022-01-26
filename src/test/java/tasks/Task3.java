package tasks;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Task3 {

	static private WebDriver driver;
	
	@BeforeAll
	static public void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test
	void test() {
		String baseUrl = "https://careers.interventure.info/";

		driver.get(baseUrl);
		
		driver.findElement(By.cssSelector(".sm\\3Aml-10 .truncate")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button .truncate")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(By.cssSelector(".transition-opacity:nth-child(33) .text-block-base-link")));
	    
	    driver.findElement(By.cssSelector(".transition-opacity:nth-child(33) .text-block-base-link")).click();
	    driver.findElement(By.cssSelector(".mt-10 .truncate")).click();
	    
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(By.id("candidate_first_name")));
	    
	    driver.findElement(By.id("candidate_first_name")).click();
	    driver.findElement(By.id("candidate_first_name")).sendKeys("Jasmina");
	    driver.findElement(By.id("candidate_last_name")).click();
	    driver.findElement(By.id("candidate_last_name")).sendKeys("Sevic");
	    driver.findElement(By.id("candidate_email")).click();
	    driver.findElement(By.id("candidate_email")).sendKeys("jasmina@mail.com");
	    driver.findElement(By.id("candidate_phone")).click();
	    driver.findElement(By.id("candidate_phone")).sendKeys("+381631234567");
	    driver.findElement(By.id("candidate_resume_remote_url")).click();
	
	
	}
}
