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

public class Test_06_Wishlist_Compare_Recentview extends BaseTest {

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
	public void TC_01_Add_To_WishList() {
		detailProductObject = noteBookPageObject.clickToProduct();
		detailProductObject.clickToAddWishListButton();
		Assert.assertEquals(detailProductObject.getMessageAddToWishListSuccess(), "The product has been added to your wishlist");
		wishListObject = detailProductObject.clickWishListLink();
		Assert.assertTrue(wishListObject.isDisplayNameProduct());
		wishListObject.clickToShareLink();
		Assert.assertEquals(wishListObject.getTitleWishlistPage(), "Wishlist of" + " " + firstName + " " + lastName);
	}

	@Test
	public void TC_02_Add_Product_To_Cart_From_WishList() {
		wishListObject.checkToCheckbox();
		cartObject = wishListObject.clickAddToCardButton();
		Assert.assertEquals(cartObject.getQuantity("wishlist-qty"), "(2)");
		Assert.assertEquals(cartObject.getQuantity("cart-qty"), "(2)");

	}

	@Test
	public void TC_03_Remove_Product() {
		cartObject.hoverToComputerLink(driver);
		noteBookPageObject = cartObject.clickToNoteBookLink(driver);
		noteBookPageObject.clickToAddWishList();
		wishListObject = noteBookPageObject.clickToWishListIcon();
		wishListObject.clickToRemoveProduct();
		wishListObject.clickToRemoveProduct();
		Assert.assertEquals(wishListObject.getMessageEmtyProduct(), "The wishlist is empty!");
		Assert.assertTrue(wishListObject.isUnDisplayTableCart());

	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		wishListObject.hoverToComputerLink(driver);
		noteBookPageObject = wishListObject.clickToNoteBookLink(driver);
		noteBookPageObject.addProductToCompare();
		Assert.assertEquals(noteBookPageObject.getMessageAddToCompareListSuccess(), "The product has been added to your " + "product comparison");
		compareProductObject = noteBookPageObject.clickToCompareLink();
		Assert.assertEquals(compareProductObject.getQuantityRemoveButton(), 2);

		// Assert.assertTrue(compareProductObject.isProductNameDisplay());
		Assert.assertEquals(compareProductObject.getNameProduct("Apple MacBook Pro 13-inch"), "Apple MacBook Pro 13-inch");
		Assert.assertEquals(compareProductObject.getNameProduct("Asus N551JK-XO076H Laptop"), "Asus N551JK-XO076H Laptop");
		Assert.assertEquals(compareProductObject.getTextByProductName("Apple MacBook Pro 13-inch"), "$1,800.00");
		Assert.assertEquals(compareProductObject.getTextByProductName("Asus N551JK-XO076H Laptop"), "$1,500.00");
		compareProductObject.clickCleartButton();
		Assert.assertEquals(compareProductObject.getMessageNoProductToCompare(), "You have no items to compare.");
		Assert.assertTrue(compareProductObject.isUnDisplayTableCompareProduct());
	}

	@Test
	public void TC_05_Recent_View_Product() {
		compareProductObject.hoverToComputerLink(driver);
		noteBookPageObject = compareProductObject.clickToNoteBookLink(driver);
		List<WebElement> listProduct;
		for (int i = 0; i < 5; i++) {
			listProduct = noteBookPageObject.getListProductElement();
			listProduct.get(i).click();
			detailProductObject.hoverToComputerLink(driver);
			noteBookPageObject = detailProductObject.clickToNoteBookLink(driver);
		}

		recentViewProductObject = noteBookPageObject.clickToRecentViewProduct();

		Assert.assertEquals(recentViewProductObject.getSizeProduct(), 3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
