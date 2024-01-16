package com.solvd.pages.base;

import com.solvd.consts.TaskPredefinedTime;
import org.openqa.selenium.WebDriver;

public abstract class TaskTimeSettingPageBase extends BaseToDoListAppBase {

    protected TaskTimeSettingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TaskTimeSettingPageBase selectPredefinedTime(TaskPredefinedTime time);

    public abstract TaskDateSettingsPageBase clickDoneBtn();
}
