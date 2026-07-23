package com.shiva.listeners;
import com.shiva.base.BaseTest;
import com.shiva.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.shiva.reports.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver = ((BaseTest) result.getInstance()).driver;


        String screenshotPath =
                ScreenshotUtil.captureScreenshot(driver, result.getName());

        test.addScreenCaptureFromPath(screenshotPath);

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}