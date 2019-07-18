package cucumber.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class NavEventListener extends AbstractWebDriverEventListener {
	
//	@Override
//	public void beforeNavigateTo(String url, WebDriver driver) {
//		System.out.println("Before Navigate to: " + url);
//	}
	
	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("before navigate back" + driver.getCurrentUrl());
	}
	
}
