package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassTest {
	
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get("http://localhost:8081/medicare");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}

	@AfterClass
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
	}
}
