package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[6]//div[1]//button[1]")
	WebElement selectShoesSize;
	
	@FindBy(className="pdp-add-to-bag")
	WebElement addToBag;
	
	@FindBy(className="desktop-iconBag")
	WebElement bag;
	
	public WebElement selectShoesSize()
	{
		return selectShoesSize;
	}
	
	public WebElement addToBag()
	{
		return addToBag;
	}
	
	public WebElement bag()
	{
		return bag;
	}
	

}
