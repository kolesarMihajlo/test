package cucumber.browserstack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.browserstack.Constants;

public class BigNeonLoginPage extends BasePage {
	
	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
//	@FindBy(css = ".jss225 .jss253 .jss227 .jss219 .jss229 ,jss232")
//	private WebElement loginButton;

	public BigNeonLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void presetUrl() {
		setUrl(Constants.BASE_URL_BIG_NEON + "login");
	}
	
	public void navigate() {
		driver.get(getUrl());
	}
	
	
	public boolean login() {
		navigate();
		username.sendKeys("kolesar.mihal@gmail.com");
		password.sendKeys("kolesar987");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div/div/div[2]/div[2]/form/div[2]/button"));
		WebElement recaptcha  = driver.findElement(By.className("g-recaptcha"));
		recaptcha.click();
		loginButton.click();
		boolean retVal = false;
		try {
			retVal = explicitWait(8, ExpectedConditions.stalenessOf(recaptcha));
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			retVal = false;
		}
		return retVal;
		
	}
	
	
	

}
