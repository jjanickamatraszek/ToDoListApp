package com.solvd.pages.android;

import com.solvd.consts.TaskPredefinedDay;
import com.solvd.pages.base.ReminderPageBase;
import com.solvd.pages.base.TaskDateSettingsPageBase;
import com.solvd.pages.base.TaskTimeSettingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TaskDateSettingsPageBase.class)
public class TaskDateSettingsPage extends TaskDateSettingsPageBase {

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'tv_confirm')]")
    private ExtendedWebElement doneBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'tv_cancel')]")
    private ExtendedWebElement cancelBtn;

    @FindBy(xpath = ".//android.widget.TextView[@text='Time']/following-sibling::android.widget.TextView[contains(@resource-id, 'item_time')]")
    private ExtendedWebElement timeSettingBtn;

    @FindBy(xpath = ".//android.widget.TextView[@text='Reminder']/following-sibling::android.widget.TextView[contains(@resource-id, 'item_time')]")
    private ExtendedWebElement reminderSettingBtn;

    @FindBy(xpath = ".//android.widget.TextView[@text='Repeat']/following-sibling::android.widget.TextView[contains(@resource-id, 'item_time')]")
    private ExtendedWebElement repeatSetting;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'calendar_today')]")
    private ExtendedWebElement todayBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'calendar_tomorrow')]")
    private ExtendedWebElement tomorrowBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'calendar_no_day')]")
    private ExtendedWebElement noDateBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'calendar_3_days_later')]")
    private ExtendedWebElement threeDaysLaterBtn;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'calendar_sunday')]")
    private ExtendedWebElement thisSundayBtn;

    public TaskDateSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TaskDateSettingsPageBase selectDay(TaskPredefinedDay day) {
        switch (day) {
            case TODAY -> {
                todayBtn.click();
            }
            case TOMORROW -> {
                tomorrowBtn.click();
            }
            case THREE_DAY_LATER -> {
                threeDaysLaterBtn.click();
            }
            case THIS_SUNDAY -> {
                thisSundayBtn.click();
            }
        }
        return this;
    }

    @Override
    public TaskDateSettingsPageBase clickNoDateBtn() {
        noDateBtn.click();
        return this;
    }

    @Override
    public String getTaskTime() {
        swipe(timeSettingBtn, 3);
        return timeSettingBtn.getText();
    }

    @Override
    public String getReminderAtValue() {
        return reminderSettingBtn.getText();
    }

    @Override
    public String getTaskRepeatSetting() {
        swipe(repeatSetting);
        return repeatSetting.getText();
    }

    @Override
    public void clickDoneBtn() {
        doneBtn.click();
    }

    @Override
    public TaskTimeSettingPageBase clickTimeSettingBtn() {
        timeSettingBtn.click();
        return initPage(TaskTimeSettingPageBase.class);
    }

    @Override
    public ReminderPageBase clickReminderSettingBtn() {
        reminderSettingBtn.click();
        return initPage(ReminderPageBase.class);
    }
}
