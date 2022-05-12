package SaucelabTestRunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.*;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = { "src/test/java/SaucelabTestRunner/testDemo.feature"}, glue = "SauceLab")

public class TestRunnerLab extends AbstractTestNGCucumberTests {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test1;

    @BeforeClass
    @Test
    public static void Start() {
        htmlReporter = new ExtentSparkReporter("C:/Users/shilp/javaprg/MobileTestingFramework/Reports/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test1 = extent.createTest("Test Demo Application", "test to validate Mobile App ");
        test1.log(Status.INFO, "Starting test case");
    }


    @AfterClass

    public static void teardown() {
        test1.info("test completed");
        extent.flush();
    }
}
