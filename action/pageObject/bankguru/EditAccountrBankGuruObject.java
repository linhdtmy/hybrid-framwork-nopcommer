package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AddNewCustomerBankGuruUI;
import bankguruUI.EditAccountBankGuruUI;
import bankguruUI.EditCustomerBankGuruUI;
import common.BasePage;

public class EditAccountrBankGuruObject extends BasePage {

	private WebDriver driver;

	public EditAccountrBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToCustomerID(String customerId) {
		waitForElementClickable(driver, EditAccountBankGuruUI.CUTOMER_ID);
		sendKeyToElement(driver, EditAccountBankGuruUI.CUTOMER_ID, customerId);

	}

	public void clickButtonSubmit() {
		waitForElementClickable(driver, EditAccountBankGuruUI.SUBMIT_BUTTON);
		clickToElement(driver, EditAccountBankGuruUI.SUBMIT_BUTTON);

	}

	public boolean isEnableCustomerName() {
		return isElementEnable(driver, EditAccountBankGuruUI.INPUT_TEXTBOX, "name");
	}

	public void enterToAccountID(String accountId) {
		waitForElementClickable(driver, EditAccountBankGuruUI.ACCOUNT_ID_INPUT);
		sendKeyToElement(driver, EditAccountBankGuruUI.ACCOUNT_ID_INPUT, accountId);

	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, EditAccountBankGuruUI.SUBMIT_BUTTON);
		clickToElement(driver, EditAccountBankGuruUI.SUBMIT_BUTTON);

	}

}
