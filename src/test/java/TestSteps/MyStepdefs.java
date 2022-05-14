package TestSteps;

import PageObjectModel.Createprofile;
import PageObjectModel.demoLogin;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    demoLogin dm;
    Createprofile cp;
    DesiredCapabilities ds = new DesiredCapabilities();
    AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {


        ds.setCapability("deviceName", "ZY22CXHHJK");
        ds.setCapability("udid", "ZY22CXHHJK");
        ds.setCapability("platformName", "Android");
        ds.setCapability("platformVersion", "10");
        ds.setCapability("appPackage", "io.testproject.demo");
        ds.setCapability("appActivity", "io.testproject.demo.MainActivity");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, ds);
        dm = new demoLogin(driver);
        cp = new Createprofile(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //  test1.info("Test Started !!!");
    }

    @Given("Go to TestProjectDemo Application")
    public void go_to_test_project_demo_application() {
     //   test1.info("Homepage is displayed !!");
        //test1.log(Status.PASS, "Test Pass");
    }


    @And("Enter Credentials {string} and {string}")
    public void enterCredentialsAnd(String username, String password) {
        username = Utility.testDemoProperties.getUsername_testdemo();
        password = Utility.testDemoProperties.getPassword_testdemo();
        dm.enterusernameandpassword(username, password);
        dm.clickLoginbutton();
        dm.displayMessage();

    }

    @Then("Customer details page will display")
    public void customerDetailsPageWillDisplay() {
        String msg = dm.getcustomerGreetingMsg();
      //  test1.info(msg);
     //   test1.log(Status.PASS,"Customer details page is displayed !");

    }

    @When("Enter wrong Credentials {string} and {string}")
    public void enter_wrong_credentials_and(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        username = Utility.testDemoProperties.getUsername_testdemo();
        password = Utility.testDemoProperties.getwrongPassword_testdemo();
        // System.out.println("username" + username);
        System.out.println("Password" + password);
        dm.enterusernameandpassword(username, password);
        dm.clickLoginbutton();
        String LgButtontxt = dm.LoginbuttonText();
        //System.out.println("Text for button: " + LgButtontxt);
        if(LgButtontxt.equalsIgnoreCase("Login")){
      //      test1.log(Status.PASS,"Test Passed");
        }else{
          //  test1.log(Status.FAIL,"Test Failed !");
        }

    }

    @Then("Customer details page should display")
    public void customerDetailsPageShouldDisplay() {

    }

    @Then("Customer details page will display with customer name")
    public void customerDetailsPageWillDisplayWithCustomerName() {

        System.out.println(cp.isDisplayed());
        String greetText = cp.getGreetText();
        System.out.println("greetText : " + greetText);
    }

    @And("Enter customer details {string} and {string},{string} and {string}")
    public void enterCustomerDetailsAndAnd(String Country, String Address, String Email, String phone) {
        Country = Utility.testDemoProperties.getCountry();
        Address = Utility.testDemoProperties.getAddress();
        Email = Utility.testDemoProperties.getEmail();
        phone  = Utility.testDemoProperties.getPhoneNumber();
        cp.enterDetails(Country, Address,Email,phone);

    }

    @Then("Click Save and Check details")
    public void clickSaveAndCheckDetails() {
        cp.save();
        cp.isSaved();
        String txtSave  = cp.getSaveprofileText();
        System.out.println("Saved Text : " + txtSave);
    }


}
