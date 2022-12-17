package pageObject.techpanda;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GenerateObject;
import jqueryUI.HomeJqueryUI;
import techpandaUI.LoginTechPandaAdminUI;
import userPageUI.LoginPageUI;

public class LoginTechPandaAdminObject extends BasePage {
	private WebDriver driver;

	public LoginTechPandaAdminObject(WebDriver driver) {
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

}
