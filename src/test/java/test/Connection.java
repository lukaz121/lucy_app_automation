package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ConnectionPage;
import page.HomeAndTransferPage;
import page.SignInPage;

import java.net.MalformedURLException;
import java.net.URL;

import static constant.Common.*;
import static constant.ConnectionLocator.*;
import static constant.DataTest.*;
import static constant.BankLocator.*;
import static constant.IdentificationTypeLocator.*;
import static constant.PurposeCodeLocator.*;
import static constant.RelationshipLocator.*;
import static constant.SourceIncomeLocator.*;

public class Connection {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    public SignInPage signIpPage;
    public HomeAndTransferPage homeAndTransferPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2XL");
        caps.setCapability("udid", "710KPVH0441127");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.lucyapp.qa");
        caps.setCapability("appActivity", "com.lucyapp.MainActivity");
        caps.setCapability("noReset", "false");
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 20);
        signIpPage = new SignInPage(driver, wait);
        homeAndTransferPage = new HomeAndTransferPage(driver, wait);
        signIpPage.clickWithLucy()
                .inputEmail(ALVIN_QA1_EMAIL)
                .inputPIN(PIN_1);
    }

    @Test
    public void addYourLocalBank() throws InterruptedException {
        ConnectionPage connectionPage = homeAndTransferPage.clickMenuButton().clickConnectionInMenu();
        ConnectionPage resultPage = connectionPage.clickAddConnectionIcon()
                .choseTypeConnectionByLocator(CSS_TYPE_YOUR_LOCAL_BANK)
                .clickSelectBank()
                .selectLocalBankByLocator(CSS_LOCAL_BANK_UOB)
                .inputFirstName(FIRST_NAME_POTENTIA)
                .inputLastName(LAST_NAME_SCHOFIELD)
                .inputOptionalEmail(THOMAS_EMAIL)
                .scrollDown(By.cssSelector(CSS_BANK_LOCATION_TITLE), 100, -800)
                .inputAccountNumber(BANK_ACC_NUMBER_10_NUMBER)
                .clickValidate();

        String successText = resultPage.getTextByLocator(By.cssSelector(CSS_ADD_SUCCESS));
        Assert.assertEquals(successText, ADD_CONNECTION_SUCCESS);
    }

    @Test
    public void addOtherLocalBank() throws InterruptedException {
        ConnectionPage connectionPage = homeAndTransferPage.clickMenuButton().clickConnectionInMenu();
        ConnectionPage resultPage = connectionPage.clickAddConnectionIcon()
                .choseTypeConnectionByLocator(CSS_TYPE_OTHER_LOCAL_BANK)
                .clickSelectBank()
                .selectLocalBankByLocator(CSS_LOCAL_BANK_STANDARD_CHARTERED)
                .inputFirstName(FIRST_NAME_POTENTIA)
                .inputLastName(LAST_NAME_SCHOFIELD)
                .inputOptionalEmail(THOMAS_EMAIL)//invalid email will not valid
                .scrollDown(By.cssSelector(CSS_BANK_LOCATION_TITLE), 100, -800)
                .inputAccountNumber(BANK_ACC_NUMBER_10_NUMBER)
                .clickValidate();

        String successText = resultPage.getTextByLocator(By.cssSelector(CSS_ADD_SUCCESS));
        Assert.assertEquals(successText, ADD_CONNECTION_SUCCESS);
    }

    @Test
    public void addOverseaIndoAllBank() throws InterruptedException {
        ConnectionPage connectionPage = homeAndTransferPage.clickMenuButton().clickConnectionInMenu();
        ConnectionPage resultPage = connectionPage.clickAddConnectionIcon()
                .choseTypeConnectionByLocator(CSS_TYPE_OVERSEAS_BANK)
                .clickCountryToTransferByLocator(CSS_INDONESIA)
                .clickIndividual()
                .clickAllIndoBank()
                .inputFirstnameSymbol(FIRST_NAME_ALVIN)
                .inputLastnameSymbol(LAST_NAME_SCHOFIELD)
                .inputAddressSymbol(INDO_BANK_ADDRESS)
                .selectIndoBankByLocator(CSS_INDO_BANK_BCA)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -1000)
                .inputAccNumberSymbol(BANK_ACC_NUMBER_16_NUMBER)
                .clickValidate();

        String successText = resultPage.getTextByLocator(By.cssSelector(CSS_ADD_SUCCESS));
        Assert.assertEquals(successText, ADD_CONNECTION_SUCCESS);
    }

    @Test
    public void addOverseaIndoLinkAja() throws InterruptedException {
        ConnectionPage connectionPage = homeAndTransferPage.clickMenuButton().clickConnectionInMenu();
        ConnectionPage resultPage = connectionPage.clickAddConnectionIcon()
                .choseTypeConnectionByLocator(CSS_TYPE_OVERSEAS_BANK)
                .clickCountryToTransferByLocator(CSS_INDONESIA)
                .clickIndividual()
                .clickLinkAja()
                .inputFirstnameSymbol(FIRST_NAME_POTENTIA)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .inputAccNumberSymbol(BANK_ACC_NUMBER_10_NUMBER)
                .clickIdentificationType()
                .selectIdentificationTypeByLocator(CSS_ID_TYPE_WORK_PERMIT)
                .inputIdentificationValueSymbol(IDENTIFICATION_ID_1)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -2500)
                .inputPhoneNumberSymbol(MOBILE_10_NUMBER)
                .inputOccupationSymbol(OCCUPATION_TESTER)
                .selectSourceIncomeSymbolByLocator(CSS_SOURCE_INCOME_BUSINESS)
                .selectPurposeCodeSymbolByLocator(CSS_PURPOSE_CODE_REAL_ESTATE_ABROAD)
                .selectRelationshipSymbolByLocator(CSS_RELATIONSHIP_BROTHER)
                .clickValidate();

        String successText = resultPage.getTextByLocator(By.cssSelector(CSS_ADD_SUCCESS));
        Assert.assertEquals(successText, ADD_CONNECTION_SUCCESS);
    }

    @Test
    public void addOverseaPhilBank() throws InterruptedException {
        ConnectionPage connectionPage = homeAndTransferPage.clickMenuButton().clickConnectionInMenu();
        ConnectionPage resultPage = connectionPage.clickAddConnectionIcon()
                .choseTypeConnectionByLocator(CSS_TYPE_OVERSEAS_BANK)
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .clickIndividual()
                .selectPhilBankTransferByLocator(CSS_PHIL_BANK_BANCO_DE_ORO)
                .inputFirstnameSymbol(FIRST_NAME_MICHAEL)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .inputAccNumberSymbol(BANK_ACC_NUMBER_16_NUMBER)
                .clickIdentificationType()
                .selectIdentificationTypeByLocator(CSS_ID_TYPE_SOCIAL_SECURITY)
                .inputIdentificationValueSymbol(IDENTIFICATION_ID_1)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -2500)
                .inputPhoneNumberSymbol(MOBILE_10_NUMBER)
                .inputOccupationSymbol(OCCUPATION_TESTER)
                .selectSourceIncomeSymbolByLocator(CSS_SOURCE_INCOME_BUSINESS)
                .selectPurposeCodeSymbolByLocator(CSS_PURPOSE_CODE_REAL_ESTATE_ABROAD)
                .selectRelationshipSymbolByLocator(CSS_RELATIONSHIP_BROTHER)
                .clickValidate();

        String successText = resultPage.getTextByLocator(By.cssSelector(CSS_ADD_SUCCESS));
        Assert.assertEquals(successText, ADD_CONNECTION_SUCCESS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
