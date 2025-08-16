package test;


import org.testng.annotations.Test;
import Pages.DEmoLogin;
import Utils.BasetEST;

public class FinalTest extends BasetEST {

    @Test
    public void validLoginTest() {
        // Create object of the Login Page
        DEmoLogin loginPage = new DEmoLogin(driver);

        // Pass parameterized values
        loginPage.login("admin", "admin123");
    }
}
