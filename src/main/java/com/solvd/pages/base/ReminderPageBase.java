package com.solvd.pages.base;

import com.solvd.consts.ReminderValue;
import org.openqa.selenium.WebDriver;

public abstract class ReminderPageBase extends BaseToDoListAppBase {

    protected ReminderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ReminderPageBase openReminderDropDown();

    public abstract ReminderPageBase selectReminderValue(ReminderValue value);

    public abstract ReminderPageBase closeReminderDropDown();

    public abstract TaskDateSettingsPageBase clickDoneBtn();
}
