package com.mannautomation.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mannautomation.base.BaseTest;
public class LoginTest extends BaseTest {
	
	@Test
	public void loginWithEmailAndPassword() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
}
