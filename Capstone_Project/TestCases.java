package stepdefinition;

public class TestCases {
	
    import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.*;
	import org.testng.Assert;

	import io.cucumber.java.en.*;
	import stepdefinition.ExcelUtils;

		WebDriver driver = Hooks.driver;

	    WebDriverWait wait;
	    String dynamicEmail;
	    String password = "Password123!";

	    @Given("user launches Chrome browser")
	    public void user_launches_chrome_browser() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @When("user opens nopCommerce homepage")
	    public void user_opens_homepage() {
	        driver.get("https://demo.nopcommerce.com/");
	    }

	    @Then("page title should contain {string}")
	    public void verify_page_title(String expected) {
	        String title = driver.getTitle();
	        Assert.assertTrue(title.contains(expected));
	    }

	    @Given("user navigates to Register page")
	    public void go_to_register() {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-register"))).click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
	    }

	    @When("user enters valid details and registers")
	    public void register_user() throws IOException {
	        dynamicEmail = "user" + System.currentTimeMillis() + "@gmail.com";

	        driver.findElement(By.id("gender-male")).click();
	        driver.findElement(By.id("FirstName")).sendKeys("Akhilesh");
	        driver.findElement(By.id("LastName")).sendKeys("Penjarla");
	        driver.findElement(By.id("Email")).sendKeys(dynamicEmail);
	        driver.findElement(By.id("Password")).sendKeys(password);
	        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

	        driver.findElement(By.id("register-button")).click();
	    }

	    @Then("user should see {string} message")
	    public void verify_registration_message(String expectedMsg) {
	        String actual = driver.findElement(By.cssSelector("div.result")).getText();
	        Assert.assertTrue(actual.contains(expectedMsg));
	    }

	    @Then("credentials should be saved in excel")
	    public void save_credentials() throws Exception {
	        String excelPath = "C:\\Users\\hi\\OneDrive\\Documents\\login.xlsx";
	        ExcelUtils excel = new ExcelUtils();
	        excel.overwriteData(excelPath, "Sheet1", dynamicEmail, password);

	        driver.findElement(By.cssSelector("a.button-1.register-continue-button")).click();
	        driver.findElement(By.cssSelector("a.ico-logout")).click();
	    }

	    @Given("user navigates to Login page")
	    public void go_to_login() {
	        driver.findElement(By.className("ico-login")).click();
	    }

	    @When("user enters stored email and password")
	    public void login_user() throws IOException {
	        String excelPath = "C:\\Users\\hi\\OneDrive\\Documents\\login.xlsx";
	        ExcelUtils excel = new ExcelUtils();
	        String email = excel.getCellData(excelPath, "Sheet1", 1, 0);
	        String pwd = excel.getCellData(excelPath, "Sheet1", 1, 1);

	        driver.findElement(By.id("Email")).sendKeys(email);
	        driver.findElement(By.id("Password")).sendKeys(pwd);
	        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	    }

	    @Then("user should be logged in successfully")
	    public void verify_login() {
	        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
	    }

	    @Given("user navigates to Computers > Desktops")
	    public void navigate_to_desktops() throws InterruptedException {
	        Actions action = new Actions(driver);
	        WebElement web = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
	        action.moveToElement(web).perform();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")).click();
	    }

	    @When("user selects a product and adds to cart")
	    public void add_product_to_cart() throws InterruptedException {
	        driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[1]")).click();
	        Thread.sleep(2000);
	    }

	    @When("user selects product attributes")
	    public void select_product_attributes() {
	        Select select = new Select(driver.findElement(By.id("product_attribute_2")));
	        select.selectByVisibleText("8GB [+$60.00]");
	        driver.findElement(By.id("product_attribute_3_6")).click();
	        driver.findElement(By.id("add-to-cart-button-1")).click();
	    }

	    @Then("product should appear in cart")
	    public void verify_cart() {
	        driver.findElement(By.xpath("//span[@class='cart-qty']")).click();
	        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	    }

	    @Given("user is on the cart page")
	    public void on_cart_page() {
	        driver.findElement(By.xpath("//span[@class='cart-qty']")).click();
	    }

	    @When("user updates quantity")
	    public void update_quantity() {
	        driver.findElement(By.xpath("//div[@id='quantity-up-125']")).click();
	    }

	    @When("applies shipping estimate")
	    public void apply_shipping() {
	        driver.findElement(By.id("open-estimate-shipping-popup")).click();
	        new Select(driver.findElement(By.id("CountryId"))).selectByVisibleText("India");
	        driver.findElement(By.id("ZipPostalCode")).sendKeys("505305");
	        driver.findElement(By.xpath("//div[normalize-space()='Next Day Air']")).click();
	        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
	    }

	    @When("accepts terms and proceeds to checkout")
	    public void proceed_checkout() {
	        driver.findElement(By.id("termsofservice")).click();
	        driver.findElement(By.id("checkout")).click();
	    }

	    @Then("checkout page should open successfully")
	    public void verify_checkout_page() {
	        Assert.assertTrue(driver.getTitle().contains("Checkout"));
	    }

	    @When("user navigates to Digital Downloads")
	    public void open_digital_downloads() throws InterruptedException {
	        wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']"))).click();
	    }

	    @Then("digital downloads page should load")
	    public void verify_digital_downloads() {
	        Assert.assertTrue(driver.getTitle().contains("Digital downloads"));
	    }

	    @When("user navigates to Books")
	    public void open_books() throws InterruptedException {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Books']"))).click();
	    }

	    @Then("books page should load")
	    public void verify_books() {
	        Assert.assertTrue(driver.getTitle().contains("Books"));
	    }
	}

}
