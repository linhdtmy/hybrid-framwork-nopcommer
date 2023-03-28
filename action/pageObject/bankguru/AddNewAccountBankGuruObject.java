package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AddNewAccountBankGuruUI;
import bankguruUI.AddNewCustomerBankGuruUI;
import common.BasePage;
import common.GenerateObject;

public class AddNewAccountBankGuruObject extends BasePage {

	private WebDriver driver;

	public AddNewAccountBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabToCustomerID() {
		waitForElementClickable(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "cusid");
		clickToElement(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "cusid");
		getWebElement(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "cusid").clear();
		getWebElement(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "cusid").sendKeys(Keys.TAB);

	}

	public boolean isDisplayErrorMessage(String errorMsg) {
		return isElementDisplay(driver, AddNewAccountBankGuruUI.ERROR_MSG, errorMsg);
	}

	public void inputToCustomerID(String customerId) {
		waitForElementVisible(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "cusid");
		sendKeyToElement(driver,  AddNewAccountBankGuruUI.INPUT_TEXTBOX,customerId, "cusid");
	}

	public void pressTabToDesposit() {
		waitForElementClickable(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "inideposit");
		clickToElement(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "inideposit");
		getWebElement(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "inideposit").clear();
		getWebElement(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "inideposit").sendKeys(Keys.TAB);
		
	}

	public void inputToInitialDeposit(String initialDeposit) {
		waitForElementVisible(driver, AddNewAccountBankGuruUI.INPUT_TEXTBOX, "inideposit");
		sendKeyToElement(driver,  AddNewAccountBankGuruUI.INPUT_TEXTBOX,initialDeposit, "inideposit");
		
	}

	public ManagerCustomerBankGuruObject clickSubmitButton() {
		waitForElementClickable(driver, AddNewAccountBankGuruUI.SUBMIT_BUTTON);
		clickToElement(driver, AddNewAccountBankGuruUI.SUBMIT_BUTTON);
		return GenerateObject.getManagerCustomerBankGuruObject(driver);
	}

}
