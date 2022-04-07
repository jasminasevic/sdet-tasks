package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobDescriptionPage {

	WebDriver driver = null;
	
	public JobDescriptionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By buttonApplyForThisJob = By.linkText("Apply for this job");
	
	public void clickButtonApplyForThisJob() {
		driver.findElement(buttonApplyForThisJob).click();
	}
	
}
