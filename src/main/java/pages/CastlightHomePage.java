package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CastlightHomePage extends BasePage {
    private final By wellbeingMenuButton = By.xpath("//button[contains(text(), 'Wellbeing')]");
    private final By waysToEarnLink = By.xpath("//a[contains(text(), 'Ways to Earn')]");
    private final By pointsBalance = By.xpath("//div[contains(@class, 'points-balance')]"); // Update this locator based on actual DOM
    private final By healthAssessmentLink = By.xpath("//a[contains(text(), 'Health Assessment')]");

    public CastlightHomePage(WebDriver driver) {
        super(driver);
    }

    public CastlightHomePage clickWellbeingMenu() {
        WebElement menuElement = waitForElement(wellbeingMenuButton);
        scrollIntoView(menuElement);
        menuElement.click();
        return this;
    }

    public CastlightHomePage clickWaysToEarn() {
        WebElement waysToEarnElement = waitForElement(waysToEarnLink);
        scrollIntoView(waysToEarnElement);
        waysToEarnElement.click();
        return this;
    }

    public String getPointsBalance() {
        WebElement pointsElement = waitForElement(pointsBalance);
        return pointsElement.getText();
    }

    public HealthAssessmentPage clickHealthAssessment() {
        WebElement assessmentLink = waitForElement(healthAssessmentLink);
        scrollIntoView(assessmentLink);
        assessmentLink.click();
        return new HealthAssessmentPage(driver);
    }
}