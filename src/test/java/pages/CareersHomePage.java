package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersHomePage {
	
	WebDriver driver = null;
	
	public CareersHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By buttonJobOpenings = By.linkText("Job openings");
	By buttonAllJobs = By.linkText("All jobs");
	
	
	public CareersHomePage clickButtonJobOpenings() {
		driver.findElement(buttonJobOpenings).click();
		return this;
	}
	
	public CareersHomePage clickButtonAllJobs() {
		driver.findElement(buttonAllJobs).click();
		return new CareersHomePage(driver);
	}

}
