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
import pageObject.bankguru.HomePageBankGuruObject;
import pageObject.bankguru.LoginPageBankGuruObject;

public class Test_01_New_Customer extends BaseTest {
	private HomePageBankGuruObject homePageObject;
	private LoginPageBankGuruObject loginPageObject;
	private AddNewCustomerBankGuruObject addNewCustomerObject;
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

		log.info("Precondition - Step 04 : Click New Customer   ");
		addNewCustomerObject = homePageObject.clickToNewCustomerLink();

	}

	@Test
	public void TC_01_Verify_Name_Field() {
		log.info("TC_01 - Name cannot be empty");
		log.info("TC_01 - Step 01 : Press Tab and move the next field ");
		addNewCustomerObject.pressTabToMoveNextField("name");
		log.info("TC_01 - Step 02 : Verify message not be blank display");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Customer name must not be blank", "name"));
		log.info("TC_01 - Name cannot be numberic");
		log.info("TC_01 - Step 03 : Enter number into name field ");
		addNewCustomerObject.enterToInputField("123", "name");
		log.info("TC_01 - Step 04 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "name"));
		log.info("TC_01 - Step 05 : Enter number and text  into name field ");
		addNewCustomerObject.enterToInputField("123abc", "name");
		log.info("TC_01 - Step 06 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "name"));
		log.info("TC_01 - Name cannot have special characters");
		log.info("TC_01 - Step 07 : Enter special charactor into name field");
		addNewCustomerObject.enterToInputField("@$#$#%ads", "name");
		log.info("TC_01 - Step 08 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "name"));
		log.info("TC_01 - Name cannot have first is  space ");
		log.info("TC_01 - Step 01 : Enter first is blank space");
		addNewCustomerObject.enterToInputField("  123", "name");
		log.info("TC_01 - Step 01 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "name"));
	}

	@Test
	public void TC_02_Verify_Address_Field() {
		log.info("TC_02 - Address cannot be empty ");
		log.info("TC_02 - Step 01 : Press Tab and move the next field ");
		addNewCustomerObject.pressTabToMoveNextField("address");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Address Field must not be blank", "address"));
		log.info("TC_02 - Address cannot have first is  space ");
		log.info("TC_02 - Step 02 : Enter first is blank space");
		addNewCustomerObject.enterToInputField("  123", "address");
		log.info("TC_02 - Step 03 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "address"));
	}

	@Test
	public void TC_03_Verify_City_Field() {
		log.info("TC_03 - City cannot be empty");
		log.info("TC_03 - Step 01 : Press Tab and move the next field ");
		addNewCustomerObject.pressTabToMoveNextField("city");
		log.info("TC_03 - Step 02 : Verify message not be blank display");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("City Field must not be blank", "city"));
		log.info("TC_03 - City cannot be numberic");
		log.info("TC_03 - Step 03 : Enter number into City field ");
		addNewCustomerObject.enterToInputField("123", "city");
		log.info("TC_03 - Step 04 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "city"));
		log.info("TC_03 - Step 05 : Enter number and text  into City field ");
		addNewCustomerObject.enterToInputField("123abc", "city");
		log.info("TC_03 - Step 06 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "city"));
		log.info("TC_03 - City cannot have special characters");
		log.info("TC_03 - Step 07 : Enter special charactor into name field");
		addNewCustomerObject.enterToInputField("@$#$#%ads", "city");
		log.info("TC_03 - Step 08 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "city"));
		log.info("TC_03 - City cannot have first is  space ");
		log.info("TC_03 - Step 01 : Enter first is blank space");
		addNewCustomerObject.enterToInputField("  123", "city");
		log.info("TC_03 - Step 01 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "city"));

	}

	@Test
	public void TC_04_Verify_State_Field() {
		log.info("TC_04 - state cannot be empty");
		log.info("TC_04 - Step 01 : Press Tab and move the next field ");
		addNewCustomerObject.pressTabToMoveNextField("state");
		log.info("TC_04 - Step 02 : Verify message not be blank display");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("State must not be blank", "state"));
		log.info("TC_04 - state cannot be numberic");
		log.info("TC_04 - Step 03 : Enter number into state field ");
		addNewCustomerObject.enterToInputField("123", "state");
		log.info("TC_04 - Step 04 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "state"));
		log.info("TC_04 - Step 05 : Enter number and text  into state field ");
		addNewCustomerObject.enterToInputField("123abc", "state");
		log.info("TC_04 - Step 06 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Numbers are not allowed", "state"));
		log.info("TC_04 - state cannot have special characters");
		log.info("TC_04 - Step 07 : Enter special charactor into state field");
		addNewCustomerObject.enterToInputField("@$#$#%ads", "state");
		log.info("TC_04 - Step 08 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "state"));
		log.info("TC_04 - state cannot have first is  space ");
		log.info("TC_04 - Step 09 : Enter first is blank space");
		addNewCustomerObject.enterToInputField("  123", "state");
		log.info("TC_04 - Step 10 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "state"));

	}

	@Test
	public void TC_05_Verify_Pin_Field() {
		log.info("TC_05 - Pin must be numberic");
		log.info("TC_05 - Step 01 : Enter number into PIN field ");
		addNewCustomerObject.enterToInputField("123", "pin");
		log.info("TC_05 - Step 02 : Verify not display error message");
		verifyTrue(addNewCustomerObject.isUnDisplayErrorMessage("Characters are not allowed", "pin"));
		log.info("TC_05 - Step 03 : Enter characters into PIN field ");
		addNewCustomerObject.enterToInputField("123abc", "pin");
		log.info("TC_05 - Step 04 : Verify not display error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Characters are not allowed", "pin"));
		log.info("TC_05 - Step 05 : Enter  empty into PIN field ");
		addNewCustomerObject.enterToInputField("", "pin");
		log.info("TC_05 - Step 06 : Verify not display error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("PIN Code must not be blank", "pin"));
		log.info("TC_05 - Step 07 : Enter  less than 6 characters into PIN field ");
		addNewCustomerObject.enterToInputField("123", "pin");
		log.info("TC_05 - Step 08 : Verify not display error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("PIN Code must have 6 Digits", "pin"));
		log.info("TC_05 - Step 09 : Enter  more than 6 characters into PIN field ");
		addNewCustomerObject.enterToInputField("12345678", "pin");
		log.info("TC_05 - Step 10 : Verify value is 6 characters");
		verifyTrue(addNewCustomerObject.is6PinValue());
		log.info("TC_05 - Step 11 : Enter  special characters into PIN field ");
		addNewCustomerObject.enterToInputField("!@$#$", "pin");
		log.info("TC_05 - Step 12 : Verify not display error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "pin"));
		log.info("TC_05 - PIN cannot have first is  space ");
		log.info("TC_05 - Step 13 : Enter first is blank space");
		addNewCustomerObject.enterToInputField("  123", "pin");
		log.info("TC_05 - Step 14 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "pin"));
		log.info("TC_05 - PIN cannot  is  blank space ");
		log.info("TC_05 - Step 15 : Enter first is blank space");
		addNewCustomerObject.enterToInputField("   ", "pin");
		log.info("TC_05 - Step 16 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "pin"));

	}

	@Test
	public void TC_06_Verify_Telephone_Field() {
		log.info("TC_06 - Name cannot be empty");
		log.info("TC_06 - Step 01 : Press Tab and move the next field ");
		addNewCustomerObject.pressTabToMoveNextField("phone");
		log.info("TC_06 - Step 02 : Verify message not be blank display");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Mobile no must not be blank", "phone"));
		log.info("TC_06 - phone cannot have first is  space ");
		log.info("TC_06 - Step 03 : Enter first is blank phone");
		addNewCustomerObject.enterToInputField("  123", "phone");
		log.info("TC_06 - Step 04 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("First character can not have space", "phone"));
		log.info("TC_06 - phone cannot have space  ");
		log.info("TC_06 - Step 05 : Enter space");
		addNewCustomerObject.enterToInputField("1 12", "phone");
		log.info("TC_06 - Step 06 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Characters are not allowed", "phone"));
		log.info("TC_06 - Name cannot have special characters");
		log.info("TC_06 - Step 07 : Enter special charactor into name field");
		addNewCustomerObject.enterToInputField("098475@", "phone");
		log.info("TC_06 - Step 08 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Special characters are not allowed", "phone"));
	}

	@Test
	public void TC_07_Verify_Email_Field() {
		log.info("TC_07 - Email cannot be empty");
		log.info("TC_07 - Step 01 : Press Tab and move the next field ");
		addNewCustomerObject.pressTabToMoveNextField("email");
		log.info("TC_07 - Step 02 : Verify message not be blank display");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID must not be blank", "email"));
		log.info("TC_07 - Step 03 : Enter first is blank phone");
		addNewCustomerObject.enterToInputField("guru99@gmail", "email");
		log.info("TC_07 - Step 04 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		addNewCustomerObject.enterToInputField("guru99@gmail.", "email");
		log.info("TC_07 - Step 05 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		addNewCustomerObject.enterToInputField("guru99gmail.com", "email");
		log.info("TC_07 - Step 06 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		addNewCustomerObject.enterToInputField("guru99", "email");
		log.info("TC_07 - Step 07 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
		log.info("TC_07 - Step 08 : Enter first is blank phone");
		addNewCustomerObject.enterToInputField("gu ru99@gmail", "email");
		log.info("TC_07 - Step 09 : Verify error message");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID is not valid", "email"));
	}

	@Test
	public void TC_08_Verify_Field_Label() {
		log.info("TC_08 - Step 01 :Tab all items");
		addNewCustomerObject.pressTabToMoveNextField("name");
		addNewCustomerObject.pressTabToMoveNextField("rad1");
		addNewCustomerObject.pressTabToMoveNextField("dob");
		addNewCustomerObject.pressTabToMoveNextField("address");
		addNewCustomerObject.pressTabToMoveNextField("city");
		addNewCustomerObject.pressTabToMoveNextField("state");
		addNewCustomerObject.pressTabToMoveNextField("pin");
		addNewCustomerObject.pressTabToMoveNextField("phone");
		addNewCustomerObject.pressTabToMoveNextField("email");
		addNewCustomerObject.pressTabToMoveNextField("password");
		log.info("TC_08 - Step 02 :Verify require message display ");
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Customer name must not be blank", "name"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Date Field must not be blank", "dob"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Address Field must not be blank", "address"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("City Field must not be blank", "city"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("State must not be blank", "state"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("PIN Code must not be blank", "pin"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Mobile no must not be blank", "phone"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Email-ID must not be blank", "email"));
		verifyTrue(addNewCustomerObject.isDisplayErrorMessage("Password must not be blank", "password"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

}
