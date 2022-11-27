package com.nopcommerce.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;

public class Test_01_Login  extends BaseTest{
	
	private WebDriver driver;
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject ;
	String inValidEmail="jsfjdf";
	String emailNotRegister="linh@gmail.com";
	String emailRegistetedEmail="abc@gmail.com";
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageObject = GenerateObject.getHomePage(driver);
		
	}
	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getElementValidationEmailMessage(driver),"Please enter your email");
	}
	@Test
	public void TC_02_Invalid_Email() {
		loginPageObject.inputToEmailTextbox(inValidEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getElementValidationEmailMessage(driver),"Wrong email");

		
	}
	@Test
	public void TC_03_Login_With_Email_Not_Register() {
		loginPageObject.inputToEmailTextbox(emailNotRegister);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageNotRegister(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	
	@Test
	public void TC_04_Login_With_Email_Register_No_Password() {
		loginPageObject.inputToEmailTextbox(emailRegistetedEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageNotRegister(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_With_Email_Register_Error_Password() {
		loginPageObject.inputToEmailTextbox(emailRegistetedEmail);
		loginPageObject.inputToPasswordTextbox("fkdhs");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageNotRegister(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	@Test
	public void TC_06_Login_With_Email_Register_Valid_Password() {
		loginPageObject.inputToEmailTextbox(emailRegistetedEmail);
		loginPageObject.inputToPasswordTextbox("Linh@12345");
		homePageObject= loginPageObject.clickToLoginButton();		
		Assert.assertTrue(homePageObject.isLogoutDisplay());

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
