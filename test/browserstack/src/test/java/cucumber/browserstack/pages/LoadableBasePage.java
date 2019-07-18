package cucumber.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class LoadableBasePage extends LoadableComponent<LoadableBasePage>  {
	
	public WebDriver driver;
	
	public LoadableBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
}
