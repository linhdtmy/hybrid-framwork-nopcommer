package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.BaseUI;
import userPageUI.ChangePasswordUI;

public class ChangePasswordUserObject extends BasePage {

	private WebDriver driver;

	public ChangePasswordUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPassword(String oldPassword) {
		waitForElementClickable(driver, ChangePasswordUI.OLD_PASSWORD);
		sendKeyToElement(driver, ChangePasswordUI.OLD_PASSWORD, oldPassword);
	}

	public void inputToNewPassword(String newPassword) {
		waitForElementClickable(driver, ChangePasswordUI.NEW_PASSWORD);
		sendKeyToElement(driver, ChangePasswordUI.NEW_PASSWORD, newPassword);
		
	}

	public void inputToConfirmPassword(String confirmPassword) {
		waitForElementClickable(driver, ChangePasswordUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, ChangePasswordUI.CONFIRM_PASSWORD, confirmPassword);
		
	}

	public HomeUserPageObject clickLogoutButton() {
		waitForElementClickable(driver, ChangePasswordUI.LOGOUT_BUTTON);
		//clickToElement(driver, ChangePasswordUI.LOGOUT_BUTTON);
		clickToElementByJS(driver, ChangePasswordUI.LOGOUT_BUTTON);
		return GenerateObject.getHomePage(driver);
	}

	public void clickChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordUI.CHANGE_BUTTON);
		clickToElement(driver, ChangePasswordUI.CHANGE_BUTTON);
		
	}

	public void clickToCloseIcon() {
		waitForElementClickable(driver,ChangePasswordUI.CLOSE_ICON);
		clickToElement(driver,ChangePasswordUI.CLOSE_ICON);
	}

	public String getMessageChangeSuccess() {
		waitForElementClickable(driver, ChangePasswordUI.CHANGE__PASSWORD_SUCCESS_MESSAGE);
		return getElementText(driver, ChangePasswordUI.CHANGE__PASSWORD_SUCCESS_MESSAGE);
	}

	

 

	
}
