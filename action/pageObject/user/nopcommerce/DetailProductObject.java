package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.DetailProductUI;
import userPageUI.ReviewProductUI;

public class DetailProductObject extends BasePage {
	private WebDriver driver;

	public DetailProductObject(WebDriver driver) {
		this.driver = driver;
	}

	public ReviewProductObject clickToAddReviewLink() {
		waitForElementClickable(driver, DetailProductUI.REVIEW_LINK);
		clickToElement(driver, DetailProductUI.REVIEW_LINK);
		return GenerateObject.getReviewPage(driver);

	}

	public void clickToAddWishListButton() {
		waitForElementClickable(driver, DetailProductUI.WISHLIST_BUTTON);
		clickToElement(driver, DetailProductUI.WISHLIST_BUTTON);
	}

	public String getMessageAddToWishListSuccess() {
		waitForElementVisible(driver, DetailProductUI.MESSAGE_ADD_WISHLIST_SUCCESS);
		return getElementText(driver, DetailProductUI.MESSAGE_ADD_WISHLIST_SUCCESS);
	}

	public WishListObject clickWishListLink() {
		waitForElementClickable(driver, DetailProductUI.WISHLIST_LINK);
		clickToElement(driver, DetailProductUI.WISHLIST_LINK);
		return GenerateObject.getWishListObject(driver);
	}
}
