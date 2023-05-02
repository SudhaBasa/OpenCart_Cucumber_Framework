package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		//features={".//Features/"},
			 features= {".//Features/Login.feature"},
			//features= {".//Features/LoginDDT.feature"},
			//features= {".//Features/LoginBDDExcel.feature"},
			//features= {".//Features/Login.feature", ".//Features/AccountRegistration.feature"},
			//features="@target/rerun.txt", //Runs only failures
			glue="stepDefinitions" ,
			plugin= {"pretty", "html:reports/myreport.html","json:reports/myreport,json"},

			dryRun=false,
			monochrome=true
			//tags="@Sanity"  								//Scenarios tagged with @Sanity
			//tags="@Sanity and @regression" 	//Scenarios tagged with both @Sanity and @Regression
			//tags="@Sanity" or @regression"	 	// Scenarios tagged with either @sanity or @regression
			





)


public class TestRunner
{

	
}
