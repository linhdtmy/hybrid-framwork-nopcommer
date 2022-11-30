package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import techpandaUI.HomeTechPandaUI;

public class HomePageTechpandaAdminObject extends BasePage {
	private WebDriver driver;

	public HomePageTechpandaAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		waitForElementVisible(driver, HomeTechPandaUI.POPUP);
		clickToElement(driver, HomeTechPandaUI.CLOSE_ICON);
	}

}
