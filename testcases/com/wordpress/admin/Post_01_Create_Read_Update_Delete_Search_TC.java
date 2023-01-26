package com.wordpress.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GenerateObject;
import pageObject.wordpress.admin.AddEditPostAdminObject;
import pageObject.wordpress.admin.DashboardAdminObject;
import pageObject.wordpress.admin.ListPostAdminObject;
import pageObject.wordpress.admin.LoginAdminObject;
import pageObject.wordpress.user.HomePageUserObject;

public class Post_01_Create_Read_Update_Delete_Search_TC extends BaseTest {
	private WebDriver driver;
	private String userName = "automationtest";
	private String password = "123456";
	private String postTitle = "Title" + generate_Random();
	private String postTitleEdit = "TitleEdit" + generate_Random();
	private String postContent = "Content " + generate_Random();
	private String postContentEdit = "ContentEdit " + generate_Random();
	private LoginAdminObject loginObject;
	private AddEditPostAdminObject addEditPostObject;
	private DashboardAdminObject dashboardAdminObject;
	private ListPostAdminObject listPostAdminObject;
	private HomePageUserObject homePageUserObject;
	private String urlAdmin, urlUser;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		log.info("Pre-condition - Step 01 :Openbrowser and admin URL ");
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = getBrowser(browserName, urlAdmin);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();
		loginObject = GenerateObject.getLoginAdminObject(driver);
		log.info("Pre-condition - Step 02 :Enter to username" + userName);
		loginObject.enterToUserName(userName);
		log.info("Pre-condition - Step 03 :Enter to password " + password);
		loginObject.enterToPassword(password);
		log.info("Pre-condition - Step 04 : Click button Login");
		dashboardAdminObject = loginObject.clickButtonLogin();
	}

	@Test
	public void TC_01_Create_New_Post() {
		log.info("TC_01 - Step 01 : Click to Post ");
		listPostAdminObject = dashboardAdminObject.clickToPost();
		log.info("TC_01 - Step 02 : Click Add new ");
		addEditPostObject = listPostAdminObject.clickAddNewButton();
		log.info("TC_01 - Step 03 : Enter title post " + postTitle);
		addEditPostObject.enterPostTitle(postTitle);
		log.info("TC_01 - Step 04 : Enter content post ");
		addEditPostObject.enterPostContent(postContent);
		log.info("TC_01 - Step 05 : Click Button Publish  ");
		addEditPostObject.clickButtonPubLish();

		log.info("TC_01 - Step 06 : Verify message post published  ");
		Assert.assertTrue(addEditPostObject.isDisableMessagePublishSuccess());

	}

	@Test
	public void TC_02_Search() {
		log.info("TC_02_Search - Step 01 : Open page  ");
		listPostAdminObject = addEditPostObject.clickToPostHeader();
		log.info("TC_02_Search - Step 02 : Enter to search textbox  ");
		listPostAdminObject.enterToSearchTextbox(postTitle);
		log.info("TC_02_Search - Step 03 : Click to search button ");
		listPostAdminObject.clickToSearchButton();
		log.info("TC_02_Search - Step 04 : Verify search table  ");
		Assert.assertEquals(listPostAdminObject.getTextByHeader("title"), postTitle);
		Assert.assertEquals(listPostAdminObject.getTextByHeader("author"), userName);
		log.info("TC_02_Search - Step 05 : Open user site ");
		listPostAdminObject.openPageUrl(driver, urlUser);
		homePageUserObject = GenerateObject.getHomePageUserObject(driver);
		log.info("TC_02_Search - Step 06 : Click to search icon   ");
		homePageUserObject.clickToSearchIcon();
		log.info("TC_02_Search - Step 07 : Send key to search textbox   ");
		homePageUserObject.sendKeyToSearchTextbox(postTitle);
		log.info("TC_02_Search - Step 08 : Enter    ");
		homePageUserObject.enterKeyboard();
		log.info("TC_02_Search - Step 09 : Verify post title display at home page  ");
		Assert.assertEquals(homePageUserObject.getPostTitle(), postTitle);
		Assert.assertEquals(homePageUserObject.getPostContent(), postContent);
		Assert.assertEquals(homePageUserObject.getPostDate(), getCurrentDate());

	}

	@Test
	public void TC_03_Edit() {
		log.info("TC_03_Edit - Step 01 : Open admin page ");
		dashboardAdminObject = homePageUserObject.openAdminPage(driver, urlAdmin);
		
		log.info("TC_03_Edit - Step 02 : Click to post item");
		listPostAdminObject = dashboardAdminObject.clickToPost();
		
		log.info("TC_03_Edit - Step 03 : Click to Edit link ");
		addEditPostObject = listPostAdminObject.clickToEditLink(postTitle);
		
		log.info("TC_03_Edit - Step 04 : Edit title +content ");
		addEditPostObject.enterPostContent(postContentEdit);
		addEditPostObject.enterPostTitle(postTitleEdit);
		
		log.info("TC_03_Edit - Step 05 : Click update button ");
		addEditPostObject.clickUpdateButton();
		
		log.info("TC_03_Edit - Step 06 : Verify post update message display ");
		verifyTrue(addEditPostObject.isDisplayUpdateSuccessMessage());

		log.info("TC_03_Edit - Step 07 : Open list post");
		listPostAdminObject = addEditPostObject.clickToPostHeader();
		
		log.info("TC_03_Edit - Step 08 : Verify post update title + content in admin page  ");
		verifyTrue(listPostAdminObject.isDisplayPostTitle(postTitleEdit));
		verifyTrue(listPostAdminObject.isDisplayAuthor(postTitleEdit));
		
		log.info("TC_03_Edit - Step 09 : Verify post update title + content in user page ");
		listPostAdminObject.openPageUrl(driver, urlUser);
		homePageUserObject = GenerateObject.getHomePageUserObject(driver);
		verifyTrue(homePageUserObject.isDisplayPostTitle(postTitleEdit));
		verifyTrue(homePageUserObject.isDisplayPostContent(postTitleEdit));
	}

	@Test
	public void TC_04_Delete() {
		log.info("TC_04_Delete - Step 01 : Open admin Page  + click to post item ");
		homePageUserObject.openAdminPage(driver, urlAdmin);
		dashboardAdminObject = GenerateObject.getDashboardAdminObject(driver);
		listPostAdminObject= dashboardAdminObject.clickToPost();
		
		log.info("TC_04_Delete - Step 02 : Check to checkbox by title  ");
		listPostAdminObject.checkToCheckBox(postTitleEdit);
		
		log.info("TC_04_Delete - Step 03 : Click pulldown + select option Move to trash   ");
		listPostAdminObject.selectDeleteOption();
		
		log.info("TC_04_Delete - Step 04 : Click button Apply   ");
		listPostAdminObject.clickButtonApply();
		
		log.info("TC_04_Delete - Step 05 : Verify messsage move to trash   ");
		verifyTrue(listPostAdminObject.isDisplayMoveToTrashMessage());
		
		log.info("TC_04_Delete - Step 06 : Enter to search textbox +Click button search    ");
		listPostAdminObject.enterToSearchTextbox(postTitleEdit);
		listPostAdminObject.clickToSearchButton();
		log.info("TC_04_Delete - Step 07 : Verify post  undisplay    ");
		verifyTrue(listPostAdminObject.isDisplayNoRecordMessage());

	}

	private String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		return formatter.format(date);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}
}
