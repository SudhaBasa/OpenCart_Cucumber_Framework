package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	
	//Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Elements
	
	@FindBy (name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']") //input[@name='agree']
	WebElement chkdPolicy;
	
	//@FindBy(xpath="//button[normalize-space()='Continue']") //button[normalize-space()='Continue']
	//@FindBy(css="button[type='submit']")
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	//Action Methods
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public WebElement getPrivacyPolicy() {
		
		return chkdPolicy;
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmation()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}

	
}
