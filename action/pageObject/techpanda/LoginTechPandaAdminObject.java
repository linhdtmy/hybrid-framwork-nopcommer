package pageObject.techpanda;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GenerateObject;
import jqueryUI.HomeJqueryUI;
import techpandaUI.LoginTechPandaUI;
import userPageUI.LoginPageUI;

public class LoginTechPandaAdminObject extends BasePage {
	private WebDriver driver;

	public LoginTechPandaAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageTechpandaAdminObject loginToPage(String userName, String password) {

		waitForElementClickable(driver, LoginTechPandaUI.USER_NAME);
		sendKeyToElement(driver, LoginTechPandaUI.USER_NAME, userName);
		waitForElementClickable(driver, LoginTechPandaUI.PASSWORD);
		sendKeyToElement(driver, LoginTechPandaUI.PASSWORD, password);
		waitForElementClickable(driver, LoginTechPandaUI.LOGIN_BUTTON);
		clickToElement(driver, LoginTechPandaUI.LOGIN_BUTTON);
		return GenerateObject.getHomePageTechpandaObject(driver);
	}

}
