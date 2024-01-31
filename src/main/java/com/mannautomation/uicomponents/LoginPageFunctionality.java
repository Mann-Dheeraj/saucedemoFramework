package com.mannautomation.uicomponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mannautomation.utility.Utility;

public class LoginPageFunctionality {
	
	WebDriver driver;
	
	public LoginPageFunctionality(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private String emailIdTEXTFIELD = "user-name";
	private String passwordIdTEXTFIELD = "password";
	private String loginBUTTON = "login-button";

	public void navigateToLoginPage() throws IOException {
		driver.manage().window().maximize();
		
		String navigateToUrl = Utility.fetchPropertyValue("applicationURL").toString();
		
		driver.get(navigateToUrl);
	}

	public void loginWithEmailAndPassword(String username, String password) {
		driver.findElement(By.id(emailIdTEXTFIELD)).sendKeys(username);
		driver.findElement(By.id(passwordIdTEXTFIELD)).sendKeys(password);
		driver.findElement(By.id(loginBUTTON)).click();
	}
	
	public boolean AssertLoginPageUrl(String loginPageUrl) {
		boolean flag = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(loginPageUrl)) {
			flag = true;
		}
		return flag;
	}
	
}
