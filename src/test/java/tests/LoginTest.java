package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClassTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClassTest {

	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		
		try {
			HomePage home=new HomePage(driver);
			home.clickLoginLink();
			
			LoginPage login = new LoginPage(driver);
			login.clickLogin("abab@gmail.com", "123");
					
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, home.getUrl());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}

	@Test
	public void verifyLoginWithInValidCredentials() {
		
		try {
			HomePage home=new HomePage(driver);
			home.clickLoginLink();
			
			LoginPage login = new LoginPage(driver);
			login.clickLogin("abab@gmail.com", "1234");
			
			String currentURL = driver.getCurrentUrl();
			String expectedURL = "http://localhost:8081/medicare/login?error";
			Assert.assertEquals(currentURL, expectedURL);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
