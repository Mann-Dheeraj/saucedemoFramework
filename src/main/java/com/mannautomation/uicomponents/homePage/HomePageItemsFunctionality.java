package com.mannautomation.uicomponents.homePage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageItemsFunctionality {

	WebDriver driver;

	public HomePageItemsFunctionality(WebDriver driver) {
		this.driver = driver;
	}

	public void findMinAndMaxPriceBySorting() {
		List<WebElement> itemsPriceElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		List<Float> price = itemsPriceElements.stream().map(p -> Float.parseFloat(p.getText().replace("$", "")))
		.sorted().collect(Collectors.toList());
		
		Float maximumPriceItem = price.get(price.size()-1);
		String maximumPriceItemXpath = "//div[text()='" + maximumPriceItem + "']";
		String addCartButtonForMaximumPriceItemXpath = maximumPriceItemXpath + "//following-sibling::button";
		
		Float minimumPriceItem = price.get(0);
		String minimumPriceItemXpath = "//div[text()='" + minimumPriceItem + "']";
		String addCartButtonForMinimumPriceItemXpath = minimumPriceItemXpath + "//following-sibling::button";
		
		driver.findElement(By.xpath(addCartButtonForMinimumPriceItemXpath)).click();
		driver.findElement(By.xpath(addCartButtonForMaximumPriceItemXpath)).click();
		
		
		
//		ArrayList<Float> prices = new ArrayList<Float>();
//		for (WebElement element : elements) {
//			prices.add(Float.parseFloat(element.getText().replace("$", "")));
//
//		}
//
//		Collections.sort(prices);
//
//		String maxItemPrice = prices.get(prices.size() - 1).toString();
//		String maxPriceItemXpath = "//div[text()='" + maxItemPrice + "']";
//		String addCartButtonForMaxPriceItemXpath = maxPriceItemXpath + "//following-sibling::button";
//
//		driver.findElement(By.xpath(addCartButtonForMaxPriceItemXpath)).click();

	}

	public void addItemWithMaxPriceToCart() {
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

	public void findMaxAndMinPriceItemWithIndex() {
		List<WebElement> el = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		float maxPrice = 0f;
		float minPrice = Float.MAX_VALUE;
		int maxPriceItemIndex = 1;
		int minPriceItemIndex = 1;
		int temp = 1;
		for (WebElement e : el) {
			float price = Float.parseFloat(e.getText().replace("$", ""));
			if (price > maxPrice) {
				maxPrice = price;
				maxPriceItemIndex = temp;

			}
			if (price < minPrice) {
				minPrice = price;
				minPriceItemIndex = temp;
			}
			temp++;
		}

		String itemWithMaxPriceTitle = driver
				.findElement(By.xpath("(//div[@class=\'inventory_item_name \'])[" + maxPriceItemIndex + "]")).getText();

		System.out.println("Title of most expensive Item on page: " + itemWithMaxPriceTitle);
		System.out.println("Index of most expensive Item on page: " + maxPriceItemIndex);
		System.out.println("Price of most expensive Item: " + maxPrice);

		driver.findElement(By.xpath("(//button[text()='Add to cart'or text()='Remove'])[" + maxPriceItemIndex + "]"))
				.click();

		String itemWithMinPriceTitle = driver
				.findElement(By.xpath("(//div[@class=\'inventory_item_name \'])[" + minPriceItemIndex + "]")).getText();

		System.out.println("Title of least expensive Item on page: " + itemWithMinPriceTitle);
		System.out.println("Index of least expensive Item on page: " + minPriceItemIndex);
		System.out.println("Price of least expensive Item: " + minPrice);

		driver.findElement(By.xpath("(//button[text()='Add to cart'or text()='Remove'])[" + minPriceItemIndex + "]"))
				.click();

	}

}