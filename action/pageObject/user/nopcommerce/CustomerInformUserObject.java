package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.CustomerUI;
import userPageUI.OrderUI;

public class CustomerInformUserObject extends BasePage {

	private WebDriver driver;

	public CustomerInformUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountIsDisplay() {
		return isElementDisplay(driver, CustomerUI.MY_ACCOUNT);

	}

	public void checkToGenderRadio() {
		waitForElementClickable(driver, CustomerUI.FEMALE_GENDER);
		clickToElement(driver, CustomerUI.FEMALE_GENDER);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementClickable(driver, CustomerUI.FIRST_NAME);
		sendKeyToElement(driver, CustomerUI.FIRST_NAME, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementClickable(driver, CustomerUI.LAST_NAME);
		sendKeyToElement(driver, CustomerUI.LAST_NAME, lastName);

	}

	public void inputToDateOfBirth() {
		waitForElementClickable(driver, CustomerUI.DAY);
		selectItemInDefaultDropdownByText(driver, CustomerUI.DAY, "1");
		waitForElementClickable(driver, CustomerUI.MONTH);
		selectItemInDefaultDropdownByText(driver, CustomerUI.MONTH, "January");
		waitForElementClickable(driver, CustomerUI.YEAR);
		selectItemInDefaultDropdownByText(driver, CustomerUI.YEAR, "1999");

	}

	public void inputToEmail(String email) {
		waitForElementClickable(driver, CustomerUI.EMAIL);
		sendKeyToElement(driver, CustomerUI.EMAIL, email);
	}

	public void inputToCompanyName(String companyName) {
		waitForElementClickable(driver, CustomerUI.COMPANY);
		sendKeyToElement(driver, CustomerUI.COMPANY, companyName);

	}

	public CustomerInformUserObject clickToSaveButton() {
		waitForElementClickable(driver, CustomerUI.BUTTON_SAVE);
		clickToElement(driver, CustomerUI.BUTTON_SAVE);
		return GenerateObject.getMyAccountPage(driver);
	}

	public boolean isCheckedFemaleGender() {
		waitForElementVisible(driver, CustomerUI.FEMALE_GENDER);
		return getWebElement(driver, CustomerUI.FEMALE_GENDER).isSelected();
	}

	public String getTextFromFirstName() {
		waitForElementVisible(driver, CustomerUI.FIRST_NAME);
		return getElementValue(driver, CustomerUI.FIRST_NAME);
	}

	public String getTextFromLastName() {
		waitForElementVisible(driver, CustomerUI.LAST_NAME);
		return getElementValue(driver, CustomerUI.LAST_NAME);
	}

	public String getTextFromEmail() {
		waitForElementVisible(driver, CustomerUI.EMAIL);
		return getElementValue(driver, CustomerUI.EMAIL);
	}

	public String getTextFromCompanyName() {
		waitForElementVisible(driver, CustomerUI.COMPANY);
		return getElementValue(driver, CustomerUI.COMPANY);
	}

	public String getTextFromDay() {
		waitForElementVisible(driver, CustomerUI.DAY);
		return getElementValue(driver, CustomerUI.DAY);
	}

	public String getTextFromMonth() {
		waitForElementVisible(driver, CustomerUI.MONTH);
		return getFirstSelectedItemDefaultDropDown(driver,CustomerUI.MONTH);
	}

	public String getTextFromYear() {
		waitForElementVisible(driver, CustomerUI.YEAR);
		return getElementValue(driver, CustomerUI.YEAR);
	}

}
