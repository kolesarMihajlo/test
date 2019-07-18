package cucumber.browserstack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {
	
//	/html/body/div[1]/div/header/div/form/input
	@FindBy(css = "header form input")
	private WebElement searchEvents;
//	/html/body/div[1]/div/header/div/span/div/span/img
	@FindBy(xpath = "/html/body/div[1]/div/header/div/span/div/span/img")
	private WebElement profileOptions;
	
	public Header(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void presetUrl() {
		
	}
	
	public void searchEvents(String event) {
		if (event != null) {
			searchEvents.sendKeys(event);
			searchEvents.submit();
		}
	}
	
	
	public WebElement openProfileOptions() {
//		/html/body/div[4]/div[2]
		WebElement profileDropDownMenu = null;
		profileOptions.click();
		try {
			profileDropDownMenu = explicitWait(5, ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[2]")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileDropDownMenu;
		
	}
	
	
	

}
