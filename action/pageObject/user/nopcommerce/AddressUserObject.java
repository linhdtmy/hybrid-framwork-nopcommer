package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import userPageUI.AddressPageUI;
import userPageUI.CustomerUI;
import userPageUI.RegisterPageUI;

public class AddressUserObject extends BasePage {

	private WebDriver driver;

	public AddressUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
		
		
	}

	public void inputToFirstName(String firstName) {
		waitForElementClickable(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastName(String lastName) {
		waitForElementClickable(driver, AddressPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmail(String email) {
		waitForElementClickable(driver, AddressPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToCompany(String companyName) {
		waitForElementClickable(driver, AddressPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.COMPANY_TEXTBOX, companyName);
		
	}

	public void selectCountry(String country) {
		waitForElementClickable(driver, AddressPageUI.COUNTRY_SELECTBOX);
		selectItemInDefaultDropdownByText(driver, AddressPageUI.COUNTRY_SELECTBOX, country);
	}

	public void selectProvince(String province) {
		waitForElementClickable(driver, AddressPageUI.PROVINCE_SELECTBOX);
		selectItemInDefaultDropdownByText(driver, AddressPageUI.PROVINCE_SELECTBOX, province);
		
	}

	public void inputToCity(String city) {
		waitForElementClickable(driver, AddressPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.CITY_TEXTBOX, city);
		
		
	}

	public void inputToAddress1(String address1) {
		waitForElementClickable(driver, AddressPageUI.ADDRESS1_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.ADDRESS1_TEXTBOX, address1);
		
	}

	public void inputToZipCode(String zipcode) {
		waitForElementClickable(driver, AddressPageUI.ZIP_CODE_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.ZIP_CODE_TEXTBOX, zipcode);
		
	}

	public void inputToPhone(String phone) {
		waitForElementClickable(driver, AddressPageUI.PHONE_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.PHONE_TEXTBOX, phone);
		
	}

	public void inputToFaxNumber(String faxNumber) {
		waitForElementClickable(driver, AddressPageUI.FAX_NUMBER_TEXTBOX);
		sendKeyToElement(driver, AddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);
	}

	public String getTitle() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_TITLE);
		return getElementText(driver, AddressPageUI.ADDRESS_TITLE);
				
	}

	
	 

	

	
}
