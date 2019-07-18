package cucumber.browserstack.pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;

	private String url;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		presetUrl();
	}

	public abstract void presetUrl();
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void pageLoadTimeOutInSec(int seconds) {
		this.driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unchecked")
	public <T, V> T explicitWait(int time, Function<? super WebDriver, V> condition) {
		return (T) new WebDriverWait(driver, time).until(condition);
	}

	public boolean isAtPage() {
		return driver.getCurrentUrl().equals(url);
	}

}
