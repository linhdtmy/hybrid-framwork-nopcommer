package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminNopcommerPageUI.DashboardUI;
import adminNopcommerPageUI.EditCustomerUI;
import adminNopcommerPageUI.ListCustomerUI;
import adminNopcommerPageUI.AddNewCustomerUI;
import common.BasePage;
import common.GenerateObject;

public class ListCustomerPageObject extends BasePage {
	private WebDriver driver;

	public ListCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectCustomerRole(String textValueOption) {

		hoverMouseToElement(driver, ListCustomerUI.CUSTOMER_ROLE_SELECTBOX);
		if (isElementDisplay(driver, ListCustomerUI.DELETE_ICON_CUSTOMER_ROLE)) {
			clickToElement(driver, ListCustomerUI.DELETE_ICON_CUSTOMER_ROLE);
		}
		clickToElement(driver, ListCustomerUI.CUSTOMER_ROLE_SELECTBOX);
		clickToElement(driver, ListCustomerUI.OPTION_CUSTOMER_ROLE_SELECTBOX, textValueOption);

	}

	public void clickSearchButton() {
		waitForElementClickable(driver, ListCustomerUI.SEARCH_BUTTON);
		clickToElement(driver, ListCustomerUI.SEARCH_BUTTON);
		sleepInSecond(3);
		
	}

	public String getTextByColumn(String columnName) {

		return getElementText(driver, ListCustomerUI.CELL, getIndexColumn(columnName));

	}

	private String getIndexColumn(String columnName) {
		waitForElementVisible(driver, ListCustomerUI.PRECEDING_COLUMN_TABLE, columnName);
		return Integer.toString(getElementSize(driver, ListCustomerUI.PRECEDING_COLUMN_TABLE, columnName) + 1);
	}

	private String getIndexRow(String emailValue) {
		waitForElementVisible(driver, ListCustomerUI.PRECEDING_COLUMN_TABLE, emailValue);
		return Integer.toString(getElementSize(driver, ListCustomerUI.PRECEDING_COLUMN_TABLE, emailValue) + 1);
	}

	public boolean isDisplayText(String value) {
		return isElementDisplay(driver, ListCustomerUI.TEXT_CELL_LIST, value);
	}

	public void enterToTextInput(String value, String nameItem) {
		waitForElementVisible(driver, ListCustomerUI.TEXT_INPUT, nameItem);
		sendKeyToElement(driver, ListCustomerUI.TEXT_INPUT, value, nameItem);

	}

	public void clearTextInput(String nameItem) {
		waitForElementVisible(driver, ListCustomerUI.TEXT_INPUT, nameItem);
		ClearValueElement(driver, ListCustomerUI.TEXT_INPUT, nameItem);
		
	}

	public EditCustomerPageObject clickEditCustomer() {
		waitForElementClickable(driver, ListCustomerUI.EDIT_BUTTON);
		clickToElement(driver, ListCustomerUI.EDIT_BUTTON);
		return GenerateObject.getEditCustomerPageObject(driver);
		
	}

	public void isDisplaySuccessMessage(String contentMessage) {
		waitForElementVisible(driver, ListCustomerUI.SUCCESS_MSG,contentMessage);
		
	}
}
