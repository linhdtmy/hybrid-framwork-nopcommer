package com.techpanda;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.techpanda.DetailProductTechPandaObject;
import pageObject.techpanda.HomePageTechpandaUserObject;
import pageObject.techpanda.MobileTechPandaObject;
import pageObject.techpanda.MyAccountTechpandaUserObject;
import pageObject.techpanda.RegisterTechPandaUserObject;
import pageObject.techpanda.ShoppingCartTechPandaObject;

public class Test_02_Front_End extends BaseTest {

	private WebDriver driver;
	private RegisterTechPandaUserObject registerPageUser;
	private HomePageTechpandaUserObject homePageUser;
	private MyAccountTechpandaUserObject myAccountUser;
	private MobileTechPandaObject mobileObject;
	private DetailProductTechPandaObject detailProduct;
	private ShoppingCartTechPandaObject shoppingCart;
	private int id = generate_Random();
	private String firstName = "linh linh " + id;
	private String lastName = "linh" + id;
	private String email = "linh" + id + "@gmail.com";
	private String password = "123456";
	private String passwordConfirm = "123456";
	private String productName = "Sony Xperia";
	private String couponCode = "Guru50";
	private String addCartSuccessMessage = productName + " was added to your shopping cart.";
	private String discountPrice = "-$5.00";
	private String grandTotal = "$100.00";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Register_User() {

		homePageUser = new HomePageTechpandaUserObject(driver);
		homePageUser.clickToAccountLink();
		registerPageUser = homePageUser.clickToRegisterLink();
		Input_Register_User(firstName, lastName, email, password, passwordConfirm);
		homePageUser = registerPageUser.clickToRegisterButton();
		Assert.assertEquals(homePageUser.getMessageValidateSuccess(), "Thank you for registering with Main Website Store.");

	}

	@Test
	public void TC_02_Verify_Information_Register() {
		homePageUser.clickToAccountLink();
		myAccountUser = homePageUser.clickToMyAccountOption();
		verifyTrue(myAccountUser.isTrueContactInformation(email, firstName, lastName));
	}

	@Test
	public void TC_03_Login_Success_To_System() {
		myAccountUser.clickToAccountLink();
		homePageUser = myAccountUser.clickLogoutLink();
		homePageUser.clickToAccountLink();
		homePageUser.clickLoginLink();
		homePageUser.inputToEmail(email);
		homePageUser.inputToPassword(password);
		homePageUser.clickToLoginButton();
		verifyTrue(myAccountUser.isDisplayMyDashboard());
		verifyTrue(myAccountUser.isDisplayHello(firstName + " " + lastName));

	}

	@Test
	public void TC_04_Verify_Cost() {
		mobileObject = myAccountUser.clickToMobileLink();
		String costList = mobileObject.getCostByProductName(productName);
		detailProduct = mobileObject.clickToProductName(productName);
		String costDetail = detailProduct.getCostProduct();
		verifyEquals(costList, costDetail);
	}

	@Parameters({ "url" })
	@Test
	public void TC_05_Verify_Discount(String url) {
		homePageUser.openUrl(driver, url);
		mobileObject = homePageUser.clickToMobileLink();
		shoppingCart = mobileObject.clickAddToCartByProductName(productName);
		verifyTrue(shoppingCart.isDisplayMessageAddCartSuccess(addCartSuccessMessage));
		shoppingCart.enterCouponCode(couponCode);
		shoppingCart.clickToApplyButton();
		verifyTrue(shoppingCart.isDiscountPriceTrue(discountPrice));
		verifyTrue(shoppingCart.isGrandTotalTrue(grandTotal));

	}

	@Test
	public void TC_06_Verify_Can_Not_Add_More500Product() {

	}

	@Test
	public void TC_07_Verify_Can_Compare_2_Product() {

	}

	@Test
	public void TC_08_Verify_Share_Wishlist_By_Email() {

	}

	@Test
	public void TC_09_Verify_Can_Add_Review() {

	}

	@Test
	public void TC_10_Verify_User_Can_Purchase_Order() {

	}

	@Test
	public void TC_11_Verify_Search_Functional() {

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
