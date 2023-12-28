package com.mannautomation.uicomponents;

import org.openqa.selenium.By;

import com.mannautomation.base.BaseTest;

public class LoginPageFunctionality extends BaseTest{
	private String emailIdTEXTFIELD = "user-name";
	private String passwordIdTEXTFIELD = "password";
	private String loginBUTTON = "login-button";
	
	public void navigateToLoginPage() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void loginWithEmailAndPassword(String username, String password) {
		driver.findElement(By.id(emailIdTEXTFIELD)).sendKeys(username);
		driver.findElement(By.id(passwordIdTEXTFIELD)).sendKeys(password);
		driver.findElement(By.id(loginBUTTON)).click();
	}
}
