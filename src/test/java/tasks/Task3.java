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
	    boolean isCvFileAdded = jobApplicationPage.isUploadedCvDisplayed() ? true : false;
	    softly.assertThat(isCvFileAdded).as("CV file").isTrue();
	    
	    jobApplicationPage.clickUploadMotivationLetterField();
	    String motivationLetterLocation = System.getProperty("user.dir") + "/src/test/resources/motivation-letter.txt";
	    jobApplicationPage.setMotivationLetter(motivationLetterLocation);
	    
	    Thread.sleep(1000);
	    boolean isMotivationLetterFileAdded = jobApplicationPage.isUploadedMotivationLetterDisplayed() ? true : false;
	    softly.assertThat(isMotivationLetterFileAdded).as("Motivation letter file").isTrue();
		
	    if(isMotivationLetterFileAdded) {
		    jobApplicationPage.clickUploadMoreButton();
	    	String referencesLocation = System.getProperty("user.dir") + "/src/test/resources/references.txt";
		    jobApplicationPage.setAdditionalMotivationLetter(referencesLocation);
		    
		    Thread.sleep(1000);		    
		    boolean isSecondMotivationLetterFileAdded = jobApplicationPage.isUploadedAdditionalMotivationLetterDisplayed() ? true : false; 
		    softly.assertThat(isSecondMotivationLetterFileAdded).as("Second motivation letter file").isTrue();
	    }
	    
	    jobApplicationPage.clickCoverLetter();
	    jobApplicationPage.setCoverLetter("Cover letter.....");
	    softly.assertThat(jobApplicationPage.isCoverLetterNotAdded()).as("Cover letter").isFalse();
	    
	    try {
		    wait.until(ExpectedConditions.elementToBeClickable(jobApplicationPage.getSubmitButton()));
	        System.out.println("Element is clickable");
	      }
	    catch(TimeoutException e) {
	        System.out.println("Element isn't clickable");
	    }
	    
	    softly.assertAll();
	
	}
}
