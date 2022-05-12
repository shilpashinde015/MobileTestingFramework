package PageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Createprofile  extends BasePage{

    private AndroidDriver driver;
    @AndroidFindBy(className = "UIKey")
    private AndroidElement keyboard;

    @AndroidFindBy(id = "greetings")
    private AndroidElement greetele;

    @AndroidFindBy(id = "logout")
    private AndroidElement logoutele;
    @AndroidFindBy(id = "country")
    private AndroidElement countryele;
    @AndroidFindBy(id = "address")
    private AndroidElement addressele;
    @AndroidFindBy(id = "email")
    private AndroidElement emailElement;
    @AndroidFindBy(id = "phone")
    private AndroidElement phoneEle;
    @AndroidFindBy(id = "save")
    private AndroidElement saveele;
    @AndroidFindBy(id = "saved")
    private AndroidElement savedele;

    public Createprofile(AndroidDriver<AndroidElement> driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isDisplayed() {
        return greetele.isDisplayed();
    }
    public String getGreetText(){
        return greetele.getText();
    }
    public void typeAddress(String address) {
        addressele.sendKeys(address);
    }
    public void typeCountry(String country) {
        countryele.sendKeys(country);
    }
    public void typeEmail(String email) {
        emailElement.sendKeys(email);
    }
    public void typePhone(String phone) {
        phoneEle.sendKeys(phone);
    }
    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
        }
    }
    public void save() {
        saveele.click();
    }
    public boolean isSaved() {
        return savedele.isDisplayed();
    }

    @Override
    public boolean isAt() {
        return false;
    }

    public void enterDetails(String Country, String Address, String Email, String phone) {
        typeCountry(Country);
        typeAddress(Address);
        typeEmail(Email);
        typePhone(phone);

    }

    public String getSaveprofileText() {
        return savedele.getText();
    }
}
