package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import jqueryUI.HomeJqueryUI;
import techpandaUI.HomeTechPandaAdminUI;

public class HomePageTechpandaAdminObject extends BasePage {
	private WebDriver driver;

	public HomePageTechpandaAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		waitForElementVisible(driver, HomeTechPandaAdminUI.POPUP);
		clickToElement(driver, HomeTechPandaAdminUI.CLOSE_ICON);
		sleepInSecond(5);
	}

	public void inputToEmailSearchInput(String email) {
		waitForElementClickable(driver, HomeTechPandaAdminUI.EMAIL_SEARCH_INPUT);
		sendKeyToElement(driver, HomeTechPandaAdminUI.EMAIL_SEARCH_INPUT, email);
	}

	public void clickButtonSearch() {
		waitForElementVisible(driver, HomeTechPandaAdminUI.SEARCH_BUTTON);
		clickToElement(driver, HomeTechPandaAdminUI.SEARCH_BUTTON);
		sleepInSecond(3);
	}

	public void inputTextToCellByHeader(String headerName, String rowIndex, String value) {
		// đếm xem element có bao nhiêu anh để biết vị trí của nó ở cột thứ mấy
		int indexCell = getElementSize(driver, HomeJqueryUI.INDEX_COLUMN_BY_HEADER_LABEL, headerName) + 1;
		waitForElementClickable(driver, HomeJqueryUI.INPUT_BY_ROW, rowIndex, Integer.toString(indexCell));
		sendKeyToElement(driver, HomeJqueryUI.INPUT_BY_ROW, value, rowIndex, Integer.toString(indexCell));

	}

	public String getTextByHeader(String nameTitle) {
		int indexCell = getElementSize(driver, HomeTechPandaAdminUI.HEADER_TITLE, nameTitle) + 1;
		return getElementText(driver, HomeTechPandaAdminUI.ROW_BY_INDEX, Integer.toString(indexCell));
	}

	public void clickToCheckbox() {
		waitForElementClickable(driver, HomeTechPandaAdminUI.CHECKBOX);
		checkToDefaultCheckboxRadio(driver, HomeTechPandaAdminUI.CHECKBOX);
	}

	public void selectDeleteOption() {
		waitForElementClickable(driver, HomeTechPandaAdminUI.ACTION_SELECTBOX);
		selectItemInDefaultDropdownByValue(driver, HomeTechPandaAdminUI.ACTION_SELECTBOX, "delete");

	}

	public void clickButtonSubmit() {
		waitForElementClickable(driver, HomeTechPandaAdminUI.SUBMIT_BUTTON);
		clickToElement(driver, HomeTechPandaAdminUI.SUBMIT_BUTTON);

	}

	public void clickAcceptAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);

	}

	public String getMessageNoRecord() {
		waitForElementVisible(driver, HomeTechPandaAdminUI.NO_RECORD_MESSAGE);
		return getElementText(driver, HomeTechPandaAdminUI.NO_RECORD_MESSAGE);
	}

}
