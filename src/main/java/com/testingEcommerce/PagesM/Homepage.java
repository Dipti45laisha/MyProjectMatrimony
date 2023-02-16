package com.testingEcommerce.PagesM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testingEcommerce.Keyword.Keyword;
import com.testingEcommerce.Utils.Locator;

public class Homepage {
	@FindBy(xpath="//li[@class=\"top-nav-item wt-pb-xs-2 wt-mr-xs-2 wt-display-flex-xs wt-align-items-center\"]/a")
	public List <WebElement> menuBeforeGiftmenu;
	
	@FindBy(xpath="(//a[@href=\"/in-en/c/jewelry-and-accessories?ref=catnav-10855\"])[1]")
	public WebElement JewelleryandAccessories;
	
	@FindBy(xpath="//span[contains(text(),'Bags & Purses')]/parent::li[@data-node-id=\"10865\"]")
	public WebElement BagsandPurses;
	
	@FindBy(xpath="//a[contains(text(),'Laptop Bags')]")
	public WebElement LaptopBags;
	
	
	@FindBy(xpath="//span[contains(text(),'Toys & Entertainment')]")
	public WebElement ToysandEntertainment;
	
	@FindBy(xpath="//a[contains(text(),'Musical Instruments')]")
	public WebElement MusicalInstruments;
	
	@FindBy(xpath= Locator.instru_submenu)
	public List <WebElement> instrumentSubMenu;
	
	
	
	
	public Homepage() {
		PageFactory.initElements(Keyword.driver,this);
	}
	public WebElement hoveron(WebElement mainMenu)
	{
	    Keyword.hoveron(JewelleryandAccessories);
	    Keyword.elementTobePresent(mainMenu);
		return JewelleryandAccessories;
	}
	public WebElement hoverON(WebElement mainMenu) {
		Keyword.hoveron(ToysandEntertainment);
	    Keyword.elementTobePresent(mainMenu);
		return ToysandEntertainment;
		
	}
	public WebElement hoveronsub(WebElement subMenu)
	{
		Keyword.elementTobePresent(subMenu);
	    Keyword.hoveron(BagsandPurses);
	    return BagsandPurses;
	}
	  
	public List<String>getmenuBeforeGiftmenu(){
	List<String>menuTexts=new ArrayList<String>();
	for (WebElement menuText:menuBeforeGiftmenu) {
		menuTexts.add(menuText.getText());
		
	}
	System.out.println(menuTexts);
	return menuTexts;
	

}
	public  void clickOnLaptopBags() {
		//Keyword.clickOn("xpath","//a[contains(text(),'Laptop Bags')]");
		LaptopBags.click();
		
		
	}
	public void clickOnMusicalInstruments()
	{
		MusicalInstruments.click();
		
	}
	public List<String>getinstrumentSubMenu()
	{
		List<String>subMenu=new ArrayList<String>();
		for (WebElement subtext:instrumentSubMenu) {
			subMenu.add(subtext.getText());
			
		}
		System.out.println(subMenu);
		Assert.assertTrue(!instrumentSubMenu.isEmpty());
		return subMenu;
	
		
	}
}
