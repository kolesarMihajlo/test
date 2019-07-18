package cucumber.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.browserstack.Constants;

public class EventsPage extends BasePage{

	public EventsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void presetUrl() {
		setUrl(Constants.BASE_URL_BIG_NEON + "/events");
	}
	
	public boolean checkIfRightUrlBasedOnPathParam(String searchParam) {
		String current = driver.getCurrentUrl();
		return current.contains(searchParam);
	}


}
