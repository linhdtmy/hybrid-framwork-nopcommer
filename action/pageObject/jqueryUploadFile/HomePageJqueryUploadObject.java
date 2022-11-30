package pageObject.jqueryUploadFile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import jqueryUI.HomeJqueryUI;
import jqueryUploadFileUI.HomeJqueryUploadUI;

public class HomePageJqueryUploadObject extends BasePage {
	private WebDriver driver;

	public HomePageJqueryUploadObject(WebDriver driver) {
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

	public boolean isDisplayFileNameUpload(String fileName) {
		waitForElementVisible(driver, HomeJqueryUploadUI.FILE_NAME_UPLOAD, fileName);
		return isElementDisplay(driver, HomeJqueryUploadUI.FILE_NAME_UPLOAD, fileName);
	}

	public void clickButtonStart() {
		waitForAllElementVisible(driver, HomeJqueryUploadUI.BUTTON_UPLOAD);
		List<WebElement> listWebElement = getListWebElement(driver, HomeJqueryUploadUI.BUTTON_UPLOAD);
		for (WebElement element : listWebElement) {
			element.click();
			sleepInSecond(3);
		}

	}

	public boolean isDisplayFileNameUploadLink(String fileName) {
		waitForElementVisible(driver, HomeJqueryUploadUI.FILE_NAME_UPLOAD_LINK, fileName);
		return isElementDisplay(driver, HomeJqueryUploadUI.FILE_NAME_UPLOAD_LINK, fileName);

	}

	public boolean isLoadFileSuccess(WebDriver driver,String fileName) {
//		WebElement i = getWebElement(driver, HomeJqueryUploadUI.IMG_UPLOAD_SUCCES, fileName);
//		return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
//		"&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
//		
		return isLoadFileSuccess(driver,HomeJqueryUploadUI.IMG_UPLOAD_SUCCES,fileName);
	}

}
