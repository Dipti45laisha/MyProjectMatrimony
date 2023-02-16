package com.testingEcommerce.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	/**
	 * Use this methos to get the locators from OR.Properties file.pass the key of locator that you want 
	 * @param locator key of locator
	 * @return value of Locator
	 */
	public static String getLocator(String locator) {
		String baseDir=System.getProperty("user.dir");
		String locatorValue="";
		
		try {
			FileInputStream fis=new FileInputStream(baseDir+"/src/main/resources/OR.properties");
			Properties prop=new Properties();
			prop.load(fis);
			locatorValue=prop.getProperty(locator);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//to handle Exception
		}
		return locatorValue;
	}

}
