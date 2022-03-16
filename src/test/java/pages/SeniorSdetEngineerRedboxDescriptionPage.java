package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeniorSdetEngineerRedboxDescriptionPage {
	
	WebDriver driver = null;
	
	public SeniorSdetEngineerRedboxDescriptionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By buttonApplyForThisJob = By.linkText("Apply for this Job");
	
	public void clickButtonApplyForThisJob() {
		driver.findElement(buttonApplyForThisJob).click();
	}
	
}
