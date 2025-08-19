package Day_26;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DBTestWithSelenium {
	JdbcUtil jdbcUtil = new JdbcUtil();
	   ResultSet resultSet;
	   WebDriver driver;
	   @BeforeClass
	   public void setup() throws ClassNotFoundException, SQLException {
	       String dbUrl = "jdbc:mysql://localhost:3306/testdb";
	       String user = "root";
	       String pass = "Punam@2610";
	       jdbcUtil.connect(dbUrl, user, pass);
	       driver = new ChromeDriver();
	   }
	   @Test
	   public void readDataAndTest() throws SQLException {
	       String query = "SELECT * FROM users WHERE status='active'";
	       resultSet = jdbcUtil.executeQuery(query);
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       while (resultSet.next()) {
	           String username = resultSet.getString("username");
	           String password = resultSet.getString("password");
	           driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username")));
	           driver.findElement(By.id("ctl00_MainContent_username")).clear();
	           driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
	           driver.findElement(By.id("ctl00_MainContent_password")).clear();
	           driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
	           driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	       }
	   }
	   @AfterClass
	   public void tearDown() throws SQLException {
	       if (driver != null) driver.quit();
	       jdbcUtil.close();
	   }


}
