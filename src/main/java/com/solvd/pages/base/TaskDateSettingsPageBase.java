package com.solvd.pages.base;

import com.solvd.consts.TaskPredefinedDay;
import org.openqa.selenium.WebDriver;

public abstract class TaskDateSettingsPageBase extends BaseToDoListAppBase {

    protected TaskDateSettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TaskDateSettingsPageBase selectDay(TaskPredefinedDay day);

    public abstract TaskDateSettingsPageBase clickNoDateBtn();

    public abstract String getTaskTime();

    public abstract String getReminderAtValue();

    public abstract String getTaskRepeatSetting();

    public abstract void clickDoneBtn();

    public abstract TaskTimeSettingPageBase clickTimeSettingBtn();

    public abstract ReminderPageBase clickReminderSettingBtn();
}
