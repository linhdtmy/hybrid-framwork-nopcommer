package pageObject.techpanda;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GenerateObject;
import jqueryUI.HomeJqueryUI;
import techpandaUI.LoginTechPandaAdminUI;
import techpandaUI.RegisterTechPandaUserUI;
import userPageUI.LoginPageUI;

public class RegisterTechPandaUserObject extends BasePage {
	private WebDriver driver;

	public RegisterTechPandaUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageTechpandaAdminObject loginToPage(String userName, String password) {

		waitForElementClickable(driver, LoginTechPandaAdminUI.USER_NAME);
		sendKeyToElement(driver, LoginTechPandaAdminUI.USER_NAME, userName);
		waitForElementClickable(driver, LoginTechPandaAdminUI.PASSWORD);
		sendKeyToElement(driver, LoginTechPandaAdminUI.PASSWORD, password);
		waitForElementClickable(driver, LoginTechPandaAdminUI.LOGIN_BUTTON);
		clickToElement(driver, LoginTechPandaAdminUI.LOGIN_BUTTON);
		return GenerateObject.getHomePageTechpandaObject(driver);
	}

	public void inputToFirstName(String firstName) {
		waitForElementClickable(driver, RegisterTechPandaUserUI.FIRST_NAME);
		sendKeyToElement(driver, RegisterTechPandaUserUI.FIRST_NAME, firstName);
	}

	public void inputToLastName(String lastName) {
		waitForElementClickable(driver, RegisterTechPandaUserUI.LAST_NAME);
		sendKeyToElement(driver, RegisterTechPandaUserUI.LAST_NAME, lastName);

	}

	public void inputToEmail(String email) {
		waitForElementClickable(driver, RegisterTechPandaUserUI.EMAIL);
		sendKeyToElement(driver, RegisterTechPandaUserUI.EMAIL, email);

	}

	public void inputToPassword(String password) {
		waitForElementClickable(driver, RegisterTechPandaUserUI.PASSWORD);
		sendKeyToElement(driver, RegisterTechPandaUserUI.PASSWORD, password);

	}

	public void inputToPasswordConfirm(String password_confirm) {
		waitForElementClickable(driver, RegisterTechPandaUserUI.PASSWORD_CONFIRM);
		sendKeyToElement(driver, RegisterTechPandaUserUI.PASSWORD_CONFIRM, password_confirm);

	}

	public HomePageTechpandaUserObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterTechPandaUserUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterTechPandaUserUI.REGISTER_BUTTON);
		return GenerateObject.getHomePageTechpandaUserObject(driver);
	}

}
