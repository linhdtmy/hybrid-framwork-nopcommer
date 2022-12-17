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
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;

public class Test_08_Switch_Role extends BaseTest {

	private WebDriver driver;
	private HomeUserPageObject homePageUserObject;
	private LoginUserPageObject loginPageUserObject;

	private LoginAdminPageObject loginAdminPageObject;
	private DashboardPageObject dashboardPageObject;

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
		String email = "admin@yourstore.com";
		String password = "admin";
		homePageUserObject.openPageUrl(driver, GlobalConstants.ADMIN_PAGE);
		// Sau khi vào trang admin thì sẽ hiển thị màn login
		loginAdminPageObject = GenerateObject.getLoginAdminPageObject(driver);
		dashboardPageObject = loginAdminPageObject.loginAsAdmin(email, password);
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
