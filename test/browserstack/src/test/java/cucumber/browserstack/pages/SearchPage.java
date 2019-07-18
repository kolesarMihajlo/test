package cucumber.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.browserstack.Constants;

public class SearchPage extends BasePage {
	
	@FindBy(name = "q")
	private WebElement searchBox;
	
	private WebElement title;
	
	@Override
	public void presetUrl() {
		setUrl(Constants.BASE_URL_GOOGLE);
		
	}
	
	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void navigate() {
		getDriver().get(getUrl());
	}
	
	public void fillSearchBox(String searchParam) {
		searchBox.sendKeys(searchParam);
		
	}
	
	public void submitForSearch() {
		searchBox.submit();
	}
	


}
