package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",    // Path to .feature files
        glue = {"stepdefinition"},                  // Step definitions + Hooks package
        plugin = {
                "pretty", 
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber.json",         // JSON report
                "junit:target/cucumber.xml"          // JUnit report
        },
        monochrome = true,                           // Cleaner console output
        publish = true                               // Publish report link in console
)
public class TestRunner {
    // Empty class → JUnit + Cucumber will handle execution
}
