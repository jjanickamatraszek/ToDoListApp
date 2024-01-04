package com.solvd.pages.android;

import com.solvd.pages.base.SpecialOfferPageBase;
import com.solvd.pages.base.SpecialOfferPopupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SpecialOfferPageBase.class)
public class SpecialOfferPage extends SpecialOfferPageBase {

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'toolbar_back')]")
    private ExtendedWebElement closeScreenBtn;

    public SpecialOfferPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SpecialOfferPopupPageBase clickCloseScreenBtn() {
        closeScreenBtn.click();
        return initPage(SpecialOfferPopupPageBase.class);
    }
}
