package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_06_Page_Generate_Object_03  {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String validEmail = "abc123" + generate_Random() + "@gmail.com";
	private String emailNotFound = "abc123" + generate_Random() + "@gmail.com";
	private String invalidEmail = "dddd";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private String incorrectPassword ="123";
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePageObject = GenerateObject.getHomePage(driver);

		RegisterPageUserObject registerPageObject ;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		registerPageObject=homePageObject.clickToRegisterLink();
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
		
		loginPageObject=homePageObject.clickToLoginLink();
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		
		loginPageObject=homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(invalidEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_NotFound_Email() {

		
		loginPageObject=homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(emailNotFound);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Existing_Email_Empty_Password() {
		loginPageObject=homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Existed_Email_IncorrectPassword() {
		
		loginPageObject=homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.inputToPasswordTextbox(incorrectPassword);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	
	}

	@Test
	public void TC_06_Login_Success() {
		loginPageObject=homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();
		//login thành công hiển thị lại trang homepage
		homePageObject=GenerateObject.getHomePage(driver);
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
