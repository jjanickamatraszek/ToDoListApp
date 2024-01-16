package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class InputTaskPageBase extends BaseToDoListAppBase {

    protected InputTaskPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void inputTaskText(String taskText);

    public abstract void clickAddTaskConfirmBtn();

    public abstract TasksPageBase leaveInputTaskMode();

    public abstract TaskDateSettingsPageBase clickSelectDateBtn();
}
