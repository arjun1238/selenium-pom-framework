package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

   private final By usernameInput = By.id("username");
   private final By passwordInput = By.id("password");
   private final By signInBtn = By.id("signInBtn");
   private final By dropdown=By.xpath("//select[@class='form-control']");
 private final By termsCheckbox=By.id("terms");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAs(String username, String password) {
        
         waitAndSendKeys(usernameInput, username);
         waitAndSendKeys(passwordInput, password);
         waitAndSelect(dropdown, "Student");
         waitAndClick(termsCheckbox);
         waitAndClick(signInBtn);
         //return new HomePage(driver);
    }
}
