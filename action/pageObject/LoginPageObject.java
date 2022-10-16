package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_EMAIL);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorMessageUnsucessfullLogin() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_UNSUCCESSFULL_LOGIN);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_UNSUCCESSFULL_LOGIN);
	}
}
