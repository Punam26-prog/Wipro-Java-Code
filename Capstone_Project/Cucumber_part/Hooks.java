package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;


public class Hooks {
	public static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
