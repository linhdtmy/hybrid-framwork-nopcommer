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
import pageObject.bankguru.AddNewCustomerBankGuruObject;
import pageObject.bankguru.EditAccountrBankGuruObject;
import pageObject.bankguru.EditCustomerBankGuruObject;
import pageObject.bankguru.HomePageBankGuruObject;
import pageObject.bankguru.LoginPageBankGuruObject;
import pageObject.bankguru.ManagerCustomerBankGuruObject;

public class Test_05_Edit_Account extends BaseTest {
	private HomePageBankGuruObject homePageObject;
	private LoginPageBankGuruObject loginPageObject;
	private AddNewCustomerBankGuruObject addNewCustomerObject;
	private ManagerCustomerBankGuruObject managerCustomerObject;
	private EditCustomerBankGuruObject editCustomerObject;
	private EditAccountrBankGuruObject editAccountObject;
	private AddNewAccountBankGuruObject newAccountObject;
	private WebDriver driver;
	private String userName = "mngr484724";
	private String password = "UrUzeva";
	private String customerName = "test";
	private String customerDOB = "10102000";
	private String customerAddress = "VietNam";
	private String customerCity = "HaNoi";
	private String customerPin = "123456";
	private String customerPhone = "0954875444";
	private String customerEmail = generate_Random() + "email123@gmail.com";
	private String customerState = "HaNoi";
	private String customerPassword = "123456";
	private String customerId = "";
	private String accountId = "";

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

		log.info("Precondition - Step 04 : Click New Customer   ");
		addNewCustomerObject = homePageObject.clickToNewCustomerLink();

		log.info("Precondition - Step 05 : Enter Customer name  ");
		addNewCustomerObject.enterToInputField(customerName, "name");
		log.info("Precondition - Step 06 : Enter DOB  ");
		addNewCustomerObject.enterToInputField(customerDOB, "dob");

		log.info("Precondition - Step 07 : Enter address ");
		addNewCustomerObject.enterToInputField(customerAddress, "address");

		log.info("Precondition - Step 08 : Enter City   ");
		addNewCustomerObject.enterToInputField(customerCity, "city");

		log.info("Precondition - Step 09 : Enter State  ");
		addNewCustomerObject.enterToInputField(customerState, "state");

		log.info("Precondition - Step 10 : Enter PIN  ");
		addNewCustomerObject.enterToInputField(customerPin, "pin");

		log.info("Precondition - Step 11 : Enter mobile phone  ");
		addNewCustomerObject.enterToInputField(customerPhone, "phone");

		log.info("Precondition - Step 12 : Enter email  ");
		addNewCustomerObject.enterToInputField(customerEmail, "email");

		log.info("Precondition - Step 13 : Enter password   ");
		addNewCustomerObject.enterToInputField(customerPassword, "password");

		log.info("Precondition - Step 14 : Click button Submit   ");
		managerCustomerObject = addNewCustomerObject.clickToSubmitButton();

		log.info("Precondition - Step 15 : Get Id  ");
		customerId = managerCustomerObject.getIdCustomer();

		newAccountObject = managerCustomerObject.clickToNewAccountLink();

		log.info("Precondition - Step 15 : Send key to customer id ");
		newAccountObject.inputToCustomerID(customerId);
		newAccountObject.inputToInitialDeposit("120000000");
		managerCustomerObject = newAccountObject.clickSubmitButton();
		accountId = managerCustomerObject.getAccountId();

		log.info("Precondition - Step 16 : Click Edit customer link   ");
		editAccountObject = managerCustomerObject.clickToEditAccount();

		log.info("Precondition - Step 17 : Enter To customerID   ");
		editAccountObject.enterToAccountID(accountId);
		
		log.info("Precondition - Step 17 : Click to button submit   ");
		editAccountObject.clickSubmitButton();

		log.info("Precondition - Step 18 : Click Button Submit   ");
		editCustomerObject.clickButtonSubmit();
		GenerateObject.getEditCustomerBankGuruObject(driver);

	}
	@Test
	public void TC_01_Verify_Name_Field() {
		
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

}
