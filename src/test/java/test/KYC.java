package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page.KycPage;
import page.SignInPage;

import java.net.MalformedURLException;
import java.net.URL;

import static constant.DataTest.*;

public class KYC {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    public SignInPage signIpPage;
    public KycPage kycPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2XL");
        caps.setCapability("udid", "710KPVH0441127"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.lucyapp.qa");
        caps.setCapability("appActivity", "com.lucyapp.MainActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 20);
        signIpPage = new SignInPage(driver, wait);
        kycPage = new KycPage(driver, wait);
        signIpPage.clickWithLucy()
                .inputEmail(KYC_EMAIL)
                .inputPIN(PIN_1);
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("===============START TESTING KYC===============");
        kycPage.clickDoKyc()
                .inputName("Jun Hoang")
                .selectDateOfBirth()
                .selectNationality()
                .inputAddress()
                .takeSelfie()
                .inputIDInfo();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
