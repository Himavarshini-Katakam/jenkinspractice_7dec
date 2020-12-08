package StepDefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Framework.SeleniumKeywords;
import PageObjects.HomePage;
import PageObjects.LoginPageFactory;
import PageObjects.ShoppingCartPageFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UpdateShoppingCartSteps {
    WebDriver driver;
	HomePage hpobj;
	ShoppingCartPageFactory scobj;
	 
	

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		
		driver=SeleniumKeywords.startBrowser();
		
		
		hpobj = new HomePage(driver);
		driver.get("http://demowebshop.tricentis.com/");
	}

	@When("^User clicks on books link$")
	public void user_clicks_on_books_link() throws Throwable {
	    hpobj.selectCategory();
	}

	@When("^selects a book to add to cart$")
	public void selects_a_book_to_add_to_cart() throws Throwable {
		
	    hpobj.selectItem();
	}

	@When("^click on Add to cart$")
	public void click_on_Add_to_cart() throws Throwable {
	   hpobj.addToCart();
	}

	@When("^item is added to cart successfully$")
	public void item_is_added_to_cart_successfully() throws Throwable {
	    String actual=hpobj.getMessage();
	    Assert.assertEquals(actual, "The product has been added to your shopping cart");
	}
	
	@When("^User is on the shopping cart page$")
	public void user_is_on_the_shopping_cart_page() throws Throwable {
		/*ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs2.get(0));
		 Thread.sleep(3000);*/
	   hpobj.goToCart();
	}

	@When("^the user selects the items on remove$")
	public void the_user_selects_the_items_on_remove() throws Throwable {
		scobj=new ShoppingCartPageFactory(driver);
	    scobj.removeItem();
	}

	@When("^clicks on the update button$")
	public void clicks_on_the_update_button() throws Throwable {
	    scobj.updateCart();
	}

	@Then("^Cart should be updated$")
	public void cart_should_be_updated() throws Throwable {
	   String actual=scobj.cartMessage();
	   Assert.assertEquals(actual, "Your Shopping Cart is empty!");
	}





}
