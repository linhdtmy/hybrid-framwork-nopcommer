package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_03_Page_Object_Modal_Register {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String email = "abc123" + generate_Random() + "@gmail.com";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePageObject = new HomePageObject(driver);
		registerPageObject = new RegisterPageObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		System.out.println("Home -page :Click to Register link");
		homePageObject.clickToRegisterLink();

		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getErrorMessageFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessagePasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {

		homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox("123");
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getErrorMessageEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Valid_Inform() {

		homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToPasswordConfirmTextbox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		registerPageObject.clickToLogoutButton();

	}

	@Test
	public void TC_04_Existed_Email() {

		homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToPasswordConfirmTextbox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getExistsEmailErrorMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6_Charactor() {
		homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox("Abc");
		registerPageObject.inputToPasswordConfirmTextbox("Abc@12345");
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getErrorMessagePasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Passconfirm() {
		homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox("Abc");
		registerPageObject.inputToPasswordConfirmTextbox("Abc@12345");
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPasswordTextbox(), "The password and confirmation password do not match.");

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
