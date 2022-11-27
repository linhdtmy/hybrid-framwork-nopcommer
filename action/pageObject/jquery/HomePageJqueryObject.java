package pageObject.jquery;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import jqueryUI.HomeJqueryUI;

public class HomePageJqueryObject extends BasePage {
	private WebDriver driver;

	public HomePageJqueryObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomeJqueryUI.PAGING_NUMBER, pageNumber);
		clickToElement(driver, HomeJqueryUI.PAGING_NUMBER, pageNumber);
		// sleepInSecond(1);

	}

	public boolean isActivePage(String pageNumber) {
		waitForElementVisible(driver, HomeJqueryUI.ACTIVE_PAGE, pageNumber);
		return isElementDisplay(driver, HomeJqueryUI.ACTIVE_PAGE, pageNumber);
	}

	public void inputTextToCountry(String headerLabel, String value) {
		waitForElementClickable(driver, HomeJqueryUI.INPUT_SEACH_BY_LABEL, headerLabel);
		sendKeyToElement(driver, HomeJqueryUI.INPUT_SEACH_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomeJqueryUI.INPUT_SEACH_BY_LABEL, Keys.ENTER, headerLabel);

	}

	public String getTextByLabelAndTextInput(String label, String inputText) {
		waitForElementVisible(driver, HomeJqueryUI.TEXT_BY_LABEL, label, inputText);
		return getElementText(driver, HomeJqueryUI.TEXT_BY_LABEL, label, inputText);
	}

	public int getCountPage() {
		waitForAllElementVisible(driver, HomeJqueryUI.LIST_PAGE);
		return getElementSize(driver, HomeJqueryUI.LIST_PAGE);
	}

	public ArrayList<String> getRowText() {
		ArrayList<String> listRow = new ArrayList<>();
		waitForAllElementVisible(driver, HomeJqueryUI.ROW_ONE_PAGE);
		for (WebElement e : getListWebElement(driver, HomeJqueryUI.ROW_ONE_PAGE)) {
			listRow.add(e.getText());
		}
		return listRow;
	}

	public void inputTextToCellByHeader(String headerName, String rowIndex, String value) {
		// đếm xem element có bao nhiêu anh để biết vị trí của nó ở cột thứ mấy
		int indexCell = getElementSize(driver, HomeJqueryUI.INDEX_COLUMN_BY_HEADER_LABEL, headerName) + 1;
		waitForElementClickable(driver, HomeJqueryUI.INPUT_BY_ROW, rowIndex, Integer.toString(indexCell));
		sendKeyToElement(driver, HomeJqueryUI.INPUT_BY_ROW, value, rowIndex, Integer.toString(indexCell));

	}

	public void selectDropdown(String headerName, String rowIndex, String value) {
		int indexCell = getElementSize(driver, HomeJqueryUI.INDEX_COLUMN_BY_HEADER_LABEL, headerName) + 1;
		waitForElementClickable(driver, HomeJqueryUI.SELECT_BY_ROW, rowIndex, Integer.toString(indexCell));
		selectItemInDefaultDropdownByText(driver, HomeJqueryUI.SELECT_BY_ROW, value, rowIndex, Integer.toString(indexCell));
	}

	public void clickToCheckbox(String headerName, String rowIndex) {
		int indexCell = getElementSize(driver, HomeJqueryUI.INDEX_COLUMN_BY_HEADER_LABEL, headerName) + 1;
		waitForElementClickable(driver, HomeJqueryUI.INPUT_BY_ROW, rowIndex, Integer.toString(indexCell));
		clickToElement(driver, HomeJqueryUI.INPUT_BY_ROW, rowIndex, Integer.toString(indexCell));
	}

}
