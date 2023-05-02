package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	//constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement linkLogout;
	
	
	//ActionMethods
	
	public boolean isMyAccountPageExist() //my account page heading
	{
		try
		{
			boolean msg=msgHeading.isDisplayed();
			return msg;
			
		// (or)
		//	return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	
}
