package com.bankguru;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.bankguru.AddNewAccountBankGuruObject;
import pageObject.bankguru.HomePageBankGuruObject;
import pageObject.bankguru.LoginPageBankGuruObject;

public class Test_04_New_Account extends BaseTest {
	private HomePageBankGuruObject homePageObject;
	private LoginPageBankGuruObject loginPageObject;
	private AddNewAccountBankGuruObject addNewAccountObject;
	private WebDriver driver;
	private String userName = "mngr484724";
	private String password = "UrUzeva";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Precondition - Step 01 : Open URL ");
		driver = getBrowser(browserName, url);
		loginPageObject = GenerateObject.getLoginPageBankGuruObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Precondition - Step 02 : Enter username + password  ");
		loginPageObject.enterToUserName(userName);
		loginPageObject.enterToPassword(password);

		log.info("Precondition - Step 03 : Click button Login  ");
		homePageObject = loginPageObject.clickToLoginButton();

		log.info("Precondition - Step 04 : Click to new Account  ");
		addNewAccountObject = homePageObject.clickToNewAccountLink();

	}

	@Test
	public void TC_01_Verify_Customer_ID() {
		log.info("TC_01 - Step 01 : Press Tab and move the next field ");
		addNewAccountObject.pressTabToCustomerID();
		verifyTrue(addNewAccountObject.isDisplayErrorMessage("Customer ID is required"));

		log.info("TC_01 - Customer id must be a numberic ");
		addNewAccountObject.inputToCustomerID("abc");
		verifyTrue(addNewAccountObject.isDisplayErrorMessage("Characters are not allowed"));

		log.info("TC_01 - Customer id cannot special character ");
		addNewAccountObject.inputToCustomerID("@#$#");
		verifyTrue(addNewAccountObject.isDisplayErrorMessage("Special characters are not allowed"));

		log.info("TC_01 - Customer id cannot blank space ");
		addNewAccountObject.inputToCustomerID(" 123");
		verifyTrue(addNewAccountObject.isDisplayErrorMessage("First character can not have space"));

	}

	@Test
	public void TC_02_Initial_Deposit() {
		log.info("TC_01 - Step 01 : Press Tab and move the next field ");
		addNewAccountObject.pressTabToDesposit();
		verifyTrue(addNewAccountObject.isDisplayErrorMessage("Initial Deposit must not be blank"));

		log.info("TC_01 - Initial Deposit must be a numberic ");
		addNewAccountObject.inputToInitialDeposit("abc");
		verifyTrue(addNewAccountObject.isDisplayErrorMessage("Characters are not allowed"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

}
