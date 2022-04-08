package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobApplicationPage {

	WebDriver driver = null;
	
	public JobApplicationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By jobTitle = By.xpath("//*[@class='textFitted']");
	By candidateFirstName = By.id("candidate_first_name");
	By candidateLastName = By.id("candidate_last_name"); 
	By candidateEmail = By.id("candidate_email");
	By candidatePhone = By.id("candidate_phone");
	By uploadCvField = By.id("upload_resume_field");
	By candidateCvRemoteUrl = By.id("candidate_resume_remote_url");
	By uploadedCvField = By.xpath("//*[@id='upload_resume_field']/div[2]/div/div/a");
	By uploadMotivationLetterField = By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[1]");
	By candidateMotivationLetterRemoteUrl = By.id("candidate_file_remote_url");
	By uploadedMotivationLetterField = By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[2]/div[1]/div/a");
	By uploadMoreButton = By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/button/span");
	By candidateAdditionalMotivationLetterRemoteUrl = By.xpath("//*[@id='candidate_file_remote_url']");
	By uploadedAdditionalMotivationLetterField = By.xpath("//*[@id=\"job-application-form\"]/div[5]/div/div[2]/div[2]/div/a");
	By candidateCoverLetter = By.id("candidate_job_applications_attributes_0_cover_letter");
	By submitButton = By.xpath("//*[@id=\"job-application-form\"]/div[7]/div/div/input[1]");
	
	public String getJobTitle() {
		return driver.findElement(jobTitle).getText();
	}
	
	public By getFirstName() {
		return candidateFirstName;
	}
	
	public void clickFirstName() {
		driver.findElement(candidateFirstName).click();
	}
	
	public void setFirstName(String firstName) {
		driver.findElement(candidateFirstName).sendKeys(firstName);
	}

	public String getFirstNameValue() {
		return driver.findElement(candidateFirstName).getAttribute("value");
	}
	
	public By getLastName() {
		return candidateLastName;
	}
	
	public void clickLastName() {
		driver.findElement(candidateLastName).click();
	}
	
	public void setLastName(String lastName) {
		driver.findElement(candidateLastName).sendKeys(lastName);
	}
	
	public String getLastNameValue() {
		return driver.findElement(candidateLastName).getAttribute("value");
	}
	
	public By getEmail() {
		return candidateEmail;
	}
	
	public void clickEmail() {
		driver.findElement(candidateEmail).click();
	}
	
	public void setEmail(String email) {
		driver.findElement(candidateEmail).sendKeys(email);
	}
	
	public String getEmailValue() {
		return driver.findElement(candidateEmail).getAttribute("value");
	} 
	
	public By getPhone() {
		return candidatePhone;
	}
	
	public void clickPhone() {
		driver.findElement(candidatePhone).click();
	}
	
	public void setPhone(String phone) {
		driver.findElement(candidatePhone).sendKeys(phone);
	}
	
	public String getPhoneValue() {
		return driver.findElement(candidatePhone).getAttribute("value");
	}
	
	public By getUploadCvField() {
		return uploadCvField;
	}
	
	public void clickCV() {
		driver.findElement(uploadCvField).click();
	}
	
	public void setCV(String cvLocation) {
		driver.findElement(candidateCvRemoteUrl).sendKeys(cvLocation);
	}
	
	public By getUploadedCvField() {
		return uploadedCvField;
	}
	
	public boolean isUploadedCvDisplayed() {
		return driver.findElement(getUploadCvField()).isDisplayed();
	}
	
	public By getUploadMotivationLetterField() {
		return uploadMotivationLetterField;
	}
	
	public void clickUploadMotivationLetterField() {
		driver.findElement(uploadMotivationLetterField).click();
	}
	
	public void setMotivationLetter(String motivationLetter) {
		driver.findElement(candidateMotivationLetterRemoteUrl).sendKeys(motivationLetter);
	}
	
	public By getUploadedMotivationLetterField() {
		return uploadedMotivationLetterField;
	}
	
	public boolean isUploadedMotivationLetterDisplayed() {
		return driver.findElement(getUploadedMotivationLetterField()).isDisplayed();
	}
	
	public void clickUploadMoreButton() {
		driver.findElement(uploadMoreButton).click();
	}
	
	public void setAdditionalMotivationLetter(String additionalMotivationLetter) {
		driver.findElement(candidateAdditionalMotivationLetterRemoteUrl).sendKeys(additionalMotivationLetter);
	}
	
	public By getUploadedAdditionalMotivationLetterField() {
		return uploadedAdditionalMotivationLetterField;
	}
	
	public boolean isUploadedAdditionalMotivationLetterDisplayed() {
		return driver.findElement(getUploadedAdditionalMotivationLetterField()).isDisplayed();
	}
	
	public By getCoverLetter() {
		return candidateCoverLetter;
	}
	
	public void clickCoverLetter() {
		driver.findElement(candidateCoverLetter).click();
	}
	
	public void setCoverLetter(String coverLetter) {
		driver.findElement(candidateCoverLetter).sendKeys(coverLetter);
	}
	
	public String getCoverLetterValue() {
		return driver.findElement(candidateCoverLetter).getAttribute("value");
	}
	
	public boolean isCoverLetterNotAdded() {
		return getCoverLetterValue().isEmpty();
	} 

	public By getSubmitButton() {
		return submitButton;
	}
}
