package com.mannautomation.test;
import org.testng.annotations.Test;

import com.mannautomation.uicomponents.LoginPageFunctionality;
public class LoginTest extends LoginPageFunctionality {

	@Test(enabled = false)
	public void loginWithEmailAndPassword() {
		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";

		navigateToLoginPage();
		loginWithEmailAndPassword(usernameOfCustomer,passwordOfCustomer);

	}
}
