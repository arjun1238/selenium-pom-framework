package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormPage extends BasePage {
    // Form Fields Locators
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("userEmail");
    private final By genderMaleRadio = By.cssSelector("label[for='gender-radio-1']");
    private final By mobileField = By.id("userNumber");
    private final By dateOfBirthInput = By.id("dateOfBirthInput");
    private final By subjectsInput = By.id("subjectsInput");
    private final By hobbiesCheckboxSports = By.cssSelector("label[for='hobbies-checkbox-1']");
    private final By hobbiesCheckboxReading = By.cssSelector("label[for='hobbies-checkbox-2']");
    private final By hobbiesCheckboxMusic = By.cssSelector("label[for='hobbies-checkbox-3']");
    private final By uploadPicture = By.id("uploadPicture");
    private final By currentAddressField = By.id("currentAddress");
    private final By stateDropdown = By.id("react-select-3-input");
    private final By cityDropdown = By.id("react-select-4-input");
    private final By submitButton = By.id("submit");

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationFormPage open() {
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        WebElement element = waitForElement(firstNameField);
        scrollIntoView(element);
        element.sendKeys(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        WebElement element = waitForElement(lastNameField);
        scrollIntoView(element);
        element.sendKeys(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        WebElement element = waitForElement(emailField);
        scrollIntoView(element);
        element.sendKeys(email);
        return this;
    }

    public RegistrationFormPage selectGenderMale() {
        WebElement element = waitForElement(genderMaleRadio);
        scrollIntoView(element);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return this;
    }

    public RegistrationFormPage setMobileNumber(String mobile) {
        waitAndSendKeys(mobileField, mobile);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String date) {
        WebElement dateElement = waitForElement(dateOfBirthInput);
        dateElement.clear();
        dateElement.sendKeys(date);
        dateElement.sendKeys(Keys.RETURN);
        return this;
    }

    public RegistrationFormPage addSubject(String subject) {
        waitAndSendKeys(subjectsInput, subject);
        waitForElement(By.xpath("//div[contains(@class, 'subjects-auto-complete__option')]")).click();
        return this;
    }

    public RegistrationFormPage selectHobbies(boolean sports, boolean reading, boolean music) {
        if (sports) waitAndClick(hobbiesCheckboxSports);
        if (reading) waitAndClick(hobbiesCheckboxReading);
        if (music) waitAndClick(hobbiesCheckboxMusic);
        return this;
    }

    public RegistrationFormPage uploadPicture(String filePath) {
        waitForElement(uploadPicture).sendKeys(filePath);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        waitAndSendKeys(currentAddressField, address);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        waitAndSendKeys(stateDropdown, state);
        waitAndSendKeys(stateDropdown, Keys.RETURN.toString());
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        waitAndSendKeys(cityDropdown, city);
        waitAndSendKeys(cityDropdown, Keys.RETURN.toString());
        return this;
    }

    public void submitForm() {
        waitAndClick(submitButton);
    }
}