package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.Common.*;
import static constant.ConnectionLocator.*;

public class ConnectionPage extends BasePage {

    public ConnectionPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ConnectionPage scrollDown(By locatorScroll, int xOffset, int yOffset) throws InterruptedException{
        this.scroll(locatorScroll, xOffset, yOffset);
        return this;
    }

    public ConnectionPage choseTypeConnectionByLocator(String typeConnection) {
        this.click(By.cssSelector(typeConnection));
        return this;
    }

    public ConnectionPage clickAddConnectionIcon() {
        this.click(By.xpath(ADD_CONNECTION_BUTTON));
        return this;
    }

    public ConnectionPage clickSelectBank() {
        this.click(By.cssSelector(CSS_SELECT_OPTION));
        return this;
    }

    public ConnectionPage selectLocalBankByLocator(String bankLocator) {
        this.click(By.cssSelector(bankLocator));
        return this;
    }

    public ConnectionPage inputFirstName(String firstName) {
        this.inputValue(By.cssSelector(CSS_ACC_FIRST_NAME), firstName);
        return this;
    }

    public ConnectionPage inputLastName(String lastName) {
        this.inputValue(By.cssSelector(CSS_ACC_LAST_NAME), lastName);
        return this;
    }

    public ConnectionPage inputOptionalEmail(String email) {
        this.inputValue(By.cssSelector(CSS_ACC_EMAIL), email);
        return this;
    }

    public ConnectionPage inputAccountNumber(String accNumber) {
        this.inputValue(By.cssSelector(CSS_ACC_NUMBER), accNumber);
        return this;
    }

    public ConnectionPage clickValidate() {
        this.click(By.cssSelector(CSS_VALIDATE));
        return this;
    }

    public ConnectionPage clickCountryToTransferByLocator(String countryLocator) {
        this.click(By.cssSelector(countryLocator));
        return this;
    }

    public ConnectionPage clickIndividual() throws InterruptedException {
        Thread.sleep(600);
        this.click(By.cssSelector(CSS_INDIVIDUAL));
        return this;
    }

    public ConnectionPage clickAllIndoBank() {
        this.click(By.cssSelector(CSS_ALL_INDO_BANK));
        return this;
    }

    public ConnectionPage clickLinkAja() {
        this.click(By.cssSelector(CSS_LINK_AJA));
        return this;
    }

    public ConnectionPage inputFirstnameSymbol(String firstname) {
        this.inputValue(By.cssSelector(CSS_FIRST_NAME_SYMBOL), firstname);
        return this;
    }

    public ConnectionPage inputLastnameSymbol(String lastname) {
        this.inputValue(By.cssSelector(CSS_LAST_NAME_SYMBOL), lastname);
        return this;
    }

    public ConnectionPage inputAddressSymbol(String address) {
        this.inputValue(By.cssSelector(CSS_ADDRESS_SYMBOL), address);
        return this;
    }

    public ConnectionPage selectIndoBankByLocator(String bankLocator) {
        this.click(By.cssSelector(CSS_BANK_NAME_SYMBOL));
        this.click(By.cssSelector(bankLocator));
        return this;
    }

    public ConnectionPage inputAccNumberSymbol(String accNumber) {
        this.inputValue(By.cssSelector(CSS_ACC_NUMBER_SYMBOL), accNumber);
        return this;
    }

    public ConnectionPage clickIdentificationType() {
        this.click(By.cssSelector(CSS_IDENTIFICATION_TYPE_SYMBOL));
        return this;
    }

    public ConnectionPage selectIdentificationTypeByLocator(String locator) {
        this.click(By.cssSelector(locator));
        return this;
    }

    public ConnectionPage inputIdentificationValueSymbol(String identificationValue) {
        this.inputValue(By.cssSelector(CSS_IDENTIFICATION_VALUE_SYMBOL), identificationValue);
        return this;
    }

    public ConnectionPage inputPhoneNumberSymbol(String phoneValue) {
        this.inputValue(By.cssSelector(CSS_PHONE_NUMBER_SYMBOL), phoneValue);
        return this;
    }

    public ConnectionPage inputOccupationSymbol(String occupationValue) {
        this.inputValue(By.cssSelector(CSS_OCCUPATION_SYMBOL), occupationValue);
        return this;
    }

    public ConnectionPage selectSourceIncomeSymbolByLocator(String sourceLocator) {
        this.click(By.cssSelector(CSS_SOURCE_INCOME_SYMBOL));
        this.click(By.cssSelector(sourceLocator));
        return this;
    }

    public ConnectionPage selectPurposeCodeSymbolByLocator(String purposeLocator) {
        this.click(By.cssSelector(CSS_PURPOSE_CODE_SYMBOL));
        this.click(By.cssSelector(purposeLocator));
        return this;
    }

    public ConnectionPage selectRelationshipSymbolByLocator(String beneficiaryLocator) {
        this.click(By.cssSelector(CSS_RELATIONSHIP_SYMBOL));
        this.click(By.cssSelector(beneficiaryLocator));
        return this;
    }

    public ConnectionPage selectPhilBankTransferByLocator(String bankLocator) {
        this.click(By.cssSelector(bankLocator));
        return this;
    }
}
