package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String namePrefix) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = namePrefix + "_" + timestamp + ".png";
            File target = Paths.get("target", "screenshots", fileName).toFile();
            FileUtils.copyFile(src, target);
            return target.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}
