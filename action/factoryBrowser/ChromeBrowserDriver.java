package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserDriver implements BrowserDriver {
	private String projectPath = System.getProperty("user.dir");

	@Override
	public WebDriver getDriverBrowser() {
		File file = new File(projectPath + "\\browserExtensions\\extension_Ublock.crx");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(file);
		 WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}

}
