package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-reactid='19']")
	WebElement mensection;
	
	@FindBy(linkText="Sports Shoes")
	WebElement SportshoesSection;
	
	public WebElement menSection()
	{
		return mensection;
	}
	
	public WebElement sportShoesSection()
	{
		return SportshoesSection;
	}
		
		

	

}
