package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClassTest;
import pages.CartPage;
import pages.Checkout_AddressPage;
import pages.Checkout_PaymentPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.ProductsPage;

public class AddToCartCheckoutTest extends BaseClassTest{
	
	@Test
	public void verifyUserCanAddItemToCart() {

		try {
			HomePage home=new HomePage(driver);
			home.clickLoginLink();
			
			LoginPage login = new LoginPage(driver);
			login.clickLogin("abab@gmail.com", "123");
			home.clickProductsLink();
			
			ProductsPage product = new ProductsPage(driver);
			product.clickAddToCartBtn("Paracetamol");
			
			CartPage cartPage = new CartPage(driver);
			
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, cartPage.getSingleItemUrl());
			
			cartPage.clickDeleteBtn();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void verifyUserCanCheckoutSingleItem() {
		
		try {
			HomePage home=new HomePage(driver);
			home.clickLoginLink();
			
			LoginPage login = new LoginPage(driver);
			login.clickLogin("abab@gmail.com", "123");
			home.clickProductsLink();
			
			ProductsPage product = new ProductsPage(driver);
			product.clickAddToCartBtn("Paracetamol");
			
			CartPage cartPage = new CartPage(driver);
			String currentCartURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCartURL, cartPage.getSingleItemUrl());
			String actualText = cartPage.getProductName().getText();
			Assert.assertEquals("Paracetamol", actualText);
			cartPage.clickCheckout();
			
			Checkout_AddressPage checkoutAddress =new Checkout_AddressPage(driver);
			String currentCheckoutAddressPageURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCheckoutAddressPageURL, checkoutAddress.getCheckout_AddressPageURL());
			checkoutAddress.clickSelectAddressBtn();
			
			Checkout_PaymentPage checkoutPayment = new Checkout_PaymentPage(driver);
			String currentCheckoutPaymentPageURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCheckoutPaymentPageURL, checkoutPayment.getCheckout_PaymentPageURL());
						
			Assert.assertEquals(checkoutPayment.getGrandTotal(), checkoutPayment.getFinalPayment());
			checkoutPayment.clickpayBtn();
			
			OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
			String actualConfirmationMsg = orderConfirmationPage.getOrderConfirmationMsg().getText();
			Assert.assertEquals(actualConfirmationMsg, "Your Order is Confirmed!!");
			orderConfirmationPage.clickContinueShoppingBtn();
			
			home.clickLogoutLink();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
				
	}

	@Test
	public void verifyUserCanCheckoutMoreThanOneItem() {

		
		try {
			HomePage home=new HomePage(driver);
			home.clickLoginLink();
			
			LoginPage login = new LoginPage(driver);
			login.clickLogin("abab@gmail.com", "123");
			home.clickProductsLink();
			
			ProductsPage product = new ProductsPage(driver);
			product.clickAddToCartBtn("Paracetamol");
			
			CartPage cartPage = new CartPage(driver);
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, cartPage.getSingleItemUrl());
			
			String actualText = cartPage.getProductName().getText();
			Assert.assertEquals(actualText, "Paracetamol");
			
			String quantity = "2";
			cartPage.setQuantityValueWithinValidRange(quantity);
					
			cartPage.clickRefreshBtn();
			String currentUpdatedURL = driver.getCurrentUrl();
			Assert.assertEquals(currentUpdatedURL, cartPage.getCartPageUpdatedItemURL());
			String actualQuantity = cartPage.getQuantityTxt().getAttribute("value");
			System.out.println(actualQuantity);
			Assert.assertEquals(actualQuantity,quantity);
			
			cartPage.clickCheckout();
			
			Checkout_AddressPage checkoutAddress =new Checkout_AddressPage(driver);
			String currentCheckoutAddressPageURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCheckoutAddressPageURL, checkoutAddress.getCheckout_AddressPageURL());
			checkoutAddress.clickSelectAddressBtn();
			
			Checkout_PaymentPage checkoutPayment = new Checkout_PaymentPage(driver);
			String currentCheckoutPaymentPageURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCheckoutPaymentPageURL, checkoutPayment.getCheckout_PaymentPageURL());
						
			Assert.assertEquals(checkoutPayment.getGrandTotal(), checkoutPayment.getFinalPayment());
			checkoutPayment.clickpayBtn();
			
			OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
			String actualConfirmationMsg = orderConfirmationPage.getOrderConfirmationMsg().getText();
			Assert.assertEquals(actualConfirmationMsg, "Your Order is Confirmed!!");
			orderConfirmationPage.clickContinueShoppingBtn();
			
			home.clickLogoutLink();
			
						
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}

}
