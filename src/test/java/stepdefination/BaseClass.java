package stepdefination;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageobjects.CustomerPage;
import pageobjects.LoginPage;
import pageobjects.SearchCustomerPage;

public class BaseClass {
	
	//common variables and methods
	
	public LoginPage lp;
	public WebDriver driver;
	
	public CustomerPage cp;
	public SearchCustomerPage sc;
	public static Logger log1;
	
	
	public String generateEmail()
	{
		return RandomStringUtils.randomAlphabetic(8);
	}

}
