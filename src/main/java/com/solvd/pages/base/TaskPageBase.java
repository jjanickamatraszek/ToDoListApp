package com.solvd.pages.base;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TaskPageBase extends AbstractPage implements IMobileUtils {

    protected TaskPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTaskText();

    public abstract String getCategory();

    public abstract String getTimeAndReminderSetting();

    public abstract String getRepeatTaskSetting();

    public abstract int getNotesAmount();

    public abstract String getTaskDueDate();

    public abstract String getTaskTime();

    public abstract String getReminderAtTime();
}
