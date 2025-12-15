package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.RegistrationFormPage;

public class RegistrationFormTest extends BaseTest {

    @Test
    public void testStudentRegistrationForm() {
        RegistrationFormPage registrationPage = new RegistrationFormPage(driver);
        
        registrationPage.open()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .selectGenderMale()
                .setMobileNumber("1234567890")
                .setDateOfBirth("15 Oct 2000")
                .addSubject("Computer Science")
                .selectHobbies(true, true, false) // Sports and Reading selected
                .setCurrentAddress("123 Test Street, Test City")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
    }
}