package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.DetailProductUI;
import userPageUI.ReviewProductUI;

public class DetailProductObject extends BasePage{
	private WebDriver driver;

	public DetailProductObject(WebDriver driver) {
		this.driver = driver;
	}

	public ReviewProductObject clickToAddReviewLink() {
		waitForElementClickable(driver, DetailProductUI.REVIEW_LINK);
		clickToElement(driver, DetailProductUI.REVIEW_LINK);
		return GenerateObject.getReviewPage(driver);
		
	}
}
