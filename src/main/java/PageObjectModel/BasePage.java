package PageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class BasePage {
    private AndroidDriver<AndroidElement> driver;

    protected String pageTitle;

    private static Logger log = Logger.getLogger(BasePage.class.getName());

    public BasePage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 10 seconds Implicit Wait
        //this.driver.manage().window().maximize();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }


    public abstract boolean isAt();
}

