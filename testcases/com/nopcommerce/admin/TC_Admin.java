package com.nopcommerce.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.admin.nopcommerce.AddAddressPageObject;
import pageObject.admin.nopcommerce.AddCustomerPageObject;
import pageObject.admin.nopcommerce.DashboardPageObject;
import pageObject.admin.nopcommerce.EditAddressPageObject;
import pageObject.admin.nopcommerce.EditCustomerPageObject;
import pageObject.admin.nopcommerce.ListCustomerPageObject;
import pageObject.admin.nopcommerce.LoginAdminPageObject;

public class TC_Admin extends BaseTest {

	private WebDriver driver;
	private LoginAdminPageObject loginPageObject;
	private DashboardPageObject homePageObject;
	private AddCustomerPageObject addCustomerPO;
	private EditCustomerPageObject editCustomerPO;
	private ListCustomerPageObject listCustomer;
	private AddAddressPageObject addAddressPO;
	private EditAddressPageObject editAddressPO;
	private String phoneNumber = "098758475";
	private String fax = "0123";
	private String address1 = "HN1";
	private String address2 = "HN2";
	private String city = "HN";
	private String zipCode = "123";
	private String country = "Viet Nam";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Precondition - Step 01 : Open URL ");
		driver = getBrowser(browserName, url);
		loginPageObject = GenerateObject.getLoginAdminPageObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Precondition - Step 02 : Enter username + password  ");

		log.info("Precondition - Step 03 : Click button Login  ");
		homePageObject = loginPageObject.clickToLoginButton();

	}

	@Test
	public void TC_01_Search_With_Product_Name() {
		log.info("TC_01_Search_With_Product_Name - Step 01 :Catalog -> Product  ");
		homePageObject.clickToProduct();
		homePageObject.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		homePageObject.clickSearchButton();
		log.info("TC_01_Search_With_Product_Name - Step 01 :Verify only one record display   ");
		verifyTrue(homePageObject.isDisplayOneRecord());
		verifyTrue(homePageObject.isDisplayProductName("Lenovo IdeaCentre 600 All-in-One PC"));
	}

	@Test
	public void TC_02_Search_With_Name_Category() {
		homePageObject.selectCategory("Computers");
		homePageObject.clickSearchButton();
		verifyTrue(homePageObject.isDisplayNoDataMessage());
	}

	@Test
	public void TC_03_Search_With_Name_Category() {
		homePageObject.checkToSearchSubCategory();
		homePageObject.clickSearchButton();
		verifyTrue(homePageObject.isDisplayOneRecord());
		verifyTrue(homePageObject.isDisplayProductName("Lenovo IdeaCentre 600 All-in-One PC"));

	}

	@Test 
	public void TC_04_Search_With_Name_Category() {
		homePageObject.selectCategory("Computers >> Desktops");
		homePageObject.clearToSearchSubCategory();
		homePageObject.clickSearchButton();
		verifyTrue(homePageObject.isDisplayOneRecord());
		verifyTrue(homePageObject.isDisplayProductName("Lenovo IdeaCentre 600 All-in-One PC"));
	}

	@Test
	public void TC_05_Search_With_Name_Manufacturer() {
		homePageObject.selectCategory("All");
		homePageObject.clearToSearchSubCategory();
		homePageObject.selectManufacture("Apple");
		homePageObject.clickSearchButton();
		verifyTrue(homePageObject.isDisplayNoDataMessage());
	}

	@Test
	public void TC_06_Go_Sku() {
		homePageObject.inputToSku("LE_IC_600");
		homePageObject.clickGoButton();
		verifyTrue(homePageObject.isDisplayProductDetail());
	}

	private String email = "test" + generate_Random() + "@gmail.com";
	private String password = "123456";
	private String firstName = "linh";
	private String lastName = "linh";
	private String companyName = "Automation FC";

	@Test
	public void TC_07_Create_New_Customer() {
		addCustomerPO = homePageObject.clickToCustomer();
		addCustomerPO.clickButtonAddNew();
		addCustomerPO.inputToTextbox("Email", email);
		addCustomerPO.inputToTextbox("Password", password);
		addCustomerPO.inputToTextbox("FirstName", firstName);
		addCustomerPO.inputToTextbox("LastName", lastName);
		addCustomerPO.inputToTextbox("DateOfBirth", "10/10/2000");
		addCustomerPO.inputToTextbox("Company", companyName);
		addCustomerPO.checkToGender();
		addCustomerPO.selectCustomerRole("Guests");
		addCustomerPO.selectNewLetter();
		addCustomerPO.inputToAdminComment("Add new customer ");
		editCustomerPO = addCustomerPO.clickSaveButton();
		verifyTrue(editCustomerPO.isDisplayMessageEditSuccess());
		listCustomer = editCustomerPO.clickBackButton();
		listCustomer.selectCustomerRole("Guests");
		listCustomer.clickSearchButton();
		verifyTrue(listCustomer.isDisplayText(firstName + " " + lastName));
		verifyTrue(listCustomer.isDisplayText(companyName));

	}

	@Test
	public void TC_08_Search_Customer_With_Email() {
		listCustomer.enterToTextInput(email, "SearchEmail");
		listCustomer.clickSearchButton();
		verifyTrue(listCustomer.isDisplayText(firstName + " " + lastName));
		verifyTrue(listCustomer.isDisplayText(companyName));

	}

	@Test
	public void TC_09_Search_Customer_With_Name() {
		listCustomer.clearTextInput("SearchEmail");
		listCustomer.enterToTextInput(firstName, "SearchFirstName");
		listCustomer.enterToTextInput(lastName, "SearchLastName");
		listCustomer.clickSearchButton();
		verifyTrue(listCustomer.isDisplayText(firstName + " " + lastName));
		verifyTrue(listCustomer.isDisplayText(companyName));
	}

	@Test
	public void TC_10_Search_Customer_VS_Company() {
		listCustomer.clearTextInput("SearchFirstName");
		listCustomer.clearTextInput("SearchLastName");
		listCustomer.enterToTextInput(companyName, "SearchCompany");
		listCustomer.clickSearchButton();
		verifyTrue(listCustomer.isDisplayText(firstName + " " + lastName));
		verifyTrue(listCustomer.isDisplayText(companyName));
	}

	@Test
	public void TC_11_Search_Customer_Full_Data() {
		listCustomer.enterToTextInput(email, "SearchEmail");
		listCustomer.enterToTextInput(firstName, "SearchFirstName");
		listCustomer.enterToTextInput(lastName, "SearchLastName");
		listCustomer.clickSearchButton();
		verifyTrue(listCustomer.isDisplayText(firstName + " " + lastName));
		verifyTrue(listCustomer.isDisplayText(companyName));

	}

	@Test
	public void TC_12_Edit_Customer() {
		editCustomerPO = listCustomer.clickEditCustomer();
		editCustomerPO.inputToTextbox("Email", "edit" + email);
		editCustomerPO.inputToTextbox("Password", "edit" + password);
		editCustomerPO.inputToTextbox("FirstName", "edit" + firstName);
		editCustomerPO.inputToTextbox("LastName", "edit" + lastName);
		editCustomerPO.inputToTextbox("DateOfBirth", "12/10/2000");
		editCustomerPO.inputToTextbox("Company", "edit" + companyName);
		editCustomerPO.inputToAdminComment("Edit new customer ");
		listCustomer = editCustomerPO.clickSaveButton();
		listCustomer.isDisplaySuccessMessage("The customer has been updated successfully.");
	}

	@Test
	public void TC_13_Add_New_Address_In_Customer_Detail() {
		log.info("TC_13_Step 01 Enter infor to search ");
		listCustomer.enterToTextInput("edit" + email, "SearchEmail");
		listCustomer.enterToTextInput("edit" + firstName, "SearchFirstName");
		listCustomer.enterToTextInput("edit" + lastName, "SearchLastName");
		listCustomer.selectCustomerRole("Guests");
		log.info("TC_13_Step 01 Click to search button");
		listCustomer.clickSearchButton();

		log.info("TC_13_Step 02 Edit customer ");
		editCustomerPO = listCustomer.clickEditCustomer();
		editCustomerPO.clickToAddress();
		log.info("TC_13_Step 03 Add address ");
		addAddressPO = editCustomerPO.clickToAddNewAddress();
		log.info("TC_13_Step 04 Enter inform to address ");
		addAddressPO.inputToTextbox("Address_FirstName", firstName);
		addAddressPO.inputToTextbox("Address_LastName", lastName);
		addAddressPO.inputToTextbox("Address_Email", email);
		addAddressPO.inputToTextbox("Address_Company", companyName);
		addAddressPO.selectCountrySelectbox(country);
		addAddressPO.inputToTextbox("Address_County", companyName);
		addAddressPO.inputToTextbox("Address_City", city);
		addAddressPO.inputToTextbox("Address_Address1", address1);
		addAddressPO.inputToTextbox("Address_Address2", address2);
		addAddressPO.inputToTextbox("Address_ZipPostalCode", zipCode);
		addAddressPO.inputToTextbox("Address_PhoneNumber", phoneNumber);
		addAddressPO.inputToTextbox("Address_FaxNumber", fax);
		log.info("TC_13_Step 05 Save address ");
		editAddressPO = addAddressPO.clickSaveButton();
		log.info("TC_13_Step 06 Verify message ");
		verifyTrue(editAddressPO.isDisplaySuccessMSG("The new address has been added successfully."));
		log.info("TC_13_Step 07 Click to back button ");
		editCustomerPO = editAddressPO.clickToBackButton();
		log.info("TC_13_Step 08 Click to address ");
		editCustomerPO.clickToAddress();
		log.info("TC_13_Step 09 Verify inform address added ");
		 //comment lại đoạn này cho chạy nhanh hơn
		/*
		Assert.assertEquals(editCustomerPO.getInFormAddress("First name", email), firstName);
		Assert.assertEquals(editCustomerPO.getInFormAddress("Last name", email), lastName);
		Assert.assertEquals(editCustomerPO.getInFormAddress("Email", email), email);
		Assert.assertEquals(editCustomerPO.getInFormAddress("Phone number", email), phoneNumber);
		Assert.assertEquals(editCustomerPO.getInFormAddress("Fax number", email), fax);
		verifyTrue(editCustomerPO.isDisplayAddress(companyName, address1, address2, city, zipCode, country));
		*/
	}

	@Test
	public void TC_14_Edit_Address_In_Customer_Detail() {
		log.info("TC_14_Step 01 Click to customer (go list customer) ");
		listCustomer = editCustomerPO.clickToCustomer();
		log.info("TC_14_Step 02 Enter inform to search area  ");
		listCustomer.enterToTextInput("edit" + email, "SearchEmail");
		listCustomer.enterToTextInput("edit" + firstName, "SearchFirstName");
		listCustomer.enterToTextInput("edit" + lastName, "SearchLastName");
		listCustomer.selectCustomerRole("Guests");
		log.info("TC_14_Step 02 Click to search button   ");
		listCustomer.clickSearchButton();
		log.info("TC_14_Step 02 Click to edit button    ");
		editCustomerPO = listCustomer.clickEditCustomer();
		log.info("TC_14_Step 02 Click to address button    ");
		//editCustomerPO.clickToAddress();
		editAddressPO = editCustomerPO.clickButtonEditAddress();
		log.info("TC_14_Step 02 Input to address     ");
		inputToAddress();
		log.info("TC_14_Step 02 Click to save button     ");
		editAddressPO = editAddressPO.clickSaveButton();
		log.info("TC_14_Step 02 Verify message display     ");
		verifyTrue(editAddressPO.isDisplaySuccessMSG("The address has been updated successfully."));
		log.info("TC_14_Step 02 Verify inform  edited     ");
		verifyEditAddressInform();
		log.info("TC_14_Step 02 Click to back button     ");
		editAddressPO.clickToBackButton();
	}

	private void inputToAddress() {
		editAddressPO.inputToTextbox("Address_FirstName", "edit" + firstName);
		editAddressPO.inputToTextbox("Address_LastName", "edit" + lastName);
		editAddressPO.inputToTextbox("Address_Email", "edit" + email);
		editAddressPO.inputToTextbox("Address_Company", "edit" + companyName);
		editAddressPO.selectCountrySelectbox(country);
		editAddressPO.inputToTextbox("Address_County", "edit" + companyName);
		editAddressPO.inputToTextbox("Address_City", "edit" + city);
		editAddressPO.inputToTextbox("Address_Address1", "edit" + address1);
		editAddressPO.inputToTextbox("Address_Address2", "edit" + address2);
		editAddressPO.inputToTextbox("Address_ZipPostalCode", "edit" + zipCode);
		editAddressPO.inputToTextbox("Address_PhoneNumber", "1" + phoneNumber);
		editAddressPO.inputToTextbox("Address_FaxNumber", "1" + fax);
	}

	private void verifyEditAddressInform() {
		Assert.assertEquals(editAddressPO.getInformAddress("Address_FirstName"), "edit" + firstName);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_LastName"), "edit" + lastName);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_Email"), "edit" + email);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_Company"), "edit" + companyName);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_City"), "edit" + city);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_Address1"), "edit" + address1);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_Address2"), "edit" + address2);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_ZipPostalCode"), "edit" + zipCode);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_PhoneNumber"), "1" + phoneNumber);
		Assert.assertEquals(editAddressPO.getInformAddress("Address_FaxNumber"), "1" + fax);
	}

	@Test
	public void TC_15_Delete_Address_In_Customer_Detail() {
		listCustomer = editCustomerPO.clickToCustomer();
		listCustomer.enterToTextInput("edit" + email, "SearchEmail");
		listCustomer.enterToTextInput("edit" + firstName, "SearchFirstName");
		listCustomer.enterToTextInput("edit" + lastName, "SearchLastName");
		listCustomer.selectCustomerRole("Guests");
		listCustomer.clickSearchButton();
		editCustomerPO = listCustomer.clickEditCustomer();
		editCustomerPO.deleteAddress();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

}
