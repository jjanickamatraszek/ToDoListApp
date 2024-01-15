package com.solvd.pages.android;

import com.solvd.consts.FlagColor;
import com.solvd.consts.TaskCategory;
import com.solvd.pages.base.InputTaskPageBase;
import com.solvd.pages.base.TaskDateSettingsPageBase;
import com.solvd.pages.base.TaskPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.solvd.pages.utils.PageUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashSet;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TasksPageBase.class)
public class TasksPage extends TasksPageBase {

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'task_none')]")
    private ExtendedWebElement createTaskPrompt;

    @FindBy(xpath = ".//androidx.recyclerview.widget.RecyclerView[contains(@resource-id, 'rv_note_list')]")
    private ExtendedWebElement tasksListContainer;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'task_add')]")
    private ExtendedWebElement addTaskBtn;

    @FindBy(xpath = ".//android.widget.TextView[@text = '%s']")
    private ExtendedWebElement taskTextFormatted;

    @FindBy(xpath = ".//android.widget.TextView[@text = '%s']/../following-sibling::*/android.widget.TextView[contains(@resource-id,'task_time')]")
    private ExtendedWebElement taskTimeDateFieldFormatted;

    @FindBy(xpath = ".//android.widget.LinearLayout[./android.widget.TextView[@text ='Today']]/following-sibling::android.widget.LinearLayout//android.widget.TextView[contains(@resource-id, 'task_text')]")
    private List<ExtendedWebElement> todayTasksTextsList;

    @FindBy(xpath = ".//android.widget.LinearLayout[./android.widget.TextView[@text ='Future']]/following-sibling::android.widget.LinearLayout//android.widget.TextView[contains(@resource-id, 'task_text')]")
    private List<ExtendedWebElement> futureTasksTextsList;

    @FindBy(xpath = "(.//android.widget.LinearLayout[.//android.widget.TextView[@text = '%s']])[3]")
    private ExtendedWebElement taskContainer;

    @FindBy(xpath = ".//android.view.ViewGroup[contains(@resource-id, 'task_contains') and .//android.widget.TextView[@text = '%s']]//android.view.View[contains(@resource-id, 'task_check')]")
    private ExtendedWebElement checkTaskRadioBtnFormatted;

    @FindBy(xpath = ".//android.view.View[contains(@resource-id, 'task_check')]")
    private ExtendedWebElement checkTaskRadioBtnGeneral;

    @FindBy(xpath = ".//android.widget.LinearLayout[contains(@resource-id, 'task_delete_layout')]")
    private ExtendedWebElement deleteTaskBtn;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'task_edit')]")
    private ExtendedWebElement editTaskDateBtn;

    @FindBy(xpath = ".//android.widget.RelativeLayout[contains(@resource-id, 'dialog_content')]")
    private ExtendedWebElement deleteTaskPopup;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'dialog_confirm')]")
    private ExtendedWebElement deleteTaskConfirmBtn;

    @ExtendedFindBy(image = "images/defaultFlag.png")
    private ExtendedWebElement defaultFlagBtn;

    @ExtendedFindBy(image = "images/redFlag.png")
    private ExtendedWebElement redFlagBtn;

    @ExtendedFindBy(image = "images/inputTextMessage.png")
    private ExtendedWebElement emptyInputWarning;

    @FindBy(xpath = ".//android.widget.LinearLayout[contains(@resource-id, 'dialog_content')]")
    private ExtendedWebElement rateAppPopup;

    @FindBy(xpath = ".//android.widget.RatingBar[contains(@resource-id, 'fivestar_rate')]//android.widget.ImageView")
    private ExtendedWebElement fiveStarRate;

    @FindBy(xpath = ".//android.widget.FrameLayout[contains(@resource-id, 'custom')]")
    private ExtendedWebElement reminderPopup;

    @FindBy(xpath = ".//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'category_layout')]")
    private ExtendedWebElement taskCategoryContainer;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id,'category_text') and @text = '%s']")
    private ExtendedWebElement taskCategoryLabelFormatted;

    public TasksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCreateTaskPromptVisible() {
        return createTaskPrompt.isVisible(3);
    }

    @Override
    public InputTaskPageBase clickAddTaskBtn() {
        addTaskBtn.click();
        return initPage(InputTaskPageBase.class);
    }

    @Override
    public TasksPageBase skipTutorial() {
        waitUntil(ExpectedConditions.visibilityOf(editTaskDateBtn.getElement()), 3);
        getDriver().navigate().back();
        waitUntil(ExpectedConditions.visibilityOf(checkTaskRadioBtnGeneral.getElement()), 3);
        getDriver().navigate().back();
        getDriver().navigate().back();
        return this;
    }

    @Override
    public TasksPageBase swipeLeftOnTask(String taskText) {
        Point location = taskContainer.format(taskText).getElement().getLocation();
        Dimension size = taskContainer.format(taskText).getElement().getSize();
        int xStart = location.getX() + (int) (size.width * 0.8);
        int xEnd = location.getX() + (int) (size.width * 0.2);
        int y = location.getY() + (int) (size.height * 0.5);
        swipe(xStart, y, xEnd, y, 1000);
        return this;
    }

    @Override
    public TasksPageBase clickDeleteTaskBtn() {
        deleteTaskBtn.click();
        return this;
    }

    @Override
    public TasksPageBase confirmDeleteTask() {
        deleteTaskConfirmBtn.click();
        return this;
    }

    @Override
    public TaskDateSettingsPageBase clickEditTaskDateBtn() {
        editTaskDateBtn.click();
        return initPage(TaskDateSettingsPageBase.class);
    }

    @Override
    public TaskPageBase openTaskByText(String taskText) {
        taskTextFormatted.format(taskText).click();
        return initPage(TaskPageBase.class);
    }

    @Override
    public TaskPageBase openTaskByIndex(int id) {
        todayTasksTextsList.get(id).click();
        return initPage(TaskPageBase.class);
    }

    @Override
    public int getNumberOfTodayTasksListed() {
        return todayTasksTextsList.size();
    }

    @Override
    public boolean areTasksDisplayedOnTodayList(List<String> tasksTexts) {
        return new HashSet<>(todayTasksTextsList.stream().map(ExtendedWebElement::getText).toList()).containsAll(tasksTexts);
    }

    @Override
    public boolean areTasksDisplayedOnFutureList(List<String> tasksTexts) {
        return new HashSet<>(futureTasksTextsList.stream().map(ExtendedWebElement::getText).toList()).containsAll(tasksTexts);
    }

    @Override
    public boolean isFlagDisplayed(FlagColor color) {
        pageUtils.setImageMatchThreshold(0.3);
        switch (color) {
            case DEFAULT -> {
                return defaultFlagBtn.isVisible();
            }
            case RED -> {
                return redFlagBtn.isVisible();
            }
        }
        return defaultFlagBtn.isVisible();
    }

    @Override
    public TasksPageBase skipRateApp() {
        if (rateAppPopup.isVisible()) {
            navigateBack();
            waitUntil(ExpectedConditions.invisibilityOf(rateAppPopup.getElement()), 3);
        }
        return this;
    }

    @Override
    public boolean isEmptyTaskWarningDisplayed() {
        return emptyInputWarning.isVisible();
    }

    @Override
    public boolean isTaskTextTrimmedForLongDesc(String taskText) {
        boolean isTrimmed = false;
        for (ExtendedWebElement currentTask : todayTasksTextsList) {
            if (taskText.startsWith(currentTask.getText().replace("...", ""))) {
                isTrimmed = true;
                break;
            }
        }
        return isTrimmed;
    }

    @Override
    public boolean isTaskDateVisible(String taskText) {
        return taskTimeDateFieldFormatted.format(taskText).isVisible(1);
    }

    @Override
    public String getTaskDate(String taskText) {
        return taskTimeDateFieldFormatted.format(taskText).getText();
    }

    @Override
    public TasksPageBase closeReminderPermissionPopup() {
        if (reminderPopup.isVisible(3)) {
            getDriver().navigate().back();
        }
        return this;
    }

    @Override
    public TasksPageBase clickTaskCategoryLabel(TaskCategory taskCategory) {
        if (taskCategory.equals(TaskCategory.DEFAULT)) {
            throw new IllegalArgumentException(TaskCategory.DEFAULT.getName() + "is not displayed on tasks screen");
        }
        PageUtils.clickIfNotSelected(taskCategoryLabelFormatted.format(taskCategory.getName()));
        return this;
    }

    @Override
    public boolean swipeToTaskCategory(String customizedTaskCategory, Direction direction) {
        return swipe(taskCategoryLabelFormatted.format(customizedTaskCategory), taskCategoryContainer, direction, 10);
    }

    @Override
    public void clickCustomizedTaskCategory(String customizedTaskCategory) {
        taskCategoryLabelFormatted.format(customizedTaskCategory).click();
    }
}
