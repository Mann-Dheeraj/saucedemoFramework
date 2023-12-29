package com.mannautomation.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;
public class LoginTest extends BaseTest {
	

	@Test(enabled = false)
	public void loginWithEmailAndPassword() {
		LoginPageFunctionality lpf = new LoginPageFunctionality();
		WebDriver driver = this.driver;
		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";

		lpf.navigateToLoginPage(driver);
		lpf.loginWithEmailAndPassword(driver,usernameOfCustomer,passwordOfCustomer);

	}
}
