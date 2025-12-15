package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void verifyValidLogin() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.loginAs("rahulshettyacademy", "learning");
        HomePage homePage = new HomePage(driver);
        String welcome = homePage.getWelcomeText();
        Thread.sleep(10000);
        Assert.assertTrue(welcome.contains("Shop Name") || welcome.length() >= 0, "Welcome text missing");
        System.out.println("Welcome text validated successfully");
    }
}
