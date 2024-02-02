package com.mannautomation.base;
import com.mannautomation.utility.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	@BeforeMethod
	
	public void setUp() throws IOException {
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
	}

//	 @AfterMethod
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }

}
