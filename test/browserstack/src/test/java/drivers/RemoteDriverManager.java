package drivers;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import util.AppProperties;
import util.ApplicationProperties;

public class RemoteDriverManager extends DriverManager {

	private String browserType;

	public RemoteDriverManager(String browserType) {
		super();
		this.browserType = browserType;
	}

	@Override
	protected void startService() {

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.LINUX);
		System.out.println("Remoting");
		try {
			String appProperty = AppProperties.getInstance().getProperty(ApplicationProperties.WEBDRIVES_BASE_PATHS);
			System.out.println(appProperty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver = new RemoteWebDriver(new java.net.URL("http://172.17.0.1:1111/wd/hub"), capabilities);

	}

	@Override
	public WebDriver getDriver() throws IOException {
		if (driver == null) {
			startService();
			createDriver();
		}
		return driver;
	}

}
