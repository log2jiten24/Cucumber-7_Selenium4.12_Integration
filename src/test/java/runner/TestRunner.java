package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.qa.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json",},
        monochrome = true,
        publish = true)
//to run the tests in parallel mode
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}