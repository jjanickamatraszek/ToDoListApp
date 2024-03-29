package com.solvd;

import com.solvd.pages.base.InputTaskPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayCreateTaskPromptTests extends ToDoListBaseTest {

    @Test
    @TestCaseKey(value = "JOANNA-46")
    public void displayCreateTaskPromptAfterLaunchTest() {
        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        Assert.assertTrue(tasksPage.isCreateTaskPromptVisible(),
                "Create task prompt is not displayed after first app launch");
    }

    @Test
    @TestCaseKey(value = "JOANNA-47")
    public void displayCreateTaskPromptWhenTaskListEmptyTest() {
        String taskText = "my task";
        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(taskText);
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial();

        tasksPage.swipeLeftOnTask(taskText);
        tasksPage.clickDeleteTaskBtn();
        tasksPage.confirmDeleteTask();

        Assert.assertTrue(tasksPage.isCreateTaskPromptVisible(),
                "Create task prompt is not displayed after removing last task from task list");
    }
}
