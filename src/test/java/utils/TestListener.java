package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import tests.BaseTestClass;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getExtentReport();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    @Override
        public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTestClass) testClass).getDriver();

        String screenshotPath =
            ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());

        extentTest.get().fail(result.getThrowable());
        extentTest.get().addScreenCaptureFromPath(screenshotPath);
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped");
    }
}
