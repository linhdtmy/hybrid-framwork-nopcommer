package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GenerateObject;
import techpandaUI.DetailProductTechPandaUI;
import techpandaUI.HomeTechPandaUserUI;
import techpandaUI.MyAccountTechPandaUserUI;
import techpandaUI.ProductCompareTechPandaUI;

public class ProductCompareTechPandaObject extends BasePage {
	private WebDriver driver;

	public ProductCompareTechPandaObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostProduct(String productName) {
		waitForElementVisible(driver, ProductCompareTechPandaUI.PRICE, productName);
		return getElementText(driver, ProductCompareTechPandaUI.PRICE, productName);
	}

	public String getImageNameProduct(String productName) {
		waitForElementVisible(driver, ProductCompareTechPandaUI.IMG, productName);
		return getElementAttribute(driver, ProductCompareTechPandaUI.IMG, "src", productName);

	}

	public void closeThisWindowTab(WebDriver driver) {
		driver.close();
		
	}

}
