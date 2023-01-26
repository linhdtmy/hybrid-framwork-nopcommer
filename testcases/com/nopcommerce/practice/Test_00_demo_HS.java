package com.nopcommerce.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.GenerateObject;
import pageObject.user.nopcommerce.HomeUserPageObject;
import pageObject.user.nopcommerce.LoginUserPageObject;
import pageObject.user.nopcommerce.RegisterPageUserObject;

public class Test_00_demo_HS extends BaseTest {

	private WebDriver driver;
	private HomeUserPageObject homePageObject;
	private LoginUserPageObject loginPageObject;
	String inValidEmail = "jsfjdf";
	String emailNotRegister = "linh@gmail.com";
	String emailRegistetedEmail = "abc@gmail.com";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser("chrome", "http://humansolutions.com.vn/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("linhboure@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Btbk@12345");
		driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'CV')]/parent::p/parent::a/parent::li")).click();
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),'Thêm CV')]")).click();
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//label[text()='Vị trí']//following-sibling::div")).click();
		 List<WebElement> e= driver.findElements(By.xpath("//label[text()='Vị trí']//following-sibling::div//div[contains(@id,'react-select')]//div[contains(@id,'react-select')]"));
		for (WebElement webElement : e) {
			System.out.println(webElement.getText());
		}
		System.out.println("123");

	}

	@Test
	public void TC_02_Invalid_Email() {

	}

	@Test
	public void TC_03_Login_With_Email_Not_Register() {

	}

	@Test
	public void TC_04_Login_With_Email_Register_No_Password() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
