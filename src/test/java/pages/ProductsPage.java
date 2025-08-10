package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ProductsPage extends BasePage {
	
	//ProductsPage Constructor
		public ProductsPage(WebDriver driver) {
			super(driver);
		}

		//ProductsPage Locators
		//Dynamic locator method
		public WebElement getProductCartBtn(String productName) {
			String xpath = "//td[contains(text(),'"+productName+"')]/following-sibling::td/a[@class='btn btn-success']";
			return driver.findElement(By.xpath(xpath));
		}
		//@FindBy(xpath = "//td[contains(text(),'Paracetamol')]/following-sibling::td/a[@class='btn btn-success']")WebElement productCartBtn;
			
		
		//ProductsPage methods
		public void clickAddToCartBtn(String productName) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement cartBtn =getProductCartBtn(productName);
				cartBtn = wait.until(ExpectedConditions.elementToBeClickable(getProductCartBtn(productName)));
				
					getProductCartBtn(productName).click();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
				
		
}
