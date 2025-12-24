package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) 
    {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + testName + ".png";

        try 
        {
            Files.copy(src, new File(path));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return path;
    }
}
