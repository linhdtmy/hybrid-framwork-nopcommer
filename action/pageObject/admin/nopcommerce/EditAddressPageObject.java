package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminNopcommerPageUI.AddAddressUI;
import adminNopcommerPageUI.EditAddressUI;
import adminNopcommerPageUI.EditCustomerUI;
import common.BasePage;
import common.GenerateObject;

public class EditAddressPageObject extends BasePage {
	private WebDriver driver;

	public EditAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplaySuccessMSG(String contentMSG) {
		return isElementDisplay(driver, EditAddressUI.ADD_SUCCESS_MSG, contentMSG);
	}

	public EditCustomerPageObject clickToBackButton() {
		waitForElementClickable(driver, EditAddressUI.BACK_BUTTON);
		clickToElement(driver, EditAddressUI.BACK_BUTTON);
		return GenerateObject.getEditCustomerPageObject(driver);
	}

	public void inputToTextbox(String idItem, String value) {
		waitForElementVisible(driver, EditAddressUI.TEXTBOX_INPUT, idItem);
		sendKeyToElement(driver, EditAddressUI.TEXTBOX_INPUT, value, idItem);

	}

	public void selectCountrySelectbox(String optionText) {
		waitForElementClickable(driver, EditAddressUI.COUNTRY_SELECTBOX);
		selectItemInDefaultDropdownByText(driver, EditAddressUI.COUNTRY_SELECTBOX, optionText);
		
	}

	public EditAddressPageObject clickSaveButton() {
		waitForElementClickable(driver, EditAddressUI.SAVE_BUTTON);
		clickToElement(driver, EditAddressUI.SAVE_BUTTON);
		return GenerateObject.getEditAddressPageObject(driver);
	}

	public String getInformAddress(String idItem) {
		return getElementValue(driver, EditAddressUI.TEXTBOX_INPUT,idItem);
		
	}

}
