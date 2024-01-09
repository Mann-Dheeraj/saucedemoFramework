package com.mannautomation.uicomponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mannautomation.utility.Utility;

public class LoginPageFunctionality {
	WebDriver driver;
	
	private String emailIdTEXTFIELD = "user-name";
	private String passwordIdTEXTFIELD = "password";
	private String loginBUTTON = "login-button";

	public void navigateToLoginPage(WebDriver driver) throws IOException {
		driver.manage().window().maximize();
		
		String navigateToUrl = Utility.fetchPropertyValue("applicationURL").toString();
		
		driver.get(navigateToUrl);
	}

	public void loginWithEmailAndPassword(WebDriver driver,String username, String password) {
		driver.findElement(By.id(emailIdTEXTFIELD)).sendKeys(username);
		driver.findElement(By.id(passwordIdTEXTFIELD)).sendKeys(password);
		driver.findElement(By.id(loginBUTTON)).click();
	}
	
	public boolean AssertLoginPageUrl(String loginPageUrl, WebDriver driver) {
		boolean flag = false;
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equalsIgnoreCase(loginPageUrl)) {
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
}
