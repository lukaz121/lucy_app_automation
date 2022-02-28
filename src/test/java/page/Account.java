package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account extends BasePage {

    public Account(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
