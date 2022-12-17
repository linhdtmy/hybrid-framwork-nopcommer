package common;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jqueryUploadFileUI.BaseJqueryUploadUI;
import jqueryUploadFileUI.HomeJqueryUploadUI;
import pageObject.user.nopcommerce.AddressUserObject;
import pageObject.user.nopcommerce.BackUserObject;
import pageObject.user.nopcommerce.ChangePasswordUserObject;
import pageObject.user.nopcommerce.DownloadUserObject;
import pageObject.user.nopcommerce.OrderUserObject;
import pageObject.user.nopcommerce.ReviewCustomerObject;
import pageObject.user.nopcommerce.ReviewProductObject;
import pageObject.user.nopcommerce.RewardUserObject;
import userPageUI.BaseUI;

public class BasePage {

	JavascriptExecutor jsExecutor;

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);

	}

	public String getPAgeTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendKeyToAlert(WebDriver driver, String key) {
		waitForAlertPresence(driver).sendKeys(key);
	}

	public void switchToWindowById(WebDriver driver, String windownId) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			if (!id.equals(windownId)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToTabWindowByTitle(WebDriver driver, String expectPageTitle) {
		// lấy ra danh sách tất cả các tab
		Set<String> listTab = driver.getWindowHandles();
		// duyệt danh sách để lấy ra page có title cần lấy
		for (String id : listTab) {

			// switch qua từng tab để lấy title
			driver.switchTo().window(id);

			String title = driver.getTitle();
			// nếu title bằng với title expect thì thoát khỏi vòng lặp
			if (title.equals(expectPageTitle)) {
				break;
			}
		}
	}

	public void closeAnotherTab(WebDriver driver, String parentTabTitle) {
		// lấy ra danh sách tất cả các tab
		Set<String> listTab = driver.getWindowHandles();
		// duyệt danh sách để lấy ra page có title cần lấy
		for (String id : listTab) {

			// switch qua từng tab để lấy title
			driver.switchTo().window(id);

			String title = driver.getTitle();
			// nếu title bằng với title expect thì thoát khỏi vòng lặp
			if (!title.equals(parentTabTitle)) {
				driver.close();
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	// dùng xpath có thể cover tất cả các locator
	// Có thể làm việc với text (CSS ko làm đc)
	// Xpath có thể đi ngược node được CSS ko được
	public WebElement getWebElement(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getWebElement(WebDriver driver, String locatorType, String... values) {
		return driver.findElement(By.xpath(getDynamicXpath(locatorType, values)));
	}

	public void clickToElement(WebDriver driver, String xpath) {
		getWebElement(driver, xpath).click();

	}

	public void clickToElement(WebDriver driver, String locatorType, String... values) {
		getWebElement(driver, getDynamicXpath(locatorType, values)).click();

	}

	public boolean isLoadFileSuccess(WebDriver driver, String xpath) {
		WebElement i = getWebElement(driver, xpath);
		return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

	}

	public boolean isLoadFileSuccess(WebDriver driver, String locatorType, String... values) {
		WebElement i = getWebElement(driver, getDynamicXpath(locatorType, values));
		return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

	}

	// Từ 2 lần dùng trở lên =>Dùng biến để ko bị lặp lại
	public void sendKeyToElement(WebDriver driver, String xpath, String textValue) {
		WebElement webElement = getWebElement(driver, xpath);

		webElement.clear();
		webElement.sendKeys(textValue);
	}

	public void sendKeyToElement(WebDriver driver, String locatorType, String textValue, String... values) {
		WebElement webElement = getWebElement(driver, getDynamicXpath(locatorType, values));
		webElement.clear();
		webElement.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String xpath) {
		return getWebElement(driver, xpath).getText();
	}

	public String getElementValue(WebDriver driver, String xpath) {
		return getWebElement(driver, xpath).getAttribute("value");
	}

	public String getElementText(WebDriver driver, String locatorType, String... values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).getText();
	}

	public void selectItemInDefaultDropdownByValue(WebDriver driver, String xpath, String textItem) {
		Select select = new Select(getWebElement(driver, xpath));
		select.selectByValue(textItem);
	}

	public void selectItemInDefaultDropdownByValue(WebDriver driver, String locatorType, String textItem, String... values) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, values)));
		select.selectByValue(textItem);
	}

	public void selectItemInDefaultDropdownByText(WebDriver driver, String xpath, String textItem) {
		Select select = new Select(getWebElement(driver, xpath));
		select.selectByVisibleText(textItem);
	}

	public void selectItemInDefaultDropdownByText(WebDriver driver, String locatorType, String textItem, String... values) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, values)));
		select.selectByVisibleText(textItem);
	}

	public String getFirstSelectedItemDefaultDropDown(WebDriver driver, String xpath) {
		Select select = new Select(getWebElement(driver, xpath));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMuitlple(WebDriver driver, String xpath) {
		Select select = new Select(getWebElement(driver, xpath));
		return select.isMultiple();
	}

	public void selectedValueDropdown(WebDriver driver, String parentItem, String childItem, String expectedValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		driver.findElement(By.cssSelector(parentItem)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItem)));
		List<WebElement> allItems = driver.findElements(By.cssSelector(childItem));
		for (WebElement webElement : allItems) {
			String actualValue = webElement.getText();
			if (actualValue.equals(expectedValue)) {
				webElement.click();
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String xpath, String attribute) {
		return driver.findElement(By.xpath(xpath)).getAttribute(attribute);

	}

	public String getCssValue(WebDriver driver, String xpath, String propertyName) {
		return driver.findElement(By.xpath(xpath)).getCssValue(propertyName);

	}

	public String getHexaColorFormRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpath) {
		return getListWebElement(driver, xpath).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... values) {
		return getListWebElement(driver, getDynamicXpath(locatorType, values)).size();
	}

	public List<WebElement> getListWebElement(WebDriver driver, String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpath) {
		WebElement element = getWebElement(driver, xpath);
		if (!element.isSelected()) {
			element.click();

		}
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String... values) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, values));
		if (!element.isSelected()) {
			element.click();

		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpath) {
		WebElement element = getWebElement(driver, xpath);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String xpath) {
		return getWebElement(driver, xpath).isDisplayed();
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType, String... values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String xpath) {
		return getWebElement(driver, xpath).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpath) {
		return getWebElement(driver, xpath).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpath) {
		driver.switchTo().frame(getWebElement(driver, xpath));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpath) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpath)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String xpath, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, xpath), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... values) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, values)), key).perform();
	}

	public void waitForElementVisible(WebDriver driver, String xpath) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getDynamicXpath(locatorType, values))));

	}

	public void waitForAllElementVisible(WebDriver driver, String xpath) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

	}

	public void waitForElementInVisible(WebDriver driver, String xpath) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

	}

	public void waitForAllElementInVisible(WebDriver driver, String xpath) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpath)));

	}

	private String getDynamicXpath(String dynamicLocator, String... params) {
		return String.format(dynamicLocator, (Object[]) params);
		// System.out.println("Click to : " + locator);
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorType)));

	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicXpath(locatorType, values))));

	}

	protected Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	protected String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void sleepInSecond(long timeSeconds) {
		try {
			Thread.sleep(timeSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileName) {
		// lấy đường dẫn thư mục upload
		String filePath = GlobalConstants.UPLOAD_FILE;
		// tạo biến để lưu danh sách tất cả các fie
		String fullFileName = "";
		for (String file : fileName) {
			fullFileName = fullFileName + filePath + file + "\n";

		}
		fullFileName = fullFileName.trim();
		System.out.println(BaseJqueryUploadUI.ADD_FILE);
		getWebElement(driver, BaseJqueryUploadUI.ADD_FILE).sendKeys(fullFileName);
		sleepInSecond(5);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);

		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public AddressUserObject getAddressObject(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.ADDRESS_LINK);
		clickToElement(driver, BaseUI.ADDRESS_LINK);
		return GenerateObject.getAddressPage(driver);
	}

	public OrderUserObject getOrderPage(WebDriver driver) {
		waitForElementVisible(driver, BaseUI.ORDER_LINK);
		clickToElement(driver, BaseUI.ORDER_LINK);
		return GenerateObject.getOrderPage(driver);
	}

	public ReviewProductObject getReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.CUSTOMER_REVIEW_LINK);
		clickToElement(driver, BaseUI.CUSTOMER_REVIEW_LINK);
		return GenerateObject.getReviewPage(driver);
	}

	public ReviewCustomerObject getReviewCustomerPage(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.CUSTOMER_REVIEW_LINK);
		clickToElement(driver, BaseUI.CUSTOMER_REVIEW_LINK);
		return GenerateObject.getReviewCustomerPage(driver);
	}

	public BackUserObject getBackPage(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.BACK_LINK);
		clickToElement(driver, BaseUI.BACK_LINK);
		return GenerateObject.getBackPage(driver);
	}

	public DownloadUserObject getDownloadPage(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.DOWNLOAD_LINK);
		clickToElement(driver, BaseUI.DOWNLOAD_LINK);
		return GenerateObject.getDownloadPage(driver);
	}

	public ChangePasswordUserObject getPasswordObject(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.CHANGE_PASS_LINK);
		clickToElement(driver, BaseUI.CHANGE_PASS_LINK);
		return GenerateObject.getChangePasswordPage(driver);
	}

	public RewardUserObject getRewardPage(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.REWARD_LINK);
		clickToElement(driver, BaseUI.REWARD_LINK);
		return GenerateObject.getRewardPage(driver);
	}

	public BasePage getPageSwitchObject(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BaseUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, BaseUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Change password":
			return GenerateObject.getChangePasswordPage(driver);
		case "Orders":
			return GenerateObject.getOrderPage(driver);
		case "Addresses":
			return GenerateObject.getAddressPage(driver);
		case "Back in stock subscriptions":
			return GenerateObject.getBackPage(driver);
		default:
			throw new RuntimeException("Pagename invalid");
		}

	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

	}

	int shortTimeout = 5, longTimeout = 30;

	public boolean isElementUnDisplay(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		overrideGlobalTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			// element ko có trong DOM =>Element không hiển thị
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			// element có trong DOM nhưng ko hiển thị
			return true;
		} else {
			// element có trong DOM và có hiển thị
			return false;
		}

	}

	public boolean isElementUnDisplay(WebDriver driver, String locatorType, String... values) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, values));
		overrideGlobalTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			// element ko có trong DOM =>Element không hiển thị
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			// element có trong DOM nhưng ko hiển thị
			return true;
		} else {
			// element có trong DOM và có hiển thị
			return false;
		}

	}
}
