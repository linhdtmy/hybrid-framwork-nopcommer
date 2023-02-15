package com.bankguru;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.bankguru.AddNewCustomerBankGuruObject;
import pageObject.bankguru.EditCustomerBankGuruObject;
import pageObject.bankguru.HomePageBankGuruObject;
import pageObject.bankguru.LoginPageBankGuruObject;
import pageObject.bankguru.ManagerCustomerBankGuruObject;

public class Test_02_Edit_Customer extends BaseTest {
	private HomePageBankGuruObject homePageObject;
	private LoginPageBankGuruObject loginPageObject;
	private AddNewCustomerBankGuruObject addNewCustomerObject;
	private ManagerCustomerBankGuruObject managerCustomerObject;
	private EditCustomerBankGuruObject editCustomerObject;
	private WebDriver driver;
	private String userName = "mngr474048";
	private String password = "jevUbej";
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

		log.info("Precondition - Step 16 : Click Edit customer link   ");
		editCustomerObject = managerCustomerObject.clickToEditCustomer();

		log.info("Precondition - Step 17 : Enter To customerID   ");
		editCustomerObject.enterToCustomerID(customerId);

		log.info("Precondition - Step 18 : Click Button Submit   ");
		editCustomerObject.clickButtonSubmit();
		GenerateObject.getEditCustomerBankGuruObject(driver);

	}

	@Test
	public void TC_01_Verify_Customer_Name() {
		log.info("TC_01 - Customer name must be dissable");
		log.info("TC_01 - Step 01 : Verify input text is disable ");
		verifyFalse(editCustomerObject.isEnableCustomerName());
	}

	@Test
	public void TC_02_Verify_Address_Field() {
		log.info("TC_02 - Address cannot be empty ");
		editCustomerObject.enterToInputField("", "address");
		log.info("TC_02 - Step 03 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Address Field must not be blank", "address"));
	}

	@Test
	public void TC_03_Verify_City_Field() {
		log.info("TC_03 - City cannot be empty");
		editCustomerObject.enterToInputField("", "city");
		log.info("TC_03 - Step 02 : Verify message not be blank display");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("City Field must not be blank", "city"));
		log.info("TC_03 - City cannot be numberic");
		log.info("TC_03 - Step 03 : Enter number into City field ");
		editCustomerObject.enterToInputField("123", "city");
		log.info("TC_03 - Step 04 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "city"));
		log.info("TC_03 - Step 05 : Enter number and text  into City field ");
		editCustomerObject.enterToInputField("123abc", "city");
		log.info("TC_03 - Step 06 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "city"));
		log.info("TC_03 - City cannot have special characters");
		log.info("TC_03 - Step 07 : Enter special charactor into name field");
		editCustomerObject.enterToInputField("@$#$#%ads", "city");
		log.info("TC_03 - Step 08 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "city"));

	}

	@Test
	public void TC_04_Verify_State_Field() {
		log.info("TC_04 - state cannot be empty");
		editCustomerObject.enterToInputField("", "state");
		log.info("TC_04 - Step 02 : Verify message not be blank display");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("State must not be blank", "state"));
		log.info("TC_04 - state cannot be numberic");
		log.info("TC_04 - Step 03 : Enter number into state field ");
		editCustomerObject.enterToInputField("123", "state");
		log.info("TC_04 - Step 04 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "state"));
		log.info("TC_04 - Step 05 : Enter number and text  into state field ");
		editCustomerObject.enterToInputField("123abc", "state");
		log.info("TC_04 - Step 06 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "state"));
		log.info("TC_04 - state cannot have special characters");
		log.info("TC_04 - Step 07 : Enter special charactor into state field");
		editCustomerObject.enterToInputField("@$#$#%ads", "state");
		log.info("TC_04 - Step 08 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "state"));

	}

	@Test
	public void TC_05_Verify_Pin_Field() {
		log.info("TC_05 - Pin must be numberic");
		log.info("TC_05 - Step 01 : Enter number into PIN field ");
		editCustomerObject.enterToInputField("123", "pin");
		log.info("TC_05 - Step 02 : Verify not display error message");
		verifyTrue(editCustomerObject.isUnDisplayErrorMessage("Characters are not allowed", "pin"));
		log.info("TC_05 - Step 03 : Enter characters into PIN field ");
		editCustomerObject.enterToInputField("123abc", "pin");
		log.info("TC_05 - Step 04 : Verify not display error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Characters are not allowed", "pin"));
		log.info("TC_05 - Step 05 : Enter  empty into PIN field ");
		editCustomerObject.enterToInputField("", "pin");
		log.info("TC_05 - Step 06 : Verify not display error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("PIN Code must not be blank", "pin"));
		log.info("TC_05 - Step 07 : Enter  less than 6 characters into PIN field ");
		editCustomerObject.enterToInputField("123", "pin");
		log.info("TC_05 - Step 08 : Verify not display error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("PIN Code must have 6 Digits", "pin"));
		log.info("TC_05 - Step 09 : Enter  more than 6 characters into PIN field ");
		editCustomerObject.enterToInputField("12345678", "pin");
		log.info("TC_05 - Step 10 : Verify value is 6 characters");
		verifyTrue(editCustomerObject.is6PinValue());
		log.info("TC_05 - Step 11 : Enter  special characters into PIN field ");
		editCustomerObject.enterToInputField("!@$#$", "pin");
		log.info("TC_05 - Step 12 : Verify not display error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "pin"));
		log.info("TC_05 - PIN cannot have first is  space ");
		log.info("TC_05 - Step 13 : Enter first is blank space");
		editCustomerObject.enterToInputField("  123", "pin");
		log.info("TC_05 - Step 14 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("First character can not have space", "pin"));
		log.info("TC_05 - PIN cannot  is  blank space ");
		log.info("TC_05 - Step 15 : Enter first is blank space");
		editCustomerObject.enterToInputField("   ", "pin");
		log.info("TC_05 - Step 16 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("First character can not have space", "pin"));

	}

	@Test
	public void TC_06_Verify_Telephone_Field() {
		log.info("TC_06 - Name cannot be empty");
		editCustomerObject.enterToInputField("", "phone");
		log.info("TC_06 - Step 02 : Verify message not be blank display");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Mobile no must not be blank", "phone"));
		log.info("TC_06 - Name cannot have special characters");
		log.info("TC_06 - Step 07 : Enter special charactor into name field");
		editCustomerObject.enterToInputField("098475@", "phone");
		log.info("TC_06 - Step 08 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "phone"));
	}

	@Test
	public void TC_07_Verify_Email_Field() {
		log.info("TC_07 - Email cannot be empty");
		editCustomerObject.enterToInputField("", "email");
		log.info("TC_07 - Step 02 : Verify message not be blank display");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Email-ID must not be blank", "email"));
		log.info("TC_07 - Step 03 : Enter first is blank phone");
		editCustomerObject.enterToInputField("guru99@gmail", "email");
		log.info("TC_07 - Step 04 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		editCustomerObject.enterToInputField("guru99@gmail.", "email");
		log.info("TC_07 - Step 05 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		editCustomerObject.enterToInputField("guru99gmail.com", "email");
		log.info("TC_07 - Step 06 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		editCustomerObject.enterToInputField("guru99", "email");
		log.info("TC_07 - Step 07 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		log.info("TC_07 - Step 08 : Enter first is blank phone");
		editCustomerObject.enterToInputField("gu ru99@gmail", "email");
		log.info("TC_07 - Step 09 : Verify error message");
		verifyTrue(editCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		 closeBrowserAndDriver();

	}

}
