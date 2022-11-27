package com.nopcommerce.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;
import pageObject.user.nopcommerce.SearchUserPageObject;

public class Test_04_Search_Advance_Search extends BaseTest {

	private WebDriver driver;
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	private RegisterPageUserObject registerPageObject;
	private SearchUserPageObject searchPageObject;
	private String firstName = "Linh";
	private String lastName = "Linh";
	private String email = "Linh" + generate_Random() + "@gmail.com";
	private String password = "123456";
	private String passwordConfirm = "123456";
	private String keywordText = "Macbook123";
	private String keywordRelative = "Lenovo";
	private String keywordAbsolute = "Thinkpad X1 Carbon Laptop";



	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageObject = GenerateObject.getHomePage(driver);
		/*
		 * Precondition 1. Register an account 2. Login to account 3. Open search page in footer
		 */
		registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToPasswordConfirmTextbox(passwordConfirm);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		homePageObject = registerPageObject.clickToLogoutButton();
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(email);
		loginPageObject.inputToPasswordTextbox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		searchPageObject = homePageObject.clickToSearchLink();
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getMessageWarning(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Not_Exist_Data() {
		searchPageObject.inputToSearchKeywordTextbox(keywordText);
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getNoProductMatchMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_With_Product_Name_Relative() {
		searchPageObject.inputToSearchKeywordTextbox(keywordRelative);
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getProduct().size(), 2);
		Assert.assertEquals(searchPageObject.getProduct().get(0).getText(), "Lenovo IdeaCentre 600 All-in-One PC");
		Assert.assertEquals(searchPageObject.getProduct().get(1).getText(), "Lenovo Thinkpad X1 Carbon Laptop");

	}

	@Test
	public void TC_04_Search_With_Product_Name_Tuyet_Doi() {
		searchPageObject.inputToSearchKeywordTextbox(keywordAbsolute);
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getProduct().size(), 1);
		Assert.assertEquals(searchPageObject.getProduct().get(0).getText(), "Lenovo Thinkpad X1 Carbon Laptop");

	}

	@Test
	public void TC_05_Search_With_Parent_Categoty() {
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook");
		searchPageObject.checkToAdvanceSearchCheckbox();
		searchPageObject.selectCategory("Computers");
		searchPageObject.uncheckToAutoSearchCategory();
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getNoProductMatchMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void TC_06_Search_With_SubCategory() {
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook");
		searchPageObject.checkToAdvanceSearchCheckbox();
		searchPageObject.selectCategory("Computers");
		searchPageObject.checkedToAutoSearchCategory();
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getProduct().size(), 1);
		Assert.assertEquals(searchPageObject.getProduct().get(0).getText(), "Apple MacBook Pro 13-inch");

	}

	@Test
	public void TC_07_Search_With_Incorrect_Manuafacturer() {
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook");
		searchPageObject.checkToAdvanceSearchCheckbox();
		searchPageObject.selectCategory("Computers");
		searchPageObject.checkedToAutoSearchCategory();
		searchPageObject.selectManufacturer("HP");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getNoProductMatchMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void TC_08_Search_With_Correct_Manuafacturer() {
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook");
		searchPageObject.checkToAdvanceSearchCheckbox();
		searchPageObject.selectCategory("Computers");
		searchPageObject.checkedToAutoSearchCategory();
		searchPageObject.selectManufacturer("Apple");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getProduct().size(), 1);
		Assert.assertEquals(searchPageObject.getProduct().get(0).getText(), "Apple MacBook Pro 13-inch");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
