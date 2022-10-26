package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminPageUI.DashboardUI;
import common.BasePage;

public class DashboardPageObject   extends BasePage {
	private WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayDashboard() {
		return isElementDisplay(driver, DashboardUI.DASHBOARD_HEADER);
	}
}
