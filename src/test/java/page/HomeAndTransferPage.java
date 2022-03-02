package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static constant.Common.*;
import static constant.HomePageLocator.*;

public class HomeAndTransferPage extends BasePage {

    public HomeAndTransferPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomeAndTransferPage clickFirstAccount () {
        this.click(By.xpath(FIRST_ACC));
        return this;
    }

    public HomeAndTransferPage clickSendButton() throws InterruptedException {
        this.click(By.cssSelector(CSS_SEND_BUTTON));
        Thread.sleep(500);
        return this;
    }

    public HomeAndTransferPage clickLocalPaynow() {
//        this.click(By.cssSelector(CSS_LOCAL_PAY_NOW));
        this.click(By.xpath(LOCAL_PAY_NOW));
        return this;
    }

    public HomeAndTransferPage clickPaynowOption() {
        this.click(By.xpath(PAY_NOW_OPTION));
        return this;
    }

    public HomeAndTransferPage clickPaynowMobile() {
        this.click(By.xpath(PAY_NOW_MOBILE));
        return this;
    }

    public HomeAndTransferPage inputMobileNumber(String mobile) {
        this.inputValue(By.xpath(MOBILE_NUMBER_PAYNOW), mobile);
        return this;
    }

    public HomeAndTransferPage inputFirstname(String firstname) {
        this.inputValue(By.cssSelector(CSS_FIRSTNAME), firstname);
        return this;
    }

    public HomeAndTransferPage inputLastname(String lastname) {
        this.inputValue(By.cssSelector(CSS_LASTNAME), lastname);
        return this;
    }

    public HomeAndTransferPage clickContinue() throws InterruptedException {
        Thread.sleep(500);
        this.click(By.cssSelector(CSS_CONTINUE));
        return this;
    }

    public HomeAndTransferPage inputPaynowAmount(String amount) {
        this.inputValue(By.xpath(PAYNOW_AMOUNT), amount);
        return this;
    }

    public HomeAndTransferPage inputDescription(String desc) {
        this.inputValue(By.xpath(DESCRIPTION), desc);
        return this;
    }

    public HomeAndTransferPage clickConfirm() {
        this.click(By.cssSelector(CSS_CONFIRM));
        return this;
    }

    public HomeAndTransferPage clickTransfer() {
        this.click(By.cssSelector(CSS_TRANSFER));
        return this;
    }

    public HomeAndTransferPage clickNRIC() {
        this.click(By.xpath(NRIC_PAYNOW));
        return this;
    }

    public HomeAndTransferPage inputNRIC(String Nric) throws InterruptedException {
        Thread.sleep(500);
        this.inputValue(By.xpath(NRIC_NUMBER_INPUT), Nric);
        return this;
    }

    public HomeAndTransferPage clickPaynowUen() {
        this.click(By.xpath(PAY_NOW_UEN));
        return this;
    }

    public HomeAndTransferPage inputUen(String uen) throws InterruptedException {
        Thread.sleep(500);
        this.inputValue(By.xpath(UEN_INPUT), uen);
        return this;
    }

    public HomeAndTransferPage clickOverseaBankAcc() {
        this.click(By.cssSelector(CSS_OVERSEA_BANK_ACC));
        return this;
    }

    public HomeAndTransferPage clickOverseaCashPayout() {
        //Cannot click by css this place??? so weird
//        this.click(By.cssSelector(CSS_OVERSEA_CASH_PAYOUT));
        this.click(By.xpath(OVERSEA_CASH_PAYOUT));
        return this;
    }

    public HomeAndTransferPage clickOverseaMobileMoney() {
//        this.click(By.cssSelector(CSS_OVERSEA_MOBILE_MONEY));
        this.click(By.xpath(OVERSEA_MOBILE_MONEY));
        return this;
    }

    public HomeAndTransferPage clickLocalBankAccount() {
        this.click(By.cssSelector(CSS_LOCAL_BANK_ACCOUNT));
//        this.click(By.xpath(OVERSEA_MOBILE_MONEY));
        return this;
    }

    public HomeAndTransferPage clickGCash() {
        this.click(By.cssSelector(CSS_GCASH));
        return this;
    }

    public HomeAndTransferPage clickCountryToTransferByLocator(String countryLocator) {
        this.click(By.cssSelector(countryLocator));
        return this;
    }

    public HomeAndTransferPage clickIndividual() throws InterruptedException {
        Thread.sleep(6000);
        this.click(By.cssSelector(CSS_INDIVIDUAL));
        return this;
    }

    public HomeAndTransferPage clickAllIndoBank() {
        this.click(By.cssSelector(CSS_ALL_INDO_BANK));
        return this;
    }

    public HomeAndTransferPage clickLinkAja() {
        this.click(By.cssSelector(CSS_LINK_AJA));
        return this;
    }

    public HomeAndTransferPage selectPhilBankTransferByLocator(String bankLocator) {
        this.click(By.cssSelector(bankLocator));
        return this;
    }

    public HomeAndTransferPage selectPhilCashPayoutBankByLocator(String bankCashPayoutLocator) {
        this.click(By.cssSelector(bankCashPayoutLocator));
        return this;
    }

    public HomeAndTransferPage inputBankAmount(String amount) {
        this.inputValue(By.xpath(BANK_AMOUNT), amount);
        return this;
    }

    public HomeAndTransferPage inputFirstnameSymbol(String firstname) {
        this.inputValue(By.cssSelector(CSS_FIRST_NAME_SYMBOL), firstname);
        return this;
    }

    public HomeAndTransferPage inputLastnameSymbol(String lastname) {
        this.inputValue(By.cssSelector(CSS_LAST_NAME_SYMBOL), lastname);
        return this;
    }

    public HomeAndTransferPage inputMiddlenameSymbol(String middlename) {
        this.inputValue(By.cssSelector(CSS_MIDDLE_NAME_SYMBOL), middlename);
        return this;
    }

    public HomeAndTransferPage inputMiddlename(String middlename) {
        this.inputValue(By.cssSelector(CSS_MIDDLE_NAME), middlename);
        return this;
    }

    public HomeAndTransferPage inputEmailSymbol(String email) {
        this.inputValue(By.cssSelector(CSS_EMAIL_SYMBOL), email);
        return this;
    }

    public HomeAndTransferPage inputMobileSymbol(String mobile) {
        this.inputValue(By.cssSelector(CSS_MOBILE_SYMBOL), mobile);
        return this;
    }

    public HomeAndTransferPage inputNationalitySymbol(String nationality) {
        this.inputValue(By.cssSelector(CSS_NATIONALITY_SYMBOL), nationality);
        return this;
    }

    public HomeAndTransferPage inputCitySymbol(String city) {
        this.inputValue(By.cssSelector(CSS_CITY_SYMBOL), city);
        return this;
    }

    public HomeAndTransferPage inputStateSymbol(String state) {
        this.inputValue(By.cssSelector(CSS_STATE_SYMBOL), state);
        return this;
    }

    public HomeAndTransferPage inputAddressSymbol(String address) {
        this.inputValue(By.cssSelector(CSS_ADDRESS_SYMBOL), address);
        return this;
    }

    public HomeAndTransferPage inputLinkAjaAccNumber(String accNumber) {
        this.inputValue(By.xpath(LINK_AJA_ACC_NUMBER_INPUT), accNumber);
        return this;
    }

    public HomeAndTransferPage selectIndoBankByLocator(String bankLocator) {
        this.click(By.cssSelector(CSS_BANK_NAME_SYMBOL));
        this.click(By.cssSelector(bankLocator));
        return this;
    }

    public HomeAndTransferPage scrollDown(By locatorScroll, int xOffset, int yOffset) throws InterruptedException{
        this.scroll(locatorScroll, xOffset, yOffset);
        return this;
    }

    public HomeAndTransferPage clickIdentificationType() {
        this.click(By.cssSelector(CSS_IDENTIFICATION_TYPE_SYMBOL));
        return this;
    }

    public HomeAndTransferPage selectLocalBankByLocator(String bankLocator) {
        this.click(By.cssSelector(bankLocator));
        return this;
    }

    public HomeAndTransferPage clickSelectBank() {
        this.click(By.cssSelector(CSS_SELECT_OPTION));
        return this;
    }

    public HomeAndTransferPage inputIdentificationValueSymbol(String identificationValue) {
        this.inputValue(By.cssSelector(CSS_IDENTIFICATION_VALUE_SYMBOL), identificationValue);
        return this;
    }

    public HomeAndTransferPage selectIdentificationTypeByLocator(String locator) {
        this.click(By.cssSelector(locator));
        return this;
    }

    public HomeAndTransferPage inputPhoneNumberSymbol(String phoneValue) {
        this.inputValue(By.cssSelector(CSS_PHONE_NUMBER_SYMBOL), phoneValue);
        return this;
    }

    public HomeAndTransferPage inputOccupationSymbol(String occupationValue) {
        this.inputValue(By.cssSelector(CSS_OCCUPATION_SYMBOL), occupationValue);
        return this;
    }

    public HomeAndTransferPage selectSourceIncomeSymbolByLocator(String sourceLocator) {
        this.click(By.cssSelector(CSS_SOURCE_INCOME_SYMBOL));
        this.click(By.cssSelector(sourceLocator));
        return this;
    }

    public HomeAndTransferPage selectPurposeCodeSymbolByLocator(String purposeLocator) {
        this.click(By.cssSelector(CSS_PURPOSE_CODE_SYMBOL));
        this.click(By.cssSelector(purposeLocator));
        return this;
    }

    public HomeAndTransferPage selectRelationshipSymbolByLocator(String beneficiaryLocator) {
        this.click(By.cssSelector(CSS_RELATIONSHIP_SYMBOL));
        this.click(By.cssSelector(beneficiaryLocator));
        return this;
    }

    public HomeAndTransferPage inputAccNumberSymbol(String accNumber) {
        this.inputValue(By.cssSelector(CSS_ACC_NUMBER_SYMBOL), accNumber);
        return this;
    }

    public HomeAndTransferPage inputAccNumber(String accNumber) {
        this.inputValue(By.cssSelector(CSS_ACC_NUMBER), accNumber);
        return this;
    }

    public HomeAndTransferPage inputEmailOptional(String email) {
        this.inputValue(By.cssSelector(CSS_EMAIL_OPTIONAL), email);
        return this;
    }

    public HomeAndTransferPage clickSaveConnection() {
        this.click(By.cssSelector(CSS_SAVE_TO_CONNECTIONS));
        return this;
    }

    public HomeAndTransferPage clickCloseResult() {
        this.click(By.cssSelector(CSS_SAVE_SHARE));
        return this;
    }

    public HomeAndTransferPage clickMenuButton() {
        this.click(By.xpath(MENU_BUTTON));
        return this;
    }

    public ConnectionPage clickConnectionInMenu() {
        this.click(By.cssSelector(MENU_CONNECTION_CHOICE));
        return new ConnectionPage(driver, wait);
    }

    public void validateBankTransferResult(String firstname, String lastname, String amount, String country, String bankName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SAVE_SHARE)));
        String nameCss = "android.widget.TextView[text=\"" + firstname + " " + lastname + "\"]";
        String locationCss = "android.widget.TextView[text=\"" + country + "\"]";
        String bankNameCss = "android.widget.TextView[text=\"" + bankName + "\"]";
        String amountCss = "android.widget.TextView[text=\"" + "$" + amount + "\"]";

        String beneficiaryResult = this.getTextByLocator(By.cssSelector(nameCss));
        String bankLocationResult = this.getTextByLocator(By.cssSelector(locationCss));
        String bankNameResult = this.getTextByLocator(By.cssSelector(bankNameCss));
        String amountResult = this.getTextByLocator(By.cssSelector(amountCss));

        String beneficiaryNameCheck = firstname + " " + lastname;
        String amountCheck = "$" + amount;

        Assert.assertEquals(beneficiaryResult, beneficiaryNameCheck);
        Assert.assertEquals(bankLocationResult, country);
        Assert.assertEquals(bankNameResult, bankName);
        Assert.assertEquals(amountResult, amountCheck);
    }

    public void validateLocalPaynowResult(String transferTo, String amount, boolean isMobile) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SAVE_SHARE)));
        String transferToCheck;
        if (isMobile) {
            transferToCheck = "+65" + transferTo;
        } else {
            transferToCheck = transferTo;
        }
        String amountCheck = "$" + amount;
        String amountCss = "android.widget.TextView[text=\"" + amountCheck + "\"]";
        String transferToCss = "android.widget.TextView[text=\"" + transferToCheck + "\"]";
        var transferToEl = driver.findElements(By.cssSelector(transferToCss));
        var amountEl = driver.findElements(By.cssSelector(amountCss));
        Assert.assertEquals(transferToEl.size(), 1);
        Assert.assertEquals(amountEl.size(), 1);
    }

    public void validateBalance(Float oldBalance, Float newBalance, Float transferAmount) {
        Float trueBalance = oldBalance - transferAmount;
        System.out.println(oldBalance);
        System.out.println(transferAmount);
        System.out.println(trueBalance);
        System.out.println(newBalance);
        Assert.assertEquals(trueBalance, newBalance);
    }
}
