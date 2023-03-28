package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import adminNopcommerPageUI.DashboardUI;
import adminNopcommerPageUI.ListCustomerUI;
import adminNopcommerPageUI.AddNewCustomerUI;
import common.BasePage;
import common.GenerateObject;

public class AddCustomerPageObject extends BasePage {
	private WebDriver driver;

	public AddCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickButtonAddNew() {
		waitForElementVisible(driver, AddNewCustomerUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddNewCustomerUI.ADD_NEW_BUTTON);

	}

	public void inputToTextbox(String nameItem, String value) {
		waitForElementVisible(driver, AddNewCustomerUI.TEXTBOX_INPUT, nameItem);
		sendKeyToElement(driver, AddNewCustomerUI.TEXTBOX_INPUT, value, nameItem);
	}

	public void checkToGender() {
		waitForElementVisible(driver, AddNewCustomerUI.FEMALE_GENDER_RADIO);
		checkToDefaultCheckboxRadio(driver, AddNewCustomerUI.FEMALE_GENDER_RADIO);

	}

	public void selectCustomerRole(String textValueOption) {

		hoverMouseToElement(driver, AddNewCustomerUI.CUSTOMER_ROLE_SELECTBOX);
		if (isElementDisplay(driver, AddNewCustomerUI.DELETE_ICON_CUSTOMER_ROLE)) {
			clickToElement(driver, AddNewCustomerUI.DELETE_ICON_CUSTOMER_ROLE);
		}
		clickToElement(driver, AddNewCustomerUI.CUSTOMER_ROLE_SELECTBOX);
		clickToElementByJS(driver, AddNewCustomerUI.OPTION_CUSTOMER_ROLE_SELECTBOX, textValueOption);
		 
	}

	public void selectNewLetter() {
		selectedValueDropdownByXpath(driver, AddNewCustomerUI.PARENT_NEW_LETTER_SELECTBOX, AddNewCustomerUI.CHILDREN_NEW_LETTER_SELECTBOX, "Your store name");
	}

	public void inputToAdminComment(String comment) {
		waitForElementVisible(driver, AddNewCustomerUI.ADMIN_COMMENT);
		sendKeyToElement(driver, AddNewCustomerUI.ADMIN_COMMENT, comment);
	}

	public EditCustomerPageObject clickSaveButton() {
		waitForElementClickable(driver, AddNewCustomerUI.SAVE_CONTINUE_BUTTON);
		clickToElement(driver, AddNewCustomerUI.SAVE_CONTINUE_BUTTON);
		return GenerateObject.getEditCustomerPageObject(driver);
	}

	public boolean isDisplayMessageEditSuccess() {
		return isElementDisplay(driver, AddNewCustomerUI.EDIT_SUCCESS_MESSAGE);

	}

	public void selectCustomerRole() {

		selectedValueDropdownByXpath(driver, AddNewCustomerUI.PARENT_CUSTOMER_ROLE_SELECTBOX, AddNewCustomerUI.CHILDREN_CUSTOMER_ROLE_SELECTBOX, "Guests");
		sleepInSecond(10);
	}

}
