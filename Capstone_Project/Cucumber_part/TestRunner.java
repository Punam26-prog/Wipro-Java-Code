package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Cucumber + TestNG Runner
@CucumberOptions(
        features = "src/test/resources/features",       // Path of your .feature files
        glue = {"stepdefinition"},                     // Package where your step defs + hooks are
        plugin = {"pretty","html:target/cucumber-report.html",
                  "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}



