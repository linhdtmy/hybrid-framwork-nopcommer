package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BaseFactory;

public class LoginPageFactoryObject extends BaseFactory{
	private WebDriver driver;
    @FindBy(xpath="//input[@class='email']")
    private WebElement emailTextbox ;
    @FindBy(xpath="//input[@class='password']")
    private WebElement passwordTextbox ;
    @FindBy(xpath="//button[contains(@class,'login-button')]")
    private WebElement loginButton ;
    @FindBy(xpath="//span[@class='field-validation-error']")
    private WebElement errorMessageEmail ;
    @FindBy(xpath="//div[contains(@class,'message-error')]")
    private WebElement errorMessageUnsuccessfullLogin ;
	
	public LoginPageFactoryObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,errorMessageEmail);
		return getElementText(driver,errorMessageEmail);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, invalidEmail);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver,passwordTextbox, password);

	}

	public String getErrorMessageUnsucessfullLogin() {
		waitForElementVisible(driver, errorMessageUnsuccessfullLogin);
		return getElementText(driver,errorMessageUnsuccessfullLogin);
	}
}
