package drivers;

import java.util.Map;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFactory {

	public Capabilities getCapabilities(Map<String, String> parameters, String browserType) throws OperationNotSupportedException {
		DesiredCapabilities capabilities = null;
		if (browserType == null || browserType.isEmpty()) {
			throw new OperationNotSupportedException("browser must be specified for remote browser");
		} else {
			if ("ch".equals(browserType)) {
				capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("chrome");
				
			} else if ("ff".equals(browserType)) {
				capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("firefox");
				capabilities.setCapability("marionette", true);
			}
		}
		return capabilities;
	}

}
