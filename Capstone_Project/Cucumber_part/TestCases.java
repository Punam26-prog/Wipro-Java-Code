package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class TestCases {
	
	 WebDriver driver = Hooks.driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // --- Registration ---
	    @Given("I am on the registration page")
	    public void i_am_on_the_registration_page() {
	        driver.findElement(By.cssSelector("a.ico-register")).click();
	    }

	    @When("I register with valid details")
	    public void i_register_with_valid_details() {
	        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
	        firstName.clear();
	        firstName.sendKeys("Punam");

	        WebElement lastName = driver.findElement(By.id("LastName"));
	        lastName.clear();
	        lastName.sendKeys("Kumari");

	        WebElement emailInput = driver.findElement(By.id("Email"));
	        emailInput.clear();
	        emailInput.sendKeys("user" + System.currentTimeMillis() + "@gmail.com");

	        WebElement passwordInput = driver.findElement(By.id("Password"));
	        passwordInput.clear();
	        passwordInput.sendKeys("password@123");

	        WebElement confirmInput = driver.findElement(By.id("ConfirmPassword"));
	        confirmInput.clear();
	        confirmInput.sendKeys("password@123");

	        driver.findElement(By.id("register-button")).click();
	    }

	    @Then("I should see registration success")
	    public void i_should_see_registration_success() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result")));
	        String resultText = driver.findElement(By.cssSelector("div.result")).getText();
	        Assert.assertTrue(resultText.toLowerCase().contains("your registration completed"));
	    }

	    // --- Add Product to Cart ---
	    @Given("I am on the Desktops category page")
	    public void i_am_on_the_desktops_category_page() {
	        Actions action = new Actions(driver);
	        WebElement web = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")));
	        action.moveToElement(web).perform();

	        WebElement desktops = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")));
	        desktops.click();
	    }

	    @When("I add a desktop product to the cart")
	    public void i_add_a_desktop_product_to_the_cart() {
	        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("(//button[contains(text(),'Add to cart')])[1]")));
	        addToCartBtn.click();
	    }

	    @Then("The product should be added to the cart")
	    public void the_product_should_be_added_to_the_cart() {
	        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='cart-qty']")).isDisplayed());
	    }

	    // --- Product Dropdown ---
	 // --- Product Details Navigation ---
	    @Given("I am on a product details page")
	    public void i_am_on_a_product_details_page() {
	        // Navigate to Desktops category first
	        Actions action = new Actions(driver);
	        WebElement web = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
	        action.moveToElement(web).perform();

	        // Click Desktops link
	        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")).click();

	        // Click the first product in Desktops
	        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	        WebElement firstProduct = wait.until(
	                ExpectedConditions.elementToBeClickable(By.xpath("(//h2[@class='product-title']/a)[1]"))
	        );
	        firstProduct.click();
	    }


	    @When("I select 8GB RAM option from dropdown")
	    public void i_select_8gb_ram_option_from_dropdown() {
	        WebElement ramDropdown = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("product_attribute_2"))
	        );
	        Select select = new Select(ramDropdown);
	        select.selectByVisibleText("8GB [+$60.00]");
	    }


	    @Then("The dropdown selection should be applied")
	    public void the_dropdown_selection_should_be_applied() {
	        WebElement ramDropdown = driver.findElement(By.id("product_attribute_2"));
	        Select select = new Select(ramDropdown);
	        Assert.assertEquals(select.getFirstSelectedOption().getText(), "8GB [+$60.00]");
	    }

	    // --- Product Radio Button ---
	    @When("I select HDD option")
	    public void i_select_hdd_option() {
	        WebElement hddOption = wait.until(
	                ExpectedConditions.elementToBeClickable(By.id("product_attribute_3_6"))
	        );
	        hddOption.click();
	    }


	    @When("I add the product to the cart")
	    public void i_add_the_product_to_the_cart() {
	        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-1")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        addToCartBtn.click();
	    }

	    @Then("The product should be added with HDD option")
	    public void the_product_should_be_added_with_hdd_option() {
	        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='cart-qty']")).isDisplayed());
	    }

	    // --- Open Cart Page ---
	    @Given("I am on the home page")
	    public void i_am_on_the_home_page() {
	        driver.get("https://demo.nopcommerce.com/");
	    }

	    @When("I open the shopping cart")
	    public void i_open_the_shopping_cart() {
	        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cart-qty']")));
	        cartIcon.click();
	    }

	    @Then("The shopping cart should be displayed")
	    public void the_shopping_cart_should_be_displayed() {
	        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	    }

}
