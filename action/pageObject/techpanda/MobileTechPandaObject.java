package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MobileTechPandaUI;
import techpandaUI.MyAccountTechPandaUserUI;

public class MobileTechPandaObject extends BasePage {
	private WebDriver driver;

	public MobileTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostByProductName(String productName) {
		waitForElementVisible(driver, MobileTechPandaUI.PRICE_BY_NAME, productName);
		return getElementText(driver, MobileTechPandaUI.PRICE_BY_NAME, productName);
	}

	public DetailProductTechPandaObject clickToProductName(String productName) {
		waitForElementVisible(driver, MobileTechPandaUI.PRODUCT_NAME_LINK, productName);
		clickToElement(driver, MobileTechPandaUI.PRODUCT_NAME_LINK, productName);
		return GenerateObject.getDetailProductTechPandaObject(driver);
	}

	public ShoppingCartTechPandaObject clickAddToCartByProductName(String productName) {
		waitForElementVisible(driver, MobileTechPandaUI.ADD_TO_CART_BUTTON_BY_PRODUCT, productName);
		clickToElement(driver, MobileTechPandaUI.ADD_TO_CART_BUTTON_BY_PRODUCT, productName);
		return GenerateObject.getShoppingCartTechPandaObject(driver);

	}

	public void clickAddToCompareByName(String productName) {
		waitForElementClickable(driver, MobileTechPandaUI.ADD_TO_COMPARE, productName);
		clickToElement(driver, MobileTechPandaUI.ADD_TO_COMPARE, productName);

	}

	public String getAddToCompareSuccessMsg(String productName1) {
		waitForElementVisible(driver, MobileTechPandaUI.SUCCESS_MSG);
		return getElementText(driver, MobileTechPandaUI.SUCCESS_MSG);
	}

	public void clickToCompareBtn() {
		waitForElementClickable(driver, MobileTechPandaUI.COMPARE_BUTTON);
		clickToElement(driver, MobileTechPandaUI.COMPARE_BUTTON);

	}

	

}
