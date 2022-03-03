package test;

import helper.ApiHelper;
import helper.KycDocument;
import helper.Response;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import page.KycPage;
import page.SignInPage;

import java.io.IOException;
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
    public void kycWithInvalidIdCardImg() throws IOException {
        System.out.println("===============START TESTING KYC===============");
        kycPage.clickDoKyc()
                .inputName(FULL_NAME)
                .selectDateOfBirth()
                .selectNationality()
                .inputAddress()
                .takeSelfie()
                .inputIDInfo();
        ApiHelper kycApi = new ApiHelper();
        KycDocument kycDoc = new KycDocument();
        kycDoc.idCardFront = kycApi.getImageBase64("id_front.jpg");
        kycDoc.imageCheckName = "id_front_2.jpg";
        Response res = kycApi.kycAction(kycDoc);
        Assert.assertEquals(res.statusCode, 200);
        System.out.println("===============END TESTING KYC===============");
    }

    @Test
    public void kycWithValidIdCardImg() throws IOException {
        System.out.println("===============START TESTING KYC===============");
        kycPage.clickDoKyc()
                .inputName(FULL_NAME)
                .selectDateOfBirth()
                .selectNationality()
                .inputAddress()
                .takeSelfie()
                .inputIDInfo();
        ApiHelper kycApi = new ApiHelper();
        KycDocument kycDoc = new KycDocument();
        kycDoc.idCardFront = kycApi.getImageBase64("id_front.jpg");
        kycDoc.imageCheckName = "id_front.jpg";
        Response res = kycApi.kycAction(kycDoc);
        Assert.assertEquals(res.statusCode, 200);
        System.out.println("===============END TESTING KYC===============");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
