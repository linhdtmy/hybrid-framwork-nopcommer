package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Test_04_Page_Object_MultiBrower extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);

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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generate_Random() {
		Random random = new Random();
		return random.nextInt();
	}

}
