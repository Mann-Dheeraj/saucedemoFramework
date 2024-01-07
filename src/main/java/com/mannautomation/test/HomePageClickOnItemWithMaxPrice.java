package com.mannautomation.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;
import com.mannautomation.uicomponents.homePage.HomePageItemsFunctionality;

public class HomePageClickOnItemWithMaxPrice extends BaseTest {

	@Test
	public void findItemWithMaxPrice() throws IOException {
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
