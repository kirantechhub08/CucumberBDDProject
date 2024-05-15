package stepdefination;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageobjects.CustomerPage;
import pageobjects.LoginPage;
import pageobjects.SearchCustomerPage;

public class Stepdef extends BaseClass {
	
	
	
	
	
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		log1=LogManager.getLogger("Stefdef");
		log1.info("Setup initiated");
	log1.info("Browser is lanuching...");
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	lp=new LoginPage(driver);
	cp=new CustomerPage(driver);
	}

	@When("user opens url as {string}")
	public void user_opens_url_as(String url) {
		log1.info("Opening the URL");
	   driver.get(url);
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String uname, String pass) {
	  lp.enterEmail(uname);
	  log1.info("username is entered");
	  lp.enterPassword(pass);
	  log1.info("password is entered");
	  
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		
	   lp.login();
	   log1.info("clicked on login button");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	   
	}
	
	@When("user click the logout button")
	public void user_click_the_logout_button() throws InterruptedException {
		lp.logout();
		log1.info("clicked on logout button");
	}

	@Then("Close the browser")
	public void close_the_browser() {
	 driver.close();
	 driver.quit();
	 log1.info("all opened browser windows are closed");
	}
	
	//********Add new Customer****************
	@Then("user can view dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=driver.getTitle();
		String expectedTitle="Dashboard / nopCommerce administration";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() {
	  
	  cp.clickOnCustomersMenu();
	  log1.info("clicked on customers menu");
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		cp.clickOnCustomersMenuItem();
		log1.info("clicked on customers menu item");
			}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	  cp.clickOnAddNew();
	  log1.info("clicked on addnew button");
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		String actual=cp.getPageTitle();
		String expected="Add a new customer / nopCommerce administration";
		
		if(actual.equalsIgnoreCase(expected))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	
	

	@When("user enetr customer info")
	public void user_enetr_customer_info() {
	cp.enterEmail(generateEmail()+ "@gmail.com");
	cp.enterPassword("Abcd@1234");
	cp.enterFirstName("kiran");
	cp.enterLastName("test");
	cp.enterGender();
	cp.enterDOB("6/13/1992");
	cp.enterCompanyName("Figmd");
	log1.info("customer details are entered");
	
	}

	@When("click on save button")
	public void click_on_save_button() {
		cp.save();
		log1.info("save button is clicked");
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String abc) {
		
		
		String actualText=driver.findElement(By.tagName("Body")).getText();
		if(actualText.equals(actualText))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}

	
	//search customer
	@When("Enter customer Email")
	public void enter_customer_email() {
		
		sc.enterEmailAddress("victoria_victoria@nopCommerce.com");
		log1.info("email is entered");
	    
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    sc.clickSearchButton();
	    log1.info("clicked on search button");
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	   
		String expectedEmail="victoria_victoria@nopCommerce.com";
		boolean result=sc.searchRecord(expectedEmail);
		
		if(result==true)
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@AfterStep
	public void screenshot(io.cucumber.java.Scenario sc) throws IOException
	{
		System.out.println("Tear Down Method executed....");
		if(sc.isFailed()==true)
		{
			
			
			
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", sc.getName());
			
			
		}
	}
	
	
	


}
