package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomeAndTransferPage;
import page.SignInPage;

import java.net.MalformedURLException;
import java.net.URL;

import static constant.BankLocator.*;
import static constant.Common.*;
import static constant.Common.CSS_SENDER_DETAILS_TITLE;
import static constant.DataTest.*;
import static constant.HomePageLocator.*;
import static constant.IdentificationTypeLocator.CSS_ID_TYPE_IDENTIFICATION_ID;
import static constant.BankLocator.CSS_LOCAL_BANK_DBS;
import static constant.PurposeCodeLocator.CSS_PURPOSE_CODE_FOREIGN_DEPOSIT;
import static constant.RelationshipLocator.CSS_RELATIONSHIP_SIBLING;
import static constant.RelationshipLocator.CSS_RELATIONSHIP_SPOUSE;
import static constant.SourceIncomeLocator.CSS_SOURCE_INCOME_LOANS;
import static constant.SourceIncomeLocator.CSS_SOURCE_INCOME_SALARY;

public class Transfer {
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
        wait = new WebDriverWait(driver, 25);
        signIpPage = new SignInPage(driver, wait);
        homeAndTransferPage = new HomeAndTransferPage(driver, wait);
        signIpPage.clickWithLucy()
                .inputEmail(ALVIN_QA1_EMAIL)
                .inputPIN(PIN_1);
    }

    @Test
    public void payNowMobile() throws InterruptedException {
        String description = PAYNOW_DESCRIPTION + "mobile $" + AMOUNT_2_00;
        HomeAndTransferPage resultPage = homeAndTransferPage.clickFirstAccount()
                .clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickLocalPaynow()
                .clickPaynowOption()
                .clickPaynowMobile()
                .inputMobileNumber(MOBILE_8_NUMBER)
                .inputFirstname(FIRST_NAME_MICHAEL)
                .scrollDown(By.xpath(FIRST_NAME_TITLE), 100, -1000)
                .inputLastname(LAST_NAME_SCHOFIELD)
                .clickContinue()
                .inputPaynowAmount(AMOUNT_2_00)
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();
        resultPage.validateLocalPaynowResult(MOBILE_8_NUMBER, AMOUNT_2_00, true);
    }

    @Test
    public void payNowNRIC() throws InterruptedException{
        String description = PAYNOW_DESCRIPTION + "NRIC $" + AMOUNT_2_00;
        HomeAndTransferPage resultPage = homeAndTransferPage.clickFirstAccount()
                .clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickLocalPaynow()
                .clickPaynowOption()
                .clickNRIC()
                .inputNRIC(NRIC_NUMBER)
                .inputFirstname(FIRST_NAME_ALVIN)
                .scrollDown(By.xpath(FIRST_NAME_TITLE), 100, -1000)
                .inputLastname(LAST_NAME_ARULSELVAN)
                .clickContinue()
                .inputPaynowAmount(AMOUNT_2_00)
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();
        resultPage.validateLocalPaynowResult(NRIC_NUMBER, AMOUNT_2_00, false);
    }

    @Test
    public void payNowUen() throws InterruptedException {
        String description = PAYNOW_DESCRIPTION + "UEN $" + AMOUNT_2_00;
        HomeAndTransferPage resultPage = homeAndTransferPage.clickFirstAccount()
                .clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickLocalPaynow()
                .clickPaynowOption()
                .clickPaynowUen()
                .inputUen(UEN_NUMBER)
                .scrollDown(By.xpath(NRIC_PAYNOW), 100, -500)
                .clickContinue()
                .inputPaynowAmount(AMOUNT_2_00)
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();
        resultPage.validateLocalPaynowResult(NRIC_NUMBER, AMOUNT_2_00, false);
    }

    @Test
    public void overseaIndoBankBca() throws InterruptedException {
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage resultPage = accountPageBefore
                .clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaBankAcc()
                .clickCountryToTransferByLocator(CSS_INDONESIA)
                .clickIndividual()
                .clickAllIndoBank()
                .inputBankAmount(AMOUNT_2_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -1000)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_POTENTIA)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .inputAddressSymbol(INDO_BANK_ADDRESS)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -5000)
                .selectIndoBankByLocator(CSS_INDO_BANK_BCA)
                .inputAccNumberSymbol(BANK_ACC_NUMBER_16_NUMBER)
//                .clickSaveConnection()
                .clickContinue()
                .clickContinue()
                .inputDescription(BCA_DESC + AMOUNT_2_00)
                .clickContinue()
                .clickTransfer();

        resultPage.validateBankTransferResult(FIRST_NAME_POTENTIA, LAST_NAME_IKARIAM, AMOUNT_2_00, INDONESIA_TEXT, INDONESIA_ALL_BANKS);
//        HomeAndTransferPage accountPageAfter = resultPage.clickCloseResult().clickFirstAccount();
//        Thread.sleep(3000);
//        Float newBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
//                .split("\\$")[1]);
//        accountPageAfter.validateBalance(oldBalance, newBalance, Float.valueOf(AMOUNT_2_00));
    }

    @Test
    public void overseaIndoBankLinkAja() throws InterruptedException {
        HomeAndTransferPage resultPage = homeAndTransferPage.clickFirstAccount()
                .clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaBankAcc()
                .clickCountryToTransferByLocator(CSS_INDONESIA)
                .clickIndividual()
                .clickLinkAja()
                .inputBankAmount(AMOUNT_7_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -1000)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_POTENTIA)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .inputLinkAjaAccNumber(LINK_AJA_ACC_NUMBER)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3000)
                .clickIdentificationType()
                .selectIdentificationTypeByLocator(CSS_ID_TYPE_IDENTIFICATION_ID)
                .inputIdentificationValueSymbol(IDENTIFICATION_ID_1)
                .inputPhoneNumberSymbol(MOBILE_10_NUMBER)
                .inputOccupationSymbol(OCCUPATION_FARMER)
                .selectSourceIncomeSymbolByLocator(CSS_SOURCE_INCOME_SALARY)
                .selectPurposeCodeSymbolByLocator(CSS_SOURCE_INCOME_SALARY)
                .selectRelationshipSymbolByLocator(CSS_RELATIONSHIP_SPOUSE)
                .scrollDown(By.cssSelector(CSS_SENDER_DETAILS_TITLE), 100, -1000)
//                .clickSaveConnection()
                .clickContinue()
                .clickContinue()
                .inputDescription(LINK_AJA_DESCRIPTION + AMOUNT_7_00)
                .clickContinue()
                .clickTransfer();
        resultPage.validateBankTransferResult(FIRST_NAME_POTENTIA, LAST_NAME_IKARIAM, AMOUNT_7_00, INDONESIA_TEXT, INDONESIA_ALL_BANKS);
    }

    @Test
    public void overseaPhilBankBanco() throws InterruptedException {
        String description = PH_OVERSEA_BANK_DESCRIPTION + AMOUNT_2_00 + " to " + BANCO_DE_ORO;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage resultPage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaBankAcc()
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .clickIndividual()
                .selectPhilBankTransferByLocator(CSS_PHIL_BANK_BANCO_DE_ORO)
                .inputBankAmount(AMOUNT_2_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -1000)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_POTENTIA)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .inputAccNumberSymbol(BANK_ACC_NUMBER_10_NUMBER)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3000)
                .clickIdentificationType()
                .selectIdentificationTypeByLocator(CSS_ID_TYPE_IDENTIFICATION_ID)
                .inputIdentificationValueSymbol(IDENTIFICATION_ID_1)
                .inputPhoneNumberSymbol(MOBILE_10_NUMBER)
                .inputOccupationSymbol(OCCUPATION_FARMER)
                .selectSourceIncomeSymbolByLocator(CSS_SOURCE_INCOME_SALARY)
                .selectPurposeCodeSymbolByLocator(CSS_SOURCE_INCOME_SALARY)
                .selectRelationshipSymbolByLocator(CSS_RELATIONSHIP_SPOUSE)
                .scrollDown(By.cssSelector(CSS_SENDER_DETAILS_TITLE), 100, -1000)
//                .clickSaveConnection()
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();

        resultPage.validateBankTransferResult(FIRST_NAME_POTENTIA, LAST_NAME_IKARIAM, AMOUNT_2_00,
                PHILIPPINES_TEXT, BANCO_DE_ORO);
//        HomeAndTransferPage accountPageAfter = resultPage.clickCloseResult().clickFirstAccount();
//        Thread.sleep(3000);
//        Float newBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
//                .split("\\$")[1]);
//        accountPageAfter.validateBalance(oldBalance, newBalance, Float.valueOf(AMOUNT_2_00));
    }

//    @Test
    public void overseaPhilCashPayoutCebuana() throws InterruptedException {
        String description = PH_OVERSEA_PAYOUT_DESCRIPTION + AMOUNT_5_00 + " to " + PAYOUT_CEBUANA;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage resultPage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaCashPayout()
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .selectPhilCashPayoutBankByLocator(CSS_PHIL_PAYOUT_BANK_CEBUANA)
                .inputBankAmount(AMOUNT_5_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -800)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_ALVIN)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .clickIdentificationType()
                .selectIdentificationTypeByLocator(CSS_ID_TYPE_IDENTIFICATION_ID)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3500)
                .inputIdentificationValueSymbol(IDENTIFICATION_ID_1)
                .inputPhoneNumberSymbol(MOBILE_10_NUMBER)
                .inputOccupationSymbol(OCCUPATION_TESTER)
                .selectSourceIncomeSymbolByLocator(CSS_SOURCE_INCOME_LOANS)
                .selectPurposeCodeSymbolByLocator(CSS_PURPOSE_CODE_FOREIGN_DEPOSIT)
                .selectRelationshipSymbolByLocator(CSS_RELATIONSHIP_SIBLING)
                .scrollDown(By.cssSelector(CSS_SENDER_DETAILS_TITLE), 100, -500)
//                .clickSaveConnection()
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();

        resultPage.validateBankTransferResult(FIRST_NAME_ALVIN, LAST_NAME_IKARIAM, AMOUNT_5_00, PHILIPPINES_TEXT, PAYOUT_CEBUANA);
//        HomeAndTransferPage accountPageAfter = resultPage.clickCloseResult().clickFirstAccount();
//        Thread.sleep(3000);
//        Float newBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
//                .split("\\$")[1]);
//        accountPageAfter.validateBalance(oldBalance, newBalance, Float.valueOf(AMOUNT_5_00));
    }

    @Test
    public void overseaPhilCashPayoutLbc() throws InterruptedException {
        String description = PH_OVERSEA_PAYOUT_DESCRIPTION + AMOUNT_5_00 + " to " + PAYOUT_LBC;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage inputDateStage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaCashPayout()
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .selectPhilCashPayoutBankByLocator(CSS_PHIL_PAYOUT_BANK_LBC)
                .inputBankAmount(AMOUNT_5_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -800)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_ALVIN)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3000)
                .inputMiddlenameSymbol(MIDDLE_NAME_JAY)
                .inputEmailSymbol(THOMAS_EMAIL)
                .inputAddressSymbol(ADDRESS_3)
                .inputMobileSymbol(MOBILE_10_NUMBER)
                .inputNationalitySymbol(NATIONALITY_SG)
                .inputCitySymbol(CITY_SG)
                .scrollDown(By.cssSelector(CSS_ADDRESS_SYMBOL_TITLE), 100, -2000)
                .inputStateSymbol(CITY_SG);

        inputDateStage.selectDateOfBirth("1", "6", "1999");
        HomeAndTransferPage resultPage = inputDateStage.clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();

        resultPage.validateBankTransferResult(FIRST_NAME_ALVIN, LAST_NAME_IKARIAM, AMOUNT_5_00, PHILIPPINES_TEXT, PAYOUT_LBC);
//        HomeAndTransferPage accountPageAfter = resultPage.clickCloseResult().clickFirstAccount();
//        Thread.sleep(3000);
//        Float newBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
//                .split("\\$")[1]);
//        accountPageAfter.validateBalance(oldBalance, newBalance, Float.valueOf(AMOUNT_5_00));
    }

    @Test
    public void overseaPhilCashPayoutBDO() throws InterruptedException {
        String description = PH_OVERSEA_PAYOUT_DESCRIPTION + AMOUNT_5_00 + " to " + PAYOUT_BDO;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage resultPage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaCashPayout()
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .selectPhilCashPayoutBankByLocator(CSS_PHIL_PAYOUT_BANK_BDO)
                .inputBankAmount(AMOUNT_5_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -800)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_ALVIN)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .clickIdentificationType()
                .selectIdentificationTypeByLocator(CSS_ID_TYPE_IDENTIFICATION_ID)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3500)
                .inputIdentificationValueSymbol(IDENTIFICATION_ID_1)
                .inputPhoneNumberSymbol(MOBILE_10_NUMBER)
                .inputOccupationSymbol(OCCUPATION_TESTER)
                .selectSourceIncomeSymbolByLocator(CSS_SOURCE_INCOME_LOANS)
                .selectPurposeCodeSymbolByLocator(CSS_PURPOSE_CODE_FOREIGN_DEPOSIT)
                .selectRelationshipSymbolByLocator(CSS_RELATIONSHIP_SIBLING)
                .scrollDown(By.cssSelector(CSS_SENDER_DETAILS_TITLE), 100, -500)
//                .clickSaveConnection()
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();

        resultPage.validateBankTransferResult(FIRST_NAME_ALVIN, LAST_NAME_IKARIAM, AMOUNT_5_00, PHILIPPINES_TEXT, PAYOUT_BDO);

//        HomeAndTransferPage accountPageAfter = resultPage.clickCloseResult().clickFirstAccount();
//        Thread.sleep(3000);
//        Float newBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
//                .split("\\$")[1]);
//        accountPageAfter.validateBalance(oldBalance, newBalance, Float.valueOf(AMOUNT_5_00));
    }

    @Test
    public void overseaPhilCashPayoutPerahub() throws InterruptedException {
        String description = PH_OVERSEA_PAYOUT_DESCRIPTION + AMOUNT_5_00 + " to " + PAYOUT_PERAHUB;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage inputDateStage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaCashPayout()
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .selectPhilCashPayoutBankByLocator(CSS_PHIL_PAYOUT_BANK_PERAHUB)
                .inputBankAmount(AMOUNT_5_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -800)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_ALVIN)
                .inputLastnameSymbol(LAST_NAME_IKARIAM)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3000)
                .inputMiddlenameSymbol(MIDDLE_NAME_JAY)
                .inputEmailSymbol(THOMAS_EMAIL)
                .inputAddressSymbol(ADDRESS_3)
                .inputMobileSymbol(MOBILE_10_NUMBER)
                .inputNationalitySymbol(NATIONALITY_SG)
                .inputCitySymbol(CITY_SG)
                .scrollDown(By.cssSelector(CSS_ADDRESS_SYMBOL_TITLE), 100, -2000)
                .inputStateSymbol(CITY_SG);

        inputDateStage.selectDateOfBirth("26", "6", "1994");
        HomeAndTransferPage resultPage = inputDateStage.clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();

        resultPage.validateBankTransferResult(FIRST_NAME_ALVIN, LAST_NAME_IKARIAM, AMOUNT_5_00, PHILIPPINES_TEXT, PAYOUT_PERAHUB);
//        HomeAndTransferPage accountPageAfter = resultPage.clickCloseResult().clickFirstAccount();
//        Thread.sleep(3000);
//        Float newBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
//                .split("\\$")[1]);
//        accountPageAfter.validateBalance(oldBalance, newBalance, Float.valueOf(AMOUNT_5_00));
    }

    @Test
    public void philOverseasMobileMoney() throws InterruptedException {
        String description = PH_OVERSEA_MOBILE_MONEY_DESCRIPTION + AMOUNT_2_00;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage resultPage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickOverseaMobileMoney()
                .clickCountryToTransferByLocator(CSS_PHILIPPINES)
                .clickGCash()
                .inputBankAmount(AMOUNT_5_00)
                .scrollDown(By.xpath(BANK_AMOUNT_TITLE), 100, -800)
                .clickContinue()
                .inputFirstnameSymbol(FIRST_NAME_MICHAEL)
                .inputLastnameSymbol(LAST_NAME_SCHOFIELD)
                .scrollDown(By.cssSelector(CSS_TRANSFER_DETAILS_TITLE), 100, -3000)
                .inputMiddlename(MIDDLE_NAME_JAY)
                .inputEmailSymbol(THOMAS_EMAIL)
//                need to scroll
                .inputAddressSymbol(ADDRESS_3)
                .inputMobileSymbol(MOBILE_10_NUMBER)
                .inputNationalitySymbol(NATIONALITY_SG)
                .inputCitySymbol(CITY_SG)
                .scrollDown(By.cssSelector(CSS_ADDRESS_SYMBOL_TITLE), 100, -800)
                .inputStateSymbol(CITY_SG);

        resultPage.selectDateOfBirth("10", "10", "2000");
        resultPage.clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();
    }

    @Test
    public void transferLocalBankAcc() throws InterruptedException {
        String description = LOCAL_BANK_DESCRIPTION + AMOUNT_2_00;
        HomeAndTransferPage accountPageBefore = homeAndTransferPage.clickFirstAccount();
        Float oldBalance = Float.valueOf(accountPageBefore.getTextByLocator(By.xpath(BALANCE_ACC_AMOUNT))
                .split("\\$")[1]);

        HomeAndTransferPage resultPage = accountPageBefore.clickSendButton()
                .scrollDown(By.xpath(TRANSFER_TO), 100, -20000)
                .clickLocalBankAccount()
                .clickSelectBank()
                .selectLocalBankByLocator(CSS_LOCAL_BANK_DBS)
                .inputFirstname(FIRST_NAME_POTENTIA)
                .inputLastname(LAST_NAME_ARULSELVAN)
                .scrollDown(By.cssSelector(CSS_BANK_LOCATION_TITLE), 100, -1800)
                .inputAccNumber(BANK_ACC_NUMBER_10_NUMBER)
                .inputEmailOptional(THOMAS_EMAIL)
                .clickSaveConnection()
                .clickContinue()
                .inputPaynowAmount(AMOUNT_2_00)
                .clickContinue()
                .clickContinue()
                .inputDescription(description)
                .clickContinue()
                .clickTransfer();
        String name = FIRST_NAME_POTENTIA + " " + LAST_NAME_ARULSELVAN;
        resultPage.validateLocalPaynowResult(name, AMOUNT_2_00, false);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
