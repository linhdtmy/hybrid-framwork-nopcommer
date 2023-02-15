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

}
