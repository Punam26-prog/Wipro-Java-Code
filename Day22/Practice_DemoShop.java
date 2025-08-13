package DemoWebShop;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class Practice_DemoShop {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://demowebshop.tricentis.com/";
    private final String email = "marval01@gmail.com";
    private final String password = "IronMan";
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    private void login() {
        driver.findElement(By.linkText("Log in")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.login-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
    }

    @Test(priority = 1)
    public void testRegister() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Marvel");
        driver.findElement(By.id("LastName")).sendKeys("User");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result")));
        Assert.assertTrue(result.getText().contains("Your registration completed"), "Registration failed");

        driver.findElement(By.linkText("Log out")).click();
    }

    @Test(priority = 2)
    public void testLoginLogout() {
        login();
        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed(), "Login failed");

        driver.findElement(By.linkText("Log out")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed(), "Logout failed");
    }

    @Test(priority = 3)
    public void testGiftCardPurchase() {
        driver.get(baseUrl); 
        login();

        driver.findElement(By.linkText("Gift Cards")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("$25 Virtual Gift Card"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("giftcard_43_RecipientName"))).sendKeys("Recipient");
        driver.findElement(By.id("giftcard_43_RecipientEmail")).sendKeys("recipient@example.com");
        driver.findElement(By.id("giftcard_43_SenderName")).clear();
        driver.findElement(By.id("giftcard_43_SenderName")).sendKeys("Sender");
        driver.findElement(By.id("giftcard_43_SenderEmail")).clear();
        driver.findElement(By.id("giftcard_43_SenderEmail")).sendKeys(email);
        driver.findElement(By.id("giftcard_43_Message")).sendKeys("Enjoy your gift!");

        driver.findElement(By.id("add-to-cart-button-43")).click();

        WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
        Assert.assertTrue(notif.getText().contains("The product has been added to your shopping cart"), "Gift card not added to cart");

        WebElement cartQty = driver.findElement(By.cssSelector("span.cart-qty"));
        String qtyText = cartQty.getText().replace("(", "").replace(")", "");
        Assert.assertTrue(Integer.parseInt(qtyText) > 0, "Cart is still empty after adding gift card");
    }
}