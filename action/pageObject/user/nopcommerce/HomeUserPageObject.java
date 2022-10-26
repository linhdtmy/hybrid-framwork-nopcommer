package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.HomePageUI;

public class HomeUserPageObject extends BasePage{
	private WebDriver driver;
    public HomeUserPageObject(WebDriver driver) {
		this.driver =driver;
	}
	public RegisterPageUserObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return GenerateObject.getRegisterPage(driver);
	}
	public LoginUserPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return GenerateObject.getLoginPage(driver);
	}
	public boolean isDisplayMyAccount() {
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_TEXT);
	}
	public CustomerInformUserObject clickToMyAccount() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_TEXT);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_TEXT);
		return GenerateObject.getMyAccountPage(driver);
	}

	
 

}
