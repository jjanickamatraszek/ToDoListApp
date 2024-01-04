package com.solvd.pages.base;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TasksPageBase extends AbstractPage implements IMobileUtils {

    protected TasksPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCreateTaskPromptVisible();

    public abstract TasksPageBase clickAddTaskBtn();

    public abstract TasksPageBase inputTaskDesc(String taskText);

    public abstract TasksPageBase clickAddTaskConfirmBtn();

    public abstract TasksPageBase skipTutorial();

    public abstract TasksPageBase swipeLeftOnTask(String taskText);

    public abstract TasksPageBase clickDeleteTaskBtn();

    public abstract TasksPageBase confirmDeleteTask();
}
