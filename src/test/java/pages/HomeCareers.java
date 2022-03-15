package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeCareers {
	
	WebDriver driver = null;
	
	public HomeCareers(WebDriver driver) {
		this.driver = driver;
	}
	
	By buttonJobOpenings = By.linkText("Job openings");
	By buttonAllJobs = By.linkText("All jobs");
	
	public void clickButtonJobOpenings() {
		driver.findElement(buttonJobOpenings).click();
	}
	
	public void clickButtonAllJobs() {
		driver.findElement(buttonAllJobs).click();
	}

}
