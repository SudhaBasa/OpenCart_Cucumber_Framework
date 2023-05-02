package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class Steps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage map;
	
	 List<HashMap<String, String>> datamap; //Data Driven
	
	Logger logger; 	// for logging //log4j
	ResourceBundle rb; // for reading properties file  // config file
	String br;  //to store browser name
	
	
	@Before
	public void setup()    // it excutes once before starting
	{
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		// for logging
	logger=LogManager.getLogger(this.getClass());
	
	//to read data from config.properties
	rb=ResourceBundle.getBundle("config");
	br=rb.getString("browser");	
	}
	
	
	@After
	public void tearDown(Scenario scenario)  //it executes once after finishing
	{
		System.out.println("Scenario Status"+ scenario.getStatus());
		
		if (scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}
	

@Given("User Launch Browser")
public void user_launch_browser()
{
    if(br.equals("chrome"))
    		{
    			driver=new ChromeDriver();
    		}
    else if(br.equals("edge"))
    {
    	driver=new EdgeDriver();
    }
    else
    {
    	driver=new FirefoxDriver();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  	
}


@Given("Opens URL {string}")
public void opens_url(String url)
{
driver.get(url);
driver.manage().window().maximize();
}


@When("User Navigates to My Account menu")
public void user_navigates_to_my_account_menu()
{
	hp=new HomePage(driver);
	hp.clickMyAccount();
	
	logger.info("Clicked on My Account");
}


@When("click on Login")
public void click_on_login() 
{
hp.clickLogin();

logger.info("Clicked on Login");
}


@When("User enters email as {string} and password as {string}")
public void user_enters_email_as_and_password_as(String email, String password) 
{
lp=new LoginPage(driver);

lp.setEmail(email);
lp.setPassword(password);

logger.info("Provided Email and Password");
}


@When("Click on Login button")
public void click_on_login_button() 
{
	lp.clickLogin();
	logger.info("Clicked on Login Button");
}


@Then("User navigates to MyAccount Page")
public void user_navigates_to_my_account_page()
{
	
map=new MyAccountPage(driver);

boolean targetPage=map.isMyAccountPageExist();
	if(targetPage)
	{
	logger.info("Login Success");
	Assert.assertTrue(true);
	}
	else
	{
	logger.info("Login Failed");
	Assert.assertTrue(false);
	}
}



//*******   Data Driven test method    **************
@Then("check User navigates to MyAccount Page by passing Email and Password with excel row {string}")
public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
{
    datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

    int index=Integer.parseInt(rows)-1;
    String email= datamap.get(index).get("username");
    String pwd= datamap.get(index).get("password");
    String result= datamap.get(index).get("result");

    lp=new LoginPage(driver);
    lp.setEmail(email);
    lp.setPassword(pwd);

    lp.clickLogin();
    try
    {
        boolean targetpage=map.isMyAccountPageExist();

        if(result.equals("Valid"))
        {
            if(targetpage==true)
            {
                MyAccountPage map=new MyAccountPage(driver);
                map.clickLogout();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }

        if(result.equals("Invalid"))
        {
            if(targetpage==true)
            {
                map.clickLogout();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }


    }
    catch(Exception e)
    {

        Assert.assertTrue(false);
    }
    driver.close();
}

//*******   Account Registration Methods    **************




}
