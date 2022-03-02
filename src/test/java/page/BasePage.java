package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

import static constant.HomePageLocator.*;
import static constant.KycLocator.*;
import static constant.LoginOrSignInLocator.*;

public class BasePage {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void inputValue(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public void enterPIN(String[] pin) {
        for (int i = 0; i < pin.length; i++) {
            switch (i) {
                case 0:
                    this.inputValue(By.xpath(PIN1), pin[i]);
                    break;
                case 1:
                    this.inputValue(By.xpath(PIN2), pin[i]);
                    break;
                case 2:
                    this.inputValue(By.xpath(PIN3), pin[i]);
                    break;
                case 3:
                    this.inputValue(By.xpath(PIN4), pin[i]);
                    break;
                case 4:
                    this.inputValue(By.xpath(PIN5), pin[i]);
                    break;
                case 5:
                    this.inputValue(By.xpath(PIN6), pin[i]);
                    break;
            }
        }
    }

    public void swipe(MobileElement element, int xOffset, int yOffset) {
        Actions action = new Actions(driver);
        action.clickAndHold(element);
        action.moveByOffset(xOffset, yOffset);
        action.perform();
    }

    public String getTextByLocator(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void selectDateOfBirth(String date, String month, String year) {
        String xpathYear2 = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.ScrollView/android.widget.ViewAnimator/android.widget.ListView/android.widget.TextView[2]";
        String cssYear = "android.widget.TextView[text=" + "\"" + year + "\"]";
        String cssDate = "android.view.View[text=\"" + date + "\"]";
        this.click(By.cssSelector(CSS_DATE_INPUT));
        this.click(By.id("android:id/date_picker_header_year"));
        var element = driver.findElements(By.cssSelector(cssYear));
        var elementScroll = driver.findElements(By.xpath(xpathYear2));
        while (element.size() == 0) {
            this.swipe(elementScroll.get(0), 100, 600);
            element = driver.findElements(By.cssSelector(cssYear));
        }
        element.get(0).click();
        int recentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int targetMonth = Integer.parseInt(month);
        String nextOrPrev = recentMonth > targetMonth ? PREV_MONTH : NEXT_MONTH;
        for (int i = 0; i < targetMonth - recentMonth; i++) {
            this.click(By.xpath(nextOrPrev));
        }
        this.click(By.cssSelector(cssDate));
        this.click(By.xpath(DATE_OK));
    }
    public void scroll(By locatorScroll, int xOffset, int yOffset) throws InterruptedException{
        Thread.sleep(300);
        MobileElement element = (MobileElement) wait
                .until(ExpectedConditions.visibilityOfElementLocated(locatorScroll));
        this.swipe(element, xOffset, yOffset);
        Thread.sleep(500);
    }

}
