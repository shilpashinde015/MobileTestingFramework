package Listener;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(("*** Running test method " + iTestResult.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("*** Executed " + iTestResult.getMethod().getMethodName() + " test successfully...");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("*** Test execution " + iTestResult.getMethod().getMethodName() + " failed...");
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("*** Test " + iTestResult.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("*** Test failed but within percentage % " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("*** Test Suite " + iTestContext.getName() + " started ***");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println(("*** Test Suite " + iTestContext.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }
}
