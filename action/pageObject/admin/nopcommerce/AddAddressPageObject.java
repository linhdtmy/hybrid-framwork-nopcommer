package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminNopcommerPageUI.AddAddressUI;
import common.BasePage;
import common.GenerateObject;

public class AddAddressPageObject extends BasePage {
	private WebDriver driver;

	public AddAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextbox(String itemName, String value) {
		waitForElementVisible(driver, AddAddressUI.INPUT_TEXTBOX, itemName);
		sendKeyToElement(driver, AddAddressUI.INPUT_TEXTBOX, value, itemName);

	}

	public void selectCountrySelectbox(String optionText) {
		waitForElementClickable(driver, AddAddressUI.COUNTRY_SELECTBOX);
		selectItemInDefaultDropdownByText(driver, AddAddressUI.COUNTRY_SELECTBOX, optionText);
	}

	public EditAddressPageObject clickSaveButton() {
		waitForElementClickable(driver, AddAddressUI.SAVE_BUTTON);
		clickToElement(driver, AddAddressUI.SAVE_BUTTON);
		return GenerateObject.getEditAddressPageObject(driver);
	}

}
