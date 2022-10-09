package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_03_Apply_BasePage_03 extends BasePage{
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email = "abc123" + generate_Random() + "@gmail.com";
	 

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		 clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		sendKeyToElement(driver, "//input[@id='Email']", "123");
		clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Valid_Inform() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc@12345");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@12345");
		clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-register']");

	}

	@Test
	public void TC_04_Existed_Email() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc@12345");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@12345");
		clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");


	}

	@Test
	public void TC_05_Password_Less_Than_6_Charactor() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc");
		getWebElement(driver, "//button[contains(@class,'register-next-step-button')]").click();
		Assert.assertEquals(getWebElement(driver, "//span[@id='Password-error']").getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Passconfirm() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc@12345");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@125");
		getWebElement(driver, "//button[contains(@class,'register-next-step-button')]").click();
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

		//Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generate_Random() {
		Random random = new Random();
		return random.nextInt();
	}

}
