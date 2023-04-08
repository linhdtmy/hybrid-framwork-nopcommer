package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.DetailProductTechPandaUI;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MyAccountTechPandaUserUI;
import techpandaUI.ReviewProductTechPandaUI;

public class ReviewProductTechPandaObject extends BasePage {
	private WebDriver driver;

	public ReviewProductTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostProduct() {
		waitForElementVisible(driver, DetailProductTechPandaUI.PRICE);
		return getElementText(driver, DetailProductTechPandaUI.PRICE);
	}

	public void clickToQuality() {
		waitForElementClickable(driver, ReviewProductTechPandaUI.QUALITY_RADIO);
		clickToElement(driver, ReviewProductTechPandaUI.QUALITY_RADIO);

	}

	public void inputToYourThought(String yourThought) {
		waitForElementClickable(driver, ReviewProductTechPandaUI.YOUR_THOUGHT);
		sendKeyToElement(driver, ReviewProductTechPandaUI.YOUR_THOUGHT, yourThought);
	}

	public void inputToYourReview(String yourReview) {
		waitForElementClickable(driver, ReviewProductTechPandaUI.YOUR_REVIEW);
		sendKeyToElement(driver, ReviewProductTechPandaUI.YOUR_REVIEW, yourReview);
	}

	public void inputToYourNickname(String yourNickname) {
		waitForElementClickable(driver, ReviewProductTechPandaUI.NICK_NAME);
		sendKeyToElement(driver, ReviewProductTechPandaUI.NICK_NAME, yourNickname);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, ReviewProductTechPandaUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ReviewProductTechPandaUI.SUBMIT_REVIEW_BUTTON);

	}

	public boolean isDisplayReviewSuccessMsg() {
		return isElementDisplay(driver, ReviewProductTechPandaUI.REVIEW_SUCCESS_MESSAGE);
	}

}
