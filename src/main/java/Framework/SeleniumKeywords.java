package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumKeywords {
	static WebDriver driver;

	//This method starts the browser and returns the webdriver instance
	public static WebDriver  startBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\himav\\Downloads\\selenium all files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
	//This method implements the click operation using webelement argument 
	public static void clickButton(WebElement we)
	{
		we.click();
	}
	//This method gets the text from webelement and returns it
	public static String Message(WebElement we)
	{
		return(we.getText());
	}
	//This method passes the data to the webelement
	public static void sendData(WebElement we,String data)
	{
		we.sendKeys(data);
	}

}
