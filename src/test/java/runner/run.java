package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//features/"}, 
glue = "stepdefination", 
dryRun = false, 
monochrome = true,
tags = "@sanity",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//plugin = {"pretty", 
		//"html:target/cucumber-report/cucumberhtmlreport.html" }
)


//to run multiple features files need to specify the features folder path else need to specify the file name
//e.g., .//features/

//to run multiple tags use and or operator 
// tags="@sanity and @regression or @ui"

// if you write the @sanity and @regression then it will run only those scenarios mentioned with @sanity @Regression
//@sanity @Regression
//Scenario:
	

public class run {

}
