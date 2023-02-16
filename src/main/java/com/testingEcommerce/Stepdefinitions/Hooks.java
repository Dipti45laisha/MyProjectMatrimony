package com.testingEcommerce.Stepdefinitions;

import com.testingEcommerce.Keyword.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public static void setUp() {
		String env=System.getProperty("env");
		System.out.println("Environment:"+env);
		Keyword.openBrowser("Chrome");
		 //Keyword.launchUrl("https://www.etsy.com/");
		 Keyword.launchUrl("https://ashtvivah.com/");
		 Keyword.maximizeBrowser();
	}
	@After
	public void teardown()
	{
		Keyword.teardown();
	}

}
