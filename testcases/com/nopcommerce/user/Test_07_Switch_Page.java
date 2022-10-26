package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.AddressUserObject;
import pageObject.user.nopcommerce.BackUserObject;
import pageObject.user.nopcommerce.ChangePasswordUserObject;
import pageObject.user.nopcommerce.CustomerInformUserObject;
import pageObject.user.nopcommerce.DownloadUserObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.OrderUserObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;
import pageObject.user.nopcommerce.ReviewUserObject;
import pageObject.user.nopcommerce.RewardUserObject;

public class Test_07_Switch_Page  extends BaseTest{

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String validEmail = "abc123" + generate_Random() + "@gmail.com";
	private String emailNotFound = "abc123" + generate_Random() + "@gmail.com";
	private String invalidEmail = "dddd";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private String incorrectPassword = "123";
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	private CustomerInformUserObject customerInformObject;
	private AddressUserObject addressObject;
	private ChangePasswordUserObject changePasswordObject;
	private OrderUserObject orderObject;
	private ReviewUserObject reviewObject;
	private RewardUserObject rewardObject;
	private BackUserObject backObject;
	private DownloadUserObject downloadObject;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);
		homePageObject = GenerateObject.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Register() {
		RegisterPageUserObject registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(validEmail);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToPasswordConfirmTextbox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		registerPageObject.clickToLogoutButton();

	}

	@Test
	public void TC_02_Login_Success() {
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(validEmail);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();
		homePageObject = GenerateObject.getHomePage(driver);
		Assert.assertTrue(homePageObject.isDisplayMyAccount());
	}

	@Test
	public void TC_03_Customer_Infor() {
		customerInformObject = new CustomerInformUserObject(driver);

		customerInformObject = homePageObject.clickToMyAccount();

		Assert.assertTrue(customerInformObject.isMyAccountIsDisplay());

	}

	@Test
	public void TC_04_Switch_Page() {
		// Customer inform => order
		orderObject = customerInformObject.getOrderPage(driver);
		// order =>address
		addressObject = orderObject.getAddressObject(driver);
		// address =>Change password
		changePasswordObject = addressObject.getPasswordObject(driver);
		// change password =>address
		addressObject = changePasswordObject.getAddressObject(driver);
		// address =>reward
		rewardObject = addressObject.getRewardPage(driver);
		//reward =>review
		reviewObject = rewardObject.getReviewPage(driver);
		//review=>back
		backObject = reviewObject.getBackPage(driver);
		// back =>dowwnload
		downloadObject = backObject.getDownloadPage(driver);
	}

	@Test
	public void TC_05_Switch_Role() {

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
