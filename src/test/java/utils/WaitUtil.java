package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public WaitUtil(WebDriver driver, int timeOutSeconds) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(timeOutSeconds));
	}

	//Explicit wait
	public WebElement waitForClickable(WebElement element) {
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

}
