package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.com.Test_01_Register_Common;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;

public class Test_13_Share_Data extends BaseTest {

	private WebDriver driver;

	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);
		homePageObject = GenerateObject.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(Test_01_Register_Common.validEmail);
		loginPageObject.inputToPasswordTextbox(Test_01_Register_Common.password);
		loginPageObject.clickToLoginButton();
		homePageObject = GenerateObject.getHomePage(driver);
		Assert.assertTrue(homePageObject.isDisplayMyAccount());

	}

	@Test
	public void TC_01_Search() {

	}

	@Test
	public void TC_02_Sort() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
