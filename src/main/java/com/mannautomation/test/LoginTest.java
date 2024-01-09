package com.mannautomation.test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;
public class LoginTest extends BaseTest {


	@Test
	public void loginWithEmailAndPassword() throws IOException {
		LoginPageFunctionality lpf = new LoginPageFunctionality();
		WebDriver driver = this.driver;
		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";

		lpf.navigateToLoginPage(driver);
		lpf.loginWithEmailAndPassword(driver,usernameOfCustomer,passwordOfCustomer);
		boolean iSUrlCorrect= lpf.AssertLoginPageUrl("https://www.saucedemo.com/", driver);
		assertEquals(iSUrlCorrect, true);
	}
	
}
