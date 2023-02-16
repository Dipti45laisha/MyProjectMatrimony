package com.testingEcommerce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingEcommerce.Keyword.Keyword;

public class TestBase {
	
	@BeforeMethod()
	public  void launchBrowser() {
	   Keyword.openBrowser("Chrome");
	   Keyword.launchUrl("https://www.etsy.com/");
	   Keyword.maximizeBrowser();
		
		}
	@AfterMethod()
	public static void teardown() {
		Keyword.teardown();
	}
	

}
