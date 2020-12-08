package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.SeleniumKeywords;

public class LoginPageFactory {
 WebDriver driver;
 
    @FindBy(id="Email")
	@CacheLookup
	WebElement emailid;
    
    @FindBy(linkText="Log in")
	@CacheLookup
	public
	WebElement loginlink;
    
    @FindBy(how=How.NAME, using="Password")
	@CacheLookup
	WebElement password;
    
    @FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	@CacheLookup
	WebElement loginbutton;
    
    @FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")
    @CacheLookup
    WebElement errormsg;
    
    public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    //This method sets the email id in login page
    public void setEmail(String emailid)
    {
    	SeleniumKeywords.sendData(this.emailid, emailid);
    }
  //This method sets the password in login page
    public void setPassword(String password)
    {
    	SeleniumKeywords.sendData(this.password, password);
    }
  //This method submits the credentials in login page
    public void submit()
    {
    	SeleniumKeywords.clickButton(loginbutton);
    }
  //This method gets the error message for invalid login
    public String textMessage()
    {
    	return(SeleniumKeywords.Message(errormsg));
    	
    }
    public void successfullogin(String emailid,String password)
    {
    	SeleniumKeywords.sendData(this.emailid, emailid);
    	SeleniumKeywords.sendData(this.password, password);
    	loginbutton.click();
    	
    }
  //This method is used to navigate to login page from home page
    public void clickLogin()
    {
    	SeleniumKeywords.clickButton(loginlink);
    }
 
}
