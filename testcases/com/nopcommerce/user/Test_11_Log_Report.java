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

public class Test_11_Log_Report extends BaseTest {

	private WebDriver driver;
	private String validEmail = "abc123" + generate_Random() + "@gmail.com";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	
    
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
		log.info("Register Step 01: Init home page");
		RegisterPageUserObject registerPageObject = homePageObject.clickToRegisterLink();
		log.info("Register Step 02: Enter firstname "+firstName);
		registerPageObject.inputToFirstNameTextbox(firstName);
		log.info("Register Step 03: Enter lastname "+lastName);
		registerPageObject.inputToLastNameTextbox(lastName);
		log.info("Register Step 04: Enter email  "+validEmail);
		registerPageObject.inputToEmailTextbox(validEmail);
		log.info("Register Step 05: Enter password "+password);
		registerPageObject.inputToPasswordTextbox(password);
		log.info("Register Step 06: Enter password confirm "+password);
		registerPageObject.inputToPasswordConfirmTextbox(password);
		log.info("Register Step 07: Click Register button ");
		registerPageObject.clickToRegisterButton();
		log.info("Register Step 08: Verify message  register successed ");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed123");
		log.info("Register Step 09: Click to login button");
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

	 

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
