package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeniorSdetEngineerRedboxApplicationPage {

	WebDriver driver = null;
	
	public SeniorSdetEngineerRedboxApplicationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By candidateFirstName = By.id("candidate_first_name");
	
	public By getCandidateFirstName() {
		return this.candidateFirstName;
	}
	
}
