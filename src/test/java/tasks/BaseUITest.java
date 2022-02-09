package tasks;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUITest {
	private static final int MAX_WAIT_DURATION = 10;
	private static final int POLLING_WAIT_DURATION = 150;
	
	private static final String BASE_URL = "https://careers.interventure.info/";

    static String browser;
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void initTests() {
    	WebDriverManager.chromedriver().setup();
    	browser = propertyReader("browser");
    }

    @BeforeEach
    public void startTest() {
    	driver = new ChromeDriver();
    	wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_DURATION), Duration.ofMillis(POLLING_WAIT_DURATION));
    	driver.manage().window().maximize();
    }

    @AfterEach
    public void closeTest() {
    	driver.close();
    }

    @AfterAll
    public static void tearDownTests() {
    	driver.quit();
    }
    
    //Utility method for safe rendering of properties:
    private static String propertyReader(String prop) {
    	var temp = "default";
    	if(!(System.getProperty(prop) == null || System.getProperty(prop).isEmpty())) {
    		temp = System.getProperty(prop);
    	}
    	return temp;
    }

    public static String getBaseURL() {
    	return BASE_URL;
    }
}
