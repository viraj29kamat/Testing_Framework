package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingBag {
	
	WebDriver driver;
	
	public ShoppingBag(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="itemContainer-base-selectionIndicator")
	WebElement closePopup;
	
	@FindBy(className="bulkActionStrip-desktopBulkWishlist")
	WebElement moveToWishlist;
	
	@FindBy(css=".inlinebuttonV2-base-actionButton.bulkActionStrip-waterMelon")
	WebElement confirmTomoveWishlist;
	
	public WebElement closePopup()
	{
		return closePopup;
	}
	
	public WebElement moveToWishlist()
	{
		return moveToWishlist;
	}
	
	public WebElement confirmTomoveWishlist()
	{
		return confirmTomoveWishlist;
	}

}
