package pageObject.techpanda;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import jqueryUI.HomeJqueryUI;
import techpandaUI.HomeTechPandaUI;

public class HomePageTechpandaUserObject extends BasePage {
	private WebDriver driver;

	public HomePageTechpandaUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		waitForElementVisible(driver, HomeTechPandaUI.POPUP);
		clickToElement(driver, HomeTechPandaUI.CLOSE_ICON);
	}

}
