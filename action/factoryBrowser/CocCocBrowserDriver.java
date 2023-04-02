package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CocCocBrowserDriver implements BrowserDriver {
	 

	@Override
	public WebDriver getDriverBrowser() {
		WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
		return  new ChromeDriver(options);
	}

}
