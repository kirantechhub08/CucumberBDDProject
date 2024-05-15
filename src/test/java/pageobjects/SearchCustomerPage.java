package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	public WebDriver driver;
	
	public SearchCustomerPage(WebDriver rDriver)
	{
		driver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="SearchEmail")
	public WebElement searchEmail;
	
	@FindBy(id="search-customers")
	public WebElement searchCustomer;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	public WebElement searchResult;
	
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRow;
	
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr/td")
	List<WebElement> tableCol;
	
	public void enterEmailAddress(String emailadd)
	{
		searchEmail.sendKeys(emailadd);
	}
	
	public void clickSearchButton()
	{
		searchCustomer.click();
	}
	
	public boolean searchRecord(String emailadd)
	{
	    boolean found=false;	
	
		for(int i=1;i<=tableRow.size(); i++)
		{
			WebElement webelementEmail= driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td"));
		    String actualEmail=webelementEmail.getText();
		    
		    if(actualEmail.equals(emailadd))
		    {
		    	found=true;
		    }    
		    
		
		}
		
		return found;
	}
	
	

}
