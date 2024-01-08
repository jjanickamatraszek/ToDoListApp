package com.solvd.pages.android;

import com.solvd.pages.base.SpecialOfferPageBase;
import com.solvd.pages.base.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(xpath = ".//android.widget.FrameLayout[contains(@resource-id, 'welcome_start')]")
    private ExtendedWebElement continueBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SpecialOfferPageBase clickContinueBtn() {
        continueBtn.click();
        return initPage(SpecialOfferPageBase.class);
    }
}
