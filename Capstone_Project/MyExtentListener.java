package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tests.AllTest;

public class MyExtentListener implements ITestListener {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== Extent Report Setup Started ===");

        String reportPath = System.getProperty("user.dir") + "/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        // Reporter config
        spark.config().setDocumentTitle("nopCommerce Test Report");
        spark.config().setReportName("Automation Execution Report");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Attach reporter
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // System info
        extent.setSystemInfo("Tester", "Punam");
        extent.setSystemInfo("Machine", "MSI");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.INFO, "Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "❌ Test Failed: " + result.getName());
        test.fail(result.getThrowable());

        // Get driver from AllTest
        Object testClass = result.getInstance();
        if (testClass instanceof AllTest) {
            driver = ((AllTest) testClass).driver;
        }

        // Screenshot
        File destDir = new File("Screenshots");
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = result.getName() + "_" + timeStamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(destDir, fileName);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            test.addScreenCaptureFromPath(destFile.getAbsolutePath(), result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        test.log(Status.FAIL, "⏳ Test Timeout: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("=== Extent Report Generated ===");
    }
}
