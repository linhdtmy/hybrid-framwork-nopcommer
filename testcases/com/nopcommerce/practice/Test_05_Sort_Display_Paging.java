package com.nopcommerce.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.NoteBookPageObject;

public class Test_05_Sort_Display_Paging extends BaseTest {

	private WebDriver driver;
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	private NoteBookPageObject noteBookPageObject;
	private String sortBy;
	private String page;
	private String iconName;
	private String pageNumber;
	private int quantityProduct;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageObject = GenerateObject.getHomePage(driver);
		homePageObject.hoverToComputerLink(driver);
		noteBookPageObject = homePageObject.clickToNoteBookLink(driver,"Apple MacBook Pro 13-inch");

	}

	public void TC_01_Sort_Name_A_To_Z() {
		sortBy = "Name: A to Z";
		noteBookPageObject.selectSortBy(sortBy);
		ArrayList<String> listSearch = noteBookPageObject.getListProductTitle();
		ArrayList<String> listSorted = noteBookPageObject.getListProductTitle();
		Collections.sort(listSorted);
		Assert.assertTrue(listSorted.equals(listSearch));
	}

	public void TC_02_Sort_Name_Z_To_A() {
		sortBy = "Name: Z to A";
		noteBookPageObject.selectSortBy(sortBy);
		ArrayList<String> listSearch = noteBookPageObject.getListProductTitle();
		ArrayList<String> listSorted = noteBookPageObject.getListProductTitle();
		Collections.reverse(listSorted);
		Assert.assertTrue(listSorted.equals(listSearch));

	}

	public void TC_03_Sort_Price_Low_To_High() {
		sortBy = "Price: Low to High";
		noteBookPageObject = noteBookPageObject.selectSortBy(sortBy);
		ArrayList<String> listSearch = noteBookPageObject.getListProductPrice();
		ArrayList<String> listSorted = new ArrayList<>(listSearch);
		Collections.sort(listSorted);
		Assert.assertTrue(listSorted.equals(listSearch));
	}

	public void TC_04_Sort_Price_High_To_Low() {
		sortBy = "Price: High to Low";
		noteBookPageObject.selectSortBy(sortBy);
		ArrayList<String> listSearch = noteBookPageObject.getListProductPrice();
		ArrayList<String> listSorted = new ArrayList<>(listSearch);
		Collections.sort(listSorted);
		Collections.reverse(listSorted);
		Assert.assertTrue(listSorted.equals(listSearch));
	}

	@Test
	public void TC_05_Display_3_product_In_OnePage() {
		page = "3";
		iconName = "next";
		noteBookPageObject.selectDisplayOnePage(page);
		quantityProduct = noteBookPageObject.getListProductTitle().size();
		Assert.assertTrue(quantityProduct <= Integer.parseInt(page));
		Assert.assertTrue(noteBookPageObject.isExistIcon(iconName));
		noteBookPageObject.selectPage(2);
		iconName = "previous";
		Assert.assertTrue(noteBookPageObject.isExistIcon(iconName));

	}

	@Test
	public void TC_06_Display_6_product_In_OnePage() {
		page = "6";
		noteBookPageObject.selectDisplayOnePage(page);
		Assert.assertTrue(quantityProduct <= Integer.parseInt(page));
		Assert.assertTrue(noteBookPageObject.isUnDisplayPaging());
	}

	@Test
	public void TC_07_Display_9_product_In_OnePage() {
		page = "9";
		noteBookPageObject.selectDisplayOnePage(page);
		Assert.assertTrue(quantityProduct <= Integer.parseInt(page));
		Assert.assertTrue(noteBookPageObject.isUnDisplayPaging());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
