package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.ReviewProductUI;

public class ReviewProductObject extends BasePage{
	private WebDriver driver;

	public ReviewProductObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTitleReview(String title) {
		waitForElementClickable(driver, ReviewProductUI.REVIEW_TITLE);
		sendKeyToElement(driver, ReviewProductUI.REVIEW_TITLE, title);
		
	}

	public void inputToContentReview(String content) {
		waitForElementClickable(driver, ReviewProductUI.REVIEW_TEXT);
		sendKeyToElement(driver, ReviewProductUI.REVIEW_TEXT, content);
		
	}

	public void clickToRating() {
		waitForElementClickable(driver, ReviewProductUI.RATING);
		clickToElement(driver, ReviewProductUI.RATING);
		
	}

	public void clickButtonSaveReview() {
		waitForElementClickable(driver, ReviewProductUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver,  ReviewProductUI.SUBMIT_REVIEW_BUTTON);
		
	}

	public CustomerInformUserObject clickToMyAccount() {
		waitForElementClickable(driver, ReviewProductUI.MY_ACCOUNT_LINK);
		clickToElement(driver, ReviewProductUI.MY_ACCOUNT_LINK);
		return GenerateObject.getMyAccountPage(driver);
	}
}
