package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.SeleniumKeywords;

public class ShoppingCartPageFactory {
	WebDriver driver;
	
	@FindBy(name="removefromcart")
	WebElement remove; 
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")
	WebElement update;
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div[2]/div[2]/div")
	WebElement msg;
	
	
	public ShoppingCartPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//This method removes the selected item from cart
	public void removeItem()
	{
		
		SeleniumKeywords.clickButton(remove);
	}
	//This method updates the cart
	public void updateCart()
	{
		SeleniumKeywords.clickButton(update);
	}
	//This method returns the message after updating the cart
	public String cartMessage()
	{
		return(SeleniumKeywords.Message(msg));
	}

}
