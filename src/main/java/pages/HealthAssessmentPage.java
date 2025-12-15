package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HealthAssessmentPage extends BasePage {
    // Note: These locators need to be updated based on actual DOM structure
    private final By heightFeetField = By.name("heightFeet");
    private final By heightInchesField = By.name("heightInches");
    private final By weightField = By.name("weight");
    private final By waistField = By.name("waist");
    private final By bloodPressureSystemicField = By.name("bloodPressureSystemic");
    private final By bloodPressureDiastolicField = By.name("bloodPressureDiastolic");
    private final By totalCholesterolField = By.name("totalCholesterol");
    private final By hdlCholesterolField = By.name("hdlCholesterol");
    private final By ldlCholesterolField = By.name("ldlCholesterol");
    private final By triglyceridesField = By.name("triglycerides");
    private final By glucoseField = By.name("glucose");
    private final By submitButton = By.cssSelector("button[type='submit']");

    public HealthAssessmentPage(WebDriver driver) {
        super(driver);
    }

    public HealthAssessmentPage fillBasicDetails(int heightFeet, int heightInches, double weight, int waist) {
        waitAndSendKeys(heightFeetField, String.valueOf(heightFeet));
        waitAndSendKeys(heightInchesField, String.valueOf(heightInches));
        waitAndSendKeys(weightField, String.valueOf(weight));
        waitAndSendKeys(waistField, String.valueOf(waist));
        return this;
    }

    public HealthAssessmentPage fillBloodPressure(int systolic, int diastolic) {
        waitAndSendKeys(bloodPressureSystemicField, String.valueOf(systolic));
        waitAndSendKeys(bloodPressureDiastolicField, String.valueOf(diastolic));
        return this;
    }

    public HealthAssessmentPage fillCholesterolDetails(int total, int hdl, int ldl, int triglycerides) {
        waitAndSendKeys(totalCholesterolField, String.valueOf(total));
        waitAndSendKeys(hdlCholesterolField, String.valueOf(hdl));
        waitAndSendKeys(ldlCholesterolField, String.valueOf(ldl));
        waitAndSendKeys(triglyceridesField, String.valueOf(triglycerides));
        return this;
    }

    public HealthAssessmentPage fillGlucose(int glucose) {
        waitAndSendKeys(glucoseField, String.valueOf(glucose));
        return this;
    }

    // Don't call this method as per requirements
    private void submitAssessment() {
        waitAndClick(submitButton);
    }
}