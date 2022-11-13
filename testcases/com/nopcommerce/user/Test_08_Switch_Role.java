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
import common.GenerateObject;
import common.GlobalConstants;
import pageObject.admin.nopcommerce.DashboardPageObject;
import pageObject.admin.nopcommerce.LoginAdminPageObject;
import pageObject.user.nopcommerce.AddressUserObject;
import pageObject.user.nopcommerce.BackUserObject;
import pageObject.user.nopcommerce.ChangePasswordUserObject;
import pageObject.user.nopcommerce.CustomerInformUserObject;
import pageObject.user.nopcommerce.DownloadUserObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.OrderUserObject;
import pageObject.user.nopcommerce.ReviewProductObject;
import pageObject.user.nopcommerce.RewardUserObject;

public class Test_08_Switch_Role extends BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String validEmail = "abc123" + generate_Random() + "@gmail.com";
	private String emailNotFound = "abc123" + generate_Random() + "@gmail.com";
	private String invalidEmail = "dddd";
	private String firstName = "abc", lastName = "efgh ", password = "Test@12345";
	private String incorrectPassword = "123";
	private HomeUserPageObject homePageUserObject;
	private LoginUserPageObject loginPageUserObject;
	private CustomerInformUserObject customerInformUserObject;
	private AddressUserObject addressUserObject;
	private ChangePasswordUserObject changePasswordUserObject;
	private OrderUserObject orderUserObject;
	private ReviewProductObject reviewUserObject;
	private RewardUserObject rewardUserObject;
	private BackUserObject backUserObject;
	private DownloadUserObject downloadUserObject;
	private LoginAdminPageObject loginAdminPageObject ;
	private DashboardPageObject dashboardPageObject ;

	String emailAddress, passwWord;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);
		homePageUserObject = GenerateObject.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		emailAddress = "abc@gmail.com";
		passwWord = "123456";
	}

	@Test
	public void TC_01_RoleUser() {
		// Mở trang login
		loginPageUserObject = homePageUserObject.clickToLoginLink();
		homePageUserObject = loginPageUserObject.loginAsUser(emailAddress, passwWord);
		Assert.assertTrue(homePageUserObject.isDisplayMyAccount());
	}

	@Test
	public void TC_02_RoleAdmin() {
		String email="admin@yourstore.com";
		String password ="admin";
	    homePageUserObject.openPageUrl(driver, GlobalConstants.ADMIN_PAGE);
	    //Sau khi vào trang admin thì sẽ hiển thị màn login
	    loginAdminPageObject = GenerateObject.getLoginAdminPageObject(driver);
	    dashboardPageObject= loginAdminPageObject.loginAsAdmin(email, password);
		Assert.assertTrue(dashboardPageObject.isDisplayDashboard());
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
