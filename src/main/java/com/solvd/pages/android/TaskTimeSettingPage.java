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

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'time_%d')]")
    private ExtendedWebElement hourBtnFormatted;

    public TaskTimeSettingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TaskTimeSettingPage selectPredefinedTime(TaskPredefinedTime time) {
        hourBtnFormatted.format(time.getHourByNumber()).click();
        return this;
    }

    @Override
    public TaskDateSettingsPageBase clickDoneBtn() {
        doneBtn.click();
        return initPage(TaskDateSettingsPageBase.class);
    }
}
