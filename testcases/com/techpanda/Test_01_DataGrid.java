package com.techpanda;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.techpanda.HomePageTechpandaAdminObject;
import pageObject.techpanda.HomePageTechpandaUserObject;
import pageObject.techpanda.LoginTechPandaAdminObject;
import pageObject.techpanda.RegisterTechPandaUserObject;

public class Test_01_DataGrid extends BaseTest {

	private WebDriver driver;
	LoginTechPandaAdminObject loginPageAdmin;
	HomePageTechpandaAdminObject homePageAdmin;
	RegisterTechPandaUserObject registerPageUser;
	HomePageTechpandaUserObject homePageUser;
	private int id = generate_Random();
	private String firstName = "linh" + id;
	private String lastName = "linh" + id;
	private String email = "linh" + id + "@gmail.com";
	private String password = "123456";
	private String passwordConfirm = "123456";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Register_User() {

		homePageUser = GenerateObject.getHomePageTechpandaUserObject(driver);
		homePageUser.clickToAccountLink();
		registerPageUser = homePageUser.clickToRegisterLink();
		Input_Register_User(firstName, lastName, email, password, passwordConfirm);
		homePageUser = registerPageUser.clickToRegisterButton();
		Assert.assertEquals(homePageUser.getMessageValidateSuccess(), "Thank you for registering with Main Website Store.");

	}

	@Test
	public void TC_02_Switch_Login_To_Admin() {
		String admin_Page = "http://live.techpanda.org/index.php/backendlogin/customer/";
		homePageUser.openPageUrl(driver, admin_Page);
		loginPageAdmin = GenerateObject.getLoginTechPandaObject(driver);
		homePageAdmin = loginPageAdmin.loginToPage("user01", "guru99com");
		homePageAdmin.closePopup();
	}

	@Test
	public void TC_03_Search_User_Register() {
		homePageAdmin = GenerateObject.getHomePageTechpandaObject(driver);
		homePageAdmin.inputToEmailSearchInput(email);
		homePageAdmin.clickButtonSearch();
		Assert.assertEquals(homePageAdmin.getTextByHeader("Name"), firstName + " " + lastName);
		Assert.assertEquals(homePageAdmin.getTextByHeader("Email"), email);

	}

	@Test
	public void TC_04_Delete_User_Register() {
		homePageAdmin.clickToCheckbox();
		homePageAdmin.selectDeleteOption();
		homePageAdmin.clickButtonSubmit();
		homePageAdmin.clickAcceptAlert();
		Assert.assertEquals(homePageAdmin.getMessageNoRecord(), "No records found.");
	}

	@Test
	public void TC_05_Login_User_Deleted() {
		String userPage = "http://live.techpanda.org/index.php";
		homePageAdmin.openPageUrl(driver, userPage);
		homePageUser = GenerateObject.getHomePageTechpandaUserObject(driver);
		homePageUser.clickToAccountLink();
		homePageUser.clickToLoginLink();
		homePageUser.inputToEmail(email);
		homePageUser.inputToPassword(password);
		homePageUser.clickToLoginButton();
		Assert.assertEquals(homePageUser.getInValidLoginMessage(), "Invalid login or password.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private void Input_Register_User(String firstName, String lastName, String email, String password, String passwordConfirm) {
		registerPageUser.inputToFirstName(firstName);
		registerPageUser.inputToLastName(lastName);
		registerPageUser.inputToEmail(email);
		registerPageUser.inputToPassword(password);
		registerPageUser.inputToPasswordConfirm(passwordConfirm);

	}

}
