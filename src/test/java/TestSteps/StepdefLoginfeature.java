package TestSteps;

import PageObjectModel.Login;
import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StepdefLoginfeature {

    DesiredCapabilities ds = new DesiredCapabilities();
    //WebDriver driver;
    AndroidDriver driver;
    Login lp;

/*    @Before
    public void setUp() throws MalformedURLException {


        ds.setCapability("deviceName","ZY22CXHHJK");
        ds.setCapability("udid","ZY22CXHHJK");
        ds.setCapability("platformName","Android");
        ds.setCapability("platformVersion","10");
        ds.setCapability("appPackage", "com.experitest.ExperiBank");
        ds.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,ds);
      // lp = new Login((AndroidDriver) driver)
        lp = new Login(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Started !!!!!");
    }*/

    @Given("^Go to Eribank Application$")
    public void user_is_on_App_page() throws Throwable {

    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
         username = Utility.readProperties.getUsername();
         password = Utility.readProperties.getPassword();
        lp.enterCredential(username,password);
        lp.clickbutton();
        lp.displayMessage();
    }
    @Then("^Hompage will display$")
    public void message_display(){
        String pageTitle = lp.getPageTitle();


    }
        @AfterMethod
    public void tearDown() {
        driver.quit();


    }

    @Then("Homepage will display")
    public void homepageWillDisplay() {
    }
}
