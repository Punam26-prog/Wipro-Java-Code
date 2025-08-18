package Day_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFile {
	WebDriver driver;

    @Test(dataProvider = "getdata", dataProviderClass = ExcelDataProvider.class)
    public void loginTest(String userName, String password) throws InterruptedException {
        System.out.println("Launching the browser.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        System.out.println("Trying login with: " + userName + " / " + password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        Thread.sleep(2000);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
            System.out.println("✅ Login successful for user: " + userName);
        } catch (Exception e) {
            String errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")).getText();
            System.out.println("❌ Login failed for user: " + userName + " | Message: " + errorMsg);
            Assert.fail("Login failed for user: " + userName);
        }

        driver.quit();
    }
}
