package myntra;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.ProductPage;
import pageObject.ShoppingBag;
import pageObject.SportShoesPage;
import resources.Base;


public class AddproductToCart extends Base  {
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class);
	
	
	
	@BeforeTest
	public void BrowserInitialization() throws IOException
	{
		driver = BrowserInitializer();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to website");
		
	}
	
	@Test
	public void addProductToCart()
	{
		WebDriverWait w = new WebDriverWait(driver,10);
		Actions a = new Actions(driver);
		HomePage hp = new HomePage(driver);
		a.moveToElement(hp.menSection()).build().perform();
		log.info("Moved at Mens Section");
		hp.sportShoesSection().click();
		log.info("clicked on Sport shoes section");
		SportShoesPage shoespage = new SportShoesPage(driver);
		a.moveToElement(shoespage.sortBy()).build().perform();
		shoespage.whatsNew().click();
		log.info("clicked on sort by WhatsNew");
		w.until(ExpectedConditions.textToBe(By.xpath("//div[@class='sort-sortBy']/span"),"What'S New"));
		shoespage.filterByBrand().click();
		log.info("clicked on Puma banrd filter");
		w.until(ExpectedConditions.visibilityOf(shoespage.brandFiltered()));
		shoespage.filterByColor().click();
		log.info("clicked on black color filter");
		w.until(ExpectedConditions.visibilityOf(shoespage.colorFiltered()));
		shoespage.selectProduct().click();
		log.info("product selected");
		Set<String>windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		log.info("Switched to product page window");
		ProductPage pp = new ProductPage(driver);
		pp.selectShoesSize().click();
		log.info("product size selected");
		pp.addToBag().click();
		log.info("product added to bag");
		pp.bag().click();
		log.info("moved to shopping bag");
		ShoppingBag sb = new ShoppingBag(driver);
		sb.closePopup().click();
		log.info("closed popup");
		sb.moveToWishlist().click();
		sb.confirmTomoveWishlist().click();
		log.info("Product moved to wishlist");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	

}
