package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BaseFactory;
import userPageUI.HomePageUI;

public class HomePageFactoryObject extends BaseFactory {
	private WebDriver driver;
    public HomePageFactoryObject(WebDriver driver) {
		this.driver =driver;
	}
    @FindBy(xpath="//a[@class='ico-register']")
    private WebElement registerLink ;
    @FindBy(xpath="//a[@class='ico-login']")
    private WebElement loginLink ;
    @FindBy(xpath="//a[@class='ico-account']")
    private WebElement myAccountText ;
    
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver,loginLink);
		clickToElement(driver,loginLink);
		
	}
	public boolean isDisplayMyAccount() {
		return isElementDisplay(driver, myAccountText);
	}

	
 

}
