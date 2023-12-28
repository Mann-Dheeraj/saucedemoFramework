package com.mannautomation.test;
import org.testng.annotations.Test;
import com.mannautomation.uicomponents.*;
public class LoginTest extends LoginPageFunctionality {
	
	@Test
	public void loginWithEmailAndPassword() {
		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";
		
		navigateToLoginPage();
		loginWithEmailAndPassword(usernameOfCustomer,passwordOfCustomer);
		
	}
}
