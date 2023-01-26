package pageObject.wordpress.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;

import common.BasePage;
import common.GenerateObject;
import pageObject.wordpress.admin.DashboardAdminObject;
import userPageUI.AddressPageUI;
import userPageUI.CustomerUI;
import userPageUI.RegisterPageUI;
import wordpressAdminUI.AddEditNewPostAdminUI;
import wordpressUserUI.HomePageUserUI;

public class HomePageUserObject extends BasePage {

	private WebDriver driver;

	public HomePageUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchIcon() {
		waitForElementClickable(driver, HomePageUserUI.SEARCH_ICON);
		clickToElement(driver, HomePageUserUI.SEARCH_ICON);
	}

	public void sendKeyToSearchTextbox(String postTitle) {
		waitForElementClickable(driver, HomePageUserUI.SEARCH_ICON);
		sendKeyToElement(driver, HomePageUserUI.SEARCH_ICON, postTitle);

	}

	public void enterKeyboard() {
		waitForElementClickable(driver, HomePageUserUI.SEARCH_ICON);
		getWebElement(driver, HomePageUserUI.SEARCH_ICON).sendKeys(Keys.ENTER);
	}

	public String getPostTitle() {
		waitForElementVisible(driver, HomePageUserUI.POST_TITLE);
		return getElementText(driver, HomePageUserUI.POST_TITLE);
	}

	public String getPostContent() {
		waitForElementVisible(driver, HomePageUserUI.POST_CONTENT);
		return getElementText(driver, HomePageUserUI.POST_CONTENT);
	}

	public void clickToPostTitle() {
		waitForElementVisible(driver, HomePageUserUI.POST_TITLE);
		clickToElement(driver, HomePageUserUI.POST_TITLE);

	}

	public String getPostDate() {
		waitForElementVisible(driver, HomePageUserUI.POST_DATE);
		return getElementText(driver, HomePageUserUI.POST_DATE);
	}

	public DashboardAdminObject openAdminPage(WebDriver driver, String urlAdmin) {
		driver.get(urlAdmin);
		return GenerateObject.getDashboardAdminObject(driver);
	}

	public boolean isDisplayPostTitle(String postTitleEdit) {
		waitForElementVisible(driver, HomePageUserUI.POST_TITLE_BY_TITLE, postTitleEdit);
		return isElementDisplay(driver, HomePageUserUI.POST_TITLE_BY_TITLE, postTitleEdit);
	}

	public boolean isDisplayPostContent(String postContentEdit) {
		waitForElementVisible(driver, HomePageUserUI.POST_CONTENT_BY_TITLE, postContentEdit);
		return isElementDisplay(driver, HomePageUserUI.POST_CONTENT_BY_TITLE, postContentEdit);
	}

}
