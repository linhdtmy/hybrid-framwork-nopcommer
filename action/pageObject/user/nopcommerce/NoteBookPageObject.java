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
		sleepInSecond(3);
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
			// System.out.println(webElement.getText());
			listPrice.add(webElement.getText().replace(",", "").substring(1));
			// System.out.println(webElement.getText().replace(",", "").substring(1));
		}

		return listPrice;

	}

	public void selectDisplayOnePage(String page) {
		waitForElementClickable(driver, NoteBookUI.DISPLAY_PAGE_PULLDOWN);
		selectItemInDefaultDropdownByText(driver, NoteBookUI.DISPLAY_PAGE_PULLDOWN, page);
		sleepInSecond(3);
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

	public void selectPage(int pageNumber) {

		waitForElementVisible(driver, NoteBookUI.PAGE, String.valueOf(pageNumber));
		clickToElement(driver, NoteBookUI.PAGE, String.valueOf(pageNumber));
		sleepInSecond(3);
	}

	public boolean isUnDisplayPaging() {
		sleepInSecond(3);
		return isElementUnDisplay(driver, NoteBookUI.PAGGING);
	}

	public DetailProductObject clickToProduct() {
		waitForElementClickable(driver, NoteBookUI.PRODUCT_LINK,"Build your own computer");
		clickToElement(driver, NoteBookUI.PRODUCT_LINK,"Build your own computer");
		return GenerateObject.getDetailPage(driver);
	}

	public void clickToAddWishList() {
		waitForElementClickable(driver, NoteBookUI.WISHLIST_BUTTON);
		clickToElement(driver, NoteBookUI.WISHLIST_BUTTON);

	}

	public WishListObject clickToWishListIcon() {
		waitForElementClickable(driver, NoteBookUI.WISHLIST_ICON);
		clickToElement(driver, NoteBookUI.WISHLIST_ICON);
		return GenerateObject.getWishListObject(driver);
	}

	public void addProductToCompare() {
		waitForAllElementVisible(driver, NoteBookUI.COMPARE_BUTTON);
		List<WebElement> listElement = getListWebElement(driver, NoteBookUI.COMPARE_BUTTON);
		for (int i = 0; i < 2; i++) {

			listElement.get(i).click();
			sleepInSecond(3);
		}

	}

	public String getMessageAddToCompareListSuccess() {
		waitForElementVisible(driver, NoteBookUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
		return getElementText(driver, NoteBookUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
	}

	public CompareProductObject clickToCompareLink() {
		waitForElementClickable(driver, NoteBookUI.PRODUCT_COMPARE_LINK);
		clickToElement(driver, NoteBookUI.PRODUCT_COMPARE_LINK);
		return GenerateObject.getCompareProductObject(driver);
	}

	public DetailProductObject clickToProductLink(int i) {
		waitForElementClickable(driver, NoteBookUI.PRODUCT_TITLE_LINK, Integer.toString(i));
		clickToElement(driver, NoteBookUI.PRODUCT_TITLE_LINK, Integer.toString(i));
		return GenerateObject.getDetailPage(driver);
	}

	public RecentViewProductObject clickToRecentViewProduct() {
		waitForElementClickable(driver, NoteBookUI.RECENT_VIEW_PRODUCT);
		clickToElement(driver, NoteBookUI.RECENT_VIEW_PRODUCT);
		return GenerateObject.getRecentViewProductObject(driver);
	}

	public List<WebElement> getListProductElement() {
		waitForAllElementVisible(driver, NoteBookUI.PRODUCT_TITLE_LINK);
		return getListWebElement(driver, NoteBookUI.PRODUCT_TITLE_LINK);
	}

}
