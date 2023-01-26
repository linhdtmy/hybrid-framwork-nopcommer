package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.AddressPageUI;
import userPageUI.CustomerUI;
import userPageUI.RegisterPageUI;
import wordpressAdminUI.LoginAdminUI;

public class LoginAdminObject extends BasePage {

	private WebDriver driver;

	public LoginAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserName(String userName) {
		waitForElementClickable(driver, LoginAdminUI.USER_NAME);
		sendKeyToElement(driver, LoginAdminUI.USER_NAME, userName);

	}

	public void enterToPassword(String password) {
		waitForElementClickable(driver, LoginAdminUI.PASSWORD);
		sendKeyToElement(driver, LoginAdminUI.PASSWORD, password);
	}

	public DashboardAdminObject clickButtonLogin() {
		waitForElementClickable(driver, LoginAdminUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminUI.LOGIN_BUTTON);
		return GenerateObject.getDashboardAdminObject(driver);
	}

}
