package com.tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
	
	
	

	public WebDriver driver;
	public ChromeOptions options;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@Test
	public void verifyRegisterWithMandatoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Momin");;
		driver.findElement(By.id("input-lastname")).sendKeys("Malik");
		driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("3018799695");
		driver.findElement(By.id("input-password")).sendKeys("herpderp69");
		driver.findElement(By.id("input-confirm")).sendKeys("herpderp69");
		driver.findElement(By.xpath("//input[@name = 'agree' ]")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'Congratulations! Your new account has been successfully created!']")).isDisplayed());
	}
	
	@Test
	public void verifyRegisterWithAllFields() {
		driver.findElement(By.id("input-firstname")).sendKeys("Momin");;
		driver.findElement(By.id("input-lastname")).sendKeys("Malik");
		driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("3018799695");
		driver.findElement(By.id("input-password")).sendKeys("herpderp69");
		driver.findElement(By.id("input-confirm")).sendKeys("herpderp69");
		driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@name = 'newsletter' and @value = '1']")).click();
		driver.findElement(By.xpath("//input[@name = 'agree' ]")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'Congratulations! Your new account has been successfully created!']")).isDisplayed());
		
		
			}
		
	@Test
	public void verifyRegisterWithExistingEmail() {
		driver.findElement(By.id("input-firstname")).sendKeys("Momin");;
		driver.findElement(By.id("input-lastname")).sendKeys("Malik");
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda1@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("3018799695");
		driver.findElement(By.id("input-password")).sendKeys("herpderp69");
		driver.findElement(By.id("input-confirm")).sendKeys("herpderp69");
		driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@name = 'newsletter' and @value = '1']")).click();
		driver.findElement(By.xpath("//input[@name = 'agree' ]")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		
		
		
		
		
		
	}
		
		
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

		
	}


}
