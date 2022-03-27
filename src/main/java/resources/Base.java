package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	
	public WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver BrowserInitializer() throws IOException
	{
		prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browsername =  prop.getProperty("Browser");
        
        if(browsername.equals("chrome"))
        {
        	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
    		driver = new ChromeDriver();
        }
        
        else if(browsername.equals("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
    		driver = new FirefoxDriver();
        }
        
        else if(browsername.equals("edge"))
        {
        	System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\resources\\msedgedriver.exe");
    		driver = new EdgeDriver();
        }
        
        else if(browsername.equals("IE"))
        {
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\resources\\IEDriverServer.exe");
    	    driver = new InternetExplorerDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
	}
	
	
		

	

}
