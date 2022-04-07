package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllJobsListingPage {

	WebDriver driver = null;
	
	public AllJobsListingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//@FindBy(xpath = "//ul[@class='block-grid']/li") List<WebElement> allJobs;
	
	By jobTitle = By.xpath("//*[@title='Junior SDET Engineer - Redbox team']");
	
	public By getJobTitle() {
		return this.jobTitle;
	}
	
	public void clickJobTitle() {
		driver.findElement(jobTitle).click();
	}
	
}
