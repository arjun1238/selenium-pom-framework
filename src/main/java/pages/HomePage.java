package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath  = "//h1[text()='Shop Name']")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText() {
        try {
            return welcomeMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
