package tasks;

import static org.testng.Assert.assertEquals;

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
	    		.visibilityOfElementLocated(By.cssSelector(".transition-opacity:nth-child(34) .text-block-base-link")));
	    
	    driver.findElement(By.cssSelector(".transition-opacity:nth-child(34) .text-block-base-link")).click();
	    driver.findElement(By.cssSelector(".mt-10 .truncate")).click();
	    
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(By.id("candidate_first_name")));
	    
	    String expectedTitle = "Senior SDET Engineer - Redbox team";
	    
	    String actualTitle = driver.findElement(By.xpath("/html/body/section/div[1]/div/h1/span")).getText();
	    
	    assertEquals(actualTitle, expectedTitle, "Position title should be Senior SDET Engineer - Redbox team");
	    
	    driver.findElement(By.id("candidate_first_name")).click();
	    driver.findElement(By.id("candidate_first_name")).sendKeys("Jasmina");
	    
	    driver.findElement(By.id("candidate_last_name")).click();
	    driver.findElement(By.id("candidate_last_name")).sendKeys("Sevic");
	    
	    driver.findElement(By.id("candidate_email")).click();
	    driver.findElement(By.id("candidate_email")).sendKeys("jasmina@mail.com");
	    
	    driver.findElement(By.id("candidate_phone")).click();
	    driver.findElement(By.id("candidate_phone")).sendKeys("+381631234567");
	    
	    driver.findElement(By.id("candidate_resume_remote_url")).click();
	    String cvLocation = System.getProperty("user.dir") + "/src/test/resources/cv.txt";
	    driver.findElement(By.id("candidate_resume_remote_url")).sendKeys(cvLocation);
	    
	    driver.findElement(By.id("candidate_file_remote_url")).click();
	    String motivationLetterLocation = System.getProperty("user.dir") + "/src/test/resources/motivation-letter.txt";
	    driver.findElement(By.id("candidate_file_remote_url")).sendKeys(motivationLetterLocation);

	    driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button")).click();
	    String referencesLocation = System.getProperty("user.dir") + "/src/test/resources/references.txt";
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button")));
	    driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button")).sendKeys(referencesLocation);
	    	    
	    driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).click();
	    driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).sendKeys("Cover letter....");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"job-application-form\"]/div[7]/div/div/input[1]")));
	}
}
