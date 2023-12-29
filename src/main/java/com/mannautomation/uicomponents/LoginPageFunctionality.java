package com.mannautomation.uicomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mannautomation.base.BaseTest;

public class LoginPageFunctionality {
	WebDriver driver;
	private String emailIdTEXTFIELD = "user-name";
	private String passwordIdTEXTFIELD = "password";
	private String loginBUTTON = "login-button";

	public void navigateToLoginPage(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	public void loginWithEmailAndPassword(WebDriver driver,String username, String password) {
		driver.findElement(By.id(emailIdTEXTFIELD)).sendKeys(username);
		driver.findElement(By.id(passwordIdTEXTFIELD)).sendKeys(password);
		driver.findElement(By.id(loginBUTTON)).click();
	}
}
