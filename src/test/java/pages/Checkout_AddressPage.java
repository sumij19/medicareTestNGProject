package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class Checkout_AddressPage extends BasePage {

	//Checkout_AddressPage constructor
	public Checkout_AddressPage(WebDriver driver) {
		super(driver);
	}
	
	String Checkout_AddressPageURL = "http://localhost:8081/medicare/cart/checkout?execution=e1s1";	
	
	//Checkout_AddressPage Locators
	@FindBy(xpath = "//a[contains(text(),'Select')]") WebElement selectAddressBtn;
	
	//Checkout_AddressPage Methods
	public void clickSelectAddressBtn(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		selectAddressBtn = wait.until(ExpectedConditions.elementToBeClickable(selectAddressBtn));
		selectAddressBtn.click();
		
	}
	public String getCheckout_AddressPageURL() {
		return Checkout_AddressPageURL;
	}
	
}
