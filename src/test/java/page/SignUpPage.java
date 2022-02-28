package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.LoginOrSignInLocator.*;

public class SignUpPage extends BasePage {

    public SignUpPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public SignUpPage clickGetStarted() {
        this.click(By.xpath(GET_STARTED));
        return this;
    }

    public SignUpPage enterEmail(String email) {
        this.inputValue(By.xpath(INPUT_SIGN_IN_EMAIL), email);
        this.click(By.xpath(CONTINUE));
        return this;
    }

    public SignUpPage enterName(String name) {
        this.inputValue(By.xpath(PREFERRED_NAME), name);
        return this;
    }

}
