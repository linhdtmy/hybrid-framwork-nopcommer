package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.DetailProductUI;
import userPageUI.RecentViewProductUI;
import userPageUI.ReviewProductUI;

public class RecentViewProductObject extends BasePage {
	private WebDriver driver;

	public RecentViewProductObject(WebDriver driver) {
		this.driver = driver;
	}

	public int getSizeProduct() {
		waitForAllElementVisible(driver, RecentViewProductUI.PRODUCT_TITLE_LINK);
		return getListWebElement(driver, RecentViewProductUI.PRODUCT_TITLE_LINK).size();
	}

}
