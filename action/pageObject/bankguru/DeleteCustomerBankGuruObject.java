package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AddNewCustomerBankGuruUI;
import bankguruUI.DeleteCustomerBankGuruUI;
import common.BasePage;
import common.GenerateObject;

public class DeleteCustomerBankGuruObject extends BasePage {

	private WebDriver driver;

	public DeleteCustomerBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabToCustomerID() {
	waitForElementClickable(driver, DeleteCustomerBankGuruUI.CUSTOMER_ID_INPUT);
	clickToElement(driver, DeleteCustomerBankGuruUI.CUSTOMER_ID_INPUT);
	getWebElement(driver, DeleteCustomerBankGuruUI.CUSTOMER_ID_INPUT).clear();
	getWebElement(driver, DeleteCustomerBankGuruUI.CUSTOMER_ID_INPUT).sendKeys(Keys.TAB);
		
	}

	public boolean isDisplayErrorMessage(String  message) {
		return isElementDisplay(driver, DeleteCustomerBankGuruUI.CUSTOMER_REQUIRED_MESSAGE, message);
		
	}

	public void inputToCustomerID(String customerID) {
		waitForElementClickable(driver, DeleteCustomerBankGuruUI.CUSTOMER_ID_INPUT);
		sendKeyToElement(driver, DeleteCustomerBankGuruUI.CUSTOMER_ID_INPUT,customerID);
		
	}


}
