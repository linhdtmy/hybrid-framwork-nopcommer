package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MyAccountTechPandaUserUI;

public class MyAccountTechpandaUserObject extends BasePage {
	private WebDriver driver;

	public MyAccountTechpandaUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPTag(String email) {
		waitForElementVisible(driver, MyAccountTechPandaUserUI.CONTACT_INFORMATION, email);
		return getElementText(driver, MyAccountTechPandaUserUI.CONTACT_INFORMATION, email);

	}

	public boolean isTrueContactInformation(String email, String firstName, String lastName) {
		waitForElementVisible(driver, MyAccountTechPandaUserUI.CONTACT_INFORMATION, email);
		String contactInfor = getElementText(driver, MyAccountTechPandaUserUI.CONTACT_INFORMATION, email);
		String lines[] = contactInfor.split("\\r?\\n");
		System.out.println(lines[0]);
		System.out.println(lines[1]);
		if (lines[0].equals(firstName + " " + lastName) && lines[1].equals(email))
			return true;
		else
			return false;

	}

	public HomePageTechpandaUserObject clickLogoutLink() {
		waitForElementClickable(driver, MyAccountTechPandaUserUI.ACCOUNT_OPTION_LINK, "Log Out");
		clickToElement(driver, MyAccountTechPandaUserUI.ACCOUNT_OPTION_LINK, "Log Out");
		return GenerateObject.getHomePageTechpandaUserObject(driver);
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, MyAccountTechPandaUserUI.ACCOUNT_LINK);
		clickToElement(driver, MyAccountTechPandaUserUI.ACCOUNT_LINK);

	}

	public boolean isDisplayMyDashboard() {
		waitForElementVisible(driver, MyAccountTechPandaUserUI.MY_DASHBOARD_LABEL);
		return isElementDisplay(driver, MyAccountTechPandaUserUI.MY_DASHBOARD_LABEL);
	}

	public boolean isDisplayHello(String fullname) {
		String hello = "Hello, " + fullname + "!";
		waitForElementVisible(driver, MyAccountTechPandaUserUI.HELLO, hello);
		return isElementDisplay(driver, MyAccountTechPandaUserUI.HELLO, hello);
	}

	public MobileTechPandaObject clickToMobileLink() {
		waitForElementVisible(driver, MyAccountTechPandaUserUI.MOBILE_LINK);
		clickToElement(driver, MyAccountTechPandaUserUI.MOBILE_LINK);
		return GenerateObject.getMobileTechPandaObject(driver);
	}

}
