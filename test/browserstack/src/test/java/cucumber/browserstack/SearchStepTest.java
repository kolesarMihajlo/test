package cucumber.browserstack;

import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.browserstack.pages.SearchPage;
import drivers.DriverFactory;

public class SearchStepTest {

	private SearchPage searchPage;
	private WebDriver driver;

//	public String searchParam;

	@BeforeClass
	public void setUp() throws IOException {
		driver = DriverFactory.getDriver();
		searchPage = new SearchPage(driver);
	}

	// @Test
	// public void main_test() {
	// 	assertTrue(a_user_is_on_page());
	// 	assertTrue(b_test_navigate_back());
	// }

	@Test(dataProvider = "search_params")
	public void a_user_is_on_page(String searchParam) {
		searchPage.navigate();
		System.out.println("search: " + searchParam);
		searchPage.fillSearchBox(searchParam);
		searchPage.submitForSearch();
		boolean pageSwitch = false;
		try {
			pageSwitch = searchPage.explicitWait(5, ExpectedConditions.titleContains(searchParam));
		} catch (TimeoutException e) {
			pageSwitch = false;
		}
//		return pageSwitch;
		Assert.assertTrue(pageSwitch);
	}

//	@Test(dataProvider = "search_params")
	public void b_test_navigate_back(String searchParam) {
		System.out.println("b_test_navigate_back:" + driver.getCurrentUrl());
		driver.navigate().back();
		Assert.assertTrue(Constants.BASE_URL_GOOGLE.equals(driver.getCurrentUrl()));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name = "search_params")
	public static Object[][] data() {
		return new Object[][] { { "star trek" }, { "java" } };
	}


}
