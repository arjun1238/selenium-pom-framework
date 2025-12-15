package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CastlightLoginPage extends BasePage {
    private final By emailField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public CastlightLoginPage(WebDriver driver) {
        super(driver);
    }

    public CastlightLoginPage open() {
        driver.get("https://us.castlighthealth.com/");
        return this;
    }

    public CastlightHomePage login(String email, String password) {
        WebElement emailElement = waitForElement(emailField);
        WebElement passwordElement = waitForElement(passwordField);
        
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        
        waitForElement(loginButton).click();
        
        return new CastlightHomePage(driver);
    }
}