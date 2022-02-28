package page;

import constant.KycLocator;
import constant.DataTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

import static constant.KycLocator.*;

import static constant.DataTest.*;

public class KycPage extends BasePage {

    public KycPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public KycPage clickDoKyc() {
        this.click(By.xpath(DO_KYC));
        this.click(By.xpath(KYC_CONFIRM));
        return this;
    }

    public KycPage inputName(String name) {
        this.inputValue(By.xpath(KYC_NAME), name);
        this.click(By.xpath(KYC_CONTINUE));
        return this;
    }

    public KycPage selectDateOfBirth() {
        this.click(By.xpath(DATE_OF_BIRTH));
        this.click(By.id("android:id/date_picker_header_year"));
        MobileElement element = driver.findElement(By.xpath(Y_1999));
        Actions action = new Actions(driver);
        action.clickAndHold(element);
        action.moveByOffset(100, 2500);
        action.perform();
        this.click(By.xpath(YEAR));
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        System.out.println(month);
        if (month < 11) {
            for (int i = 0; i < 11 - month; i++) {
                this.click(By.xpath(NEXT_MONTH));
            }
        } else if (month > 11){
            for (int i = 0; i < month - 11; i++) {
                this.click(By.xpath(PREV_MONTH));
            }
        }
        this.click(By.xpath(DATE));
        this.click(By.xpath(DATE_OK));
        this.click(By.xpath(PICK_DATE_CONTINUE));
        return this;
    }

    public KycPage selectNationality() {
        this.click(By.xpath(OPEN_SELECT_NATIONALITY));
        this.click(By.xpath(SINGAPORE));
        this.click(By.xpath(KYC_CONFIRM));
        return this;
    }

    public KycPage inputAddress() {
        this.inputValue(By.xpath(ADDRESS_LINE_1), ADDRESS_1);
        this.inputValue(By.xpath(ADDRESS_LINE_2), ADDRESS_2);
        this.inputValue(By.xpath(KycLocator.POSTCODE), DataTest.POSTCODE);
        this.click(By.xpath(ADDRESS_CONTINUE));
        return this;
    }

    public KycPage takeSelfie() {
        this.click(By.xpath(READY_SELFIE));
        this.click(By.xpath(CAMERA_ONE_TIME));
        this.click(By.xpath(CAMERA_ONE_TIME));
        this.click(By.xpath(TAKE_SELFIE));
        this.click(By.xpath(PHOTO_OK));
        return this;
    }

    public void inputIDInfo() {
        this.click(By.xpath(ID_CARD_VERIFY));
        this.click(By.xpath(ID_CARD_TYPE));
        this.click(By.xpath(SG_CITIZEN));
        this.inputValue(By.xpath(ID_NUMBER), "S8633338D");
        this.click(By.xpath(ID_CARD_CONTINUE));
        this.click(By.xpath(TAKE_ID_PHOTO));
        this.click(By.xpath(PHOTO_OK));
        this.click(By.xpath(TAKE_ID_PHOTO));
        this.click(By.xpath(PHOTO_OK));
        this.click(By.xpath(FINISH_KYC));
    }
}
