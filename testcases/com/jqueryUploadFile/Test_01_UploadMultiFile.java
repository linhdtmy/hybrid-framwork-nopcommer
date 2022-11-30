package com.jqueryUploadFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.jqueryUploadFile.HomePageJqueryUploadObject;

public class Test_01_UploadMultiFile extends BaseTest {

	private WebDriver driver;
	HomePageJqueryUploadObject homePageObject;
	private String cat = "cat.jpg";
	private String image = "images (1).png";
	private String lucky = "lucky.png";
	private String[] listImage = { cat, image, lucky };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePageObject = GenerateObject.getHomePageJqueryUploadObject(driver);

	}

	@Test
	public void TC_01_Upload_One_File() {
		homePageObject.uploadMultipleFiles(driver, cat);
		Assert.assertTrue(homePageObject.isDisplayFileNameUpload(cat));
		homePageObject.clickButtonStart();
		Assert.assertTrue(homePageObject.isDisplayFileNameUploadLink(cat));
		Assert.assertTrue(homePageObject.isLoadFileSuccess(driver,cat));
	}

	@Test
	public void TC_02_Upload_Multi_Files() {
		homePageObject.refreshToPage(driver);
		homePageObject.uploadMultipleFiles(driver, listImage);
		for (String fileName : listImage) {
			Assert.assertTrue(homePageObject.isDisplayFileNameUpload(fileName));
		}

		homePageObject.clickButtonStart();
		for (String fileName : listImage) {
			Assert.assertTrue(homePageObject.isDisplayFileNameUploadLink(fileName));
			Assert.assertTrue(homePageObject.isLoadFileSuccess(driver,fileName));
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
