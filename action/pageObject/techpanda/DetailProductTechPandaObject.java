package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.DetailProductTechPandaUI;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MyAccountTechPandaUserUI;
import techpandaUI.ReviewProductTechPandaUI;

public class DetailProductTechPandaObject extends BasePage {
	private WebDriver driver;

	public DetailProductTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostProduct() {
		waitForElementVisible(driver, DetailProductTechPandaUI.PRICE);
		return getElementText(driver, DetailProductTechPandaUI.PRICE);
	}

	public ReviewProductTechPandaObject clickToAddToReviewLink() {
		waitForElementClickable(driver, DetailProductTechPandaUI.ADD_TO_REVIEW);
		clickToElement(driver, DetailProductTechPandaUI.ADD_TO_REVIEW);
		return GenerateObject.getReviewProductTechPandaObject(driver);
	}

}
