package com.mannautomation.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.mannautomation.uicomponents.homePage.*;
import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;

public class HomePageClickOnItemWithMaxPrice extends BaseTest {

	@Test
	public void findItemWithMaxPrice() {
		WebDriver driver = this.driver;

		LoginPageFunctionality lpf = new LoginPageFunctionality();
		HomePageItemsFunctionality hpf = new HomePageItemsFunctionality();

		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";

		lpf.navigateToLoginPage(driver);
		lpf.loginWithEmailAndPassword(driver, usernameOfCustomer, passwordOfCustomer);
		hpf.addItemWithMaxPriceToCart(driver);

	}

}
