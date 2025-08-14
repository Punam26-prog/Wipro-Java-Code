package nopcommerce;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.UUID;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    private String createdEmployeeFullName;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1, groups = "regression")
    public void loginTest() {
        driver.get(baseUrl);

        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='username']")));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        username.clear();
        username.sendKeys("Admin");
        password.clear();
        password.sendKeys("admin123");
        submit.click();

        boolean loggedIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("header"))) != null;
        Assert.assertTrue(loggedIn, "Login failed.");
    }

    @Test(priority = 2, groups = "regression", dependsOnMethods = "loginTest")
    public void addEmployeeTest() {
        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']/ancestor::a")));
        pimMenu.click();

        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));
        addBtn.click();

        String firstName = "Selenium";
        String lastName = "User" + UUID.randomUUID().toString().substring(0,5);
        createdEmployeeFullName = firstName + " " + lastName;

        WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        WebElement lastNameInput = driver.findElement(By.name("lastName"));

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        WebElement saveBtn = driver.findElement(By.xpath("//button[@type='submit' and contains(.,'Save')]"));
        saveBtn.click();

        By displayNameLocator = By.xpath("//*[contains(text(),'" + firstName + "') and contains(text(),'" + lastName + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(displayNameLocator));

        Assert.assertTrue(driver.getPageSource().contains(firstName), "Employee creation failed.");
    }

    @Test(priority = 3, groups = "regression", dependsOnMethods = "addEmployeeTest")
    public void searchEmployeeTest() {
        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']/ancestor::a")));
        pimMenu.click();

        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder*='Employee Name']")));
        nameInput.clear();
        nameInput.sendKeys(createdEmployeeFullName);
        nameInput.sendKeys(Keys.ENTER);

        WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        searchBtn.click();

        By rowLocator = By.xpath("//div[contains(@class,'oxd-table-body')]//div[contains(.,'" + createdEmployeeFullName + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(rowLocator));

        Assert.assertTrue(driver.getPageSource().contains(createdEmployeeFullName), "Employee not found.");
    }

    @Test(priority = 4, groups = "regression", dependsOnMethods = "searchEmployeeTest")
    public void logoutTest() {
        WebElement userDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-userdropdown-name")));
        userDropdown.click();
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
        logout.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='username']")));
    }

    @Test(enabled = false) // Ignored test
    public void ignoredTestExample() {
        System.out.println("This test will be skipped because it's disabled.");
    }
}