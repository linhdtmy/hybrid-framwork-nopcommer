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
import pageObject.techpanda.ProductCompareTechPandaObject;
import pageObject.techpanda.RegisterTechPandaUserObject;
import pageObject.techpanda.ReviewProductTechPandaObject;
import pageObject.techpanda.ShoppingCartTechPandaObject;
import pageObject.techpanda.TVTechPandaObject;
import pageObject.techpanda.WishListTechPandaObject;

public class Test_02_Front_End extends BaseTest {

	private WebDriver driver;
	private RegisterTechPandaUserObject registerPageUser;
	private HomePageTechpandaUserObject homePageUser;
	private MyAccountTechpandaUserObject myAccountUser;
	private MobileTechPandaObject mobileObject;
	private DetailProductTechPandaObject detailProduct;
	private ShoppingCartTechPandaObject shoppingCart;
	private TVTechPandaObject tvObject;
	private WishListTechPandaObject wishListObject;
	private ReviewProductTechPandaObject reviewProductObject;
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
	String numberProduct = "501";
	private String productName1 = "Sony Xperia";
	private String productName2 = "IPhone";
	String addToCompareSuccessMsg = "The product IPhone has been added to comparison list.";
	private ProductCompareTechPandaObject compareObject;

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

	@Parameters({ "url" })
	@Test
	public void TC_06_Verify_Can_Not_Add_More500Product(String url) {
		homePageUser.openUrl(driver, url);
		mobileObject = homePageUser.clickToMobileLink();
		shoppingCart = mobileObject.clickAddToCartByProductName(productName);
		shoppingCart.inputToQty(numberProduct);
		shoppingCart.clickToUpdateButton();
		verifyTrue(shoppingCart.isDisplayErrorQtyMSG("Some of the products cannot be ordered in requested quantity."));
		verifyTrue(shoppingCart.isDisplayMaxMessage("* The maximum quantity allowed for purchase is 500."));

	}

	@Parameters({ "url" })
	@Test
	public void TC_07_Verify_Can_Compare_2_Product(String url) {
		homePageUser.openUrl(driver, url);
		mobileObject = homePageUser.clickToMobileLink();
		mobileObject.clickAddToCompareByName(productName1);
		verifyEquals(mobileObject.getAddToCompareSuccessMsg(productName1), "The product " + productName1 + " has been added to comparison list.");
		mobileObject.clickAddToCompareByName(productName2);
		verifyEquals(mobileObject.getAddToCompareSuccessMsg(productName1), "The product " + productName2 + " has been added to comparison list.");
		mobileObject.clickToCompareBtn();
		String cost1 = mobileObject.getCostByProductName(productName1);
		String cost2 = mobileObject.getCostByProductName(productName2);
		mobileObject.switchToTabWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		compareObject = new ProductCompareTechPandaObject(driver);
		verifyTrue(compareProductInNewWindow(productName1, cost1));
		verifyTrue(compareProductInNewWindow(productName2, cost2));
		compareObject.closeThisWindowTab(driver);
		compareObject.switchToTabWindowByTitle(driver, "Mobile");

	}

	private boolean compareProductInNewWindow(String productName, String productCost) {
		if (productCost.equals(compareObject.getCostProduct(productName))) {
			return true;
		} else
			return false;

	}

	private String productName3 = "LG LCD";
	private String message = "LG LCD";

	@Parameters({ "url" })
	@Test
	public void TC_08_Verify_Share_Wishlist_By_Email(String url) {
		homePageUser.openUrl(driver, url);
		tvObject = homePageUser.clickToTVLink();
		wishListObject = tvObject.clickToAddWishListByName(productName3);
		wishListObject.clickToSaveAndShareWishListButton();
		wishListObject.inputToEmail(email);
		wishListObject.inputToMessage(message);
		wishListObject.clickToShareWishListButton();
		verifyTrue(wishListObject.verifySuccessMsgDisplay());

	}

	private String yourThought = "thought";
	private String yourReview = "review";
	private String yourNickname = "nickname";

	@Parameters({ "url" })
	@Test
	public void TC_09_Verify_Can_Add_Review(String url) {
		homePageUser.openUrl(driver, url);
		tvObject = homePageUser.clickToTVLink();
		detailProduct = tvObject.clickToProductName();
		reviewProductObject = detailProduct.clickToAddToReviewLink();
		reviewProductObject.clickToQuality();
		reviewProductObject.inputToYourThought(yourThought);
		reviewProductObject.inputToYourReview(yourReview);
		reviewProductObject.inputToYourNickname(yourNickname);
		reviewProductObject.clickToSubmitButton();
		verifyTrue(reviewProductObject.isDisplayReviewSuccessMsg());
	}

	private String zipCode = "123";

	@Parameters({ "url" })
	@Test
	public void TC_10_Verify_User_Can_Purchase_Order(String url) {
		homePageUser.openUrl(driver, url);
		homePageUser.clickToAccountLink();
		wishListObject = homePageUser.clickToMyWishlishLink();
		shoppingCart = wishListObject.clickToAddToCart();
		shoppingCart.selectCountry();
		shoppingCart.inputToZipCode(zipCode);
		shoppingCart.clickToEstimateButton();
		// Chuưa tìm thấy action tieestp theo nên chưa viết tiếp
	}

	@Parameters({ "url" })
	@Test
	public void TC_11_Verify_Search_Functional(String url) {
		homePageUser.openUrl(driver, url);
		homePageUser.clickToAdvanceSearch();
		homePageUser.inputToFromPrice("1");
		homePageUser.inputToToPrice("150");
		homePageUser.clickToSearchButton();
		homePageUser.noteTheProductInfor();
		homePageUser.clickModifySearch();
		homePageUser.inputToFromPrice("151");
		homePageUser.inputToToPrice("1000");
		homePageUser.clickToSearchButton();
		homePageUser.noteTheProductInfor();
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
