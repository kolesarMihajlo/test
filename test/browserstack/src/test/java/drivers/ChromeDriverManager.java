package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

	private String driverPropertyKey = "webdriver.chrome.driver";

	@Override
	protected void startService() {
		System.setProperty(driverPropertyKey, driversBasePathValue + osPath + "/chromedriver" + extension);

	}

	@Override
	protected void stopService() {

	}

	@Override
	protected void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		driver = new ChromeDriver();
		
	}

}
