package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public WebDriver driver;
	//Explicit wait
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	

}
