package pageObject.techpanda;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaAdminUI;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.TVTechPandaUI;

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

	public MobileTechPandaObject clickToMobileLink() {
		waitForElementVisible(driver, HomeTechPandaUserUI.MOBILE_LINK);
		clickToElement(driver, HomeTechPandaUserUI.MOBILE_LINK);
		return GenerateObject.getMobileTechPandaObject(driver);
	}

	public void clickLoginLink() {
		waitForElementVisible(driver, HomeTechPandaUserUI.LOGIN_LINK);
		clickToElement(driver, HomeTechPandaUserUI.LOGIN_LINK);

	}

	public TVTechPandaObject clickToTVLink() {
		waitForElementClickable(driver, HomeTechPandaUserUI.TV_LINK);
		clickToElement(driver, HomeTechPandaUserUI.TV_LINK);
		return GenerateObject.getTVTechPandaObject(driver);
	}

	public WishListTechPandaObject clickToMyWishlishLink() {
		waitForElementClickable(driver, HomeTechPandaUserUI.MY_WISHLIST_LINK);
		clickToElement(driver, HomeTechPandaUserUI.MY_WISHLIST_LINK);
		return GenerateObject.getWishListTechPandaObject(driver);

	}

	public void clickToAdvanceSearch() {
		waitForElementClickable(driver, HomeTechPandaUserUI.ADVANCE_SEARCH_LINK);
		clickToElement(driver, HomeTechPandaUserUI.ADVANCE_SEARCH_LINK);

	}

	public void inputToFromPrice(String price) {
		waitForElementVisible(driver, HomeTechPandaUserUI.FROM_PRICE_INPUT);
		sendKeyToElement(driver, HomeTechPandaUserUI.FROM_PRICE_INPUT, price);

	}

	public void inputToToPrice(String price) {
		waitForElementVisible(driver, HomeTechPandaUserUI.TO_PRICE_INPUT);
		sendKeyToElement(driver, HomeTechPandaUserUI.TO_PRICE_INPUT, price);

	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, HomeTechPandaUserUI.SEARCH_BUTTON);
		clickToElement(driver, HomeTechPandaUserUI.SEARCH_BUTTON);

	}

	public void noteTheProductInfor() {
		waitForElementVisible(driver, HomeTechPandaUserUI.LIST_PRODUCT_NAME);
		List<WebElement> listProductName = getListWebElement(driver, HomeTechPandaUserUI.LIST_PRODUCT_NAME);
		waitForElementVisible(driver, HomeTechPandaUserUI.LIST_COST_PRODUCT);
		List<WebElement> listProductCost = getListWebElement(driver, HomeTechPandaUserUI.LIST_COST_PRODUCT);
		for (WebElement webElement : listProductName) {
			System.out.println(webElement.getText());

		}
		for (WebElement webElement : listProductCost) {
			System.out.println(webElement.getText());

		}
	}

	public void clickModifySearch() {
		waitForElementClickable(driver, HomeTechPandaUserUI.MODIFY_SEARCH);
		clickToElement(driver, HomeTechPandaUserUI.MODIFY_SEARCH);

	}

}
