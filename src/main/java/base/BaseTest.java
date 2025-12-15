package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenshotUtil;
import utils.WebDriverFactory;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        driver = WebDriverFactory.createDriver();
        driver.manage().window().maximize();
        String base = utils.ConfigReader.get("base.url", "https://example.com");
        driver.get(base);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (!result.isSuccess() && driver != null) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            System.out.println("Saved screenshot: " + path);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
