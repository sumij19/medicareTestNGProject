package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class BasePage {
	
	public WebDriver driver;
	public WaitUtil waitUtil;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver,10);
		PageFactory.initElements(driver, this);
	}
	
}
