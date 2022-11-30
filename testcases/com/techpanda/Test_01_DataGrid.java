package com.techpanda;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.techpanda.HomePageTechpandaAdminObject;
import pageObject.techpanda.HomePageTechpandaUserObject;
import pageObject.techpanda.LoginTechPandaAdminObject;
import pageObject.techpanda.LoginTechPandaUserObject;

public class Test_01_DataGrid extends BaseTest {

	private WebDriver driver;
	LoginTechPandaAdminObject loginPageAdmin;
	HomePageTechpandaAdminObject homePageAdmin;
	LoginTechPandaUserObject loginPageUser;
	HomePageTechpandaUserObject homePageUser;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		loginPage = GenerateObject.getLoginTechPandaObject(driver);
//		homePage=loginPage.loginToPage("user01", "guru99com");
//		homePage.closePopup();
		 
	}

	@Test
	public void TC_01_Register_User() {

	}
	@Test
	public void TC_02_Login_To_Admin() {

	}
	@Test
	public void TC_03_Search_User_Register() {

	}
	@Test
	public void TC_04_Delete_User_Register() {

	}
	@Test
	public void TC_05_Login_User_Deleted() {

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
