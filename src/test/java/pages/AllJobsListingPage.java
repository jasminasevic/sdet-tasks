package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllJobsListingPage {

	WebDriver driver = null;
	
	public AllJobsListingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//@FindBy(xpath = "//ul[@class='block-grid']/li") List<WebElement> allJobs;
	
	By seniorSDETEngineerRedboxTeamTitle = By.xpath("//*[@title='Senior SDET Engineer - Redbox team']");
	
	public By getSeniorSdetEngeenerTeamTitle() {
		return this.seniorSDETEngineerRedboxTeamTitle;
	}
	
	public void clickSeniorSDETEngineerRedboxTeamTitle() {
		driver.findElement(seniorSDETEngineerRedboxTeamTitle).click();
	}
	
}
