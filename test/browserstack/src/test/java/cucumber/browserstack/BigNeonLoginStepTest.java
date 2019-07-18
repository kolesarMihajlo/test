package cucumber.browserstack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.browserstack.pages.BigNeonLoginPage;
import drivers.DriverFactory;

public class BigNeonLoginStepTest {
	
	BigNeonLoginPage loginPage;
	private WebDriver driver;
	
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = DriverFactory.getDriver();
		loginPage = new BigNeonLoginPage(driver);
	}
	
	@Test
	public void loginTest() {
		boolean retVal = loginPage.login();
		System.out.println(" Result: " + retVal);
		Assert.assertTrue(retVal);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
