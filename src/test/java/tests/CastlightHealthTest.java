package tests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import base.BaseTest;
import pages.CastlightLoginPage;
import pages.CastlightHomePage;
import pages.HealthAssessmentPage;

public class CastlightHealthTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CastlightHealthTest.class);

    @Test
    public void testHealthAssessmentWorkflow() {
        CastlightLoginPage loginPage = new CastlightLoginPage(driver);
        
        // Login to the application
        CastlightHomePage homePage = loginPage.open()
            .login("nagarjuna.venna@gmail.com", "Third@123");

        // Navigate to Ways to Earn through Wellbeing menu
        homePage.clickWellbeingMenu()
               .clickWaysToEarn();

        // Get and log points balance
        String pointsBalance = homePage.getPointsBalance();
        logger.info("Current points balance: " + pointsBalance);

        // Navigate to Health Assessment and fill details
        HealthAssessmentPage healthAssessment = homePage.clickHealthAssessment();
        
        healthAssessment.fillBasicDetails(5, 10, 170.5, 34)
                       .fillBloodPressure(120, 80)
                       .fillCholesterolDetails(200, 50, 130, 150)
                       .fillGlucose(95);

        // Note: As per requirements, we don't submit the assessment
    }
}