package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

	//LoginPage Constructor 
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//LoginPage Locators
	@FindBy(xpath = "//input[@id='username']")WebElement loginEmailField;
	@FindBy(xpath = "//input[@id='password']")WebElement loginPasswordField;
	@FindBy(xpath = "//input[@value='Login']")WebElement loginButton;
	@FindBy(xpath = "//a[contains(text(),'Register')]")WebElement registerLink;
		
	//LoginPage methods
	public void clickLogin(String userEmail, String password) {
		loginEmailField.sendKeys(userEmail);
		loginPasswordField.sendKeys(password);
		loginButton.click();
		
	}

}
