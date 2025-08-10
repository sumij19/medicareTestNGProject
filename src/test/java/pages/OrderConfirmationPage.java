package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class OrderConfirmationPage extends BasePage{

	//OrderConfirmationPage constructor
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	//OrderConfirmationPage Locators
	@FindBy (xpath="//h3[contains(text(),'Your Order is Confirmed!!')]") WebElement orderConfirmationMsg;
	@FindBy (xpath="//a[contains(text(),'Continue Shopping')]") WebElement ContinueShoppingBtn;

	//OrderConfirmationPage Methods
	public WebElement getOrderConfirmationMsg() {
		return orderConfirmationMsg;
	}
	public void clickContinueShoppingBtn() {
		ContinueShoppingBtn.click();
	}

}
