package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OperaBrowserDriver implements BrowserDriver {
	 

	@Override
	public WebDriver getDriverBrowser() {
		WebDriverManager.operadriver().setup();
		return new OperaDriver();
	}

}
