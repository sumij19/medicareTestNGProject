package pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import utils.WaitUtil;

public class HomePage extends BasePage {
	
	//homePage Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//homePage Locators
	@FindBy(xpath = "//a[contains(text(),'Login')]")WebElement loginLink;
	@FindBy(xpath = "//a[contains(text(),'Sign')]")WebElement SignUpLink;
	@FindBy(xpath = "//li[@id='listProducts']/a")WebElement ProductsLink;
	@FindBy(xpath = "//li[@id='logout']/a[contains(text(),'Logout')]")WebElement LogoutLink;
	String homePageURL = "http://localhost:8081/medicare/";
				
	//homePage methods
	public void clickSignUpLink() {
		SignUpLink.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void clickProductsLink() {
		waitUtil.waitForClickable(ProductsLink).click();
	}
	
	public void clickLogoutLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LogoutLink);
		//LogoutLink.click();
	}

	public String getUrl() {
		
		return homePageURL;
	}

}	

		