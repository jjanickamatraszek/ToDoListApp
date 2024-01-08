package com.solvd.pages.base;

import com.solvd.consts.FlagColor;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class TasksPageBase extends AbstractPage implements IMobileUtils {

    protected TasksPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCreateTaskPromptVisible();

    public abstract InputTaskPageBase clickAddTaskBtn();

    public abstract TasksPageBase skipTutorial();

    public abstract TasksPageBase swipeLeftOnTask(String taskText);

    public abstract TasksPageBase clickDeleteTaskBtn();

    public abstract TasksPageBase confirmDeleteTask();

    public abstract TaskDateSettingsPageBase clickEditTaskDateBtn();

    public abstract TaskPageBase openTaskByText(String taskText);

    public abstract TaskPageBase openTaskByIndex(int id);

    public abstract int getNumberOfTodayTasksListed();

    public abstract boolean areTasksDisplayedOnTodayList(List<String> tasksTexts);

    public abstract boolean areTasksDisplayedOnFutureList(List<String> tasksTexts);

    public abstract boolean isFlagDisplayed(FlagColor color);

    public abstract TasksPageBase skipRateApp();

    public abstract boolean isEmptyTaskWarningDisplayed();

    public abstract boolean isTaskTextTrimmedForLongDesc(String taskText);

    public abstract boolean isTaskDateVisible(String taskText);

    public abstract String getTaskDate(String taskText);

    public abstract TasksPageBase closeReminderPermissionPopup();
}
