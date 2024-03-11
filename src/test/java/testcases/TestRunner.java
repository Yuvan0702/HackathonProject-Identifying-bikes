package testcases;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
			//features= {".//feature_files/Feature.feature"},
		features= {"C:\\Users\\2303749\\eclipse-workspace\\hackathon\\src\\test\\resources\\feature_files\\Feature.feature"},
			glue="stepdefinitions",
		
			plugin= {"pretty",
					"html:report/myCucumberReport.html",
					"rerun:target/rerun.txt",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			
			)
	 
	public class TestRunner {
		
	 
	}

