package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{

	//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Elements
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccount;
	
	@FindBy(linkText="Register")
	WebElement register;
	
	@FindBy(linkText="Login") //login link added
	WebElement linkLogin;
	
	
	
	
	//ActionMethods
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickRegister()
	{
		register.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	
	
}
