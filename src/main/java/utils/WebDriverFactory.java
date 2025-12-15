package utils;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        String browser = ConfigReader.get("browser", "CHROME").toUpperCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless", "false"));

        BrowserType type = BrowserType.valueOf(browser);
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                if (headless) opts.addArguments("--headless=new");
                // Add options to handle ads and improve stability
                opts.addArguments("--disable-notifications");
                opts.addArguments("--disable-popup-blocking");
                opts.addArguments("--disable-extensions");
                opts.addArguments("--headless=new");
                opts.addArguments("--no-sandbox");
                opts.addArguments("--disable-dev-shm-usage");
                return new ChromeDriver(opts);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
