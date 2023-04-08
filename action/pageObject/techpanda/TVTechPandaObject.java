package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MobileTechPandaUI;
import techpandaUI.MyAccountTechPandaUserUI;
import techpandaUI.TVTechPandaUI;

public class TVTechPandaObject extends BasePage {
	private WebDriver driver;

	public TVTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public WishListTechPandaObject clickToAddWishListByName(String productName3) {
		waitForElementClickable(driver, TVTechPandaUI.WISHLIST_BY_NAME_LINK, productName3);
		clickToElement(driver, TVTechPandaUI.WISHLIST_BY_NAME_LINK, productName3);
		return GenerateObject.getWishListTechPandaObject(driver);
	}

	public DetailProductTechPandaObject clickToProductName() {
		waitForElementClickable(driver, TVTechPandaUI.PRODUCT_NAME);
		clickToElement(driver, TVTechPandaUI.PRODUCT_NAME);
		return GenerateObject.getDetailProductTechPandaObject(driver);
	}

}
