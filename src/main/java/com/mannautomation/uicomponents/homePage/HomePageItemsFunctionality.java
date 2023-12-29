package com.mannautomation.uicomponents.homePage;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mannautomation.base.BaseTest;

public class HomePageItemsFunctionality {

	WebDriver driver;

	public void addItemWithMaxPriceToCart(WebDriver driver) {
		List<WebElement> el = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		BigDecimal max = new BigDecimal(0);

		for (WebElement e : el) {
			BigDecimal price = new BigDecimal(e.getText().replace("$", ""));
			if (price.compareTo(max) > 0)
				max = price;
		}

		System.out.println(max);
		String element = "//div[text()='" + max + "']/following-sibling::button";
		driver.findElement(By.xpath(element)).click();
	}

}
