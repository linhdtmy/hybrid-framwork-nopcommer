package common;

import org.openqa.selenium.WebDriver;

import pageObject.admin.nopcommerce.DashboardPageObject;
import pageObject.admin.nopcommerce.LoginAdminPageObject;
import pageObject.jquery.HomePageJqueryObject;
import pageObject.jqueryUploadFile.HomePageJqueryUploadObject;
import pageObject.techpanda.HomePageTechpandaAdminObject;
import pageObject.techpanda.HomePageTechpandaUserObject;
import pageObject.techpanda.LoginTechPandaAdminObject;
import pageObject.techpanda.RegisterTechPandaUserObject;
import pageObject.user.nopcommerce.AddressUserObject;
import pageObject.user.nopcommerce.BackUserObject;
import pageObject.user.nopcommerce.CartObject;
import pageObject.user.nopcommerce.ChangePasswordUserObject;
import pageObject.user.nopcommerce.CompareProductObject;
import pageObject.user.nopcommerce.CustomerInformUserObject;
import pageObject.user.nopcommerce.DetailProductObject;
import pageObject.user.nopcommerce.DownloadUserObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.NoteBookPageObject;
import pageObject.user.nopcommerce.OrderUserObject;
import pageObject.user.nopcommerce.RecentViewProductObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;
import pageObject.user.nopcommerce.ReviewCustomerObject;
import pageObject.user.nopcommerce.ReviewProductObject;
import pageObject.user.nopcommerce.RewardUserObject;
import pageObject.user.nopcommerce.SearchUserPageObject;
import pageObject.user.nopcommerce.WishListObject;
import pageObject.wordpress.admin.AddEditPostAdminObject;
import pageObject.wordpress.admin.DashboardAdminObject;
import pageObject.wordpress.admin.ListPostAdminObject;
import pageObject.wordpress.admin.LoginAdminObject;
import pageObject.wordpress.user.HomePageUserObject;

public class GenerateObject {
	public static HomeUserPageObject getHomePage(WebDriver driver) {
		return new HomeUserPageObject(driver);
	}

	public static LoginUserPageObject getLoginPage(WebDriver driver) {
		return new LoginUserPageObject(driver);
	}

	public static RegisterPageUserObject getRegisterPage(WebDriver driver) {
		return new RegisterPageUserObject(driver);
	}

	public static CustomerInformUserObject getMyAccountPage(WebDriver driver) {
		return new CustomerInformUserObject(driver);
	}

	public static WishListObject getWishListObject(WebDriver driver) {
		return new WishListObject(driver);
	}

	public static AddressUserObject getAddressPage(WebDriver driver) {
		return new AddressUserObject(driver);
	}

	public static OrderUserObject getOrderPage(WebDriver driver) {
		return new OrderUserObject(driver);
	}

	public static CartObject getCartObject(WebDriver driver) {
		return new CartObject(driver);
	}

	public static CompareProductObject getCompareProductObject(WebDriver driver) {
		return new CompareProductObject(driver);
	}

	public static RecentViewProductObject getRecentViewProductObject(WebDriver driver) {
		return new RecentViewProductObject(driver);
	}

	public static ChangePasswordUserObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordUserObject(driver);
	}

	public static ReviewProductObject getReviewPage(WebDriver driver) {
		return new ReviewProductObject(driver);
	}

	public static ReviewCustomerObject getReviewCustomerPage(WebDriver driver) {
		return new ReviewCustomerObject(driver);
	}

	public static DetailProductObject getDetailPage(WebDriver driver) {
		return new DetailProductObject(driver);
	}

	public static ReviewCustomerObject getCustomerObject(WebDriver driver) {
		return new ReviewCustomerObject(driver);
	}

	public static RewardUserObject getRewardPage(WebDriver driver) {
		return new RewardUserObject(driver);
	}

	public static BackUserObject getBackPage(WebDriver driver) {
		return new BackUserObject(driver);
	}

	public static DownloadUserObject getDownloadPage(WebDriver driver) {
		return new DownloadUserObject(driver);
	}

	public static LoginAdminPageObject getLoginAdminPageObject(WebDriver driver) {
		return new LoginAdminPageObject(driver);
	}

	public static SearchUserPageObject getSearchUserPageObject(WebDriver driver) {
		return new SearchUserPageObject(driver);
	}

	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}

	public static NoteBookPageObject getNoteBookPageObject(WebDriver driver) {
		return new NoteBookPageObject(driver);
	}

	public static HomePageJqueryObject getHomePageObject(WebDriver driver) {
		return new HomePageJqueryObject(driver);
	}

	public static LoginTechPandaAdminObject getLoginTechPandaObject(WebDriver driver) {
		return new LoginTechPandaAdminObject(driver);
	}

	public static HomePageTechpandaAdminObject getHomePageTechpandaObject(WebDriver driver) {
		return new HomePageTechpandaAdminObject(driver);
	}

	public static HomePageJqueryUploadObject getHomePageJqueryUploadObject(WebDriver driver) {
		return new HomePageJqueryUploadObject(driver);
	}

	public static HomePageTechpandaUserObject getHomePageTechpandaUserObject(WebDriver driver) {
		return new HomePageTechpandaUserObject(driver);
	}

	public static HomePageUserObject getHomePageUserObject(WebDriver driver) {
		return new HomePageUserObject(driver);
	}

	public static RegisterTechPandaUserObject getRegisterTechPandaUserObject(WebDriver driver) {
		return new RegisterTechPandaUserObject(driver);
	}

	public static AddEditPostAdminObject getAddNewPostAdminObject(WebDriver driver) {
		return new AddEditPostAdminObject(driver);
	}

	public static DashboardAdminObject getDashboardAdminObject(WebDriver driver) {
		return new DashboardAdminObject(driver);
	}

	public static LoginAdminObject getLoginAdminObject(WebDriver driver) {
		return new LoginAdminObject(driver);
	}

	public static ListPostAdminObject getListPostAdminObject(WebDriver driver) {
		return new ListPostAdminObject(driver);
	}
}
