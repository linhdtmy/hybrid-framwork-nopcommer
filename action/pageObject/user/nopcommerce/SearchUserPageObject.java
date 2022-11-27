package pageObject.user.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import userPageUI.ReviewCustomerUI;
import userPageUI.SearchPageUI;

public class SearchUserPageObject extends BasePage {
	private WebDriver driver;

	public SearchUserPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);

	}

	public String getMessageWarning() {
		waitForElementVisible(driver, SearchPageUI.WARNING_MESSAGE);
		return getElementText(driver, SearchPageUI.WARNING_MESSAGE);
	}

	public void inputToSearchKeywordTextbox(String keywordText) {
		waitForElementClickable(driver, SearchPageUI.SEARCH_KEYWORD_INPUT);
		sendKeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_INPUT, keywordText);
	}

	public String getNoProductMatchMessage() {
		waitForElementVisible(driver, SearchPageUI.NO_RESULT_MESSAGE);
		return getElementText(driver, SearchPageUI.NO_RESULT_MESSAGE);
	}

	public List<WebElement> getProduct() {
		waitForAllElementVisible(driver, SearchPageUI.PRODUCT_TITLE);
		List<WebElement> product = getListWebElement(driver, SearchPageUI.PRODUCT_TITLE);
		return product;

	}

	public void checkToAdvanceSearchCheckbox() {
		waitForElementClickable(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);

	}

	public void selectCategory(String option) {
		waitForElementClickable(driver, SearchPageUI.CATEGORY_SELECT);
		selectItemInDefaultDropdownByText(driver, SearchPageUI.CATEGORY_SELECT, option);

	}

	public void uncheckToAutoSearchCategory() {
		waitForElementClickable(driver, SearchPageUI.AUTO_SEARCH_CATEGORY_CHECKBOX);
		if (getWebElement(driver, SearchPageUI.AUTO_SEARCH_CATEGORY_CHECKBOX).isSelected()) {
			getWebElement(driver, SearchPageUI.AUTO_SEARCH_CATEGORY_CHECKBOX).clear();
		}
	}

	public void checkedToAutoSearchCategory() {
		waitForElementClickable(driver, SearchPageUI.AUTO_SEARCH_CATEGORY_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.AUTO_SEARCH_CATEGORY_CHECKBOX);

	}

	public void selectManufacturer(String option) {
		waitForElementClickable(driver, SearchPageUI.MANUAFACTURER_SELECT);
		selectItemInDefaultDropdownByText(driver, SearchPageUI.MANUAFACTURER_SELECT, option);

	}

}
