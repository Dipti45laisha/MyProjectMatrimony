package com.testingEcommerce.Keyword;

import java.sql.DriverAction;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keyword {
	private static final WebElement getWebElement = null;
	public static WebDriver driver;
	private static WebDriverWait wait=null;
	
	public static void elementTobePresent(WebElement element)
	{
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void openBrowser(String browsername) {
		if (browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else if (browsername.equalsIgnoreCase("InternetExplorer")) {
			driver = new InternetExplorerDriver();
		} else if (browsername.equalsIgnoreCase("MicrosoftEdge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Broesername" + browsername);
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void teardown() {
		driver.quit();

	}

	public static void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	
	

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		 
			if (locatorType.equalsIgnoreCase("id"))
				return driver.findElement(By.id(locatorValue));
			else if (locatorType.equalsIgnoreCase("className"))
				return driver.findElement(By.className(locatorValue));
			else if (locatorType.equalsIgnoreCase("name"))
				return driver.findElement(By.name(locatorValue));
			else if (locatorType.equalsIgnoreCase("partialLinkTex"))
				return driver.findElement(By.partialLinkText(locatorValue));
			else if (locatorType.equalsIgnoreCase("linkText"))
				return driver.findElement(By.linkText(locatorValue));
			else if (locatorType.equalsIgnoreCase("tagName"))
				return driver.findElement(By.tagName(locatorValue));
			else if (locatorType.equalsIgnoreCase("xpath"))
				return driver.findElement(By.xpath(locatorValue));
			else if (locatorType.equalsIgnoreCase("css"))
				return driver.findElement(By.cssSelector(locatorValue));
			else
				return null;
		 }
			
		
		 public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
			 {
				if (locatorType.equalsIgnoreCase("id"))
					return driver.findElements(By.id(locatorValue));
				else if (locatorType.equalsIgnoreCase("className"))
					return driver.findElements(By.className(locatorValue));
				else if (locatorType.equalsIgnoreCase("name"))
					return driver.findElements(By.name(locatorValue));
				else if (locatorType.equalsIgnoreCase("partialLinkTex"))
					return driver.findElements(By.partialLinkText(locatorValue));
				else if (locatorType.equalsIgnoreCase("linkText"))
					return driver.findElements(By.linkText(locatorValue));
				else if (locatorType.equalsIgnoreCase("tagName"))
					return driver.findElements(By.tagName(locatorValue));
				else if (locatorType.equalsIgnoreCase("xpath"))
					return driver.findElements(By.xpath(locatorValue));
				else if (locatorType.equalsIgnoreCase("css"))
					return driver.findElements(By.cssSelector(locatorValue));
				else
					return null;
				
			}
			 


	
	}

	/**This method is no longer be availble in coming version of framework..
	 * getTexts(String locator)
	 * 
	 * @param element
	 * @return
	 */
     @Deprecated
	public static String getText(WebElement element) {
		return element.getText();
	}
	public static List<String> getTexts(String locator) {
		String locatorType=locator.split("##")[0];
		String locatorValue=locator.split("##")[1];
		return getTexts(locatorType,locatorValue);
		// TODO Auto-generated method stub

	}
	
	public static String getText(String locatorType,String locatorValue) {
		if (locatorType.equalsIgnoreCase("id"))
			return driver.findElement(By.id(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("className"))
			return driver.findElement(By.className(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("name"))
			return driver.findElement(By.name(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("partialLinkTex"))
			return driver.findElement(By.partialLinkText(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("linkText"))
			return driver.findElement(By.linkText(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("tagName"))
			return driver.findElement(By.tagName(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(locatorValue)).getText();
		else if (locatorType.equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(locatorValue)).getText();
		else
			return null;
		
	}
	public static List<String> getTexts(String locatorType,String locatorValue){
		List<String> texts=new ArrayList<String>();
		List<WebElement>elements=new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("id"))
			elements= driver.findElements(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("className"))
			elements=driver.findElements(By.className(locatorValue));
		else if (locatorType.equalsIgnoreCase("name"))
			elements=driver.findElements(By.name(locatorValue));
		else if (locatorType.equalsIgnoreCase("partialLinkTex"))
			elements= driver.findElements(By.partialLinkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("linkText"))
			elements= driver.findElements(By.linkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("tagName"))
			elements= driver.findElements(By.tagName(locatorValue));
		else if (locatorType.equalsIgnoreCase("xpath"))
			elements=driver.findElements(By.xpath(locatorValue));
		else if (locatorType.equalsIgnoreCase("css"))
			elements=driver.findElements(By.cssSelector(locatorValue));
		else
			return null;
		
		for(WebElement element:elements) {
			texts.add(element.getText());
		}
		return texts;
		
	}
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

public static void hoveron(WebElement element) {
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
	action.build();
	action.perform();
}
	
	public static void hoveron(String LocatorType,String locatorValue) {
		Actions action=new Actions(driver);
	    WebElement ele=getWebElement(LocatorType,locatorValue);
	    action.moveToElement(ele).perform();
//		action.build();
//	    action.perform();
	
}
}