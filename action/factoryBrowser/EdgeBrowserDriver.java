package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowserDriver implements BrowserDriver {
	 

	@Override
	public WebDriver getDriverBrowser() {
		WebDriverManager.edgedriver().setup();
		return  new EdgeDriver();
	}

}
