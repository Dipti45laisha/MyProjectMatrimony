import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingEcommerce.Base.TestBase;
import com.testingEcommerce.Keyword.Keyword;
import com.testingEcommerce.PagesM.Homepage;
import com.testingEcommerce.Utils.FileUtils;
import com.testingEcommerce.Utils.Locator;
import com.testingEcommerce.Utils.LocatorType;

public class HomePageTests extends TestBase {
	@Test
	public static void verifysigninfuntionlity() throws InterruptedException {
		Keyword.clickOn("xpath", "//button[contains(text(),' Sign in')]");
		Thread.sleep(3000);
		Keyword.enterText("xpath", "//input[@id=\"join_neu_email_field\"]", "deepti.bhakkad@gmail.com");
		Keyword.enterText("xpath", "//input[@id=\"join_neu_password_field\"]", "Laisha@1234");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//label[contains(text(),'Stay signed in'
		// )]")).click();
		Keyword.clickOn("xpath", "//button[@value=\"sign-in\"]");
		String ExpectedTitle = "Etsy India - Shop for handmade, vintage, custom, and unique gifts for everyone";
		String actualTitle = Keyword.driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}

	@Test
	public static void verifySearchfunctianility() {
		Keyword.enterText("xpath", "//input[@data-id=\"search-query\"]", "clothing woman ");
		Keyword.clickOn("xpath", "(//button[@type=\"submit\"])[1]");
		String ExpectedTitle = "Clothing woman - Etsy IN";
		String actualTitle = Keyword.driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}

	@Test
	public static void verifyElementsAddtoBasket() throws InterruptedException {
		verifySearchfunctianility();
		Thread.sleep(3000);
		Keyword.clickOn("xpath",
				"(//h3[contains(text(),'Kimono, GOLD RUSH, Robe-Style Bohemian Kimono with Floral Patterns, Cover-up, beachwear, bohemian, shawl, wrap, summer, boho, bridal, kimono')] )[1]");
		// driver.get("https://www.etsy.com/in-en/listing/734803508/kimono-gold-rush-robe-style-bohemian?click_key=f5076f23bad5fb1ca89fbf48b5415ebc2f8e1713%3A734803508&click_sum=ee53277f&ref=search2_top_narrowing_intent_modules_top_rated-2&pro=1");
		// ArrayList<String> tabs1=new ArrayList<String>(driver.getWindowHandles());
		ArrayList<String> tab1 = new ArrayList<String>(Keyword.driver.getWindowHandles());
		Keyword.driver.switchTo().window(tab1.get(1));
		Keyword.clickOn("xpath", "//button[contains(text(),'Add to basket')]");
		// driver.switchTo().window(tabs1.get(0));
		String ExpectedTitle = "Buy Kimono GOLD RUSH Robe-style Bohemian Kimono With Floral Online in India - Etsy";
		String actualTitle = Keyword.driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);

		// driver.get("https://www.etsy.com/in-en/search?q=clothing%20women&ref=auto-1&as_prefix=clothing%20");
		Keyword.driver.switchTo().window(tab1.get(1));
		Thread.sleep(3000);
		Keyword.clickOn("xpath",
				"//h3[contains(text(),'Hand Embroidery Linen Dress, Linen Casual Dress Women with Pockets, Linen Boho Dress, Loose Dress, Oversized Plus Size Dress, Linen Clothing')]");
		ArrayList<String> tabs2 = new ArrayList<String>(Keyword.driver.getWindowHandles());

		Keyword.driver.switchTo().window(tabs2.get(2));
		WebElement List = Keyword.getWebElement("xpath", "//select[@id=\"variation-selector-0\"]\"");
		Select size = new Select(List);
		size.selectByIndex(2);
		Thread.sleep(3000);
		Keyword.enterText("xpath", "//textarea[@aria-labelledby=\\\"personalization-field-label\\\"]\"", "Yellow");
		// Thread.sleep(2000);
		Keyword.clickOn("xpath", "//button[contains(text(),' Add to basket')]");
		String ExpectedTitle1 = "[Etsy - Shopping basket";
		// Thread.sleep(2000);
		String actualtitle1 = Keyword.driver.getTitle();
		Assert.assertEquals(actualtitle1, ExpectedTitle1);
	}
	@Test
	public void verifymenuBeforeGiftsMenu() {
		  ArrayList <String> menueTexts=new ArrayList<String>();
		  menueTexts.add("Sellers' Sales Hub");
		  menueTexts.add("Jewellery & Accessories");
		  menueTexts.add("Clothing & Shoes"); 
		  menueTexts.add("Home & Living");
		  menueTexts.add("Wedding & Party"); 
		  menueTexts.add("Toys & Entertainment");
		  menueTexts.add("Art & Collectibles");
		  menueTexts.add("Craft Supplies");
		  menueTexts.add("Gifts");
		// List<String> mainmenues=Keyword.getTexts("xpath","//li[@class=\"top-nav-item wt-pb-xs-2 wt-mr-xs-2 wt-display-flex-xs wt-align-items-center\"]/a");
		//List<String>mainmenues=Keyword.getTexts(LocatorType.XPATH,FileUtils.getLocator("homepage.mainmenues_list"));
		  List<String>mainmenues=Keyword.getTexts(Locator.mainmenues_list);
		// List<String>mainmenues=Keyword.getTexts("xpath",Locator.mainmenues_list);
		Assert.assertEquals(menueTexts, mainmenues);
		System.out.println(mainmenues);
		
	}
	@Test
	public void verifymenuBeforeGiftsMenuUsingPOM() {
		 ArrayList <String> menueTexts=new ArrayList<String>();
		  menueTexts.add("Sellers' Sales Hub");
		  menueTexts.add("Jewellery & Accessories");
		  menueTexts.add("Clothing & Shoes"); 
		  menueTexts.add("Home & Living");
		  menueTexts.add("Wedding & Party"); 
		  menueTexts.add("Toys & Entertainment");
		  menueTexts.add("Art & Collectibles");
		  menueTexts.add("Craft Supplies");
		  menueTexts.add("Gifts");
		//  Homepage home=PageFactory.initElements(Keyword.driver,Homepage.class);
		  Homepage home=new Homepage();
		List<String>mainmenues=	home.getmenuBeforeGiftmenu();
		System.out.println(mainmenues);
		Assert.assertEquals(menueTexts, mainmenues);
		
	}
	@Test
	 
	  public void mouseHoveronNavigationMenu() throws AWTException, InterruptedException {
	   WebElement mainMenu = Keyword.getWebElement("xpath","(//a[@href=\"/in-en/c/jewelry-and-accessories?ref=catnav-10855\"])[1]");
	   Keyword.hoveron(mainMenu);
	  
	  //Hovering on main menu actions.moveToElement(mainMenu).perform();
	  Thread.sleep(2000);
	  
	 
	  
	  WebElement subMenu = Keyword.getWebElement("xpath","//span[contains(text(),'Bags & Purses')]/parent::li[@data-node-id=\"10865\"]");
	  Keyword.hoveron(subMenu);
	  
	  
	  Assert.assertTrue(subMenu.isEnabled());
	  Thread.sleep(2000);
	  Keyword.clickOn("xpath","//a[contains(text(),'Laptop Bags')]");
	  List<WebElement>laptopbags=Keyword.getWebElements("xpath","//a[contains(text(),'Laptop Bags')]");
	  Assert.assertTrue(!laptopbags.isEmpty()); 
	  }
	 
	
	
}