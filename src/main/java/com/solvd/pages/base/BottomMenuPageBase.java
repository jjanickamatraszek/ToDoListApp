package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class BottomMenuPageBase extends BaseToDoListAppBase {

    protected BottomMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TasksPageBase clickTasksBtn();

    public abstract CalendarPageBase clickCalendarBtn();

    public abstract SideMenuPageBase clickMenuBtn();
}
