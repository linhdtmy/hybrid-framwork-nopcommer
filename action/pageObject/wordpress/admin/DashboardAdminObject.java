package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.AddressPageUI;
import userPageUI.CustomerUI;
import userPageUI.RegisterPageUI;
import wordpressAdminUI.DashboardAdminUI;

public class DashboardAdminObject extends BasePage {

	private WebDriver driver;

	public DashboardAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public ListPostAdminObject clickToPost() {
		waitForElementClickable(driver, DashboardAdminUI.POST_BUTTON);
		clickToElement(driver, DashboardAdminUI.POST_BUTTON);
		return GenerateObject.getListPostAdminObject(driver);

	}

}
