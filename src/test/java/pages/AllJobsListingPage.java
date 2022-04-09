package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllJobsListingPage {

	WebDriver driver = null;
	
	public AllJobsListingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//@FindBy(xpath = "//ul[@class='block-grid']/li") List<WebElement> allJobs;
	
	By jobTitle = By.xpath("//*[@title='Junior SDET Engineer - Redbox team']");
	By departmentsDdlist = By.xpath("//*[@title='Departments']");
	By specificDepartmentValue = By.xpath("//*[@title='Departments']/..//*[@data-value='QA/QE']");
	By locationsDdlist = By.xpath("//*[@title='Locations']");
	By specificLocationValue = By.xpath("//*[@title='Locations']/..//*[@data-value='Belgrade']");
	By jobs = By.xpath("//ul[@class='block-grid']/li");
	
	public By getJobTitle() {
		return this.jobTitle;
	}
	
	public void clickJobTitle() {
		driver.findElement(jobTitle).click();
	}
	
	public By getDepartmentsDdlist() {
		return this.departmentsDdlist;
	}
	
	public void clickDepartmentsDdlist() {
		driver.findElement(getDepartmentsDdlist()).click();
	}
	
	public By getSpecificDepartmentValue() {
		return specificDepartmentValue;
	}
	
	public void clickSpecificDepartmentValue() {
		driver.findElement(getSpecificDepartmentValue()).click();
	}
	
	public By getLocationsDdlist() {
		return this.locationsDdlist;
	}
	
	public void clickLocationsDdlist() {
		driver.findElement(getLocationsDdlist()).click();
	}
	
	public By getSpecificLocationValue() {
		return specificLocationValue;
	}
	
	public void clickSpecificLocationValue() {
		driver.findElement(getSpecificLocationValue()).click();
	}
	
	public By jobs() {
		return this.jobs;
	}
	
	public List<WebElement> getJobsList() {
		return driver.findElements(jobs);
	}
	
	
	
}
