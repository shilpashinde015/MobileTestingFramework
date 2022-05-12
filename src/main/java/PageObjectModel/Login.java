package PageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class Login extends BasePage{

   private AndroidDriver driver;
   //  private WebDriver driver;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
        private AndroidElement uName;
    //private WebElement uName;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
    private AndroidElement uPass;
    // private WebElement uPass;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
    private AndroidElement loginbtn;
   // private WebElement loginbtn;

    //@FindBy(id = "android:id/title")
    //private WebElement pageTitle;

  /*  public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/
    public Login(AndroidDriver<AndroidElement> driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Override
    public boolean isAt() {
        return false;
    }

   public void setUname(String userName){
        uName.sendKeys(userName);
    }
    public void setPassword(String Password){
        uPass.sendKeys(Password);
    }

    public void enterCredential(String username, String password) {
        uName.sendKeys(username);
        uPass.sendKeys(password);

    }

    public void displayMessage() {
        System.out.println("Login Successfully");
    }

    public void clickbutton() {
      loginbtn.click();
    }

    public String getApplicationTitle() {
     //   return   driver.findElement(pageTitle).getText();
        return "Hello !!!";

    }
}
