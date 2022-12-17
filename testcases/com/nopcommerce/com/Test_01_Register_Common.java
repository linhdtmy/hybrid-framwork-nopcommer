package com.nopcommerce.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;

public class Test_01_Register_Common extends BaseTest {
	private WebDriver driver;
	public static String validEmail = "abc123" + generate_Random_Number() + "@gmail.com";
	public static String password = "Test@12345";
	private String firstName = "abc", lastName = "efgh ";
	private HomeUserPageObject homePageObject;

	@Parameters("browser")
	@BeforeTest
	public void registerUser(String browserName) {

		driver = getBrowser(browserName);
		homePageObject = GenerateObject.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Register Step 01: Init home page");
		RegisterPageUserObject registerPageObject = homePageObject.clickToRegisterLink();
		log.info("Register Step 02: Enter firstname " + firstName);
		registerPageObject.inputToFirstNameTextbox(firstName);
		log.info("Register Step 03: Enter lastname " + lastName);
		registerPageObject.inputToLastNameTextbox(lastName);
		log.info("Register Step 04: Enter email  " + validEmail);
		registerPageObject.inputToEmailTextbox(validEmail);
		log.info("Register Step 05: Enter password " + password);
		registerPageObject.inputToPasswordTextbox(password);
		log.info("Register Step 06: Enter password confirm " + password);
		registerPageObject.inputToPasswordConfirmTextbox(password);
		log.info("Register Step 07: Click Register button ");
		registerPageObject.clickToRegisterButton();
		log.info("Register Step 08: Verify message  register successed ");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Register Step 09: Click to login button");
		registerPageObject.clickToLogoutButton();

		driver.quit();
	}
}
