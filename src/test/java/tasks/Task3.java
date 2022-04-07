package tasks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.AllJobsListingPage;
import pages.JobApplicationPage;
import pages.JobDescriptionPage;

@DisplayName("Verify that form works properly")
class Task3 extends BaseUITest {
	
	@Test
	@DisplayName("Form validation")
	void test() throws InterruptedException {
		
		AllJobsListingPage allJobsListingPage = new AllJobsListingPage(driver);
		JobDescriptionPage jobDescriptionPage = new JobDescriptionPage(driver);
		JobApplicationPage jobApplicationPage = new JobApplicationPage(driver);
		
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(allJobsListingPage.getJobTitle()));
	    allJobsListingPage.clickJobTitle();
	    	    
	    jobDescriptionPage.clickButtonApplyForThisJob();
	    
	    By candidateFirstName = jobApplicationPage.getFirstName();
	    wait.until(ExpectedConditions
	    		.visibilityOfElementLocated(candidateFirstName));
	    
	    String expectedTitle = "Junior SDET Engineer - Redbox team";
	    String actualTitle = jobApplicationPage.getJobTitle();
	    assertEquals(actualTitle, expectedTitle, "Position title should be Junior SDET Engineer - Redbox team");
	    
	    jobApplicationPage.clickFirstName();
	    jobApplicationPage.setFirstName("Jasmina");
	    String firstNameValue = jobApplicationPage.getFirstNameValue();
	    assertFalse(firstNameValue.isEmpty(), "First name should be added");
	    
	    jobApplicationPage.clickLastName();
	    jobApplicationPage.setLastName("Sevic");
	    String lastNameValue = jobApplicationPage.getLastNameValue();
	    assertFalse(lastNameValue.isEmpty(), "Last name should be added");
	    
	    jobApplicationPage.clickEmail();
	    jobApplicationPage.setEmail("jasmina@gmail.com");
	    String emailValue = jobApplicationPage.getEmailValue();
	    assertFalse(emailValue.isEmpty(), "Email should be added");
	    
	    jobApplicationPage.clickPhone();
	    jobApplicationPage.setPhone("+38161234567");
	    
	    SoftAssertions softly = new SoftAssertions();
	    
	    String phoneValue = jobApplicationPage.getPhoneValue();
	    softly.assertThat(phoneValue.isEmpty()).as("phone value").isFalse();
	    	       
	    jobApplicationPage.clickCV();
	    String cvLocation = System.getProperty("user.dir") + "/src/test/resources/cv.txt";
	    jobApplicationPage.setCV(cvLocation);
	    
	    Thread.sleep(1000);
	    boolean isCvFileAdded = false;
	    try {
	    	if(driver.findElement(By.xpath("//*[@id='upload_resume_field']/div[2]/div/div/a")).isDisplayed()) {
	    		isCvFileAdded = true;
	    	}
	    } catch(Exception e){
	    	isCvFileAdded = false;
	    }
	    softly.assertThat(isCvFileAdded).as("CV file").isTrue();
	    
	    driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[1]")).click();    
	    String motivationLetterLocation = System.getProperty("user.dir") + "/src/test/resources/motivation-letter.txt";
	    driver.findElement(By.id("candidate_file_remote_url")).sendKeys(motivationLetterLocation);

	    Thread.sleep(1000);
	    boolean isMotivationLetterFileAdded = false;
	    try {
	    	if(driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[2]/div[1]/div/a")).isDisplayed()) {
	    		isMotivationLetterFileAdded = true;
	    	}
	    } catch(Exception e) {
	    	isMotivationLetterFileAdded = false;
	    	}
	    softly.assertThat(isMotivationLetterFileAdded).as("Motivation letter file").isTrue();
		
	    if(isMotivationLetterFileAdded) {
		    driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button/span")).click();
		    String referencesLocation = System.getProperty("user.dir") + "/src/test/resources/references.txt";
		    driver.findElement(By.xpath("//*[@id=\"candidate_file_remote_url\"]")).sendKeys(referencesLocation);
		    
		    Thread.sleep(1000);
		    boolean isSecondMotivationLetterFileAdded = false;
		    try {
			    if(driver.findElement(By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[2]/div[2]/div/a")).isDisplayed()) {
			    	isSecondMotivationLetterFileAdded = true;
			    }
			} catch(Exception e) {
				isSecondMotivationLetterFileAdded = false;
			}
		softly.assertThat(isSecondMotivationLetterFileAdded).as("Second motivation letter file").isTrue();
	    }
	    
	    driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).click();
	    driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).sendKeys("Cover letter....");
	    
	    String coverLetterValue = driver.findElement(By.id("candidate_job_applications_attributes_0_cover_letter")).getAttribute("value");
	    boolean isCoverLetterValueAdded = false;
	    if(!coverLetterValue.isEmpty()) {
	    	isCoverLetterValueAdded = true;
	    }
	    softly.assertThat(isCoverLetterValueAdded).as("Cover letter").isTrue();
	    
	    try {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"job-application-form\"]/div[7]/div/div/input[1]")));
	        System.out.println("Element is clickable");
	      }
	    catch(TimeoutException e) {
	        System.out.println("Element isn't clickable");
	    }
	    
	    softly.assertAll();
	
	}
}
