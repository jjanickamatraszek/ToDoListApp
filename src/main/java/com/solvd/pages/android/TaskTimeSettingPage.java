package com.solvd.pages.android;

import com.solvd.consts.TaskPredefinedTime;
import com.solvd.pages.base.TaskDateSettingsPageBase;
import com.solvd.pages.base.TaskTimeSettingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TaskTimeSettingPageBase.class)
public class TaskTimeSettingPage extends TaskTimeSettingPageBase {

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'dialog_time_confirm')]")
    private ExtendedWebElement doneBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'time_7')]")
    private ExtendedWebElement am7Btn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'time_10')]")
    private ExtendedWebElement am10Btn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'time_16')]")
    private ExtendedWebElement pm04Btn;

    public TaskTimeSettingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TaskTimeSettingPage selectPredefinedTime(TaskPredefinedTime time) {
        switch (time) {

            case AM7 -> {
                am7Btn.click();
            }
            case AM10 -> {
                am10Btn.click();
            }
            case PM4 -> {
                pm04Btn.click();
            }
        }
        return this;
    }

    @Override
    public TaskDateSettingsPageBase clickDoneBtn() {
        doneBtn.click();
        return initPage(TaskDateSettingsPageBase.class);
    }
}
