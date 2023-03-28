package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import bankguruUI.AddNewCustomerBankGuruUI;
import bankguruUI.HomePageBankGuruUI;
import common.BasePage;
import common.GenerateObject;

public class HomePageBankGuruObject extends BasePage {

	private WebDriver driver;

	public HomePageBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddNewCustomerBankGuruObject clickToNewCustomerLink() {
		waitForElementClickable(driver, HomePageBankGuruUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageBankGuruUI.NEW_CUSTOMER_LINK);
		return GenerateObject.getAddNewCustomerBankGuruObject(driver);
	}

	public AddNewAccountBankGuruObject clickToNewAccountLink() {
		waitForElementClickable(driver, HomePageBankGuruUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, HomePageBankGuruUI.NEW_ACCOUNT_LINK);
		return GenerateObject.getAddNewAccountBankGuruObject(driver);
	}

}
