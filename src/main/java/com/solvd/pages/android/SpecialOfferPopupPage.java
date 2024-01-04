package com.solvd.pages.android;

import com.solvd.pages.base.SpecialOfferPopupPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SpecialOfferPopupPageBase.class)
public class SpecialOfferPopupPage extends SpecialOfferPopupPageBase {

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'dialog_close')]")
    private ExtendedWebElement giveUpSpecialOfferPopupCloseBtn;

    public SpecialOfferPopupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TasksPageBase closePopup() {
        giveUpSpecialOfferPopupCloseBtn.click();
        return initPage(TasksPageBase.class);
    }
}
