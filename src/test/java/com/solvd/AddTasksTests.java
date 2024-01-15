package com.solvd;

import com.solvd.consts.*;
import com.solvd.pages.base.InputTaskPageBase;
import com.solvd.pages.base.TaskDateSettingsPageBase;
import com.solvd.pages.base.TaskPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.solvd.utils.TimeDateUtils;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class AddTasksTests extends ToDoListBaseTest {

    @DataProvider
    public Object[][] predefinedTaskTimeDateAndReminders() {
        return new Object[][]{
                {TaskPredefinedDay.TOMORROW, LocalDate.now().plusDays(1), TaskPredefinedTime.AM10, ReminderValue.MIN_10_BEFORE},
                {TaskPredefinedDay.THREE_DAY_LATER, LocalDate.now().plusDays(3), TaskPredefinedTime.AM7, ReminderValue.MIN_15_BEFORE},
                {TaskPredefinedDay.THIS_SUNDAY, TimeDateUtils.getThisSundayLocalDate(LocalDate.now()), TaskPredefinedTime.PM4, ReminderValue.MIN_30_BEFORE}
        };
    }

    @Test
    @TestCaseKey(value = "JOANNA-48")
    public void addSimpleTaskTest() {
        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial();
        Assert.assertTrue(tasksPage.areTasksDisplayedOnTodayList(List.of(expectedTaskText)),
                "Task '%s' isn't displayed on the list for TODAY".formatted(expectedTaskText));
        Assert.assertFalse(tasksPage.isTaskDateVisible(expectedTaskText),
                "Task planned for today has a date displayed.");
        Assert.assertTrue(tasksPage.isFlagDisplayed(FlagColor.DEFAULT),
                "Newly added task doesn't have default flag set");

        TaskDateSettingsPageBase taskDateSettingsPage = tasksPage.swipeLeftOnTask(expectedTaskText)
                .clickEditTaskDateBtn();
        Assert.assertEquals(taskDateSettingsPage.getTaskTime(), DefaultTaskSettings.timeAndReminderSetting,
                "Newly created simple task has default time setting different than expected");
        Assert.assertEquals(taskDateSettingsPage.getTaskRepeatSetting(), DefaultTaskSettings.repeatTaskSetting,
                "Newly created simple task has default repeat setting different than expected");
        taskDateSettingsPage.clickDoneBtn();

        TaskPageBase myTaskPage = tasksPage.openTaskByText(expectedTaskText);
        Assert.assertEquals(myTaskPage.getTaskText(), expectedTaskText,
                "Task text displayed on task screen is different than expected");
        Assert.assertEquals(myTaskPage.getCategory(), TaskCategory.DEFAULT.getName(),
                "Category setting displayed on task screen for newly created task is different than default one");
        Assert.assertEquals(myTaskPage.getTimeAndReminderSetting(), DefaultTaskSettings.timeAndReminderSetting,
                "Time and reminder setting displayed on task screen for newly created task is different than default one");
        Assert.assertEquals(myTaskPage.getRepeatTaskSetting(), DefaultTaskSettings.repeatTaskSetting,
                "Repeat task setting displayed on task screen for newly created task ia different than default one");
        Assert.assertEquals(myTaskPage.getNotesAmount(), 0,
                "Newly created task has some notes added when should have none");
    }

    @Test
    @TestCaseKey(value = "JOANNA-49")
    public void addThreeSimpleTasksInRowTest() {
        List<String> tasksToAddInRow = List.of("my task 1", "my task 2", "my task 3");
        int expectedTaskAmount = 4;

        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial()
                .clickAddTaskBtn()
                .inputTaskText(tasksToAddInRow.get(0));
        inputTaskPage.clickAddTaskConfirmBtn();
        inputTaskPage.inputTaskText(tasksToAddInRow.get(1));
        inputTaskPage.clickAddTaskConfirmBtn();
        inputTaskPage.inputTaskText(tasksToAddInRow.get(2));
        inputTaskPage.clickAddTaskConfirmBtn();
        inputTaskPage.leaveInputTaskMode()
                .skipRateApp();
        Assert.assertEquals(tasksPage.getNumberOfTodayTasksListed(), expectedTaskAmount,
                "Amount of listed tasks is different than expected");
        Assert.assertTrue(tasksPage.areTasksDisplayedOnTodayList(tasksToAddInRow),
                "Some of the tasks aren't displayed on the task list");
    }

    @Test
    @TestCaseKey(value = "JOANNA-50")
    public void dontAddEmptyTaskTest() {
        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText("");
        inputTaskPage.clickAddTaskConfirmBtn();
        Assert.assertTrue(tasksPage.isEmptyTaskWarningDisplayed(),
                "Warning message wasn't displayed");
        Assert.assertEquals(tasksPage.getNumberOfTodayTasksListed(), 0,
                "Task with empty text was added to the list");
    }

    @Test
    @TestCaseKey(value = "JOANNA-51")
    public void addTaskWithLongTextTest() {
        expectedTaskText = "aaaaaaaaaaBBBBBBBBBBccccccccccDDDDDDDDDDeeeeeeeeeeee";

        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial();
        Assert.assertTrue(tasksPage.isTaskTextTrimmedForLongDesc(expectedTaskText),
                "Task text isn't correctly trimmed or task isn't displayed on the tasks list");

        TaskPageBase taskPage = tasksPage.openTaskByIndex(0);
        Assert.assertEquals(taskPage.getTaskText(), expectedTaskText,
                "Task text isn't displayed entirely on task screen or is different than expected");
    }

    @Test
    @TestCaseKey(value = "JOANNA-52")
    public void addTaskForTodayTest() {
        LocalDate today = LocalDate.now();

        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        inputTaskPage.clickSelectDateBtn()
                .selectDay(TaskPredefinedDay.TODAY)
                .clickDoneBtn();
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial();
        Assert.assertTrue(tasksPage.areTasksDisplayedOnTodayList(List.of(expectedTaskText)),
                "Task '%s' isn't displayed on the tasks list for TODAY".formatted(expectedTaskText));
        Assert.assertFalse(tasksPage.isTaskDateVisible(expectedTaskText),
                "Task planned for today has a date displayed.");

        TaskPageBase taskPage = tasksPage.openTaskByText(expectedTaskText);
        Assert.assertEquals(taskPage.getTaskDueDate(), TimeDateUtils.parseDateToTaskPageDateFormat(today),
                "Task due date on task screen is different than expected");
    }

    @Test
    @TestCaseKey(value = "JOANNA-53")
    public void addTaskForTodayAtGivenTimeWithDefaultReminder() {
        TaskPredefinedTime expectedTaskTime = TaskPredefinedTime.AM7;

        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        TaskDateSettingsPageBase taskDateSettingsPage = inputTaskPage.clickSelectDateBtn();
        taskDateSettingsPage.clickTimeSettingBtn()
                .selectPredefinedTime(expectedTaskTime)
                .clickDoneBtn();
        Assert.assertEquals(taskDateSettingsPage.getTaskTime(), expectedTaskTime.getValue(),
                "Task time on task date setting screen is different than selected");
        Assert.assertEquals(taskDateSettingsPage.getReminderAtValue(), TimeDateUtils.moveBackTimeByMinutes(expectedTaskTime, DefaultTaskSettings.defaultReminderMinutes.getValue()),
                "Reminder time on task date setting screen is different than expected");

        taskDateSettingsPage.clickDoneBtn();
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial()
                .closeReminderPermissionPopup();
        Assert.assertTrue(tasksPage.areTasksDisplayedOnTodayList(List.of(expectedTaskText)),
                "Task '%s' isn't on the tasks list for TODAY".formatted(expectedTaskText));
        Assert.assertEquals(tasksPage.getTaskDate(expectedTaskText), expectedTaskTime.getValue_AMPM(),
                "Task time on the tasks list is different than expected");

        TaskPageBase taskPage = tasksPage.openTaskByText(expectedTaskText);
        Assert.assertEquals(taskPage.getTaskTime(), expectedTaskTime.getValue_AMPM(),
                "Task time on task screen is different than predefined time set during task creation");
        Assert.assertEquals(taskPage.getReminderAtTime(), TimeDateUtils.moveBackTimeByMinutes(expectedTaskTime, DefaultTaskSettings.defaultReminderMinutes.getValue()),
                "Reminder time on task screen is different than expected");
    }

    @Test
    @TestCaseKey(value = "JOANNA-54")
    public void addTaskForTomorrowTest() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        inputTaskPage.clickSelectDateBtn()
                .selectDay(TaskPredefinedDay.TOMORROW)
                .clickDoneBtn();
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial();
        Assert.assertTrue(tasksPage.areTasksDisplayedOnFutureList(List.of(expectedTaskText)),
                "Task '%s' isn't displayed on the tasks list for FUTURE".formatted(expectedTaskText));
        Assert.assertEquals(tasksPage.getTaskDate(expectedTaskText), TimeDateUtils.parseDateToTasksListPageDateFormat(tomorrow),
                "Task due date on the tasks list is different than expected");

        TaskPageBase taskPage = tasksPage.openTaskByText(expectedTaskText);
        Assert.assertEquals(taskPage.getTaskDueDate(), TimeDateUtils.parseDateToTaskPageDateFormat(tomorrow),
                "Task due date on task screen is different than expected");
    }

    @Test(dataProvider = "predefinedTaskTimeDateAndReminders")
    @TestCaseKey(value = "JOANNA-55")
    public void addTaskForFutureWithPredefinedTimeAndReminderTest(TaskPredefinedDay expectedDay, LocalDate expectedDate, TaskPredefinedTime expectedTime, ReminderValue reminderValue) {
        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        TaskDateSettingsPageBase taskDateSettingsPage = inputTaskPage.clickSelectDateBtn()
                .selectDay(expectedDay)
                .clickTimeSettingBtn()
                .selectPredefinedTime(expectedTime)
                .clickDoneBtn()
                .clickReminderSettingBtn()
                .openReminderDropDown()
                .selectReminderValue(DefaultTaskSettings.defaultReminderMinutes)
                .selectReminderValue(reminderValue)
                .closeReminderDropDown()
                .clickDoneBtn();
        Assert.assertEquals(taskDateSettingsPage.getTaskTime(), expectedTime.getValue(),
                "Task time on task date setting screen is different than selected");
        Assert.assertEquals(taskDateSettingsPage.getReminderAtValue(), TimeDateUtils.moveBackTimeByMinutes(expectedTime, reminderValue.getValue()),
                "Reminder time on task date setting screen is different than expected");
        taskDateSettingsPage.clickDoneBtn();
        inputTaskPage.clickAddTaskConfirmBtn();

        tasksPage.skipTutorial()
                .closeReminderPermissionPopup();
        Assert.assertTrue(tasksPage.areTasksDisplayedOnFutureList(List.of(expectedTaskText)),
                "Task '%s' isn't displayed on the tasks list for FUTURE".formatted(expectedTaskText));
        Assert.assertEquals(tasksPage.getTaskDate(expectedTaskText), TimeDateUtils.parseDateToTasksListPageDateTimeFormat(expectedDate, expectedTime),
                "Task due date and time on the tasks list is different than expected");

        TaskPageBase taskPage = tasksPage.openTaskByText(expectedTaskText);
        Assert.assertEquals(taskPage.getTaskDueDate(), TimeDateUtils.parseDateToTaskPageDateFormat(expectedDate),
                "Task due date on task screen is different than expected");
        Assert.assertEquals(taskPage.getTaskTime(), expectedTime.getValue_AMPM(),
                "Task time on task screen is different than predefined time set during task creation");
        Assert.assertEquals(taskPage.getReminderAtTime(), TimeDateUtils.moveBackTimeByMinutes(expectedTime, reminderValue.getValue()),
                "Reminder time is different than expected");
    }

    @Test
    @TestCaseKey(value = "JOANNA-56")
    public void addTaskWithNoDateTest() {
        TasksPageBase tasksPage = pageUtils.goToTaskPage();
        InputTaskPageBase inputTaskPage = tasksPage.clickAddTaskBtn();
        inputTaskPage.inputTaskText(expectedTaskText);
        inputTaskPage.clickSelectDateBtn()
                .clickNoDateBtn()
                .clickDoneBtn();
        inputTaskPage.clickAddTaskConfirmBtn();
        tasksPage.skipTutorial();
        Assert.assertTrue(tasksPage.areTasksDisplayedOnFutureList(List.of(expectedTaskText)),
                "Task '%s' isn't displayed on the tasks list for FUTURE".formatted(expectedTaskText));
        Assert.assertFalse(tasksPage.isTaskDateVisible(expectedTaskText),
                "Task date is visible although task was set with no date");

        TaskPageBase taskPage = tasksPage.openTaskByText(expectedTaskText);
        Assert.assertEquals(taskPage.getTaskDueDate(), DefaultTaskSettings.dueDateSetting,
                "Task without date has unexpected date displayed");
    }
}
