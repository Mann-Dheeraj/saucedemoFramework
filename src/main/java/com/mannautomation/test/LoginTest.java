package com.mannautomation.test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;
public class LoginTest extends BaseTest {


	@Test(dataProvider = "emailPasswordData")
	public void loginWithEmailAndPassword(String uname, String pass) throws IOException {
		LoginPageFunctionality lpf = new LoginPageFunctionality();
		WebDriver driver = this.driver;
		String usernameOfCustomer = uname;
		String passwordOfCustomer = pass;

		lpf.navigateToLoginPage(driver);
		lpf.loginWithEmailAndPassword(driver,usernameOfCustomer,passwordOfCustomer);
		boolean iSUrlCorrect= lpf.AssertLoginPageUrl("https://www.saucedemo.com/inventory.html", driver);
		assertEquals(iSUrlCorrect, true);
	}
	
	@DataProvider (name="emailPasswordData")
	public Object[][] testDataGenerator() {
		Object [][] emailPasswordCombination = {{"standard_user", "secret_sauce"},
												{"locked_out_user", "secret_sauce"},
												{"problem_user", "secret_sauce"},
												{"performance_glitch_user", "secret_sauce"},
												{"error_user", "secret_sauce"},
												{"visual_user", "secret_sauce"}
												};
		return emailPasswordCombination;
	}
	
}
