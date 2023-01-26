package com.nopcommerce.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.CartObject;
import pageObject.user.nopcommerce.CompareProductObject;
import pageObject.user.nopcommerce.DetailProductObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.NoteBookPageObject;
import pageObject.user.nopcommerce.RecentViewProductObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;
import pageObject.user.nopcommerce.WishListObject;

public class Test_07_Order extends BaseTest {

	private WebDriver driver;
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	private NoteBookPageObject noteBookPageObject;
	private RegisterPageUserObject registerObject;
	private DetailProductObject detailProductObject;
	private WishListObject wishListObject;
	private CartObject cartObject;
	private CompareProductObject compareProductObject;
	private RecentViewProductObject recentViewProductObject;
	private String firstName = "linh";
	private String lastName = "linh", email = generate_Random_Number() + "linh@gmail.com", password = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageObject = GenerateObject.getHomePage(driver);
		registerObject = homePageObject.clickToRegisterLink();
		registerObject.inputToFirstNameTextbox(firstName);
		registerObject.inputToLastNameTextbox(lastName);
		registerObject.inputToEmailTextbox(email);
		registerObject.inputToPasswordTextbox(password);
		registerObject.inputToPasswordConfirmTextbox(password);
		registerObject.clickToRegisterButton();
		Assert.assertEquals(registerObject.getRegisterSuccessMessage(), "Your registration completed");
		loginPageObject = registerObject.clickLoginButton();
		loginPageObject.inputToEmailTextbox(email);
		loginPageObject.inputToPasswordTextbox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		homePageObject.hoverToComputerLink(driver);
		noteBookPageObject = homePageObject.clickToNoteBookLink(driver);
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
	}

	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {

	}

	@Test
	public void TC_03_Remove_From_Cart() {

	}

	@Test
	public void TC_04_Update_Shopping_Cart() {
	}

	@Test
	public void TC_05_Checkout_Order() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
