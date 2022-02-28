package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.LoginOrSignInLocator.*;

public class SignInPage extends BasePage {

    public SignInPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public SignInPage clickWithLucy() {
        this.click(By.xpath(WITH_LUCY));
        return this;
    }

    public SignInPage inputEmail(String email) {
        this.inputValue(By.xpath(INPUT_LOGIN_EMAIL), email);
        this.click(By.xpath(CONFIRM_EMAIL_LOGIN));
        return this;
    }

    public void inputPIN(String[] pin) {
        this.enterPIN(pin);
    }
}
