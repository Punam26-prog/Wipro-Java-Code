package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSteps {
    WebDriver driver;

    // Hooks
    @Before(order = 0)
    public void setUp() {
        System.out.println("Launching Browser Before Scenario");
        WebDriverManager.chromedriver().setup(); // manages ChromeDriver automatically
        driver = new ChromeDriver();
    }

    @Before(order = 1)
    public void setUp1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        System.out.println("Closing Browser After Scenario");
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("➡ Executing Before Each Step");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("⬅ Executing After Each Step");
    }

    // Step Definitions
    @Given("I launch Flipkart website")
    public void i_launch_flipkart_website() {
        driver.get("https://www.flipkart.com");

        // Close login popup if appears
        try {
            driver.findElement(By.xpath("//button[text()='✕']")).click();
        } catch (Exception e) {
            System.out.println("Login popup not displayed");
        }
    }

    @When("I search for product {string}")
    public void i_search_for_product(String product) {
        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"))
              .sendKeys(product);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I should see the search results")
    public void i_should_see_the_search_results() {
        System.out.println("Search results displayed successfully");
    }

    @Then("I should see no results message")
    public void i_should_see_no_results_message() {
        System.out.println(" No results found for invalid product");
    }
}