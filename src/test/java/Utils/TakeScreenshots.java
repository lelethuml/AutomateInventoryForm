package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TakeScreenshots {

    private static final String screenshotDir = System.getProperty("user.dir") + "/Screenshots";

    public void takeSnapshots(WebDriver driver, String screenshotName){
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File src = takeScreenshot.getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotDir, screenshotName + ".jpeg");

        try {
            org.apache.commons.io.FileUtils.copyFile(src, destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
