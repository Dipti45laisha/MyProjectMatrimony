import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingEcommerce.Base.TestBase;
import com.testingEcommerce.Keyword.Keyword;
import com.testingEcommerce.PagesM.Homepage;

public class HomepageTestPOM extends TestBase {
	@Test
	public void mouseHoveronNavigationMenu(){
		 Homepage home=new Homepage();
		 WebElement mainMenu = home.JewelleryandAccessories;
		 home.hoveron(mainMenu);
		   //Hovering on main menu actions.moveToElement(mainMenu).perform();
		 // Keyword.elementTobePresent(mainMenu);
		  WebElement subMenu = home.BagsandPurses;
		  home.hoveronsub(subMenu);
		  Assert.assertTrue(subMenu.isEnabled());
		 // Keyword.elementTobePresent(subMenu);
		  home.clickOnLaptopBags();
		  List<WebElement>laptopbags=Keyword.getWebElements("xpath","//a[contains(text(),'Laptop Bags')]");
		  Assert.assertTrue(!laptopbags.isEmpty()); 
		  }
		 

}
