package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminNopcommerPageUI.DashboardUI;
import adminNopcommerPageUI.EditAddressUI;
import adminNopcommerPageUI.EditCustomerUI;
import common.BasePage;
import common.GenerateObject;

public class EditCustomerPageObject extends BasePage {
	private WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayMessageEditSuccess() {
		return isElementDisplay(driver, EditCustomerUI.EDIT_SUCCESS_MESSAGE);

	}

	public ListCustomerPageObject clickBackButton() {
		waitForElementClickable(driver, EditCustomerUI.BACK_BUTTON);
		clickToElement(driver, EditCustomerUI.BACK_BUTTON);
		return GenerateObject.getListCustomerPageObject(driver);
	}

	public void inputToTextbox(String nameItem, String value) {
		waitForElementVisible(driver, EditCustomerUI.TEXTBOX_INPUT, nameItem);
		sendKeyToElement(driver, EditCustomerUI.TEXTBOX_INPUT, value, nameItem);
	}

	public void inputToAdminComment(String comment) {
		waitForElementVisible(driver, EditCustomerUI.ADMIN_COMMENT);
		sendKeyToElement(driver, EditCustomerUI.ADMIN_COMMENT, comment);
	}

	public ListCustomerPageObject clickSaveButton() {
		waitForElementClickable(driver, EditCustomerUI.SAVE_BUTTON);
		clickToElement(driver, EditCustomerUI.SAVE_BUTTON);
		return GenerateObject.getListCustomerPageObject(driver);

	}

	public void clickToAddress() {
		waitForElementClickable(driver, EditCustomerUI.ADDRESS_BUTTON);
		clickToElement(driver, EditCustomerUI.ADDRESS_BUTTON);

	}

	public AddAddressPageObject clickToAddNewAddress() {
		waitForElementClickable(driver, EditCustomerUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, EditCustomerUI.ADD_NEW_ADDRESS_BUTTON);
		return GenerateObject.getAddAddressPageObject(driver);

	}

	public String getInFormAddress(String columnName, String email) {
		// return isElementDisplay(driver, EditCustomerUI.INFORM_ADDRESS,email,Integer.toString(getColumnIndexByColumnName(columnName)));
		String contentText = getElementText(driver, EditCustomerUI.INFORM_ADDRESS, email, Integer.toString(getColumnIndexByColumnName(columnName)));
		return contentText;
	}

	private int getColumnIndexByColumnName(String columnName) {
		return getElementSize(driver, EditCustomerUI.COLUMN_INDEX, columnName) + 1;
	}

	public boolean isDisplayAddress(String companyName, String address1, String address2, String city, String zipCode, String country) {
		return isElementDisplay(driver, EditCustomerUI.ADDRESS_COLUMN_INFORM, companyName, address1, address2, city, zipCode, country);
	}

	public EditAddressPageObject clickButtonEditAddress() {
		waitForElementClickable(driver, EditCustomerUI.EDIT_ADDRESS_BUTTON);
		clickToElement(driver, EditCustomerUI.EDIT_ADDRESS_BUTTON);
		return GenerateObject.getEditAddressPageObject(driver);

	}

	public ListCustomerPageObject clickToCustomer() {
		 
		waitForElementVisible(driver, DashboardUI.SUB_CUSTOMER_LEFT_MENU);
		clickToElement(driver, DashboardUI.SUB_CUSTOMER_LEFT_MENU);
		sleepInSecond(3);
		return GenerateObject.getListCustomerPageObject(driver);

	}

	public void deleteAddress() {
		waitForElementClickable(driver, DashboardUI.DELETE_ADDRESS_BUTTON);
		clickToElement(driver, DashboardUI.DELETE_ADDRESS_BUTTON);
		acceptAlert(driver);

	}
}
