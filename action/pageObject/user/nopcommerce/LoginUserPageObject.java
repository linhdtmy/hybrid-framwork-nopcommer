package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import userPageUI.LoginPageUI;

public class LoginUserPageObject extends BasePage {
	private WebDriver driver;

	public LoginUserPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomeUserPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
	    return new HomeUserPageObject(driver);
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

	public HomeUserPageObject loginAsUser(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		 return clickToLoginButton();
	}
	public String getElementValidationEmailMessage(WebDriver driver) {
	waitForElementVisible(driver, LoginPageUI.VALIDATION_MESSAGE);
	return  getElementText(driver, LoginPageUI.VALIDATION_MESSAGE);
	}
	
	public String getErrorMessageNotRegister() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_UNSUCCESSFULL_LOGIN);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_UNSUCCESSFULL_LOGIN);
	}
}
