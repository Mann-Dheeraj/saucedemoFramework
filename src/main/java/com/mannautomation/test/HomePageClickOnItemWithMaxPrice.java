package com.mannautomation.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;
import com.mannautomation.uicomponents.homePage.HomePageItemsFunctionality;

public class HomePageClickOnItemWithMaxPrice extends BaseTest {
	
	LoginPageFunctionality lpf;
	HomePageItemsFunctionality hpf;
	
	@BeforeMethod
	public void setUPReference() {
		lpf = new LoginPageFunctionality(this.driver);
		hpf = new HomePageItemsFunctionality(this.driver);
	}

	@Test
	public void findItemWithMinAndMaxPrice() throws IOException {

		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";

		lpf.navigateToLoginPage();
		lpf.loginWithEmailAndPassword( usernameOfCustomer, passwordOfCustomer);
//		hpf.addItemWithMaxPriceToCart(driver);
		hpf.findMaxAndMinPriceItemWithIndex();

	}

}