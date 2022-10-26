package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_05_Page_Object_Factory_Login extends BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String validEmail = "abc123" + generate_Random() + "@gmail.com";
	private String emailNotFound = "abc123" + generate_Random() + "@gmail.com";
	private String invalidEmail = "dddd";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private String incorrectPassword ="123";
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);
		homePageObject = new HomeUserPageObject(driver);

		RegisterPageUserObject registerPageObject = new RegisterPageUserObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePageObject.clickToRegisterLink();
		registerPageObject = new RegisterPageUserObject(driver);
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
	public void TC_01_Login_Empty_Data() {
		loginPageObject = new LoginUserPageObject(driver);
		homePageObject.clickToLoginLink();
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		loginPageObject = new LoginUserPageObject(driver);
		homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(invalidEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_NotFound_Email() {

		loginPageObject = new LoginUserPageObject(driver);
		homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(emailNotFound);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Existing_Email_Empty_Password() {
		loginPageObject = new LoginUserPageObject(driver);
		homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Existed_Email_IncorrectPassword() {
		loginPageObject = new LoginUserPageObject(driver);
		homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.inputToPasswordTextbox(incorrectPassword);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	
	}

	@Test
	public void TC_06_Login_Success() {
		loginPageObject = new LoginUserPageObject(driver);
		homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();
		//login thành công hiển thị lại trang homepage
		//homePageObject= new HomePageObject(driver);
		Assert.assertTrue(homePageObject.isDisplayMyAccount());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generate_Random() {
		Random random = new Random();
		return random.nextInt();
	}

}
