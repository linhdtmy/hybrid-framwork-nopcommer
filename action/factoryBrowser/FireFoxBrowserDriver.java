package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxBrowserDriver implements BrowserDriver {

	@Override
	public WebDriver getDriverBrowser() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();

	}

}
