package com.solvd.pages.base;

import com.solvd.consts.TaskPredefinedTime;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TaskTimeSettingPageBase extends AbstractPage {

    protected TaskTimeSettingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TaskTimeSettingPageBase selectPredefinedTime(TaskPredefinedTime time);

    public abstract TaskDateSettingsPageBase clickDoneBtn();
}
