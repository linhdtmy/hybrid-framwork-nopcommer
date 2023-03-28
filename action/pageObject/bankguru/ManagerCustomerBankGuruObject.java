package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import bankguruUI.LoginPageBankGuruUI;
import bankguruUI.ManagerCustomerBankGuruUI;
import common.BasePage;
import common.GenerateObject;

public class ManagerCustomerBankGuruObject extends BasePage {

	private WebDriver driver;

	public ManagerCustomerBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getIdCustomer() {
		waitForElementVisible(driver, ManagerCustomerBankGuruUI.CUSTOMER_ID);
		return getElementText(driver, ManagerCustomerBankGuruUI.CUSTOMER_ID);
	}

	public EditCustomerBankGuruObject clickToEditCustomer() {
		waitForElementVisible(driver, ManagerCustomerBankGuruUI.EDIT_LINK);
		clickToElement(driver, ManagerCustomerBankGuruUI.EDIT_LINK);
		return GenerateObject.getEditCustomerBankGuruObject(driver);
	}

	public DeleteCustomerBankGuruObject clickToDeleteCustomer() {
		waitForElementVisible(driver, ManagerCustomerBankGuruUI.DELETE_LINK);
		clickToElement(driver, ManagerCustomerBankGuruUI.DELETE_LINK);
		return GenerateObject.getDeleteCustomerBankGuruObject(driver);
	}

	public AddNewAccountBankGuruObject clickToNewAccountLink() {
		waitForElementClickable(driver, ManagerCustomerBankGuruUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, ManagerCustomerBankGuruUI.NEW_ACCOUNT_LINK);
		return GenerateObject.getAddNewAccountBankGuruObject(driver);
	}

	public String getAccountId() {
		waitForElementVisible(driver, ManagerCustomerBankGuruUI.ACCOUNT_ID);
		return getElementText(driver, ManagerCustomerBankGuruUI.ACCOUNT_ID);
	}

	public EditAccountrBankGuruObject clickToEditAccount() {
		waitForElementClickable(driver, ManagerCustomerBankGuruUI.EDIT_ACCOUNT_LINK);
		clickToElement(driver, ManagerCustomerBankGuruUI.EDIT_ACCOUNT_LINK);
		return GenerateObject.getEditAccountrBankGuruObject(driver);
	}

}
