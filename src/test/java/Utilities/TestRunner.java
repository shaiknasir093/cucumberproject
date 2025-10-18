package Utilities;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".//Features/",
    glue = "StepDefinition",
   // plugin = {"pretty", "html:Reports/cucumber-html-report.html"},
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    tags="@sanity",
    dryRun=false,
    monochrome = true
)
public class TestRunner {
}


