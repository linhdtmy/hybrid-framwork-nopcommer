package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import userPageUI.ReviewCustomerUI;

public class ReviewCustomerObject extends BasePage{
	private WebDriver driver;

	public ReviewCustomerObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewMyAccountLabel() {
	waitForElementVisible(driver, ReviewCustomerUI.PRODUCT_LINK);
	return getElementText(driver,  ReviewCustomerUI.PRODUCT_LINK);
	}
}
