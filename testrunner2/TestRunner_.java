package testrunner2;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\amazon.feature",
glue = "org.stepdefinition2",dryRun = false,plugin = {"html:Htmlreport/Amazonwebsite","json: JSONREPORT/Amazon"})






public class TestRunner_ {

	
}


//monochrome = false)    //default value is false
//dryRun = false,  //default value is false
//strict = false,
//tags = {"@Smoke"})
//plugin = {"html:Htmlreport/OrangeHrmwesite",
//		 "pretty",
//		 "json:Jsonreport/OrangeHrmwebsite",
//		 "com.cucumber.listener.ExtentCucumberFormatter:ExtentReport/OrangeHrm.Html"})