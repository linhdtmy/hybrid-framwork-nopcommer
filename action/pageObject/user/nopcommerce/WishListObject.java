package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.DetailProductUI;
import userPageUI.ReviewProductUI;
import userPageUI.WishListUI;

public class WishListObject extends BasePage {
	private WebDriver driver;

	public WishListObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayNameProduct() {
		waitForElementVisible(driver, WishListUI.PRODUCT_NAME);
		return isElementDisplay(driver, WishListUI.PRODUCT_NAME);
	}

	public void clickToShareLink() {
		waitForElementClickable(driver, WishListUI.SHARE_LINK);
		clickToElement(driver, WishListUI.SHARE_LINK);

	}

	public String getTitleWishlistPage() {
		waitForElementVisible(driver, WishListUI.WISHLIST_TITLE);
		return getElementText(driver, WishListUI.WISHLIST_TITLE);
	}

	public void checkToCheckbox() {
		waitForElementClickable(driver, WishListUI.CHECKBOX);
		checkToDefaultCheckboxRadio(driver, WishListUI.CHECKBOX);

	}

	public CartObject clickAddToCardButton() {
		waitForElementClickable(driver, WishListUI.ADD_TO_CARD_BUTTON);
		clickToElement(driver, WishListUI.ADD_TO_CARD_BUTTON);
		return GenerateObject.getCartObject(driver);
	}

	public void clickToRemoveProduct() {
		waitForElementClickable(driver, WishListUI.REMOVE_BUTTON);
		clickToElement(driver, WishListUI.REMOVE_BUTTON);
		sleepInSecond(2);
	}

	public String getMessageEmtyProduct() {
		waitForElementVisible(driver, WishListUI.MESSAGE_EMTY_PRODUCT);
		return getElementText(driver, WishListUI.MESSAGE_EMTY_PRODUCT);
	}

	public boolean isUnDisplayTableCart() {

		return isElementUnDisplay(driver, WishListUI.TABLE_CART);
	}

}
