package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import userPageUI.AddressPageUI;
import userPageUI.CustomerUI;
import userPageUI.RegisterPageUI;
import wordpressAdminUI.ListPostAdminUI;
import wordpressAdminUI.LoginAdminUI;

public class ListPostAdminObject extends BasePage {

	private WebDriver driver;

	public ListPostAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddEditPostAdminObject clickAddNewButton() {
		waitForElementClickable(driver, ListPostAdminUI.ADD_NEW_BUTTON);
		clickToElement(driver, ListPostAdminUI.ADD_NEW_BUTTON);
		return GenerateObject.getAddNewPostAdminObject(driver);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementClickable(driver, ListPostAdminUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, ListPostAdminUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ListPostAdminUI.SEARCH_BUTTON);
		clickToElement(driver, ListPostAdminUI.SEARCH_BUTTON);
	}

	public String getTextByHeader(String headerName) {
		int indexColumn = getElementSize(driver, ListPostAdminUI.HEADER_TABLE, headerName) + 1;
		return getElementText(driver, ListPostAdminUI.CELL_TABLE, Integer.toString(1), Integer.toString(indexColumn));

	}

	public AddEditPostAdminObject clickToEditLink(String title) {
		hoverMouseToElement(driver, ListPostAdminUI.POST_TITLE_BY_TITLE, title);
		waitForElementClickable(driver, ListPostAdminUI.EDIT_ICON_BY_TITLE, title, "Edit");
		clickToElement(driver, ListPostAdminUI.EDIT_ICON_BY_TITLE, title, "Edit");
		return GenerateObject.getAddNewPostAdminObject(driver);
	}

	public boolean isDisplayPostTitle(String postTitleEdit) {
		waitForElementVisible(driver, ListPostAdminUI.POST_TITLE_BY_TITLE, postTitleEdit);
		return isElementDisplay(driver, ListPostAdminUI.POST_TITLE_BY_TITLE, postTitleEdit);
	}

	public boolean isDisplayAuthor(String postTitleEdit) {
		waitForElementVisible(driver, ListPostAdminUI.POST_CONTENT_BY_TITLE, postTitleEdit);
		return isElementDisplay(driver, ListPostAdminUI.POST_CONTENT_BY_TITLE, postTitleEdit);
	}

	public void checkToCheckBox(String postTitleEdit) {
		waitForElementClickable(driver, ListPostAdminUI.CHECKBOX_BY_TITLE, postTitleEdit);
		checkToDefaultCheckboxRadio(driver, ListPostAdminUI.CHECKBOX_BY_TITLE, postTitleEdit);
	}

	public void selectDeleteOption() {
		waitForElementClickable(driver, ListPostAdminUI.ACTION_SELECTBOX);
		selectItemInDefaultDropdownByValue(driver, ListPostAdminUI.ACTION_SELECTBOX, "trash");
	}

	public void clickButtonApply() {
		waitForElementClickable(driver, ListPostAdminUI.APPLY_BUTTON);
		clickToElement(driver, ListPostAdminUI.APPLY_BUTTON);

	}

	public boolean isDisplayMoveToTrashMessage() {
		waitForElementVisible(driver, ListPostAdminUI.MOVE_TO_TRASH_MESSAGE);
		return isElementDisplay(driver, ListPostAdminUI.MOVE_TO_TRASH_MESSAGE);
	}

	public boolean isDisplayNoRecordMessage() {
		waitForElementVisible(driver, ListPostAdminUI.NO_POST_MESSAGE);
		return isElementDisplay(driver, ListPostAdminUI.NO_POST_MESSAGE);
	}

}
