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
	

}
