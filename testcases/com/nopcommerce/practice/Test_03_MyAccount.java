package com.nopcommerce.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.AddressUserObject;
import pageObject.user.nopcommerce.ChangePasswordUserObject;
import pageObject.user.nopcommerce.CustomerInformUserObject;
import pageObject.user.nopcommerce.DetailProductObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.ReviewCustomerObject;
import pageObject.user.nopcommerce.ReviewProductObject;

public class Test_03_MyAccount extends BaseTest {

	private WebDriver driver;
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	private CustomerInformUserObject customerObject;
	private AddressUserObject addressObject;
	private ChangePasswordUserObject changePasswordObject;
	private DetailProductObject detailProductObject;
	private ReviewProductObject reviewProductObject;
	private ReviewCustomerObject reviewCustomerObject;
	
	String inValidEmail = "jsfjdf";
	String emailNotRegister = "linh@gmail.com";
	String emailRegistetedEmail = "linh@gmail.com";
	String firstName = "Linh111";
	String lastName = "Linh111";
	String email = "a123@gmail.com";
	String password = "12345678";
	String companyName = "ABC";
	String country = "United States";
	String province = "California";
	String city = "XXx";
	String address1 = "address1";
	String zipcode = "123";
	String phone = "12343545";
	String faxNumber = "13243";
	String oldPassword = "1234567890";
	String newPassword = "1234567809";
	String confirmPassword = "1234567809";
	String title ="title";
	String content="it so good";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageObject = GenerateObject.getHomePage(driver);

	}

	@Test
	public void TC_01_CustomerInfor() {
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(emailRegistetedEmail);
		loginPageObject.inputToPasswordTextbox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		customerObject = homePageObject.clickToMyAccount();
		customerObject.checkToGenderRadio();
		customerObject.inputToFirstNameTextBox(firstName);
		customerObject.inputToLastNameTextBox(lastName);
		customerObject.inputToDateOfBirth();
		customerObject.inputToEmail(email);
		customerObject.inputToCompanyName(companyName);
		customerObject = customerObject.clickToSaveButton();
		Assert.assertTrue(customerObject.isCheckedFemaleGender());
		Assert.assertEquals(customerObject.getTextFromFirstName(), firstName);
		Assert.assertEquals(customerObject.getTextFromLastName(), lastName);
		Assert.assertEquals(customerObject.getTextFromEmail(), email);
		Assert.assertEquals(customerObject.getTextFromCompanyName(), companyName);
		Assert.assertEquals(customerObject.getTextFromDay(), "1");
		Assert.assertEquals(customerObject.getTextFromMonth(), "January");
		Assert.assertEquals(customerObject.getTextFromYear(), "1999");

	}

	@Test
	public void TC_02_Address() {
		addressObject = customerObject.getAddressObject(driver);
		addressObject.clickToAddNewButton();
		addressObject.inputToFirstName(firstName);
		addressObject.inputToLastName(lastName);
		addressObject.inputToEmail(email);
		addressObject.inputToCompany(companyName);
		addressObject.selectCountry(country);
		addressObject.selectProvince(province);
		addressObject.inputToCity(city);
		addressObject.inputToAddress1(address1);
		addressObject.inputToZipCode(zipcode);
		addressObject.inputToPhone(phone);
		addressObject.inputToFaxNumber(faxNumber);
		addressObject.clickToSaveButton();
		Assert.assertEquals(addressObject.getTitle(), "My account - Addresses");

	}

	@Test
	public void TC_03_Change_Password() {
		changePasswordObject = addressObject.getPasswordObject(driver);
		changePasswordObject.inputToOldPassword(oldPassword);
		changePasswordObject.inputToNewPassword(newPassword);
		changePasswordObject.inputToConfirmPassword(confirmPassword);
		changePasswordObject.clickChangePasswordButton();
		Assert.assertEquals(changePasswordObject.getMessageChangeSuccess(), "Password was changed");
		changePasswordObject.clickToCloseIcon();
		homePageObject = changePasswordObject.clickLogoutButton();
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(email);
		loginPageObject.inputToPasswordTextbox(oldPassword);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsucessfullLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		loginPageObject.inputToPasswordTextbox(newPassword);
		homePageObject = loginPageObject.clickToLoginButton();
		Assert.assertTrue(homePageObject.isDisplayMyAccount());

	}

	@Test
	public void TC_04_Product_Review() {
		detailProductObject = homePageObject.clickToDetailLink();
		reviewProductObject=detailProductObject.clickToAddReviewLink();
		reviewProductObject.inputToTitleReview(title);
		reviewProductObject.inputToContentReview(content);
		reviewProductObject.clickToRating();
		reviewProductObject.clickButtonSaveReview();
		customerObject = reviewProductObject.clickToMyAccount();
		reviewCustomerObject= customerObject.getReviewCustomerPage(driver);
		
		Assert.assertEquals(reviewCustomerObject.getReviewMyAccountLabel(), "Apple MacBook Pro 13-inch");
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
