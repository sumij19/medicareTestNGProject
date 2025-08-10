package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class CartPage extends BasePage {
	
	//CartPage Constructor 
		public CartPage(WebDriver driver) {
			super(driver);
			
		}
		
		String cartPageSingleItemURL = "http://localhost:8081/medicare/cart/show?result=added";	
		String cartPageUpdatedItemURL = "http://localhost:8081/medicare/cart/show?result=updated";
		
		//CartPage Locators
		@FindBy(xpath = "//h4[contains(text(),'Paracetamol')]")WebElement productName;
		
		@FindBy(xpath = "//tr[td//h4[contains(text(),'Paracetamol')]]/td/input[@type='number']")WebElement quantityTxt;
		@FindBy(xpath = "//tr[td//h4[contains(text(),'Paracetamol')]]/td[@data-th='Price']")WebElement price;
		@FindBy(xpath = "//tr[td//h4[contains(text(),'Paracetamol')]]/td[@data-th='Subtotal']")WebElement subtotal;
		@FindBy(xpath = "//tr[td//h4[contains(text(),'Paracetamol')]]/td/button[@name='refreshCart']")WebElement refreshBtn;	
		@FindBy(xpath = "//tr[td//h4[contains(text(),'Paracetamol')]]/td/a[@class='btn btn-danger btn-sm']")WebElement deleteBtn;
		@FindBy(xpath = "//td/strong[contains(text(),'Total')]")WebElement total;
		@FindBy(xpath = "//a[contains(text(),' Continue Shopping')]")WebElement continueShoppingLink;
		@FindBy(xpath = "//a[contains(text(),'Checkout ')]")WebElement checkoutLink;
		By checkoutLinkLocator = By.xpath("//a[contains(text(),'Checkout ')]");
		
		//CartPage methods
		public WebElement getProductName() {
			return productName;
		}

		public void clickCheckout() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement checkoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLinkLocator));
				checkoutLink.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void clickContinueShopping() {
			continueShoppingLink.click();
		}
		
		public void setQuantityValueWithinValidRange(String value) {
			quantityTxt.clear();
			quantityTxt.sendKeys(value);	
			
		}
		public WebElement getQuantityTxt() {
			
			return quantityTxt;
		}

		
		public boolean checkSubtotal() {
			
			String priceStrValue = price.getText();
			String priceOnlyDigit = "";
			for(int i=0;i<priceStrValue.length();i++) {
				
				if (Character.isDigit(priceStrValue.charAt(i))) {
					priceOnlyDigit+=priceStrValue.charAt(i);
				}
				
			}
			
			int price = Integer.parseInt(priceOnlyDigit);
			
			String quantityTxtStrValue = quantityTxt.getText();
			int quantity = Integer.parseInt(quantityTxtStrValue);
			
			String subtotalStrValue = subtotal.getText();
			int subtotal = Integer.parseInt(subtotalStrValue);
			
			if(subtotal == price*quantity) {
				return true;
			}
			else return false;
		}
		
		public void clickRefreshBtn() {
			refreshBtn.click();
		}
		
		public void clickDeleteBtn() {
			deleteBtn.click();
		}

		public String getSingleItemUrl() {
			
			return cartPageSingleItemURL;
		}
		
		public String getCartPageUpdatedItemURL() {
			return cartPageUpdatedItemURL;
		}

}
