package com.jquery;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.jquery.HomePageJqueryObject;

public class Test_01_Paging extends BaseTest {

	private WebDriver driver;
	private HomePageJqueryObject homePageJqueryObject;
	 

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageJqueryObject = GenerateObject.getHomePageObject(driver);

	}

	public void TC_01_Paging() {
		homePageJqueryObject.openPageNumber("2");
		Assert.assertTrue(homePageJqueryObject.isActivePage("2"));

		homePageJqueryObject.openPageNumber("5");
		Assert.assertTrue(homePageJqueryObject.isActivePage("5"));

		homePageJqueryObject.openPageNumber("12");
		Assert.assertTrue(homePageJqueryObject.isActivePage("12"));

		homePageJqueryObject.openPageNumber("20");
		Assert.assertTrue(homePageJqueryObject.isActivePage("20"));

	}

	public void TC_02_Search_By_Label() {
		homePageJqueryObject.inputTextToCountry("Country", "Somalia");
		Assert.assertEquals(homePageJqueryObject.getTextByLabelAndTextInput("females", "338282"), "338282");
		Assert.assertEquals(homePageJqueryObject.getTextByLabelAndTextInput("country", "Somalia"), "Somalia");
		Assert.assertEquals(homePageJqueryObject.getTextByLabelAndTextInput("males", "349238"), "349238");
		Assert.assertEquals(homePageJqueryObject.getTextByLabelAndTextInput("total", "687522"), "687522");

	}

	public void TC_03_Get_All_Datalist() {
		homePageJqueryObject.refreshToPage(driver);
		// 1.Lấy ra số lượng các page
		int countPage = homePageJqueryObject.getCountPage();
		// 2. Dùng vòng lặp for lặp từng page để lấy ra từng dòng dữ liệu
		ArrayList<String> listRow = new ArrayList<>();
		for (int i = 1; i <= countPage; i++) {
			homePageJqueryObject.openPageNumber(Integer.toString(i));
			System.out.println("==========");
			for (String string : homePageJqueryObject.getRowText()) {
				listRow.add(string);
				System.out.println(string);
			}
		}

	}

	@Test
	public void TC_04_Enter_Text_To_Cell() {
		homePageJqueryObject.inputTextToCellByHeader("Album", "1", "abc");
		homePageJqueryObject.inputTextToCellByHeader("Artist", "1", "123");
		homePageJqueryObject.inputTextToCellByHeader("Year", "1", "2000");
		homePageJqueryObject.inputTextToCellByHeader("Price", "1", "20000000");
		homePageJqueryObject.selectDropdown("Origin","1","US");
		homePageJqueryObject.clickToCheckbox("With Poster?", "1" );


	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
