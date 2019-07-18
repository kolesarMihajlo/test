package cucumber.browserstack.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.browserstack.Constants;

public class BigNeonHomePage extends LoadableBasePage {

	public BigNeonHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//	private WebElement searchEvents;

//	public BigNeonHomePage(WebDriver driver) {
//		super(driver);
//		PageFactory.initElements(driver, this);
//	}
//
//	@Override
//	public void presetUrl() {
//		// TODO Auto-generated method stub
//		setUrl(Constants.BASE_URL_BIG_NEON);
//	}

	public List<WebElement> checkForResultOfSearch(String searchParam) {
		List<WebElement> elements = driver.findElements(By.xpath("a[contains(@href,'"+searchParam+"']"));
		return elements;
	}
	
	public boolean selectFirstFromFilteredList(String searchParam) {
		List<WebElement> elements = checkForResultOfSearch(searchParam);
		if (!elements.isEmpty()) {
			elements.get(0).click();
			return true;
		}
		return false;
	}
	
	@Override
	protected void load() {
		driver.get(Constants.BASE_URL_BIG_NEON);
	}

	@Override
	public void isLoaded() throws Error {
		Assert.assertTrue(driver.getCurrentUrl().contains(Constants.BASE_URL_BIG_NEON));
	}

}
