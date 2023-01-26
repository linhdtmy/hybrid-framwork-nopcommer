package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.CartUI;
import userPageUI.DetailProductUI;
import userPageUI.HomePageUI;
import userPageUI.ReviewProductUI;
import userPageUI.WishListUI;

public class CartObject extends BasePage {
	private WebDriver driver;

	public CartObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getQuantity(String name) {
		sleepInSecond(2);
		waitForElementVisible(driver, CartUI.QUANTITY_ITEM, name);
		return getElementText(driver, CartUI.QUANTITY_ITEM, name);
	}

	
}
