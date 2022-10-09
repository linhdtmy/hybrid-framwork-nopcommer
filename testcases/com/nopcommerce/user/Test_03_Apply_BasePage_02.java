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

public class Test_03_Apply_BasePage_02 {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email = "abc123" + generate_Random() + "@gmail.com";
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = BasePage.getBasePageObject();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", "123");
		basePage.clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Valid_Inform() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc@12345");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@12345");
		basePage.clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

	}

	@Test
	public void TC_04_Existed_Email() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc@12345");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@12345");
		basePage.clickToElement(driver, "//button[contains(@class,'register-next-step-button')]");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");


	}

	@Test
	public void TC_05_Password_Less_Than_6_Charactor() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc");
		basePage.getWebElement(driver, "//button[contains(@class,'register-next-step-button')]").click();
		Assert.assertEquals(basePage.getWebElement(driver, "//span[@id='Password-error']").getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Passconfirm() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "First");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Last");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc@12345");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@125");
		basePage.getWebElement(driver, "//button[contains(@class,'register-next-step-button')]").click();
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

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
