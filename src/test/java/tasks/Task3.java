package tasks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DisplayName("Verify that form works properly")
class Task3 {

	static private WebDriver driver;
	
	@BeforeAll
	static public void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test
	@DisplayName("Form validation")
	void test() throws InterruptedException {
		String baseUrl = "https://careers.interventure.info/";

		driver.get(baseUrl);
		
		driver.findElement(By.cssSelector(".sm\\3Aml-10 .truncate")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button .truncate")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(By.xpath("//*[@id=\"section-jobs\"]/div[2]/ul/li[36]/a")));
	    
	    driver.findElement(By.xpath("//*[@id=\"section-jobs\"]/div[2]/ul/li[36]/a")).click();
	    driver.findElement(By.xpath("/html/body/main/section[1]/div/div/div[2]/a")).click();
	    
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(By.id("candidate_first_name")));
	    
	    String expectedTitle = "Senior SDET Engineer - Redbox team";
	    
	    String actualTitle = driver.findElement(By.xpath("/html/body/section/div[1]/div/h1/span")).getText();
	    
	    assertEquals(actualTitle, expectedTitle, "Position title should be Senior SDET Engineer - Redbox team");
	    
	    driver.findElement(By.id("candidate_first_name")).click();
	    driver.findElement(By.id("candidate_first_name")).sendKeys("Jasmina");
	    
	    String firstNameValue = driver.findElement(By.id("candidate_first_name")).getAttribute("value");
	    boolean firstNameValueAdded = false;
	    if(!firstNameValue.isEmpty()) {
	    	firstNameValueAdded = true;
	    }
	    assertTrue(firstNameValueAdded, "First name should be added");
	    
	    driver.findElement(By.id("candidate_last_name")).click();
	    driver.findElement(By.id("candidate_last_name")).sendKeys("Sevic");
	    
	    String lastNameValue = driver.findElement(By.id("candidate_last_name")).getAttribute("value");
	    boolean lastNameValueAdded = false;
	    if(!lastNameValue.isEmpty()) {
	    	lastNameValueAdded = true;
	    }
	    assertTrue(lastNameValueAdded, "Last name should be added");
	    
	    driver.findElement(By.id("candidate_email")).click();
	    driver.findElement(By.id("candidate_email")).sendKeys("jasmina@mail.com");
	    
	    String emailValue = driver.findElement(By.id("candidate_email")).getAttribute("value");
	    boolean emailValueAdded = false;
	    if(!emailValue.isEmpty()) {
	    	emailValueAdded = true;
	    }
	    assertTrue(emailValueAdded, "Email should be added");
	    
	    driver.findElement(By.id("candidate_phone")).click();
	    driver.findElement(By.id("candidate_phone")).sendKeys("+381631234567");
	    
	    String phoneValue = driver.findElement(By.id("candidate_phone")).getAttribute("value");
	    boolean phoneValueAdded = false;
	    if(!phoneValue.isEmpty()) {
	    	phoneValueAdded = true;
	    }
	    assertTrue(phoneValueAdded, "Phone should be added");
	    
	    driver.findElement(By.id("candidate_resume_remote_url")).click();
	    String cvLocation = System.getProperty("user.dir") + "/src/test/resources/cv.txt";
	    driver.findElement(By.id("candidate_resume_remote_url")).sendKeys(cvLocation);
	    
	    Thread.sleep(1000);
	    if(driver.findElement(By.xpath("//*[@id=\"upload_resume_field\"]/div[2]/div/div/a")).isDisplayed()) {
	    	assertTrue(true, "CV is uploaded");
	    }else {
	    	assertTrue(false, "CV is not uploaded");
	    }
	    
	    driver.findElement(By.id("candidate_file_remote_url")).click();
	    String motivationLetterLocation = System.getProperty("user.dir") + "/src/test/resources/motivation-letter.txt";
	    driver.findElement(By.id("candidate_file_remote_url")).sendKeys(motivationLetterLocation);

	    Thread.sleep(1000);
	    if(driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[2]/div[1]/div/a")).isDisplayed()) {
	    	assertTrue(true, "Additional file is uploaded");
	    }else {
	    	assertTrue(false, "Additional file is not uploaded");
	    }

	    wait.until(ExpectedConditions
	    		.presenceOfElementLocated(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button/span")));
	    driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button/span")).click();
	    String referencesLocation = System.getProperty("user.dir") + "/src/test/resources/references.txt";
	    driver.findElement(By.xpath("//*[@id=\"candidate_file_remote_url\"]")).sendKeys(referencesLocation);
	    
	    Thread.sleep(1000);
	    if(driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[2]/div[2]/div/a")).isDisplayed()) {
	    	assertTrue(true, "Second additional file is uploaded");
	    }else {
	    	assertTrue(false, "Second additional file is not uploaded");
	    }
	    
	    driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).click();
	    driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).sendKeys("Cover letter....");
	    
	    String coverLetterValue = driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).getAttribute("value");
	    boolean coverLetterValueAdded = false;
	    if(!coverLetterValue.isEmpty()) {
	    	coverLetterValueAdded = true;
	    }
	    assertTrue(coverLetterValueAdded, "Cover letter should be added");
	    
	    try {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"job-application-form\"]/div[7]/div/div/input[1]")));
	        System.out.println("Element is clickable");
	      }
	    catch(TimeoutException e) {
	        System.out.println("Element isn't clickable");
	    }
	
	}
}
