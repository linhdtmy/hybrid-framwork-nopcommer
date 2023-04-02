package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MobileTechPandaUI;
import techpandaUI.MyAccountTechPandaUserUI;
import techpandaUI.ShoppingCartTechPandaUI;

public class ShoppingCartTechPandaObject extends BasePage {
	private WebDriver driver;

	public ShoppingCartTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterCouponCode(String couponCode) {
		sendKeyToElement(driver, ShoppingCartTechPandaUI.COUPON_CODE, couponCode);

	}

	public void clickToApplyButton() {
		waitForElementVisible(driver, ShoppingCartTechPandaUI.APPLY_BUTTON);
		clickToElement(driver, ShoppingCartTechPandaUI.APPLY_BUTTON);

	}

	public boolean isDisplayMessageAddCartSuccess(String messageSuccess) {
		waitForElementVisible(driver, ShoppingCartTechPandaUI.ADD_CART_SUCCESS_MESSAGE);
		return messageSuccess.equals(getElementText(driver, ShoppingCartTechPandaUI.ADD_CART_SUCCESS_MESSAGE));
	}

	public boolean isDiscountPriceTrue(String discountPrice) {
		waitForElementVisible(driver, ShoppingCartTechPandaUI.DISCOUNT);
		return discountPrice.equals(getElementText(driver, ShoppingCartTechPandaUI.DISCOUNT));
	}

	public boolean isGrandTotalTrue(String grandTotal) {
		waitForElementVisible(driver, ShoppingCartTechPandaUI.GRAND_TOTAL);
		return grandTotal.equals(getElementText(driver, ShoppingCartTechPandaUI.GRAND_TOTAL));
	}

}
