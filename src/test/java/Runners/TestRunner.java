package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
features = "C:\\Hima\\java_capgemini\\DemoWebShopMaven\\src\\test\\java\\features"
,glue={"StepDefinitions"}
,tags={"@SuccessfulLogin,@UnsuccessfulLogin"}
,plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"}



)
public class TestRunner extends AbstractTestNGCucumberTests {

}
