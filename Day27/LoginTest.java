package tests;

	import org.testng.Assert;
	import org.testng.annotations.Test;
	import Pages.HomePage;
	import Pages.LoginPage;
	import base.BaseTest;

	public class LoginTest extends BaseTest {

	    @Test
	    public void verifyValidLogin() {
	       
	        LoginPage LoginPage = new LoginPage(driver);
	        LoginPage.enterUsername("john");   // Parabank demo user
	        LoginPage.enterPassword("demo");   // Parabank demo password
	        LoginPage.clickLogin();

	        // Step 2: Navigate to home page and get welcome text
	        HomePage homePage = new HomePage(driver);
	        String welcomeText = homePage.getWelcomeText();

	        // Step 3: Assert that login is successful
	        Assert.assertTrue(welcomeText.contains("Welcome"),
	            "Login failed - Welcome text not found!");
	    }
	}



