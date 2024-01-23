package com.tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	
public WebDriver driver;
	
	
	@BeforeMethod
	public void loginSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();

}
	

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		
		driver.findElement(By.cssSelector("#input-email")).sendKeys("seleniumpanda1@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		WebElement editYourAccountInfoLink = driver.findElement(By.linkText("Edit your account information"));
		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		Assert.assertTrue(editYourAccountInfoLink.isDisplayed() && logoutLink.isDisplayed());
		
		
	}
	@Test(priority = 2)
	public void verifyLoginWithInvalidCrendentials() {
		driver.findElement(By.id("input-email")).sendKeys("sssssseleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Sssssselenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		//Assert.assertEquals(actualWarningMessage, expectedWarningMessage);	
		//Assert.assertEquals(actualWarningMessage, expectedWarningMessage);// you can use either or assertions
		
		
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmail() {
		driver.findElement(By.id("input-email")).sendKeys("szcasdaeleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		//Assert.assertEquals(actualWarningMessage, expectedWarningMessage);	
		
	}
	@Test(priority = 4)
	public void verifyLoginWithInvalidPassword() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Ssselenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);	
		
		
	}
	
	@Test(priority = 5)
	public void verifyLoginWithNoCredentials() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
