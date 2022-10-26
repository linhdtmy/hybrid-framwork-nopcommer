package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BaseFactory;

public class RegisterPageFactoryObject extends BaseFactory {

	private WebDriver driver;
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastnameTextbox;
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement emailExistErrorMessage;
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	public RegisterPageFactoryObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver,registerButton);

	}

	public String getErrorMessageFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageLastnameTextbox() {
		waitForElementVisible(driver,lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageEmailTextbox() {
		waitForElementVisible(driver,emailErrorMessage);
		return getElementText(driver,emailErrorMessage);
	}

	public String getErrorMessagePasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver,confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstnameTextbox);
		sendKeyToElement(driver,firstnameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextbox);
		sendKeyToElement(driver,lastnameTextbox, lastName);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);

	}

	public void inputToPasswordConfirmTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver,confirmPasswordTextbox, confirmPassword);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,registerSuccessMessage);
		return getElementText(driver,registerSuccessMessage);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getExistsEmailErrorMessage() {
		waitForElementVisible(driver, emailExistErrorMessage);
		return getElementText(driver, emailExistErrorMessage);
	}

}
