package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.DetailTechPandaUI;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MyAccountTechPandaUserUI;

public class DetailProductTechPandaObject extends BasePage {
	private WebDriver driver;

	public DetailProductTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostProduct() {
		waitForElementVisible(driver, DetailTechPandaUI.PRICE);
		return getElementText(driver, DetailTechPandaUI.PRICE);
	}

}
