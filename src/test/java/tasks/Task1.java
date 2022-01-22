package tasks;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class Task1 {
	
	static private WebDriver driver;
	  
	@BeforeAll
	static public void setUp() {
	   driver = new ChromeDriver();
	}

	@Test
	@DisplayName("Verify that Junior SDET Engineer - Redbox Team is in the list")
	void test() {
		String baseUrl = "https://careers.interventure.info/";

		driver.get(baseUrl);
	    driver.manage().window().setSize(new Dimension(1311, 741));
	    driver.findElement(By.cssSelector(".sm\\3Aml-10 .truncate")).click();
	    driver.findElement(By.cssSelector(".flex > .careersite-button > .flex")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".flex > .careersite-button > .flex"));
	      System.out.println(element.getText());
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    WebElement lista = driver.findElement(By.cssSelector("#section-jobs > div.mx-auto.text-lg.block-max-w--md > ul"));
	    System.out.println(lista.getText());
	    
	    List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='block-grid']/li"));
  	    System.out.println(allOptions.size());
	    for(int i = 1; i < allOptions.size(); i++) {
	    	System.out.println(driver.findElement(By.cssSelector("#section-jobs > div.mx-auto.text-lg.block-max-w--md > ul > li:nth-child(" + i + ") > a > span")).getText());
	    	System.out.println(driver.findElement(By.cssSelector("#section-jobs > div.mx-auto.text-lg.block-max-w--md > ul > li:nth-child(" + i + ") > a > div > span:nth-child(1)")).getText());
	    	System.out.println(driver.findElement(By.cssSelector("#section-jobs > div.mx-auto.text-lg.block-max-w--md > ul > li:nth-child(" + i + ") > a > div > span:last-child")).getText());
	    }
	}
}
