package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@class='nav-link']")
	WebElement btnLogout1;
	
	
	public void enterEmail(String s)
	{
		email.clear();
		email.sendKeys(s);
	}
	
	public void enterPassword(String p)
	{
		pass.clear();
		pass.sendKeys(p);
	}
	
	
	public void login()
	{
		btnLogin.click();
	}
	
	public void logout() throws InterruptedException 
	{
		Thread.sleep(5000);
		btnLogout1.click();
	}

}
  