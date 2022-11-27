package pageObject.user.nopcommerce;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GenerateObject;
import userPageUI.BaseUI;
import userPageUI.NoteBookUI;
import userPageUI.ReviewCustomerUI;
import userPageUI.SearchPageUI;

public class NoteBookPageObject extends BasePage {
	private WebDriver driver;

	public NoteBookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public NoteBookPageObject selectSortBy(String sortType) {
		waitForElementClickable(driver, NoteBookUI.SORT_BY_PULLDOWN);
		selectItemInDefaultDropdownByText(driver, NoteBookUI.SORT_BY_PULLDOWN, sortType);
		return GenerateObject.getNoteBookPageObject(driver);
	}

	public ArrayList<String> getListProductTitle() {
		ArrayList<String> listTitle = new ArrayList<String>();
		for (WebElement productTitle : getListWebElement(driver, NoteBookUI.PRODUCT_TITLE)) {
			listTitle.add(productTitle.getText());
		}
		return listTitle;

	}

	public ArrayList<String> getListProductPrice() {
		ArrayList<String> listPrice = new ArrayList<String>();
		waitForAllElementVisible(driver, NoteBookUI.PRODUCT_PRICE);
		List<WebElement> listProduct = getListWebElement(driver, NoteBookUI.PRODUCT_PRICE);
		for (WebElement webElement : listProduct) {
			//System.out.println(webElement.getText());
			listPrice.add(webElement.getText().replace(",", "").substring(1));
			//System.out.println(webElement.getText().replace(",", "").substring(1));
		}
		System.out.println("====********========");
		for (String s : listPrice) {
			System.out.println(s);
		}
//		for  (WebElement productPrice : listProduct) {
//			listPrice.add(productPrice.getText().replace(",", "").substring(1));
//			System.out.println("==========");
//			System.out.println(productPrice.getText().replace(",", "").substring(1));
//		}
		return listPrice;

	}

	public void selectDisplayOnePage(String page) {
		waitForElementClickable(driver, NoteBookUI.DISPLAY_PAGE_PULLDOWN);
		selectItemInDefaultDropdownByText(driver, NoteBookUI.DISPLAY_PAGE_PULLDOWN, page);
	}

	public boolean isExistIcon(String iconName) {
		if (iconName.equals("next")) {
			waitForElementVisible(driver, NoteBookUI.NEXT_ICON);
			return isElementDisplay(driver, NoteBookUI.NEXT_ICON);
		} else {
			waitForElementVisible(driver, NoteBookUI.PREVIOUS_ICON);
			return isElementDisplay(driver, NoteBookUI.PREVIOUS_ICON);
		}

	}

	public void selectPage(String pageNumber) {
		waitForElementVisible(driver, NoteBookUI.PAGE, pageNumber);
		clickToElement(driver, NoteBookUI.PAGE, pageNumber);
	}

	public void selectPage2() {
		waitForElementVisible(driver, NoteBookUI.PAGE_2);
		clickToElement(driver, NoteBookUI.PAGE_2);
	}

}
