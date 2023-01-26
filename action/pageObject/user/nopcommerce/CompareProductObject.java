package pageObject.user.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GenerateObject;
import userPageUI.CartUI;
import userPageUI.CompareProductUI;
import userPageUI.DetailProductUI;
import userPageUI.HomePageUI;
import userPageUI.ReviewProductUI;
import userPageUI.WishListUI;

public class CompareProductObject extends BasePage {
	private WebDriver driver;

	public CompareProductObject(WebDriver driver) {
		this.driver = driver;
	}

	public int getQuantityRemoveButton() {
		waitForAllElementVisible(driver, CompareProductUI.REMOVE_BUTTON);
		return getListWebElement(driver, CompareProductUI.REMOVE_BUTTON).size();
	}

	public String getNameProduct(String name) {

		waitForElementVisible(driver, CompareProductUI.NAME_PRODUCT, name);
		// waitForElementVisible(driver, "//tr[@class='product-name']//a[@href='/apple-macbook-pro-13-inch']");
		return getElementText(driver, CompareProductUI.NAME_PRODUCT, name);
		// return getElementText(driver, "//tr[@class='product-name']//a[@href='/apple-macbook-pro-13-inch']");
	}

	public String getTextByProductName(String productName) {

		int index = getListWebElement(driver, CompareProductUI.INDEX_BY_ROW, productName).size() + 1;
		return getElementText(driver, CompareProductUI.PRICE, Integer.toString(index));
	}

	public void clickCleartButton() {
		waitForElementClickable(driver, CompareProductUI.CLEAR_BUTTON);
		clickToElement(driver, CompareProductUI.CLEAR_BUTTON);

	}

	public String getMessageNoProductToCompare() {
		waitForElementVisible(driver, CompareProductUI.MESSAGE_COMPARE_LIST_NO_DATA);
		return getElementText(driver, CompareProductUI.MESSAGE_COMPARE_LIST_NO_DATA);
	}

	public boolean isUnDisplayTableCompareProduct() {
		waitForElementInVisible(driver, CompareProductUI.TABLE_COMPARE_PRODUCT);
		return isElementUnDisplay(driver, CompareProductUI.TABLE_COMPARE_PRODUCT);

	}

//	public boolean isProductNameDisplay() {
//		List<WebElement>listElement = getListWebElement(driver, CompareProductUI.NAME_PRODUCT);
//		for (WebElement webElement : listElement) {
//			
//		}
//	}

}
