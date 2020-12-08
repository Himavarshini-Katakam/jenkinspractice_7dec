package PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.SeleniumKeywords;

public class HomePage {
WebDriver driver;
@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a")
WebElement books;
@FindBy(linkText="Computers")
WebElement computers;
@FindBy(linkText="Electronics")
WebElement electronics;
@FindBy(linkText="Apparel & Shoes")
WebElement apparel;
@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a")
WebElement item;
@FindBy(how=How.ID,using="add-to-cart-button-13")
WebElement addcart;
@FindBy(xpath="//*[@id='bar-notification']/p")
@CacheLookup
WebElement msg;
@FindBy(xpath="//*[@id='topcartlink']/a")
WebElement shoppingcart;
//This method clicks the shopping cart in home page
public void goToCart()
{
	
	SeleniumKeywords.clickButton(shoppingcart);
}


//This method add the items to cart
public void addToCart()
{
	
	
	SeleniumKeywords.clickButton(addcart);
	
}
//This method selects the category 
public void selectCategory()
{
	

	SeleniumKeywords.clickButton(books);
}
//This method selects the item in the selected category
public void selectItem() throws InterruptedException
{
	Actions actions = new Actions(driver);   
	actions.sendKeys(Keys.PAGE_DOWN).build().perform();//Scrolls down and selects the item

	Thread.sleep(2000);
	
	
	SeleniumKeywords.clickButton(item);
}
//This method returns the message after adding the item to cart
public String getMessage()
{
	return(SeleniumKeywords.Message(msg));
}

public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

}
