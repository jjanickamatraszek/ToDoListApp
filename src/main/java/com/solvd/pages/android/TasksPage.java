package com.solvd.pages.android;

import com.solvd.pages.base.TasksPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TasksPageBase.class)
public class TasksPage extends TasksPageBase {

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'task_none')]")
    private ExtendedWebElement createTaskPrompt;

    @FindBy(xpath = ".//androidx.recyclerview.widget.RecyclerView[contains(@resource-id, 'rv_note_list')]")
    private ExtendedWebElement tasksListContainer;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'task_add')]")
    private ExtendedWebElement addTaskBtn;

    @FindBy(xpath = ".//android.widget.EditText[contains(@resource-id, 'task_create_input')]")
    private ExtendedWebElement inputNewTaskTextField;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'task_create_btn')]")
    private ExtendedWebElement addTaskConfirmBtn;

    @FindBy(xpath = ".//android.widget.TextView[@text = '%s']")
    private ExtendedWebElement taskTextFormatted;

    @FindBy(xpath = "(.//android.widget.LinearLayout[.//android.widget.TextView[@text = '%s']])[3]")
    private ExtendedWebElement taskContainer;

    @FindBy(xpath = ".//android.view.ViewGroup[contains(@resource-id, 'task_contains') and .//android.widget.TextView[@text = '%s']]//android.view.View[contains(@resource-id, 'task_check')]")
    private ExtendedWebElement checkTaskRadioBtnFormatted;

    @FindBy(xpath = ".//android.view.View[contains(@resource-id, 'task_check')]")
    private ExtendedWebElement checkTaskRadioBtnGeneral;

    @FindBy(xpath = ".//android.widget.LinearLayout[contains(@resource-id, 'task_delete_layout')]")
    private ExtendedWebElement deleteTaskBtn;

    @FindBy(xpath = ".//android.widget.ImageView[contains(@resource-id, 'task_edit')]")
    private ExtendedWebElement editTaskBtn;

    @FindBy(xpath = ".//android.widget.RelativeLayout[contains(@resource-id, 'dialog_content')]")
    private ExtendedWebElement deleteTaskPopup;

    @FindBy(xpath = ".//android.widget.TextView[contains(@resource-id, 'dialog_confirm')]")
    private ExtendedWebElement deleteTaskConfirmBtn;

    public TasksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCreateTaskPromptVisible() {
        return createTaskPrompt.isVisible(3);
    }

    @Override
    public TasksPageBase clickAddTaskBtn() {
        addTaskBtn.click();
        return this;
    }

    @Override
    public TasksPageBase inputTaskDesc(String taskText) {
        inputNewTaskTextField.type(taskText);
        return this;
    }

    @Override
    public TasksPageBase clickAddTaskConfirmBtn() {
        addTaskConfirmBtn.click();
        return this;
    }

    @Override
    public TasksPageBase skipTutorial() {
        waitUntil(ExpectedConditions.visibilityOf(editTaskBtn.getElement()), 3);
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
}
