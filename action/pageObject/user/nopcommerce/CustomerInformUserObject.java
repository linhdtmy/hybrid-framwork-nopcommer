package pageObject.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import userPageUI.CustomerUI;
import userPageUI.OrderUI;

public class CustomerInformUserObject extends BasePage {

	private WebDriver driver;

	public CustomerInformUserObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountIsDisplay() {
		return isElementDisplay(driver, CustomerUI.MY_ACCOUNT);
		// TODO Auto-generated method stub
		
	}

	

	
}
