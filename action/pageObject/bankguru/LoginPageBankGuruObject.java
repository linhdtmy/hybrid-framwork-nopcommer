package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import bankguruUI.LoginPageBankGuruUI;
import common.BasePage;
import common.GenerateObject;

public class LoginPageBankGuruObject extends BasePage {

	private WebDriver driver;

	public LoginPageBankGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserName(String userName) {
		waitForElementClickable(driver, LoginPageBankGuruUI.USER_NAME_INPUT);
		sendKeyToElement(driver, LoginPageBankGuruUI.USER_NAME_INPUT, userName);
	}

	public void enterToPassword(String password) {
		waitForElementClickable(driver, LoginPageBankGuruUI.PASSWORD_INPUT);
		sendKeyToElement(driver, LoginPageBankGuruUI.PASSWORD_INPUT, password);

	}

	public HomePageBankGuruObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageBankGuruUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageBankGuruUI.LOGIN_BUTTON);
		return GenerateObject.getHomePageBankGuruObject(driver);
	}

}
