package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AddNewCustomerBankGuruUI;
import bankguruUI.EditCustomerBankGuruUI;
import common.BasePage;

public class EditCustomerBankGuruObject extends BasePage {

	private WebDriver driver;

	public EditCustomerBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabToMoveNextField(String nameField) {
		if (nameField.equals("name")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "name");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "name");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "name").clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "name").sendKeys(Keys.TAB);
		} else if (nameField.equals("dob")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "dob");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "dob");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "dob").clear();
			;
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "dob").sendKeys(Keys.TAB);
		} else if (nameField.equals("rad1")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "rad1");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "rad1");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "rad1").sendKeys(Keys.TAB);
		} else if (nameField.equals("address")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA);
			clickToElement(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA);
			getWebElement(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA).clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA).sendKeys(Keys.TAB);
		} else if (nameField.equals("city")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "city");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "city");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "city").clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "city").sendKeys(Keys.TAB);
		} else if (nameField.equals("state")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "state");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "state");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "state").clear();
			;
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "state").sendKeys(Keys.TAB);
		} else if (nameField.equals("pin")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno").clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno").sendKeys(Keys.TAB);
		} else if (nameField.equals("phone")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "telephoneno");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "telephoneno");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "telephoneno").clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "telephoneno").sendKeys(Keys.TAB);
		} else if (nameField.equals("email")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid").clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid").sendKeys(Keys.TAB);
		} else if (nameField.equals("password")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "password");
			clickToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "password");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid").clear();
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid").sendKeys(Keys.TAB);
		} else {
			System.out.println("nameField not valid");
		}

	}

	public boolean isDisplayErrorMessage(String errorMessage, String nameField) {

		if (nameField.equals("name")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.CUSTOMERNAME_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.CUSTOMERNAME_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("address")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.ADDRESS_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.ADDRESS_ERROR_MESSAGE, errorMessage);

		} else if (nameField.equals("city")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.CITY_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.CITY_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("state")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.STATE_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.STATE_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("pin")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.PIN_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.PIN_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("phone")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.PHONE_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.PHONE_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("email")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.EMAIL_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.EMAIL_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("dob")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.DOB_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.DOB_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("password")) {
			waitForElementVisible(driver, AddNewCustomerBankGuruUI.PASSWORD_ERROR_MESSAGE, errorMessage);
			return isElementDisplay(driver, AddNewCustomerBankGuruUI.PASSWORD_ERROR_MESSAGE, errorMessage);
		} else {
			System.out.println("nameField not valid");
			return false;
		}

	}

	public void enterToInputField(String nameText, String nameField) {

		if (nameField.equals("name")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "name");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "name").clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, nameText, "name");
		} else if (nameField.equals("address")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA);
			getWebElement(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA).clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.ADDRESS_TEXTAREA, nameText);
		} else if (nameField.equals("city")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "city");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "city").clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, nameText, "city");
		} else if (nameField.equals("state")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "state");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "state").clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, nameText, "state");
		} else if (nameField.equals("pin")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno").clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, nameText, "pinno");
		} else if (nameField.equals("phone")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "telephoneno");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "telephoneno").clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, nameText, "telephoneno");
		} else if (nameField.equals("email")) {
			waitForElementClickable(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid");
			getWebElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "emailid").clear();
			sendKeyToElement(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, nameText, "emailid");
		} else {
			System.out.println("nameField not valid");
		}
	}

	public boolean isUnDisplayErrorMessage(String errorMessage, String nameField) {
		if (nameField.equals("name")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.CUSTOMERNAME_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("address")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.ADDRESS_ERROR_MESSAGE, errorMessage);

		} else if (nameField.equals("city")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.CITY_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("state")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.STATE_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("pin")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.PIN_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("phone")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.PHONE_ERROR_MESSAGE, errorMessage);
		} else if (nameField.equals("email")) {
			return isElementUnDisplay(driver, AddNewCustomerBankGuruUI.EMAIL_ERROR_MESSAGE, errorMessage);
		} else {
			System.out.println("nameField not valid");
			return false;
		}
	}

	public boolean is6PinValue() {
		waitForElementVisible(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno");
		int size = getElementValue(driver, AddNewCustomerBankGuruUI.INPUT_TEXTBOX, "pinno").length();
		if (size == 6) {
			return true;
		} else
			return false;
	}

	public void enterToCustomerID(String customerId) {
		waitForElementClickable(driver, EditCustomerBankGuruUI.CUTOMER_ID);
		sendKeyToElement(driver, EditCustomerBankGuruUI.CUTOMER_ID, customerId);

	}

	public void clickButtonSubmit() {
		waitForElementClickable(driver, EditCustomerBankGuruUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerBankGuruUI.SUBMIT_BUTTON);

	}

	public boolean isEnableCustomerName() {
		return isElementEnable(driver, EditCustomerBankGuruUI.INPUT_TEXTBOX, "name");
	}

}
