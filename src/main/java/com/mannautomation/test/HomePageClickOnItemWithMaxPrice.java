package com.mannautomation.test;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mannautomation.uicomponents.LoginPageFunctionality;

public class HomePageClickOnItemWithMaxPrice extends LoginPageFunctionality{

	@Test
	public void findItemWithMaxPrice() {
		String usernameOfCustomer = "standard_user";
		String passwordOfCustomer = "secret_sauce";

		navigateToLoginPage();
		loginWithEmailAndPassword(usernameOfCustomer,passwordOfCustomer);


		List<WebElement> el = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		BigDecimal max = new BigDecimal(0);

		for(WebElement e: el) {
			BigDecimal price = new BigDecimal(e.getText().replace("$",""));
			if(price.compareTo(max)> 0)
				max = price;
		}
		
		System.out.println(max);
		String element = "//div[text()='"+max.floatValue()+"']/following-sibling::button";
		driver.findElement(By.xpath(element)).click();

	}

}
