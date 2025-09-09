package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",    
        glue = {"stepdefinition"},                
        plugin = {
                "pretty", 
                "html:target/cucumber-reports.html", 
                "json:target/cucumber.json",        
                "junit:target/cucumber.xml"        
        },
        monochrome = true,                           
        publish = true                              
)
public class TestRunner {
    // Empty class → JUnit + Cucumber will handle execution
}

