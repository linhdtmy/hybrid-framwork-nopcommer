package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaAdminUI;
import techpandaUI.HomeTechPandaUserUI;

public class HomePageTechpandaUserObject extends BasePage {
	private WebDriver driver;

	public HomePageTechpandaUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		waitForElementVisible(driver, HomeTechPandaAdminUI.POPUP);
		clickToElement(driver, HomeTechPandaAdminUI.CLOSE_ICON);
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, HomeTechPandaUserUI.ACCOUNT_LINK);
		clickToElement(driver, HomeTechPandaUserUI.ACCOUNT_LINK);
	}

	public RegisterTechPandaUserObject clickToRegisterLink() {
		waitForElementClickable(driver, HomeTechPandaUserUI.REGISTER_LINK);
		clickToElement(driver, HomeTechPandaUserUI.REGISTER_LINK);
		return GenerateObject.getRegisterTechPandaUserObject(driver);
	}

	public String getMessageValidateSuccess() {
		waitForAllElementVisible(driver, HomeTechPandaUserUI.MESSAGE_SUCCESS);
		return getElementText(driver, HomeTechPandaUserUI.MESSAGE_SUCCESS);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomeTechPandaUserUI.LOGIN_LINK);
		clickToElement(driver, HomeTechPandaUserUI.LOGIN_LINK);

	}

	public String getInValidLoginMessage() {
		waitForAllElementVisible(driver, HomeTechPandaUserUI.INVALID_LOGIN_MESSAGE);
		return getElementText(driver, HomeTechPandaUserUI.INVALID_LOGIN_MESSAGE);
	}

	public void inputToEmail(String email) {
		waitForElementClickable(driver, HomeTechPandaUserUI.EMAIL_INPUT);
		sendKeyToElement(driver, HomeTechPandaUserUI.EMAIL_INPUT, email);
	}

	public void inputToPassword(String password) {
		waitForElementClickable(driver, HomeTechPandaUserUI.PASSWORD_INPUT);
		sendKeyToElement(driver, HomeTechPandaUserUI.PASSWORD_INPUT, password);

	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, HomeTechPandaUserUI.LOGIN_BUTTON);
		clickToElement(driver, HomeTechPandaUserUI.LOGIN_BUTTON);
	}

	public MyAccountTechpandaUserObject clickToMyAccountOption() {
		waitForElementClickable(driver, HomeTechPandaUserUI.ACCOUNT_OPTION_LINK, "My Account");
		clickToElement(driver, HomeTechPandaUserUI.ACCOUNT_OPTION_LINK, "My Account");
		return GenerateObject.getMyAccountTechpandaUserObject(driver);
	}

	public void openUrl(WebDriver driver, String url) {
		openPageUrl(driver, url);

	}

	public MobileTechPandaObject clickToMobileLink() {
		waitForElementVisible(driver, HomeTechPandaUserUI.MOBILE_LINK);
		clickToElement(driver, HomeTechPandaUserUI.MOBILE_LINK);
		return GenerateObject.getMobileTechPandaObject(driver);
	}

	public void clickLoginLink() {
		waitForElementVisible(driver, HomeTechPandaUserUI.LOGIN_LINK);
		clickToElement(driver, HomeTechPandaUserUI.LOGIN_LINK);
		
	}

}
