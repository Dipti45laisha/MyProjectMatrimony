package com.testingEcommerce.Stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testingEcommerce.Keyword.Keyword;
import com.testingEcommerce.PagesM.Homepage;
import com.testingEcommerce.Utils.FileUtils;
import com.testingEcommerce.Utils.Locator;
import com.testingEcommerce.Utils.LocatorType;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepsTestCases {


	@Then("user click on sign in button")
	public void clikonsigninbutton() throws InterruptedException {
		Keyword.clickOn("css", FileUtils.getLocator("homepage.signin_btn"));
		// Keyword.clickOn(LocatorType.CSS,Locator.signin_btn);
	}

	@Then("user have to send Email Address")
	public void sendTextonemailAddress() throws InterruptedException {
		Thread.sleep(2000);
		Keyword.enterText("css",FileUtils.getLocator("homepage.text_email"), "deepti.bhakkad@gmail.com");
	}

	@Then("user have to send Paassword")
	public void sendTextonPassword() {
		Keyword.enterText("css",FileUtils.getLocator("homepage.text_password"), "Laisha@1234");
	}

	@Then("user have to click on Sign in button")
	public void clickOnSigninButton() throws InterruptedException {
		Thread.sleep(3000);
		Keyword.clickOn("css",FileUtils.getLocator("hompage.clickonsignin_btn"));
	}

	@Then("Application should launch")
	public void verifyTitleofhomePage() {
		String ExpectedTitle = "Etsy India - Shop for handmade, vintage, custom, and unique gifts for everyone";
		String actualTitle = Keyword.driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}

	@Then("user click on to the Your Account icon")
	public void clickonYourAccountIcon() throws InterruptedException {
		Thread.sleep(2000);
		Keyword.clickOn("css", "button[data-selector=you-menu-tooltip]");
	}

	@Then("user click on sign out button")
	public void clickonsignoutButton() throws InterruptedException {
		Thread.sleep(2000);
		Keyword.clickOn("css", "a[href=\"https://www.etsy.com/in-en/logout.php?ref=hdr_user_menu-signout\"]");
	}

	@Then("Application should signout")
	public void verifyTitleofSignoutPage() {
		String ExpectedTitle = "Etsy India - Shop for handmade, vintage, custom, and unique gifts for everyone";
		String actualTitle = Keyword.driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}

	@Then("Go to search Fuction & Send the text to be search")
	public void enterTextOnsearchFunction() {
		Keyword.enterText("css",FileUtils.getLocator("homepage.search_text"), "clothing woman");
	}
	@Then("Click on Seach button")
	public void clickOnSearchButton()
	{
		Keyword.clickOn("css",FileUtils.getLocator("homepage.search_btn"));
	}
	@Then("Verify a search functionality")
	public void VerifyTitleofSearchPage()
	{
		String ExpectedTitle = "Clothing woman - Etsy IN";
		String actualTitle = Keyword.driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}

	
	@Then("Get All menuTexts on nav Bar")
	public void verifymenuBeforeGiftsMenu() {
		Homepage home=new Homepage();
	

		List<String>mainmenues=	home.getmenuBeforeGiftmenu();
		
	}
	@Then("check all the products on navBar")
	public void checkProducts()
	{
		Homepage home=new Homepage();
		ArrayList<String> menueTexts = new ArrayList<String>();
		menueTexts.add("Sellers' Sales Hub");
		menueTexts.add("Jewellery & Accessories");
		menueTexts.add("Clothing & Shoes");		
		menueTexts.add("Home & Living");
		menueTexts.add("Wedding & Party");
		menueTexts.add("Toys & Entertainment");
		menueTexts.add("Art & Collectibles");
		menueTexts.add("Craft Supplies");
		menueTexts.add("Gifts");
		// List<String> mainmenues = Keyword.getTexts(Locator.mainmenues_list);
		List<String>mainmenues=	home.getmenuBeforeGiftmenu();
		Assert.assertTrue(mainmenues.containsAll(menueTexts));		
	}    
	@Then("HoverOn Toys & Entertainment")
	public void hoverOnToysandEntertainment() {
		Homepage home=new Homepage();
		WebElement mainMenu=home.ToysandEntertainment;
		home.hoverON(mainMenu);
	}
	@Then("ClickON Musical Instruments")
	public void cilckONMusicalinstruments() {
		Homepage home=new Homepage();
		WebElement subMenu=home.MusicalInstruments;
		Keyword.elementTobePresent(subMenu);
		home.clickOnMusicalInstruments();
	}
	@Then("Get instrument Sub Menu")
     public void verifygetInstrumentsubMenu()
     {
		//List<String> instrusubmenu = Keyword.getTexts("xpath", Locator.instru_submenu);
		Homepage home=new Homepage();
		home.getinstrumentSubMenu();
	}

}
