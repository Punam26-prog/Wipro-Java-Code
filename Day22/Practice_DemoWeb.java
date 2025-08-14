package DemoWebShop;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class Practice_DemoWeb {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://demowebshop.tricentis.com/";
    private final String email = "marval01@gmail.com"; 
    private final String password = "IronMan";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void testRegister() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Tony");
        driver.findElement(By.id("LastName")).sendKeys("Stark");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();

        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
            Assert.assertTrue(result.getText().contains("Your registration completed"));
            driver.findElement(By.linkText("Log out")).click();
        } catch (TimeoutException e) {
            driver.findElement(By.linkText("Log in")).click();
            driver.findElement(By.id("Email")).sendKeys(email);
            driver.findElement(By.id("Password")).sendKeys(password);
            driver.findElement(By.cssSelector("input.button-1.login-button")).click();
        }
    }

    @Test(priority = 2)
    public void testLoginAndLogout() {
        if (!driver.findElements(By.linkText("Log out")).isEmpty()) {
            driver.findElement(By.linkText("Log out")).click();
        }
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

        driver.findElement(By.linkText("Log out")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
    }

    @Test(priority = 3)
    public void testGiftCardsSectionAndAddToCart() {
        // Login first
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        // Navigate to Gift Cards page
        driver.findElement(By.linkText("Gift Cards")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("gift-cards"));

        // Loop through each gift card
        List<WebElement> productLinks = driver.findElements(By.cssSelector(".product-title a"));
        for (int i = 0; i < productLinks.size(); i++) {
            productLinks = driver.findElements(By.cssSelector(".product-title a")); // Refresh list
            String productName = productLinks.get(i).getText();
            productLinks.get(i).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-name")));

            // Fill required recipient details (for physical and virtual gift cards)
            if (!driver.findElements(By.id("giftcard_43_RecipientName")).isEmpty()) {
                driver.findElement(By.id("giftcard_43_RecipientName")).clear();
                driver.findElement(By.id("giftcard_43_RecipientName")).sendKeys("Bruce Wayne");
                driver.findElement(By.id("giftcard_43_RecipientEmail")).clear();
                driver.findElement(By.id("giftcard_43_RecipientEmail")).sendKeys("bruce.wayne@example.com");
                driver.findElement(By.id("giftcard_43_Message")).sendKeys("Happy Birthday!");
            }
            if (!driver.findElements(By.id("giftcard_44_RecipientName")).isEmpty()) {
                driver.findElement(By.id("giftcard_44_RecipientName")).clear();
                driver.findElement(By.id("giftcard_44_RecipientName")).sendKeys("Clark Kent");
                driver.findElement(By.id("giftcard_44_RecipientEmail")).clear();
                driver.findElement(By.id("giftcard_44_RecipientEmail")).sendKeys("clark.kent@example.com");
                driver.findElement(By.id("giftcard_44_Message")).sendKeys("Enjoy your gift!");
            }

            // Add to cart
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Add to cart']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
            addToCartBtn.click();

            // Validate success notification
            WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
            Assert.assertTrue(notif.getText().contains("The product has been added"), "Add to cart failed for: " + productName);

            notif.findElement(By.cssSelector(".close")).click();
            wait.until(ExpectedConditions.invisibilityOf(notif));

            driver.navigate().back();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}