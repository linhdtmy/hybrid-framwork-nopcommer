package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.AddressUserObject;
import pageObject.user.nopcommerce.BackUserObject;
import pageObject.user.nopcommerce.ChangePasswordUserObject;
import pageObject.user.nopcommerce.CustomerInformUserObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;

public class Test_09_Dynamic_Locator extends BaseTest {

	private WebDriver driver;
	private String validEmail = "abc123" + generate_Random() + "@gmail.com";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	private CustomerInformUserObject customerInformObject;
	private AddressUserObject addressObject;
	private ChangePasswordUserObject changePasswordObject;
    private BackUserObject backUserObject;
    
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);
		homePageObject = GenerateObject.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Register() {
		RegisterPageUserObject registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(validEmail);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToPasswordConfirmTextbox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		registerPageObject.clickToLogoutButton();

	}

	@Test
	public void TC_02_Login_Success() {
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();
		homePageObject = GenerateObject.getHomePage(driver);
		Assert.assertTrue(homePageObject.isDisplayMyAccount());
	}

	@Test
	public void TC_03_Customer_Infor() {
		customerInformObject = new CustomerInformUserObject(driver);

		customerInformObject = homePageObject.clickToMyAccount();

		Assert.assertTrue(customerInformObject.isMyAccountIsDisplay());

	}

	@Test
	public void TC_04_Switch_Page() {

		addressObject = (AddressUserObject) customerInformObject.getPageSwitchObject(driver, "Addresses");

		changePasswordObject = (ChangePasswordUserObject) addressObject.getPageSwitchObject(driver, "Change password");

		addressObject = (AddressUserObject) changePasswordObject.getPageSwitchObject(driver, "Addresses");

		backUserObject = (BackUserObject) addressObject.getPageSwitchObject(driver, "Back in stock subscriptions");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
