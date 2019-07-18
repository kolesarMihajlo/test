package drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager{
	
	private  String driverPropertyKey = "webdriver.gecko.driver";
	
	@Override
	protected void startService() {
		System.setProperty(driverPropertyKey, driversBasePathValue+osPath+"/geckodriver"+extension);
	}

	@Override
	protected void stopService() {
	
	}

	@Override
	protected void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("test-type");
		driver = new FirefoxDriver();
	}

}
