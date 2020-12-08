package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.SeleniumKeywords;

public class RegistrationPageFactory {
 WebDriver driver;
 @FindBy(linkText="Register")
	@CacheLookup
	public
	WebElement registerlink;
 @FindBy(id="gender-male")
	@CacheLookup
	WebElement male;
 @FindBy(id="gender-female")
	@CacheLookup
	WebElement female;
 
 @FindBy(xpath="//*[@id='FirstName']")
 @CacheLookup
 WebElement firstname;
 
 @FindBy(how=How.XPATH,using="//*[@id='LastName']")
 @CacheLookup
 WebElement lastname;
 
 @FindBy(how=How.ID,using="Email")
 @CacheLookup
 WebElement email;
 
 @FindBy(how=How.NAME,using="Password")
 @CacheLookup
 WebElement password;
 
 @FindBy(name="ConfirmPassword")
	@CacheLookup
	WebElement confirmpassword;
 
 @FindBy(id="register-button")
	@CacheLookup
	WebElement registerbutton;
 @FindAll({@FindBy(className="text-box single-line")})
 @CacheLookup
 List<WebElement> errormsg;
 
 @FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]/span")
 @CacheLookup
 WebElement emailformaterr;
 
 public RegistrationPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//This method sets the first name in registration page
 public void setFirstName(String firstname)
 {
	 
	 SeleniumKeywords.sendData(this.firstname, firstname);
 }
//This method sets the last name in registration page
 public void setLastName(String lastname)
 {
	
	 SeleniumKeywords.sendData(this.lastname, lastname);
 }
//This method sets the email in registration page
 public void setEmail(String email)
 {
	
	 SeleniumKeywords.sendData(this.email, email);
 }
//This method sets the password in registration page
 public void setPassword(String password)
 {
	 
	 SeleniumKeywords.sendData(this.password,password);
 }
//This method sets the confirm password in registration page
 public void setConfirmPassword(String confirmpassword)
 {
	
	 SeleniumKeywords.sendData(this.confirmpassword, confirmpassword);
 }
//This method selects the male option in registration page
 public void setMale()
 {
	
	 SeleniumKeywords.clickButton(male);
 }
//This method selects the female option in registration page
 public void setFemale()
 {
	 
	 SeleniumKeywords.clickButton(female);
 }
//This method submits the credentials passed in registration page
 public void submit()
 {
	
	 SeleniumKeywords.clickButton(registerbutton);
 }
//This method gets all the error messages and stores in list and returns the list
 public List<String> textRegistration()
 {
	 List<String> errText = new ArrayList<String>(); ;
	 for(WebElement var:errormsg)
	 {
		 errText.add(SeleniumKeywords.Message(var));
	 }
	 return(errText);
 }
 
 public void setRegistration(String firstname,String lastname,String email,String password,String confirmpassword,String gender)
 {
	 if(gender.equalsIgnoreCase("male"))
	 {
		 SeleniumKeywords.clickButton(male);
	 }
	 else
	 {
		 SeleniumKeywords.clickButton(female);
	 }
	 SeleniumKeywords.sendData(this.firstname, firstname);
	 SeleniumKeywords.sendData(this.lastname, lastname);
	 SeleniumKeywords.sendData(this.email, email);
	 SeleniumKeywords.sendData(this.password,password);
	 SeleniumKeywords.sendData(this.confirmpassword, confirmpassword);
	 SeleniumKeywords.clickButton(registerbutton);

 }
 //This method gets the email format error and returns it
 public String emailFormat()
 {
	 return(SeleniumKeywords.Message(emailformaterr));
 }

}
