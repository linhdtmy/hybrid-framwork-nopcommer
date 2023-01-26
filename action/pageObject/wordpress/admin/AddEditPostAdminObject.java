package pageObject.wordpress.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.AddressPageUI;
import userPageUI.CustomerUI;
import userPageUI.RegisterPageUI;
import wordpressAdminUI.AddEditNewPostAdminUI;

public class AddEditPostAdminObject extends BasePage {

	private WebDriver driver;

	public AddEditPostAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterPostTitle(String postTitle) {
		waitForElementClickable(driver, AddEditNewPostAdminUI.TITLE_INPUT);
		clickToElement(driver, AddEditNewPostAdminUI.TITLE_INPUT);
		getWebElement(driver, AddEditNewPostAdminUI.TITLE_INPUT).sendKeys(Keys.BACK_SPACE);
		sleepInSecond(3);
		sendKeyToElement(driver, AddEditNewPostAdminUI.TITLE_INPUT, postTitle);

	}

	public void enterPostContent(String postContent) {	
		waitForElementClickable(driver, AddEditNewPostAdminUI.CONTENT_INPUT);
		clickToElement(driver, AddEditNewPostAdminUI.CONTENT_INPUT);
		getWebElement(driver, AddEditNewPostAdminUI.CONTENT_INPUT_AFFTER).sendKeys(Keys.CONTROL + "a");
		getWebElement(driver, AddEditNewPostAdminUI.CONTENT_INPUT_AFFTER).sendKeys(Keys.DELETE);
		sleepInSecond(3);
		sendKeyToElement(driver, AddEditNewPostAdminUI.CONTENT_INPUT_AFFTER, postContent);

	}

	public void clickButtonPubLish() {
		waitForElementClickable(driver, AddEditNewPostAdminUI.PUBLISH_BUTTON);
		clickToElement(driver, AddEditNewPostAdminUI.PUBLISH_BUTTON);
		sleepInSecond(2);
		clickToElement(driver, AddEditNewPostAdminUI.PUBLISH_BUTTON_2);

	}

	public boolean isDisableMessagePublishSuccess() {
		waitForElementVisible(driver, AddEditNewPostAdminUI.PUBLISHED_MESSAGE);
		return isElementDisplay(driver, AddEditNewPostAdminUI.PUBLISHED_MESSAGE);
	}

	public ListPostAdminObject clickToPostHeader() {
		waitForElementClickable(driver, AddEditNewPostAdminUI.POST_HEADER_ICON);
		clickToElement(driver, AddEditNewPostAdminUI.POST_HEADER_ICON);
		return GenerateObject.getListPostAdminObject(driver);
	}

	public void clickUpdateButton() {
		waitForElementClickable(driver, AddEditNewPostAdminUI.UPDATE_BUTTON);
		clickToElement(driver, AddEditNewPostAdminUI.UPDATE_BUTTON);
	}

	public boolean isDisplayUpdateSuccessMessage() {
		waitForElementVisible(driver, AddEditNewPostAdminUI.UPDATE_SUCCESS_MESSAGE);
		return isElementDisplay(driver, AddEditNewPostAdminUI.UPDATE_SUCCESS_MESSAGE);

	}

}
