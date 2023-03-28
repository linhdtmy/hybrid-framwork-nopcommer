package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminNopcommerPageUI.DashboardUI;
import common.BasePage;
import common.GenerateObject;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayDashboard() {
		return isElementDisplay(driver, DashboardUI.DASHBOARD_HEADER);
	}

	public void clickToProduct() {
		waitForElementClickable(driver, DashboardUI.CATALOG_LEFT_MENU);
		clickToElement(driver, DashboardUI.CATALOG_LEFT_MENU);
		waitForElementClickable(driver, DashboardUI.PRODUCT_LEFT_MENU);
		clickToElement(driver, DashboardUI.PRODUCT_LEFT_MENU);

	}

	public void inputToProductName(String productName) {
		waitForElementVisible(driver, DashboardUI.PRODUCT_SEARCH_INPUT);
		sendKeyToElement(driver, DashboardUI.PRODUCT_SEARCH_INPUT, productName);

	}

	public void clickSearchButton() {
		waitForElementClickable(driver, DashboardUI.SEARCH_BUTTON);
		clickToElement(driver, DashboardUI.SEARCH_BUTTON);

	}

	public boolean isDisplayOneRecord() {
		return isElementDisplay(driver, DashboardUI.ONE_RECORD);
	}

	public boolean isDisplayProductName(String productName) {
		return isElementDisplay(driver, DashboardUI.PRODUCT_NAME, productName);
	}

	public void selectCategory(String categoryName) {
		waitForElementClickable(driver, DashboardUI.CATEGORY_SEARCH_SELECTBOX);
		selectItemInDefaultDropdownByText(driver, DashboardUI.CATEGORY_SEARCH_SELECTBOX, categoryName);

	}

	public boolean isDisplayNoDataMessage() {
		waitForElementVisible(driver, DashboardUI.NO_DATA_MESSAGE);
		return isElementDisplay(driver, DashboardUI.NO_DATA_MESSAGE);
	}

	public void checkToSearchSubCategory() {
		waitForElementVisible(driver, DashboardUI.SUB_CATEGORY_SEARCH_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, DashboardUI.SUB_CATEGORY_SEARCH_CHECKBOX);

	}

	public void clearToSearchSubCategory() {
		waitForElementVisible(driver, DashboardUI.SUB_CATEGORY_SEARCH_CHECKBOX);
		uncheckToDefaultCheckboxRadio(driver, DashboardUI.SUB_CATEGORY_SEARCH_CHECKBOX);

	}

	public void selectManufacture(String manufactureName) {
		waitForElementClickable(driver, DashboardUI.MANUFACTURE_SELECTBOX);
		selectItemInDefaultDropdownByText(driver, DashboardUI.MANUFACTURE_SELECTBOX, manufactureName);

	}

	public void inputToSku(String skuName) {
		sendKeyToElement(driver, DashboardUI.SKU_INPUT, skuName);

	}

	public void clickGoButton() {
		waitForElementClickable(driver, DashboardUI.GO_BUTTON);
		clickToElement(driver, DashboardUI.GO_BUTTON);

	}

	public boolean isDisplayProductDetail() {
		return isElementDisplay(driver, DashboardUI.PRODUCT_NAME_DETAIL);
	}

	public AddCustomerPageObject clickToCustomer() {
		waitForElementVisible(driver, DashboardUI.CUSTOMER_LEFT_MENU);
		clickToElement(driver, DashboardUI.CUSTOMER_LEFT_MENU);
		waitForElementVisible(driver, DashboardUI.SUB_CUSTOMER_LEFT_MENU);
		clickToElement(driver, DashboardUI.SUB_CUSTOMER_LEFT_MENU);
		return GenerateObject.getAddCustomerPageObject(driver);

	}
}
