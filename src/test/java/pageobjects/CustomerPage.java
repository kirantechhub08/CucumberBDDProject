package pageobjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	
	public WebDriver driver;
	
	public CustomerPage(WebDriver rdriver)
	{
       driver=rdriver;
       PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;

	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddNew;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap'")
	WebElement txtCustomerRole;
	
	@FindBy(xpath="//li[contains(text(),'Administrators')")
	WebElement lstItemAdministrator;
	
	@FindBy(xpath="//li[contains(text(),'Registered')")
	WebElement lstItemRegister;
	
	@FindBy(xpath="//li[contains(text(),'Guests')")
	WebElement lstItemGuest;
	
	
	@FindBy(xpath="//*[@id=''VendorId]")
	WebElement dropdownVendor;
	
	
	@FindBy(id="Gender_Male")
	WebElement male;
	
	@FindBy(id="Gender_Female")
	WebElement female;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtDob;
	
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompanyName;
	
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
    WebElement txtAdminContent;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;
	
	public void enterDOB(String s)
	{
		txtDob.sendKeys(s);
	}
	
	public void enterCompanyName(String s1)
	{
		txtCompanyName.sendKeys(s1);
	}
	
	public String getPageTitle()
	{
	   return driver.getTitle();
	}
	
	
	public void clickOnCustomersMenu()
	{
		lnkCustomers_menu.click();
	}

	public void clickOnCustomersMenuItem()
	{
		lnkCustomers_menuitem.click();
	}
	
	public void clickOnAddNew()
	{
		btnAddNew.click();
	}
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	
	public void enterFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void enterGender()
	{
		male.click();
	}
	
	public void selectRole(String role)
	{
		txtCustomerRole.sendKeys(role);
	}
	
	public void save()
	{
		btnSave.click();
	}
	
	
	public String generateRandomString()
	{
		return RandomStringUtils.randomAlphanumeric(8);
	}
}
