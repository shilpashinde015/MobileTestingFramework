package PageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoLogin  extends BasePage{


    private AndroidDriver driver;

    public demoLogin(AndroidDriver<AndroidElement> driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean isAt() {
        return false;
    }


    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;
    @AndroidFindBy(id = "name")
    private AndroidElement nameElement;
    @AndroidFindBy(id = "password")
    private AndroidElement passwordElement;
    @AndroidFindBy(id = "login")
    private AndroidElement loginElement;

    @AndroidFindBy(id = "greetings")
    private AndroidElement greet;

    public void displayMessage() {
        System.out.println("Login Successfully");
    }


    public void enterusernameandpassword(String username, String password) {
        nameElement.sendKeys(username);
        passwordElement.sendKeys(password);

    }

    public void clickLoginbutton() {
        loginElement.click();
    }

    public String getcustomerGreetingMsg() {
        String name = greet.getText();
        return name;
    }

    public String LoginbuttonText() {
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOf(loginElement));
        String lgText = loginElement.getText();
        return lgText;

    }
}
