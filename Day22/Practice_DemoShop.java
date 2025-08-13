package DemoWebShop;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Practice_DemoShop {
	 private WebDriver driver;
	    private final String baseUrl = "https://demowebshop.tricentis.com/";
	    private final String email = "marval01@gmail.com";
	    private final String password = "IronMan";

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(baseUrl);
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) driver.quit();
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

	        WebElement result = driver.findElement(By.cssSelector(".result"));
	        Assert.assertTrue(result.getText().contains("Your registration completed"), "Registration failed");

	        driver.findElement(By.linkText("Log out")).click();
	    }

	    @Test(priority = 2)
	    public void testLoginLogout() {
	        driver.findElement(By.linkText("Log in")).click();
	        driver.findElement(By.id("Email")).sendKeys(email);
	        driver.findElement(By.id("Password")).sendKeys(password);
	        driver.findElement(By.cssSelector("input.login-button")).click();

	        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed(), "Login failed");

	        driver.findElement(By.linkText("Log out")).click();
	        Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed(), "Logout failed");
	    }

	    @Test(priority = 3)
	    public void testGiftCardPurchase() {
	        driver.findElement(By.linkText("Log in")).click();
	        driver.findElement(By.id("Email")).sendKeys(email);
	        driver.findElement(By.id("Password")).sendKeys(password);
	        driver.findElement(By.cssSelector("input.login-button")).click();
	        driver.findElement(By.linkText("Gift Cards")).click();
	        driver.findElement(By.linkText("$25 Virtual Gift Card")).click();

	        driver.findElement(By.id("giftcard_43_RecipientName")).sendKeys("Recipient");
	        driver.findElement(By.id("giftcard_43_RecipientEmail")).sendKeys("recipient@example.com");
	        driver.findElement(By.id("giftcard_43_SenderName")).sendKeys("Sender");
	        driver.findElement(By.id("giftcard_43_SenderEmail")).sendKeys(email);
	        driver.findElement(By.id("giftcard_43_Message")).sendKeys("Enjoy your gift!");

	        driver.findElement(By.id("add-to-cart-button-43")).click();

	        WebElement notif = driver.findElement(By.cssSelector(".bar-notification.success"));
	        Assert.assertTrue(notif.getText().contains("The product has been added to your shopping cart"), "Gift card not added to cart");
	    }
	
}
