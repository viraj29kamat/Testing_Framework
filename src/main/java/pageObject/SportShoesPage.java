package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportShoesPage {
	
	WebDriver driver;
	
	public SportShoesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sort-sortBy")
	WebElement sort;
	
	@FindBy(xpath="//label[normalize-space()=\"What's New\"]")
	WebElement sortByWhatsNew;
	
	@FindBy(xpath="//div[@class='vertical-filters-filters brand-container']//li[1]//label[1]//div[1]")
	WebElement filterByBrand;
	
	@FindBy(className="filter-summary-filter")
	WebElement brandFiltered;
	
	@FindBy(xpath="//div[4]//ul[1]//li[1]//label[1]//div[1]")
	WebElement filterByColor;
	
	@FindBy(className="filter-summary-colourBox")
	WebElement colorFiltered;
	
	@FindBy(xpath="//div[@class='search-rightContainer column-base']//li[1]//a[1]")
	WebElement selectProduct;
	
	public WebElement sortBy()
	{
		return sort;
	}
	
	public WebElement whatsNew()
	{
		return sortByWhatsNew;
	}
	
	public WebElement filterByBrand()
	{
		return filterByBrand;
	}
	
	public WebElement brandFiltered()
	{
		return brandFiltered;
	}
	
	public WebElement filterByColor()
	{
		return filterByColor;
	}
	
	public WebElement colorFiltered()
	{
		return colorFiltered;
	}
	
	public WebElement  selectProduct()
	{
		return selectProduct;
	}
	
	
	

}
