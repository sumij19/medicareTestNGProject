package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class Checkout_PaymentPage  extends BasePage {

		//Checkout_PaymentPage constructor
		public Checkout_PaymentPage(WebDriver driver) {
			super(driver);
		}
		
		String Checkout_PaymentPageURL = "http://localhost:8081/medicare/cart/checkout?execution=e1s2";
		
		//Checkout_PaymentPage Locators
		@FindBy(xpath = "//a[contains(text(),'Pay')and@role='button']") WebElement payBtn;
		@FindBy(xpath = "//div/h3[contains(text(),'Paracetamol')]/following::div/h3[contains(text(),'Grand Total')]") WebElement grandTotal;
		@FindBy(xpath = "//li[@class='active']/a/span") WebElement finalPayment;
		
		public double getGrandTotal() {
			String grandTotalStr = grandTotal.getText();
			String grandTotalPriceStr = grandTotalStr.substring(16, grandTotalStr.length()-2);
			double grandTotalPrice = Double.parseDouble(grandTotalPriceStr);
			
			return grandTotalPrice;
		}

		public double getFinalPayment() {
			String finalPaymentStr = finalPayment.getText();
			String finalPaymentPriceStr = finalPaymentStr.substring(2, finalPaymentStr.length()-2);
			double finalPaymentPrice = Double.parseDouble(finalPaymentPriceStr);
			
			return finalPaymentPrice;
		}

		//Checkout_PaymentPage Methods
		public void clickpayBtn(){
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				payBtn = wait.until(ExpectedConditions.elementToBeClickable(payBtn));
				payBtn.click();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		public String getCheckout_PaymentPageURL() {
			return Checkout_PaymentPageURL;
		}
		
}
