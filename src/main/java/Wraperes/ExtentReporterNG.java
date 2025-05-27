package Wraperes;

import Actions.BrowserActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;




public class ExtentReporterNG implements ITestListener {
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public  ExtentReports getReportObject(){

            String reportPath=System.getProperty("user.dir")+"\\reports\\Summary.html";
            ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("HTML Report");
            reporter.config().setDocumentTitle("Test Result");
            ExtentReports extent=new ExtentReports();
            extent.attachReporter(reporter) ;
            extent.setSystemInfo("Tester","Abdallah Ahmed");
            return extent;
    }
    ExtentReports extent= getReportObject();

    private String getFullTestName(ITestResult result) {
        String testName = result.getTestContext().getName();
        String methodName = result.getMethod().getMethodName();
        return testName + "." + methodName;
    }
    @Override
    public void onTestStart(ITestResult result) {

        test.set(extent.createTest(getFullTestName(result)));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS,"Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());

        TakesScreenshot ts=(TakesScreenshot) BrowserActions.getDriver();
        File source=ts.getScreenshotAs(OutputType.FILE);
        String tcName= result.getName();
        String filePath=System.getProperty("user.dir")+"\\reports\\" +tcName + ".png";

        File file=new File(System.getProperty("user.dir")+"\\reports\\" + tcName + ".png");
        try {
            FileUtils.copyFile(source,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
