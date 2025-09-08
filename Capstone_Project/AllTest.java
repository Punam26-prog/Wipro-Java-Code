package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({tests.MyListener.class, tests.MyExtentListener.class})

public class AllTest {
	
	 WebDriver driver;
	    String dynamicEmail; // To reuse for login after registration

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.nopcommerce.com/");
	    }

	    @Test(priority = 1)
	    public void launchBrowserTest() {
	        String title = driver.getTitle();
	        System.out.println("Page Title: " + title);
	        Assert.assertTrue(title.contains("nopCommerce"));
	    }

	    @Test(priority = 2)
	    public void userCanRegisterSuccessfully() throws IOException {
	        // open register page
	        driver.findElement(By.cssSelector("a.ico-register")).click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));

	        // Excel file path
	        String excelPath = "C:\\Users\\PC\\Downloads\\login.xlsx";
	        ExcelUtils excel = new ExcelUtils();

	        // Generate unique email and password (store to class variable)
	        dynamicEmail = "user" + System.currentTimeMillis() + "@gmail.com";
	        String password = "Password123!";

	        // Optional: select gender if present
	        try {
	            WebElement genderMale = driver.findElement(By.id("gender-male"));
	            if (!genderMale.isSelected()) {
	                genderMale.click();
	            }
	        } catch (Exception ignored) {}

	        // Fill registration form (clear before sendKeys for safety)
	        WebElement firstName = driver.findElement(By.id("FirstName"));
	        firstName.clear();
	        firstName.sendKeys("Punam ");

	        WebElement lastName = driver.findElement(By.id("LastName"));
	        lastName.clear();
	        lastName.sendKeys("Kumari");

	        WebElement emailInput = driver.findElement(By.id("Email"));
	        emailInput.clear();
	        emailInput.sendKeys(dynamicEmail);

	        WebElement passwordInput = driver.findElement(By.id("Password"));
	        passwordInput.clear();
	        passwordInput.sendKeys(password);

	        WebElement confirmInput = driver.findElement(By.id("ConfirmPassword"));
	        confirmInput.clear();
	        confirmInput.sendKeys(password);

	        // Submit registration
	        driver.findElement(By.id("register-button")).click();

	        // Wait for and assert success message
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result")));
	        String resultText = driver.findElement(By.cssSelector("div.result")).getText();
	        Assert.assertTrue(resultText.toLowerCase().contains("your registration completed"),
	                "Registration not successful. Actual message: " + resultText);

	        // Click Continue (wait until clickable) and then logout
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.button-1.register-continue-button"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-logout"))).click();

	        // Save credentials to Excel (wrapped in try/catch so test won't crash if Excel write fails)
	        try {
	            excel.overwriteData(excelPath, "Sheet1", dynamicEmail, password);
	        } catch (Exception e) {
	            System.err.println("Failed to write credentials to Excel: " + e.getMessage());
	            e.printStackTrace();
	        }

	        System.out.println("Registered with new Email: " + dynamicEmail);
	    }

	    @Test(priority = 3)
	    public void userCanLogin() throws IOException {
	        String excelPath = "C:\\Users\\PC\\Downloads\\login.xlsx";
	        ExcelUtils excel = new ExcelUtils();

	        // Read credentials from Excel
	        String email = excel.getCellData(excelPath, "Sheet1", 1, 0);
	        String password = excel.getCellData(excelPath, "Sheet1", 1, 1);

	        // Perform login
	        driver.findElement(By.className("ico-login")).click();
	        driver.findElement(By.id("Email")).sendKeys(email);
	        driver.findElement(By.id("Password")).sendKeys(password);
	        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	        try {
	            Alert myAlert = driver.switchTo().alert(); 
	            System.out.println("Alert found: " + myAlert.getText());
	            myAlert.accept(); 
	            System.out.println("Alert accepted successfully.");
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present, nothing to accept.");
	        }
	    }

	    @Test(priority = 4)
	    public void addProductToCart() throws InterruptedException {
	        Actions action = new Actions(driver);
	        WebElement web = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
	        action.moveToElement(web).perform();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")).click();
	        driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[1]")).click();
	        Thread.sleep(2000);
	    }

	    @Test(priority = 5)
	    public void productpage_dropdown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,300)", "");
	        WebElement ramDropdown = driver.findElement(By.id("product_attribute_2"));
	        Select select = new Select(ramDropdown);
	        select.selectByVisibleText("8GB [+$60.00]");
	    }

	    @Test(priority = 6)
	    public void productpage_radiobutton() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        driver.findElement(By.id("product_attribute_3_6")).click();
	        js.executeScript("window.scrollBy(0,400)", "");
	        driver.findElement(By.id("add-to-cart-button-1")).click();
	    }

	    @Test(priority = 7)
	    public void productpage_addtocart() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,-800)", "");
	        driver.findElement(By.xpath("//span[@class='cart-qty']")).click();
	    }

	    @Test(priority = 8)
	    public void Shopping_cart_Quantity() throws InterruptedException {
	        WebElement qtyBox = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
	        qtyBox.clear();
	        qtyBox.sendKeys("2");
	        driver.findElement(By.name("updatecart")).click();
	        Thread.sleep(200);
	    }

	    @Test(priority = 9)
	    public void shipping() {
	        driver.findElement(By.id("open-estimate-shipping-popup")).click();
	    }

	    @Test(priority = 10)
	    public void shipping_address() throws InterruptedException {
	        WebElement countryDropdown = driver.findElement(By.id("CountryId"));
	        Select select = new Select(countryDropdown);
	        select.selectByVisibleText("India");

	        driver.findElement(By.id("ZipPostalCode")).sendKeys("505305");
	        Thread.sleep(2000);

	        driver.findElement(By.xpath("//div[normalize-space()='Next Day Air']")).click();
	        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
	    }

	    @Test(priority = 11)
	    public void checkout() {
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
	         js.executeScript("window.scrollBy(0,400)", "");
	        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	        driver.findElement(By.xpath("//button[@id='checkout']")).click();
	    }

	    @Test(priority = 12)
	    public void digital_downloads() throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Use desktop menu locator
	        WebElement digitalDownloads = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
	            )
	        );
	        
	        digitalDownloads.click();
	        Thread.sleep(2000);
	    }
	    
	    @Test(priority = 13)
	    public void books() {
	        driver.findElement(By.xpath("//a[normalize-space()='Books']")).click();
	    }

//	    @AfterClass
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }

        
}

