package cucumber.browserstack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.browserstack.pages.BigNeonHomePage;
import cucumber.browserstack.pages.BigNeonLoginPage;
import cucumber.browserstack.pages.EventsPage;
import cucumber.browserstack.pages.Header;
import drivers.DriverFactory;

public class HeaderStepsTest {

	private WebDriver driver;
	private Header header;
	private BigNeonHomePage homePage;
	private BigNeonLoginPage loginPage;

	@BeforeClass
	public void setUp() throws IOException {
		driver = DriverFactory.getDriver();
		loginPage = new BigNeonLoginPage(driver);
		Assert.assertTrue(loginPage.login());
		homePage = new BigNeonHomePage(driver);
		homePage.isLoaded();
	}

	@Test(dataProvider = "search_params")
	public void searchInHeader(String params) {
		header = new Header(driver);
		header.searchEvents(params);
		if (params == null || params.equals("")) {
			homePage.isLoaded();
		} else {
			homePage.selectFirstFromFilteredList(params);
			EventsPage events = new EventsPage(driver);
			Assert.assertTrue(events.checkIfRightUrlBasedOnPathParam(params));
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "search_params")
	public static Object[][] data() {
		return new Object[][] { { "flyleaf" } };
	}

}
