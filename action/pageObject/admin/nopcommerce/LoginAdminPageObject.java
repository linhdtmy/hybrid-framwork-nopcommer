package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import adminNopcommerPageUI.LoginAdminUI;
import common.BasePage;
import common.GenerateObject;
import userPageUI.LoginPageUI;

public class LoginAdminPageObject  extends BasePage {
	private WebDriver driver;

	public LoginAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginAdminUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginAdminUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginAdminUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginAdminUI.PASSWORD_TEXTBOX, password);
		
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginAdminUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminUI.LOGIN_BUTTON);
		return GenerateObject.getDashboardPageObject(driver);
	}
	public DashboardPageObject loginAsAdmin(String email,String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
