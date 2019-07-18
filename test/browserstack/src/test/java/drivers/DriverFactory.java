package drivers;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.browserstack.BrowsersEnum;

public class DriverFactory {

	public static final String USERNAME = "mihajlokolesar1";
	public static final String AUTOMATE_KEY = "txnsAiFEM4HVNzswBFtY";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	private static String browser;

	public static WebDriver getDriver() throws IOException {
		browser = System.getProperty("browser");
		BrowsersEnum browserEnum = BrowsersEnum.getEnumForCode(browser);
		DriverManager manager;
		switch (browserEnum) {
		case FIREFOX:
			System.out.println(" Firefox local");
			manager = new FirefoxDriverManager();
			break;
		case CHROME:
			System.out.println("Chrome local");
			manager = new ChromeDriverManager();
			break;
		case REMOTE:
			System.out.println("Remoting");
			manager = new RemoteDriverManager("ff");
			break;
		default:
			System.out.println("Local default");
			manager = new FirefoxDriverManager();// set safari as default
			break;
		}

		return manager.getDriver();

	}

//	public static WebDriver getDriver(String params) throws MalformedURLException {
//		if ("remote".equals(params)) {
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability("browser", "Chrome");
//			caps.setCapability("browser_version", "66.0");
//			caps.setCapability("os", "Windows");
//			caps.setCapability("os_version", "10");
//			caps.setCapability("resolution", "1600x1200");
//			caps.setCapability("name", "Bstack-[Java] Sample Test");
//			WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
//			return driver;
//		} else if ("firefox".equals(params)) {
//			String os = System.getProperty("os.name");
//			String osPath = null;
//			String extension = "";
//			if (os.contains("Windows")) {
//				osPath = "windows";
//				extension = ".exe";
//			} else {
//				osPath = "linux";
//			}
//			System.setProperty("webdriver.gecko.driver",
//					"src/test/resources/drivers/" + osPath + "/geckodriver" + extension);
//			return new FirefoxDriver();
//		} else {
//			return null;
//		}
//	}

}
