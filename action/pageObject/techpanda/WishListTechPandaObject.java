package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MobileTechPandaUI;
import techpandaUI.MyAccountTechPandaUserUI;
import techpandaUI.TVTechPandaUI;
import techpandaUI.WishListTechPandaUI;

public class WishListTechPandaObject extends BasePage {
	private WebDriver driver;

	public WishListTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddWishListByName(String productName3) {
		waitForElementClickable(driver, TVTechPandaUI.WISHLIST_BY_NAME_LINK, productName3);
		clickToElement(driver, TVTechPandaUI.WISHLIST_BY_NAME_LINK, productName3);

	}

	public void clickToSaveAndShareWishListButton() {
		waitForElementClickable(driver, WishListTechPandaUI.SAVE_AND_SHARE_WISHLIST_BUTTON);
		clickToElement(driver, WishListTechPandaUI.SAVE_AND_SHARE_WISHLIST_BUTTON);
	}

	public void inputToEmail(String email) {
		waitForElementVisible(driver, WishListTechPandaUI.EMAIL_TEXT_AREA);
		sendKeyToElement(driver, WishListTechPandaUI.EMAIL_TEXT_AREA, email);

	}

	public void inputToMessage(String message) {
		waitForElementVisible(driver, WishListTechPandaUI.MESSAGE_TEXT_AREA);
		sendKeyToElement(driver, WishListTechPandaUI.MESSAGE_TEXT_AREA, message);

	}

	public void clickToShareWishListButton() {
		waitForElementVisible(driver, WishListTechPandaUI.SHARE_WISHLIST_BUTTON);
		clickToElement(driver, WishListTechPandaUI.SHARE_WISHLIST_BUTTON);
	}

	public boolean verifySuccessMsgDisplay() {
		waitForElementVisible(driver, WishListTechPandaUI.SUCCESS_MSG);
		return isElementDisplay(driver, WishListTechPandaUI.SUCCESS_MSG);
	}

	public ShoppingCartTechPandaObject clickToAddToCart() {
		waitForElementClickable(driver, WishListTechPandaUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishListTechPandaUI.ADD_TO_CART_BUTTON);
		return GenerateObject.getShoppingCartTechPandaObject(driver);
	}

}
