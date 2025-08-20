package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/login.feature",   // Path to feature file
    glue = "stepDefinition",                                  // Step definitions package
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true                                         // Make console output readable
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
